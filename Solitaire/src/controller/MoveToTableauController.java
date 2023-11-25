package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.Card;
import stackManager.Foundation;
import stackManager.Tableau;
import stackManager.Waste;

public class MoveToTableauController extends ControlHandler {

	// private int times;
	private static MoveToTableauController instance = new MoveToTableauController();

	private MoveToTableauController() {
	}

	public static MoveToTableauController getInstance() {
		if (instance == null) {
			instance = new MoveToTableauController();
		}
		return instance;
	}

	public static void resetInstance() {
		instance = null;
	}

	// Tableau to tableau
	public void execute(Tableau moveFrom, Tableau moveTo, int cardMove) {
		if (cardMove > 1) { // more than 1 card to move
			List<Card> temp = new ArrayList<Card>();
			temp.clear();
			for (int i = 0; i < cardMove; i++) {
				temp.add(moveFrom.pop(moveFrom.getCardList()));
			}
			Collections.reverse(temp);
			moveTo.addAll(temp);
		} else if (cardMove == 1) {
			moveTo.push(moveTo.getCardList(), moveFrom.pop(moveFrom.getCardList()));
		}
		// else invalid move
	}

	// Waste to tableau
	public void execute(Waste moveFrom, Tableau moveTo, int cardMove) {
		moveTo.push(moveTo.getCardList(), moveFrom.pop(moveFrom.getCardList()));
	}

	// Foundation to tableau
	public void execute(Foundation moveFrom, Tableau moveTo, int cardMove) {
		moveTo.push(moveTo.getCardList(), moveFrom.pop(moveFrom.getCardList()));
	}

	// Tableau to Foundation
	public void execute(Tableau moveFrom, Foundation moveTo, int cardMove) {
		moveTo.push(moveTo.getCardList(), moveFrom.pop(moveFrom.getCardList()));
	}

	// Move 1 card
	public int getMoveCardCount(Card moveFrom, Tableau target) {
		if (target.checkValidAction(moveFrom)) {
			return 1;
		}
		return -1;
	}

	// Move more than 1 card
	public int getMoveCardCount(List<Card> moveFromList, Tableau target, int showCardListCount) {
		int moveCardCount = 1;
		boolean validCardList = false;
		
		//check the count of moveFromList when a valid card exist
		for (int i = moveFromList.size() - 1; i >= 0; i--) { 
			
			if(!validCardList) {
				validCardList = target.checkValidAction(moveFromList.get(i));
			}
			
			if(moveFromList.size() <= 1) 
				break;
			
			//if card list Top card not match suit/rank, break the loop
			if(moveFromList.get(i).getSuit().getColor() == moveFromList.get(i - 1).getSuit().getColor()
					|| (moveFromList.get(i).getRank().getNum() - moveFromList.get(i - 1).getRank().getNum() != 1)) {
				break;
			}
			moveCardCount++;
			
			
		}
		
		if(validCardList)
			return moveCardCount;
		
		return -1;
	}

	public int getShowCard(List<Card> moveFromList) {
		int showCardCount = 0;

		for (int i = moveFromList.size() -1 ; i >= 0; i--) {
			if (!moveFromList.get(i).getShow()) {
				return showCardCount;
			}
			showCardCount++;
		}
		
		return showCardCount;
	}
}
