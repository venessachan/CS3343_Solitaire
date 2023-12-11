package main;

import java.util.ArrayList;
import java.util.List;

import card.Suit;
import controller.DealController;
import controller.DisplayController;
import controller.MoveToFoundationController;
import controller.MoveToTableauController;
import controller.ScoreController;
import controller.UndoController;
import stackManager.CommandHistory;
import stackManager.Deck;
import stackManager.Foundation;
import stackManager.Stock;
import stackManager.Tableau;
import stackManager.Waste;

public class GameManager {
	
	private static GameManager instance = new GameManager();

	private int move;
	//private int score;
	private List<Foundation> foundation = new ArrayList<>();
	private List<Tableau> tableaus = new ArrayList<>();
	private String previousAction;
	private Deck deck;
	private Stock stock;
	private Waste waste;
	
	static DisplayController displayController;
	static ScoreController scoreController;
	static MoveToFoundationController moveToFoundationController;
	static MoveToTableauController moveToTableauController;
	static DealController dealController;
	static UndoController undoController;
	private CommandHistory commandHistory;
	
	private GameManager(){
		reset();
		//score = 0;
	}
	

	public static GameManager getInstance() {
	  if (instance == null) {
		  instance = new GameManager();
	  }
	  return instance;
	}
	
	public static void resetInstance() {
        instance = null;
    }
	
	public void start() {
		reset();
	    displayController = DisplayController.getInstance();
	    scoreController = ScoreController.getInstance();
	    moveToFoundationController = MoveToFoundationController.getInstance();
	    moveToTableauController = MoveToTableauController.getInstance();
	    dealController = DealController.getInstance();
	    undoController = UndoController.getInstance();
	    commandHistory = new CommandHistory();

		long seed = 0;// for testing
		//long seed = System.currentTimeMillis();		//every games have different seed
		setPreviousAction("");
		setScore(0);
		setCombo(0);
		setMove(0);
		//scoreController.setComboCount(0);
		
		//Deck
		deck = new Deck();
		deck.shuffle(seed);//seed
		
		//Foundation
		foundation = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		
		//Tableau - create 7 tableau
		for (int i = 0; i < 7; i++) {
		    tableaus.add(new Tableau());
		}
		 
		for(int i=1;i<=7;i++) {
			for(int j=1; j<=i;j++) {
				tableaus.get(i-1).push(deck.pop());
			}
		}
		
		//Stock
		stock = new Stock();
		while(!deck.isEmpty()) {
			stock.push(deck.pop());
		}
				
		//Waste
		waste = new Waste();
		tabAutoFlip();
		
		//Print board
		String foundationPrint = "";
		for(int i = 0; i < 4; i++) {
			foundationPrint = foundationPrint + foundation.get(i).print() + " ";
		}
		printBoard();
	}
	
