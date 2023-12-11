package controller;

import java.util.List;

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
			return -2;
		}
		String[] cmdParts = previousCmd.split(" ");
		if(cmdParts[0].equals("D")) {
			if(waste.isEmpty()) {
				if(stock.isEmpty()) {
					//error
					//no card can back from waste
					return -3;
				}else {
					//put all cards from stock back to waste
					while(!stock.isEmpty()) {
						waste.push(stock.pop());
					}
					waste.peek().flip();	//show the top card
					//commandHistory.pop();
					return 1;
				}
			}else {
				//put 1 card from waste back to stock
				waste.peek().flip();	//hide the top card
				stock.push(waste.pop());
				if(!waste.isEmpty()) {
					waste.peek().flip();	//show the new top card
				}
				//commandHistory.pop();
				return 2;
			}
		}else if(cmdParts[0].equals("T")) {
			try {
				int moveFrom = Integer.parseInt(cmdParts[1]);
				int moveTo = Integer.parseInt(cmdParts[2]);
				if(!tableaus.get(moveFrom-1).isEmpty()) {
					tableaus.get(moveFrom-1).peek().flip();
				}
				if(moveTo == 0 ) {		//From foundation to Tableau
					int foundationIndex = Integer.parseInt(cmdParts[3]);
					Foundation f = foundation.get(foundationIndex);
					Tableau t = tableaus.get(moveFrom-1);
					moveToTableauController.execute(f, t, foundationIndex);
					//commandHistory.pop();
					return 3;
				}else{		//from tableau to tableau
					int validCard = Integer.parseInt(cmdParts[3]);
					moveToTableauController.execute(tableaus.get(moveTo-1), tableaus.get(moveFrom-1), validCard);
					//commandHistory.pop();
					return 4;
				}
			}catch(NumberFormatException e) {
				//return error message
				return -4;
			}
			
		}else if(cmdParts[0].equals("W")){
			try {
				int moveTo = Integer.parseInt(cmdParts[1]);
				waste.peek().flip();		//hide top card		
				if(moveTo == 0 ) {		//From foundation to waste
					int foundationIndex = Integer.parseInt(cmdParts[2]);
					Foundation f = foundation.get(foundationIndex);
					if(!f.isEmpty()) {
						waste.push(f.pop());
						//commandHistory.pop();
						return 5;
					}
					return -5;
					
				}else{
					Tableau t = tableaus.get(moveTo-1);
					if(!t.isEmpty()) {
						waste.push(t.pop());
						//commandHistory.pop();
						return 6;
					}
					return -6;
					
				}
				
			}catch(NumberFormatException e) {
				//return error message
				return -7;
			}
		}
		return -1;
	}
	
	
}
