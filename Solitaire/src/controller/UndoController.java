package controller;

public class UndoController {
	public void undoMe() {}
	
	protected static void addUndoCommand(ControlHandler cmd){
        undoList.push(cmd);
    }
	
	public static void undoOneCommand(){
        if(undoList.isEmpty()) 
            System.out.println("Nothing to undo.\n");
        else //add  bracket
        	undoList.pop().undoMe();
        	gameManager.setScore(-50);
        
    }
}
