package controller;

public class UndoController extends ControlHandler {
	private static UndoController instance = new UndoController();
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
	
	public void addUndoCommand(String previousCmd){
		commandHistory.push(previousCmd);
    }

	public String peekUndoCommand(){
		if(commandHistory.isEmpty()){
			return null;	// -> print "Nothing to undo\n."
		}
		return commandHistory.peek();
    }
	
	public String popUndoCommand(){
		return commandHistory.pop();
    }
	
	public int execute(String previousCmd) {
		if(previousCmd==null) {
			return -5;
		}
		String[] cmdParts = previousCmd.split(" ");
		if(cmdParts[0].equals("D")) {
			if(gameManager.getWaste().isEmpty()) {
				if(gameManager.getStock().isEmpty()) {
					//error
					//no card can back from waste
					return -2;
				}else {
					//put all cards from stock back to waste
					while(!gameManager.getStock().isEmpty()) {
						gameManager.getWaste().push(gameManager.getStock().pop());
					}
					gameManager.getWaste().peek().flip();	//show the top card
					gameManager.getCommandHistory().pop();
					return 1;
				}
			}else {
				//put 1 card from waste back to stock
				gameManager.getWaste().peek().flip();	//hide the top card
				gameManager.getStock().push(gameManager.getWaste().pop());
				if(!gameManager.getWaste().isEmpty()) {
					gameManager.getWaste().peek().flip();	//show the new top card
				}
				commandHistory.pop();
				return 2;
			}
		}else if(cmdParts[0].equals("T")) {
			try {
				int moveFrom = Integer.parseInt(cmdParts[1]);
				int moveTo = Integer.parseInt(cmdParts[2]);
				if(!gameManager.getTableaus().get(moveFrom-1).isEmpty()) {
					gameManager.getTableaus().get(moveFrom-1).peek().flip();
				}
				if(moveTo == 0 ) {		//From foundation to Tableau
					int foundationIndex = Integer.parseInt(cmdParts[3]);
					foundation.get(foundationIndex);
					tableaus.get(moveFrom-1);
					moveToTableauController.execute("U " + cmdParts[1]);
					commandHistory.pop();
					return 3;
				}else{		//from tableau to tableau
					int validCard = Integer.parseInt(cmdParts[3]);
					moveToTableauController.execute(gameManager.getTableaus().get(moveTo-1), gameManager.getTableaus().get(moveFrom-1), validCard);
					commandHistory.pop();
					return 4;
				}
			}catch(NumberFormatException e) {
				//return error message
				return -3;
			}
			
		}else if(cmdParts[0].equals("W")){
			try {
				int moveTo = Integer.parseInt(cmdParts[1]);
				gameManager.getWaste().peek().flip();		//hide top card		
				if(moveTo == 0 ) {		//From foundation to waste
					int foundationIndex = Integer.parseInt(cmdParts[2]);
					Foundation f = gameManager.getFoundation().get(foundationIndex);
					if(!f.isEmpty()) {
						gameManager.getWaste().push(f.pop());
						gameManager.getCommandHistory().pop();
					}	
					return 5;
				}else{
					Tableau t = gameManager.getTableaus().get(moveTo-1);
					if(!t.isEmpty()) {
						gameManager.getWaste().push(t.pop());
						gameManager.getCommandHistory().pop();
					}
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
