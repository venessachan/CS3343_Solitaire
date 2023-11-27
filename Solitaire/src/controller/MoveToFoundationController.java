package controller;

import java.util.List;

import card.Card;
import main.GameManager;
import stackManager.Foundation;
import stackManager.Waste;

public class MoveToFoundationController extends ControlHandler{

	private static MoveToFoundationController instance = new MoveToFoundationController();
	
	private MoveToFoundationController() {}
	
	public static MoveToFoundationController getInstance() {
	  if (instance == null) {
		  instance = new MoveToFoundationController();
	  }
	  return instance;
	}
		
	public static void resetInstance() {
        instance = null;
    }

	public void execute(Card moveFromCard, Foundation foundation) {
		foundation.push(foundation.getCardList(), moveFromCard);
	}
	
	public int getListIndex(Card moveFromCard, List<Foundation> foundation) {
		if(foundation.get(0).checkValidAction(moveFromCard)) {
			return 0;
		}
		else if(foundation.get(1).checkValidAction(moveFromCard)) {
			return 1;
		}
		else if(foundation.get(2).checkValidAction(moveFromCard)) {
			return 2;
		}
		else if(foundation.get(3).checkValidAction(moveFromCard)) {
			return 3;
		}
		else
			return -1;
	}
}
