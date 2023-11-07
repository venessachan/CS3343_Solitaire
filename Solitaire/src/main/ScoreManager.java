package main;

public class ScoreManager {
    public static ScoreManager scoreManager = new ScoreManager();
    GameManager gameManager = GameManager.getInstance();
    private String previousAction;
    private int comboCount;
    private int score;
    
    public ScoreManager() {
    	score = 0;
    	comboCount = 0;
    	previousAction="";
    }

    public void checkCombo() {
    	if (previousAction.equals("T")) {
    		if (comboCount >= 20) {
    			setScore(50*10);
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
    		comboCount++;
    	}else {
    		setComboCount(0);
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
	
	
	public void setComboCount(int comboCount) {
		this.comboCount = comboCount;
	}
	
	public int getComboCount() {
		return comboCount;
	}
	
	public static ScoreManager getInstance() {
		return scoreManager;
	}
}