package controller;

import main.GameManager;

public class ControlHandler {
	
    private static final ControlHandler instance = new ControlHandler();
    static GameManager gameManager = GameManager.getInstance();
    
    protected ControlHandler() {}
    
    public static ControlHandler getInstance() {
		return instance;
	}

    public int execute(String cmd) {
    	return gameManager.commandExecute(cmd);
    }
    
    public void tabAutoFlip() {
    	gameManager.tabAutoFlip();
    } 
    
}
