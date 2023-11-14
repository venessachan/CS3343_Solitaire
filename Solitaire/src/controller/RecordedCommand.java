package controller;

import java.util.Stack;

import main.GameManager;
import main.ScoreManager;

public abstract class RecordedCommand implements Command {
	
    public abstract void undoMe();
    public abstract void redoMe();
    static GameManager gameManager = GameManager.getInstance();
    
    private static Stack<RecordedCommand> undoList = new Stack<>();
    private static Stack<RecordedCommand> redoList = new Stack<>();
    
    protected static void addUndoCommand(RecordedCommand cmd){
        undoList.push(cmd);
    }

    protected static void addRedoCommand(RecordedCommand cmd){
        redoList.push(cmd);
    }
    
    protected static void clearRedoList(){
    	redoList.clear();
    }
    
    public static void undoOneCommand(){
        if(undoList.isEmpty()) 
            System.out.println("Nothing to undo.\n");
        else //add  bracket
        	undoList.pop().undoMe();
        	gameManager.setScore(-50);
        
    }
    
    public static void redoOneCommand()
    {
        if(redoList.isEmpty())
            System.out.println("Nothing to redo.\n");
        else
           redoList.pop().redoMe();
    }
    
}
