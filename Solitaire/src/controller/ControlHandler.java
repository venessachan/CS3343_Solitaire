package controller;

import java.util.List;

import main.GameManager;
import stackManager.CommandHistory;
import stackManager.Foundation;
import stackManager.Stock;
import stackManager.Tableau;
import stackManager.Waste;

public abstract class ControlHandler {
	
    //private static final ControlHandler instance = new ControlHandler();
    static GameManager gameManager = GameManager.getInstance();
    protected Stock stock;
    protected Waste waste;
    protected CommandHistory commandHistory;
    protected List<Foundation> foundation;
    protected List<Tableau> tableaus;
    
    protected ControlHandler() {
    	stock = gameManager.getStock();
    	waste = gameManager.getWaste();
    	commandHistory = gameManager.getCommandHistory();
    	foundation = gameManager.getFoundation();
    	tableaus = gameManager.getTableaus();
    }
    
//    public static ControlHandler getInstance() {
//		return instance;
//	}

    public abstract int execute(String cmd);
    public void tabAutoFlip() {
    	gameManager.tabAutoFlip();
    } 
    
}
