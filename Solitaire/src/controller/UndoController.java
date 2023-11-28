package controller;

import java.util.List;

import main.GameManager;
import stackManager.CommandHistory;
import stackManager.Foundation;
import stackManager.Stock;
import stackManager.Tableau;
import stackManager.Waste;

public class UndoController {
	private static UndoController instance = new UndoController();
	static MoveToFoundationController moveToFoundationController = MoveToFoundationController.getInstance();
	static MoveToTableauController moveToTableauController = MoveToTableauController.getInstance();
	
	private UndoController() {}

	public static UndoController getInstance() {
	  if (instance == null) {
		  instance = new UndoController();
	  }
		  return instance;
		}
		
	public static void resetInstance() {
        instance = null;
    }
	
	public void addUndoCommand(CommandHistory commandHistory, String previousCmd){
		commandHistory.push(previousCmd);
    }

	public String peekUndoCommand(CommandHistory commandHistory){
		if(commandHistory.isEmpty()){
			return null;	// -> print "Nothing to undo\n."
		}
		return commandHistory.peek();
    }
	
	public String popUndoCommand(CommandHistory commandHistory){
		return commandHistory.pop();
    }
	
	public int execute(CommandHistory commandHistory, Stock stock, Waste waste, List<Tableau> tableaus, List<Foundation> foundation) {
		String previousCmd = peekUndoCommand(commandHistory);
		if(previousCmd==null) {
			return -5;
		}
		String[] cmdParts = previousCmd.split(" ");
		if(cmdParts[0].equals("D")) {
			if(waste.isEmpty(waste.getCardList())) {
				if(stock.isEmpty(stock.getCardList())) {
					//error
					//no card can back from waste
					return -2;
				}else {
					//put all cards from stock back to waste
					while(!stock.isEmpty(stock.getCardList())) {
						waste.push(waste.getCardList(), stock.pop(stock.getCardList()));
					}
					waste.peek(waste.getCardList()).flip();	//show the top card
					return 1;
				}
			}else {
				//put 1 card from waste back to stock
				waste.peek(waste.getCardList()).flip();	//hide the top card
				stock.push(stock.getCardList(), waste.pop(waste.getCardList()));
				if(!waste.isEmpty(waste.getCardList())) {
					waste.peek(waste.getCardList()).flip();	//show the new top card
				}
				return 2;
			}
		}else if(cmdParts[0].equals("T")) {
			try {
				int moveFrom = Integer.parseInt(cmdParts[1]);
				int moveTo = Integer.parseInt(cmdParts[2]);
				if(moveTo == 0 ) {		//From foundation to Tableau
					int foundationIndex = Integer.parseInt(cmdParts[3]);
					Foundation f = foundation.get(foundationIndex);
					Tableau t = tableaus.get(moveFrom-1);
					moveToTableauController.execute(f, t, foundationIndex);
					return 3;
				}else{		//from tableau to tableau
					int validCard = Integer.parseInt(cmdParts[3]);
					moveToTableauController.execute(tableaus.get(moveTo-1), tableaus.get(moveFrom-1), validCard);
					return 4;
				}
			}catch(NumberFormatException e) {
				//return error message
				return -3;
			}
			
		}else if(cmdParts[0].equals("W")){
			try {
				int moveTo = Integer.parseInt(cmdParts[1]);
				waste.peek(waste.getCardList()).flip();		//hide top card		
				if(moveTo == 0 ) {		//From foundation to waste
					int foundationIndex = Integer.parseInt(cmdParts[2]);
					Foundation f = foundation.get(foundationIndex);
					waste.push(waste.getCardList(), f.pop(f.getCardList()));
					return 5;
				}else{
					Tableau t = tableaus.get(moveTo-1);
					waste.push(waste.getCardList(), t.pop(t.getCardList()));
					return 6;
				}
				
			}catch(NumberFormatException e) {
				//return error message
				return -4;
			}
		}
		return -1;
	}
	
	
}
