package main;

import java.util.ArrayList;
import java.util.List;

import card.Card;
import card.Deck;
import card.Suit;
import controller.DisplayController;
import controller.MoveTableauController;
import controller.RedoController;
import controller.ScoreController;
import controller.UndoController;
import stackManager.Foundation;
import stackManager.Stock;
import stackManager.Tableau;
import stackManager.Waste;

public class GameManager {
	
	private static GameManager instance = new GameManager();

	private int move;
	//private int score;
	private List<Foundation> foundation;
	private List<Tableau> tableaus;
	private Deck deck;
	private Stock stock;
	private Waste waste;
	private UndoController undoController;
	private RedoController redoController = RedoController.getInstance();
	private DisplayController displayController;
	private MoveTableauController moveTableauController;
	static ScoreController scoreController = ScoreController.getInstance();
	private String previousAction;
	
	private GameManager(){
		foundation.clear();
		tableaus.clear();
		deck = null;
		stock = null;
		waste = null;
		//should be change to singleton
		undoController = null;
		redoController = null;
		displayController = null;
		moveTableauController = null;
		previousAction = "";
		//score = 0;
	}
	
	
	public void start() {
		
		//int level = sc.nextInt();
		//displayController.printboard(level);
		displayController.printboard();
		
		
		long seed = 0;// for testing
		//long seed = System.currentTimeMillis();		//every games have different seed
		previousAction = "";
		scoreController.setScore(0);			//chock bug-> not set 0 here
		move = 0;
		//Deck
		deck = new Deck();
		deck.shuffle(seed);//seed
		
		//Foundation
		foundation = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		//Stock
		stock = new Stock();
		stock.setStock(deck.getCards());
		
		//Tableau
		tableaus = new ArrayList<>();
		for(int i=1;i<=7;i++) {
			Tableau tableau = new Tableau();
			List<Card> temp= new ArrayList<>();
			for(int j=1; j<=i;j++) {
				temp.add(stock.pop());
			}
			tableau.put(temp);
			tableaus.add(tableau);
		}
		
		//Waste
		waste = new Waste();
		tabAutoFlip();
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
				//move?
				scoreController.addScore(-50);
				previousAction = cmd;
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
				//move?
				//score?
				previousAction = cmd;
				return 3;
			case "T":
				return 4;	
			//may need to adjust, affect undo/redo
			case "TNext":
				String moveFrom = cmdParts[1];
				String moveTo = cmdParts[2];
				if(moveTo.equals("0")) {
					//moveToFoundation
					scoreController.checkCombo(previousActionParts[2]);
				}else {
					//moveTableau
				}
				move();
				previousAction = cmd;
				return 5;
			case "W":
				displayController.printMoveToQ();
				return 6;
			case "WasteNext":
				if(cmdParts[1].equals("0")) {
					//wasteToFoundation
					scoreController.checkCombo(previousActionParts[2]);
				}else {
					//wasteToTableau
				}
				move();
				previousAction = cmd;
				return 7;
			case "D":
				//deal
				previousAction = cmd;
				return 8;
			case "Q":
				displayController.printQuitMessage();
				//quit? or restart
				return -2;
			default:
				System.out.print("Please input a valid command.\n\n");
				return 0;
		}
	}
		
	public void tabAutoFlip(){
		for(Tableau t: tableaus) {
			if(!t.empty() && !(t.peek().getShow())) 
				t.peek().setShow(true);
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
		if(foundation.get(0).full() && foundation.get(1).full()
			&& foundation.get(2).full() && foundation.get(3).full()) {
			return true;
		}
		
		scoreController.addScore(1000000/getMove());
		return false;
	}
	
	public void setScore(int score) {
		scoreController.setScore(score);
	}
	
}
