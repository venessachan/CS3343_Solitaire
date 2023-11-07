package controller;

import java.util.List;

import card.Card;
import main.GameManager;
import stackManager.Foundation;
import stackManager.Waste;

public class WasteToFoundation extends RecordedCommand{

	private Card removedCard;
	private int founIndex;
	
	@Override
	public void execute(String[] cmdParts) {
		Card c;
		GameManager g = GameManager.getInstance();
		Waste waste = g.getWaste();
		List<Foundation> foundate = g.getFoundate();
		
		
		if(waste.empty()) {
			System.out.printf("Move invalid.\n\n");
			return;
		}
		
		c= waste.peak();
		
		boolean isPut =false;
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
			foundate.get(founIndex).push(c);
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
