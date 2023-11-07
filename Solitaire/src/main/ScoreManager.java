package main;

public class ScoreManager {
    public static ScoreManager scoreManager = new ScoreManager();
    GameManager gameManager = GameManager.getInstance();
    private String previousAction;
    private int comboCount;
    private int score;
    
    private ScoreManager() {
    	score = 0;
    	comboCount = 0;
    	previousAction="";
    }

    public void checkCombo() {
    	if (previousAction.equals("T")) {
    		comboCount++;
    		if (comboCount >= 20) {
    			setScore(50*5);
    		}
    		else if(comboCount >= 10) {
    			setScore(50*5);
    		}else if(comboCount >= 7) {
    			setScore(50*3);
    		}else if(comboCount >= 3) {
    			setScore(50*2);
    		}else {
    			setScore(50);
    		}
    	}else {
    		comboCount = 0;
    	}
    }
    
    public void setPreviousAction(String previousAction) {
    	this.previousAction = previousAction;
    }
    
    public String getPreviousAction() {
    	return previousAction;
    }
    
    
	public void setScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return score;
	}
	
	public static ScoreManager getInstance() {
		return scoreManager;
	}
}