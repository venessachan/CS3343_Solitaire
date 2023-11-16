package controller;

import java.util.List;

import card.Card;
import main.GameManager;
import stackManager.Foundation;
import stackManager.Waste;

public class MoveToFoundationController extends ControlHandler{

	private Card removedCard;
	private int founIndex;
	private static MoveToFoundationController instance = new MoveToFoundationController();
	
	private MoveToFoundationController() {}
	
	public static MoveToFoundationController getInstance() {
		return instance;
	}
	
	public void execute(Card card, List<Foundation> foundation) {
		int foundationIndex = getListIndex(card, foundation);
		
		if(foundationIndex >=0) {
			foundation.get(founIndex).push(foundation.get(founIndex).getCardList(), card);
			

			
			System.out.printf("Move successful.\n\n");
		}else {
			System.out.printf("Move invalid.\n\n");
		}	
	}
	
	public int getListIndex(Card card, List<Foundation> foundation) {
		if(foundation.get(0).checkValidAction(card)) {
			return 0;
		}
		else if(foundation.get(1).checkValidAction(card)) {
			return 1;
		}
		else if(foundation.get(2).checkValidAction(card)) {
			return 2;
		}
		else if(foundation.get(3).checkValidAction(card)) {
			return 3;
		}
		else
			return -1;
	}


}
