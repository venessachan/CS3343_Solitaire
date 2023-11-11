package controller;

import java.util.List;

import card.Card;
import main.GameManager;
import stackManager.Foundation;
import stackManager.Tableau;

public class MoveToFoundation extends RecordedCommand{

	private Card removedCard;
	private int founIndex;
	private int tabIndex;
	
	@Override
	public void execute(String[] cmdParts) {
		Card c;
		GameManager gameManager = GameManager.getInstance();
		//try catch input
		int moveFrom = Integer.parseInt(cmdParts[0]);
		
		List<Foundation> foundate = gameManager.getFoundate();
		List<Tableau> tab = gameManager.getTab();
		
		if(moveFrom -1 <0 || moveFrom-1 > 6) {
			System.out.printf("Move invalid.\n\n");
			return;
		}
		
		//Check from waste or not
		c = tab.get(moveFrom-1).peek();
		
		boolean isPut = false;
		if(foundate.get(0).checkValidAction(c)) {
			founIndex = 0;
			isPut = true;
		}
		else if(foundate.get(1).checkValidAction(c)) {
			founIndex = 1;
			isPut = true;
		}
		else if(foundate.get(2).checkValidAction(c)) {
			founIndex = 2;
			isPut = true;
		}
		else if(foundate.get(3).checkValidAction(c)) {
			founIndex = 3;
			isPut = true;
		}
		else
			isPut = false;
			
		
		if(isPut) {
			tabIndex = moveFrom-1;
			foundate.get(founIndex).push(c);
			removedCard = tab.get(moveFrom-1).pop();
			addUndoCommand(this);
			clearRedoList();
			gameManager.checkCombo();
			gameManager.setScore(50);
			System.out.printf("Move successful.\n\n");
		}else {
			System.out.printf("Move invalid.\n\n");
		}
		
	}

	@Override
	public void undoMe() {
		GameManager gameManager = GameManager.getInstance();
		gameManager.getFoundate().get(founIndex).pop();
		gameManager.getTab().get(tabIndex).push(removedCard);
		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		GameManager gameManager = GameManager.getInstance();
		gameManager.getFoundate().get(founIndex).push(removedCard);
		gameManager.getTab().get(tabIndex).pop();
		addUndoCommand(this);	
	}
//
//	public int getFoundIndex() {
//		return founIndex;
//	}
}
