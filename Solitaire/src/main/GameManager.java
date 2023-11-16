package main;

import java.util.ArrayList;
import java.util.List;

import card.Suit;
import controller.DealController;
import controller.DisplayController;
import controller.MoveToFoundationController;
import controller.MoveToTableauController;
import controller.RedoController;
import controller.ScoreController;
import controller.UndoController;
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
	//private List<Tableau> tableaus;
	private List<Tableau> tableaus = new ArrayList<>();
	private String previousAction;
	private Deck deck;
	private Stock stock;
	private Waste waste;
	private UndoController undoController;
	private RedoController redoController = RedoController.getInstance();
	private DisplayController displayController;
	static ScoreController scoreController = ScoreController.getInstance();
	static MoveToFoundationController moveToFoundationController = MoveToFoundationController.getInstance();
	static MoveToTableauController moveToTableauController = MoveToTableauController.getInstance();
	static DealController dealController = DealController.getInstance();
	
	private GameManager(){
		previousAction = "";
		foundation.clear();
		tableaus.clear();
		deck = null;
		stock = null;
		waste = null;
		//should be change to singleton
		undoController = null;
		redoController = null;
		displayController = null;
		scoreController = null;
		dealController = null;
		moveToFoundationController = null;
		moveToTableauController = null;
		//score = 0;
	}
	
	
	public void start() {
		
		//int level = sc.nextInt();
		//displayController.printboard(level);
		
		
		
		long seed = 0;// for testing
		//long seed = System.currentTimeMillis();		//every games have different seed
		previousAction = "";
		scoreController.setScore(0);			//chock bug-> not set 0 here
		setMove(0);
		
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
				tableaus.get(i).push(tableaus.get(i).getCardList(), deck.pop(deck.getCards()));
			}
		}
		
		//Stock
		stock = new Stock();
		while(!deck.isEmpty(deck.getCards())) {
			stock.push(stock.getCardList(), deck.pop(deck.getCards()));
		}
				
		//Waste
		waste = new Waste();
		tabAutoFlip();
		
		//Print board
		String foundationPrint = "";
		for(int i = 0; i < 4; i++) {
			foundationPrint = foundationPrint + foundation.get(i).print() + " ";
		}
		String[] foundationsInfo = foundationPrint.split(" ");
		
		String tableausPrint = "";
		for(int i = 0; i < 7; i++) {
			tableausPrint = tableausPrint + tableaus.get(i).print() + " ";
		}
		String[] tableausInfo = tableausPrint.split(" ");
		displayController.printboard(stock.count(stock.getCardList()), waste.print(), scoreController.getScore(), move, foundationsInfo, tableausInfo);
	}
	
	public int commandExecute(String cmd) {
		String[] cmdParts = cmd.split(" ");
		String[] previousActionParts = previousAction.split(" ");
		switch(cmdParts[0]) {
		//case sensitive need to change -> chock bug
			case "S":
				start();
				previousAction = "";
				return 1;
			case "U":
				undoController = new UndoController();
				undoController.undoOneCommand();
				move();
				scoreController.addScore(-50);
				previousAction = cmd;
				//add redo list
				return 2;
			case "R":
				//case sensitive
				if(!previousActionParts[0].equals("U")) {
					redoController.clearRedoList();
					//can print message
					return -1;
				}else {
					redoController.redoOneCommand();
				}
				move();
				//score?
				previousAction = cmd;
				return 3;
			case "T":
				try{
					int moveFrom = Integer.parseInt(cmdParts[1]);
					int moveTo = Integer.parseInt(cmdParts[2]);
					
					//Error checking
					if(moveFrom -1 < 0 || moveFrom -1 > 6 || moveTo -1 < 0 || moveTo -1 > 6 || moveFrom == moveTo) {
						//put to displayController
						displayController.printInputReminder2();
						return -1;
					}
						
					if(tableaus.get(moveFrom-1).isEmpty(tableaus.get(moveFrom-1).getCardList())) {
						displayController.printInvalidMove();
						return -1;
					}
					
					//tableau to foundation
					if(moveTo == 0) {
						//error checking
						int foundationIndex = moveToFoundationController.getListIndex(tableaus.get(moveFrom-1).peek(tableaus.get(moveFrom-1).getCardList()), foundation);
						if(foundationIndex < 0 || foundation.get(foundationIndex).isFull()) {
							displayController.printInvalidMove();
							return -1;
						}
							
						//valid
						moveToFoundationController.execute(tableaus.get(moveFrom-1).pop(tableaus.get(moveFrom-1).getCardList()), foundation);
						scoreController.checkCombo(previousActionParts[2]);
						
					}else {
						//move Tableau to Tableau
						//error checking
						int showCardCount = moveToTableauController.getShowCard(tableaus.get(moveFrom -1).getCardList());
						if(showCardCount <= 0) {
							displayController.printInvalidMove();
							return -1;
						}
						
						int validCard = moveToTableauController.getMoveCardCount(tableaus.get(moveFrom).getCardList(), tableaus.get(moveTo), showCardCount);
						if(validCard <= 0) {
							displayController.printInvalidMove();
							return -1;
						}
						//valid
						moveToTableauController.execute(tableaus.get(moveFrom), tableaus.get(moveTo), validCard);
						displayController.printValidMove();
						tabAutoFlip();
					}
				}catch(NumberFormatException e) {
					System.out.printf("Invalid input.\n\n");
					return -1;
				}
				
				move();
				previousAction = cmd;
//				addUndoCommand(this);
//				clearRedoList();
				return 4;	
			case "W":
				try{
					int moveFrom = Integer.parseInt(cmdParts[1]);
					int moveTo = Integer.parseInt(cmdParts[2]);
					
					//error checking
					if(waste.isEmpty(waste.getCardList())) {
						displayController.printInvalidMove();
						return -1;
					}
					
					if(moveTo == 0) {
						//wasteToFoundation
						//error checking
						int foundationIndex = moveToFoundationController.getListIndex(waste.peek(waste.getCardList()), foundation);
						if(foundationIndex < 0 || foundation.get(foundationIndex).isFull()) {
							displayController.printInvalidMove();
							return -1;
						}
						//valid
						moveToFoundationController.execute(waste.pop(waste.getCardList()), foundation);
						scoreController.checkCombo(previousActionParts[2]);
					}else {
						//wasteToTableau
						int validCard = moveToTableauController.getMoveCardCount(waste.peek(waste.getCardList()), tableaus.get(moveTo));
						if(validCard <= 0) {
							displayController.printInvalidMove();
							return -1;
						}
						//valid
						moveToTableauController.execute(waste, tableaus.get(moveTo), 1);
						displayController.printValidMove();
						waste.peek(waste.getCardList()).flip();
						
					}
				}catch(NumberFormatException e) {
					System.out.printf("Invalid input.\n\n");
				}
			
				move();
				previousAction = cmd;
//				addUndoCommand(this);
//				clearRedoList();
				return 5;
			case "D":
				dealController.execute(stock, waste);
				previousAction = cmd;
				displayController.printAddCardToWaste();
//				addUndoCommand(this);
//				clearRedoList();
				return 6;
			case "Q":
				displayController.printQuitMessage();
				//quit? or restart
				return -2;
			default:
				//invalid command
				displayController.printInputReminder1();
				return 0;
		}
	}
	
	//may be need to refactor
	public void tabAutoFlip(){
		for(Tableau t: tableaus) {
			if(!t.isEmpty(t.getCardList()) && !(t.peek(t.getCardList()).getShow())) 
				t.peek(t.getCardList()).setShow(true);
		}
	}
	
	public static GameManager getInstance() {
		return instance;
	}
	
	public List<Tableau> getTab() {
		return tableaus;
	}
	
	public List<Foundation> getFoundate() {
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
			scoreController.addScore(1000000/getMove());
			return true;
		}
		return false;
	}
	
	public void setScore(int score) {
		scoreController.setScore(score);
	}
	
}
