package controller;

import main.GameManager;

public class ScoreController {
    public static ScoreController ScoreController = new ScoreController();
    GameManager gameManager = GameManager.getInstance();
    private int comboCount;
    private int score;
    
    private ScoreController() {
    	score = 0;
    	comboCount = 0;
    }
    
    public void checkCombo(String previousAction) {
    	if (previousAction.equals("0")) {
    		if (comboCount >= 20) {
    			addScore(50*10);
    		}
    		else if(comboCount >= 10) {
    			addScore(50*5);
    		}else if(comboCount >= 7) {
    			addScore(50*3);
    		}else if(comboCount >= 3) {
    			addScore(50*2);
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
	
	public static ScoreController getInstance() {
		return ScoreController;
	}
}