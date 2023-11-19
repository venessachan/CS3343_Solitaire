package controller;

import java.util.Stack;

import main.GameManager;

public class RedoController {
	private static RedoController instance = new RedoController();

	private RedoController() {}

	public static RedoController getInstance() {
		return instance;
	}
	
	public void addRedoCommand(CommandHistory commandHistory, String undoCmd){
		commandHistory.push(commandHistory.getRedoCommandList(), undoCmd);
    }
	
	public void clearRedoList(CommandHistory commandHistory){
		commandHistory.clear(commandHistory.getRedoCommandList());
    }
	
	public String popRedoCommand(CommandHistory commandHistory){
		return commandHistory.pop(commandHistory.getRedoCommandList());
    }
	
	public boolean isEmpty(CommandHistory commandHistory){
		return commandHistory.isEmpty(commandHistory.getRedoCommandList());
    }

	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
}
