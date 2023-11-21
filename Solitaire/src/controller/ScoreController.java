package controller;

import main.GameManager;

public class ScoreController {
    //private static ScoreController ScoreController = new ScoreController();
	private static ScoreController instance;
    
    GameManager gameManager = GameManager.getInstance();
    private int comboCount;
    private int score;
    
    private ScoreController() {
    	setScore(0);
    	comboCount = 0;
    }
    
    public static ScoreController getInstance() {
  	  if (instance == null) {
          instance = new ScoreController();
      }
      return instance;
  	}
  	
  	public static void resetInstance() {
      instance = null;
  	}
    
    public void checkCombo(String previousAction) {
    	String[] previousActionParts = previousAction.split(" ");
    	if ((previousActionParts[0].equals("W") && previousActionParts[1].equals("0"))
    			|| (previousActionParts[0].equals("T") && previousActionParts[2].equals("0"))) {
    		if (comboCount >= 20) {
    			addScore(50*32);
    		}
    		else if(comboCount >= 10) {
    			addScore(50*16);
    		}else if(comboCount >= 7) {
    			addScore(50*8);
    		}else if(comboCount >= 3) {
    			addScore(50*4);
    		}else {
    			addScore(50);
    		}
    		comboCount++;
    	}else {
    		setComboCount(0);
    	}
    }
    
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public void setComboCount(int comboCount) {
		this.comboCount = comboCount;
	}
	
	public int getComboCount() {
		return comboCount;
	}
}