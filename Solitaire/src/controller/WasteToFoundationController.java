package controller;

import java.util.List;

import card.Card;
import main.GameManager;
import stackManager.Foundation;
import stackManager.Waste;

public class WasteToFoundationController extends ControlHandler{

	private Card removedCard;
	private int founIndex;
	
	@Override
	public void execute(String[] cmdParts) {
		Card card;
		GameManager gameManager = GameManager.getInstance();
		Waste waste = gameManager.getWaste();
		List<Foundation> foundate = gameManager.getFoundate();
		
		
		if(waste.empty()) {
			System.out.printf("Move invalid.\n\n");
			return;
		}
		
		card= waste.peak();
		
		boolean isPut =false;
		if(foundate.get(0).checkValidAction(card)) {
			founIndex = 0;
			isPut = true;
		}
		else if(foundate.get(1).checkValidAction(card)) {
			founIndex = 1;
			isPut = true;
		}
		else if(foundate.get(2).checkValidAction(card)) {
			founIndex = 2;
			isPut = true;
		}
		else if(foundate.get(3).checkValidAction(card)) {
			founIndex = 3;
			isPut = true;
		}
		else
			isPut = false;
			
		
		if(isPut) {
			foundate.get(founIndex).push(card);
			removedCard = waste.pop();
			addUndoCommand(this);
			clearRedoList();
			
			System.out.printf("Move successful.\n\n");
		}else {
			System.out.printf("Move invalid.\n\n");
		}
		
	}

	@Override
	public void undoMe() {
		GameManager g = GameManager.getInstance();
		g.getWaste().push(removedCard);
		g.getFoundate().get(founIndex).pop();
		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		GameManager g = GameManager.getInstance();
		g.getWaste().pop();
		g.getFoundate().get(founIndex).push(removedCard);
		addUndoCommand(this);	
	}

}
