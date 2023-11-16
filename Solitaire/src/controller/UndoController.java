package controller;

import java.util.List;

import stackManager.Stock;
import stackManager.Waste;

public class UndoController {
	private static UndoController instance = new UndoController();
	private UndoController() {}
	public void undoMe() {}

	public static UndoController getInstance() {
		return instance;
	}
	
	public void addUndoCommand(CommandHistory commandHistory, String previousCmd){
		commandHistory.push(commandHistory.getUndoCommandList(), previousCmd);
    }
	
//	public static void undoOneCommand(){
//        if(undoList.isEmpty()) 
//            System.out.println("Nothing to undo.\n");
//        else //add  bracket
//        	undoList.pop().undoMe();
//        	gameManager.setScore(-50);
//        
//    }
	
	public String getPreviousCmd(CommandHistory commandHistory) {
		
		if(commandHistory.isEmpty(commandHistory.getUndoCommandList())){
			return null;	// -> print "Nothing to undo\n."
		}
		
		List<String> undoList = commandHistory.getUndoCommandList();
		return undoList.get(undoList.size()-1);
	}
	
	public void execute(CommandHistory commandHistory, Stock stock, Waste waste) {
		String previousCmd = getPreviousCmd(commandHistory);
		String[] cmdParts = previousCmd.split(" ");
		if(cmdParts[0].equals("D")) {
			if(!stock.isEmpty(stock.getCardList())) {
				stock.peek(stock.getCardList()).flip();
			}
			stock.push(stock.getCardList(), waste.pop(waste.getCardList()));
			waste.peek(waste.getCardList()).flip();
		}else if(cmdParts[0].equals("T")) {
			
		}else if(cmdParts[0].equals("W")){
			try {
				int moveTo = Integer.parseInt(cmdParts[1]);
				if(moveTo < 0 || moveTo > 6) {
					return; //return error message
				}
				
				if(moveTo == 0 ) {
					
				}else{
					
				}
			}catch(NumberFormatException e) {
				//return error message
			}
			
		}
	}
	
	
}