	public int commandExecute(String cmd) {
		String[] cmdParts = cmd.split(" ");
		switch(cmdParts[0]) {
			case "S":
				start();
				setPreviousAction("");
				return 1;
			case "U":
				if(undoController.execute(getCommandHistory(), stock, waste, tableaus, foundation) < 0) {
					printBoard();
					displayController.printInvalidUndo();
					return -1;
				}else{
					undoController.popUndoCommand(commandHistory);
					setPreviousAction(undoController.peekUndoCommand(getCommandHistory()));
					move();
					scoreController.addScore(-50);
					printBoard();
					displayController.printValidUndo();
					return 2;
				}
				
			case "T":
				try{
					int moveFrom = Integer.parseInt(cmdParts[1]);
					int moveTo = Integer.parseInt(cmdParts[2]);
					int validCard = 0;
					//Error checking
					if(moveFrom < 1 || moveFrom > 7 || moveTo  < 0 || moveTo > 7 || moveFrom == moveTo) {
						//put to displayController
						printBoard();
						displayController.printInvalidMove();
						displayController.printInputReminder2();
						return -3;
					}
						
					if(tableaus.get(moveFrom-1).isEmpty()) {
						printBoard();
						displayController.printInvalidMove();
						return -4;
					}
					
					//tableau to foundation
					if(moveTo == 0) {
						//error checking
						int foundationIndex = moveToFoundationController.getListIndex(tableaus.get(moveFrom-1).peek(), foundation);
						if(foundationIndex < 0) {
							printBoard();
							displayController.printInvalidMove();
							return -5;
						}
							
						//valid
						moveToFoundationController.execute(tableaus.get(moveFrom-1).pop(), foundation.get(foundationIndex));	
						setPreviousAction(cmd + " " + foundationIndex);	//index 3
						scoreController.checkCombo(getPreviousAction());
						undoController.addUndoCommand(getCommandHistory(), getPreviousAction());
						move();
						tabAutoFlip();
						printBoard();
						displayController.printValidMove();
						return 4;
					}else {
						//move Tableau to Tableau
						//error checking
						int showCardCount = moveToTableauController.getShowCard(tableaus.get(moveFrom -1).getCardList());
						if(showCardCount <= 0) {
							printBoard();
							displayController.printInvalidMove();
							return -6;
						}
						
						validCard = moveToTableauController.getMoveCardCount(tableaus.get(moveFrom-1), tableaus.get(moveTo-1), showCardCount);
						if(validCard <= 0) {
							printBoard();
							displayController.printInvalidMove();
							return -7;
						}
						//valid
						moveToTableauController.execute(tableaus.get(moveFrom-1), tableaus.get(moveTo-1), validCard);
						tabAutoFlip();
						setPreviousAction(cmd + " " + validCard);		//index 3
						undoController.addUndoCommand(getCommandHistory(), getPreviousAction());
						scoreController.checkCombo(getPreviousAction());
						move();						
						printBoard();
						displayController.printValidMove();
						return 5;
					}
						
				}catch(NumberFormatException e) {
					printBoard();
					displayController.printInvalidMove();
					return -8;
				}catch(Exception e) {
					printBoard();
					displayController.printInvalidMove();
					return -18;
				}
			case "W":
				try{					
					int moveTo = Integer.parseInt(cmdParts[1]);
					
					//error checking
					if(waste.isEmpty()) {
						printBoard();
						displayController.printInvalidMove();
						displayController.printInvalidWaste();
						return -9;
					}					
					if(moveTo  < 0 || moveTo > 7) {
						printBoard();
						displayController.printInvalidMove();
						return -10;
					}
					
					if(moveTo == 0) {
						//wasteToFoundation
						//error checking
						int foundationIndex = moveToFoundationController.getListIndex(waste.peek(), foundation);
						if(foundationIndex < 0) {
							printBoard();
							displayController.printInvalidMove();
							return -11;
						}
						//valid
						moveToFoundationController.execute(waste.pop(), foundation.get(foundationIndex));
						setPreviousAction(cmd + " " + foundationIndex);	//index 2
						undoController.addUndoCommand(getCommandHistory(), getPreviousAction());
						scoreController.checkCombo(getPreviousAction());
						move();
						printBoard();
						displayController.printValidMove();
						return 6;
					}else {
						//wasteToTableau
						int validCard = moveToTableauController.getMoveCardCount(waste.peek(), tableaus.get(moveTo-1));
						//No card is valid
						if(validCard <= 0) {
							printBoard();
							displayController.printInvalidMove();
							return -12;
						}
						//valid
						moveToTableauController.execute(waste, tableaus.get(moveTo-1), 1);
						if(!waste.isEmpty()) {
							waste.peek().flip();
						}
						setPreviousAction(cmd);	//index 2
						undoController.addUndoCommand(getCommandHistory(), getPreviousAction());
						scoreController.checkCombo(getPreviousAction());
						move();
						printBoard();
						displayController.printValidMove();
						return 7;
					}
				}catch(NumberFormatException e) {
					printBoard();
					displayController.printInputReminder1();
					return -13;
				}catch(Exception e) {
					printBoard();
					displayController.printInvalidMove();
					return -23;
				}
			

			case "D":
				if(dealController.deal(stock, waste) > 0) {
					setPreviousAction(cmd);
					undoController.addUndoCommand(getCommandHistory(), getPreviousAction());
					scoreController.checkCombo(getPreviousAction());
					move();
					printBoard();
					displayController.printAddCardToWaste();
					return 8;
				}else {
					printBoard();
					displayController.printNoCardDeal();
					return -14;
				}
				
				
			case "Q":
				displayController.printQuitMessage();
				reset();
				resetInstance();
				//quit? or restart
				return -15;
			default:
				//invalid command
				printBoard();
				displayController.printInputReminder1();
				return 0;
		}
		
	}
	
	//may be need to refactor
	public void tabAutoFlip(){
		for(Tableau t: tableaus) {
			if(!t.isEmpty() && !(t.peek().getShow())) 
				t.peek().setShow(true);
		}
	}
	
	public List<Tableau> getTableaus() {
		return tableaus;
	}
	
	public List<Foundation> getFoundation() {
		return foundation;
	}
	
	public Deck getDeck() {
		return deck;
	}

	public Stock getStock() {
		return stock;
	}

	public Waste getWaste() {
		return waste;
	}

	public CommandHistory getCommandHistory() {
		return commandHistory;
	}
	
	public void move() {
		move += 1;
	}
	
	public void setMove(int move) {
		this.move = move;
	}
	
	public int getMove() {
		return move;
	}
	
	public void setPreviousAction(String previousAction) {
    	this.previousAction = previousAction;
    }
	
    public String getPreviousAction() {
    	return previousAction;
    }
    
	public boolean isWin() {

		if(foundation.get(0).isFull() && foundation.get(1).isFull()
			&& foundation.get(2).isFull() && foundation.get(3).isFull()) {
			if(getMove() > 0) {
				scoreController.addScore(1000000/getMove());
			}
			
			return true;
		}
		return false;
	}
	
	public void setScore(int score) {
		scoreController.setScore(score);
	}
	
	public int getScore() {
		return scoreController.getScore();
	}
	
	public void setCombo(int combo) {
		scoreController.setComboCount(combo);
	}
	
	public int getCombo() {
		return scoreController.getComboCount();
	}
	public void printBoard() {
		displayController.printboard(stock.count(), waste.print(), scoreController.getScore(), move, foundation, tableaus);
	}
	
	public void reset() {
		previousAction = "";
		foundation.clear();
		tableaus.clear();
		deck = null;
		stock = null;
		waste = null;
		undoController = null;
		displayController = null;
		scoreController = null;
		dealController = null;
		moveToFoundationController = null;
		moveToTableauController = null;
		commandHistory = null;
	}
	
}
