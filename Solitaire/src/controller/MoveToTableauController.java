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
				temp.add(moveFrom.pop());
			}
			Collections.reverse(temp);
			moveTo.addAll(temp);
		} else if (cardMove == 1) {
			moveTo.push(moveFrom.pop());
		}
		// else invalid move
	}

	// Waste to tableau
	public void execute(Waste moveFrom, Tableau moveTo, int cardMove) {
		moveTo.push(moveFrom.pop());
	}

	// Foundation to tableau
	public void execute(Foundation moveFrom, Tableau moveTo, int cardMove) {
		moveTo.push(moveFrom.pop());
	}

	// Move 1 card from waste to tableau
	public int getMoveCardCount(Card moveFrom, Tableau target) {
		if (target.checkValidAction(moveFrom)) {
			return 1;
		}
		return -1;
	}
	
	//Find available card(s) can move from tableau to tableau
	public int getMoveCardCount(Tableau moveFrom, Tableau target, int showCardCount) {
		int j = moveFrom.count() -1;
		for(int i = 0; i < showCardCount; i++) {
			if(target.checkValidAction(moveFrom.getCardList().get(j))) {			//find the starting card in moveFrom tableau
				return checkValidColumn(j, moveFrom);
			}
			j--;
		}
		return -1;
	}

	//Check validation for moveFrom tableau
	public int checkValidColumn(int start, Tableau moveFrom) {
		int validCount = 1;
		for(int i = moveFrom.count()-1; i > start; i--) {		//check the card from last card of moveFrom tableau to starting card
			if(moveFrom.checkValidCard(moveFrom.getCardList().get(i), moveFrom.getCardList().get(i-1))){
				//valid
				validCount++;
			}else {
				return -2;
			}
		}
		return validCount;
	}

	//get how many cards are shown in the card list
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
