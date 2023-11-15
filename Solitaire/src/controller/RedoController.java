package controller;

import java.util.Stack;

import main.GameManager;

public class RedoController {
	private static RedoController instance = new RedoController();

	private RedoData redoData;
	
	private RedoController() {
		redoData = new RedoData();
	}
	
	public void redoMe() {}
	
	protected void addRedoCommand(ControlHandler cmd){
        redoList.push(cmd);
    }
	
	public void clearRedoList(){
    	redoList.clear();
    }
	
	public static void redoOneCommand()
    {
        if(redoList.isEmpty())
            System.out.println("Nothing to redo.\n");
        else
           redoList.pop().redoMe();
    }
	
	public static RedoController getInstance() {
		return instance;
	}
}
