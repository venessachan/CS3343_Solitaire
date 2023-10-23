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
		GameManager g = GameManager.getInstance();
		int moveFrom = Integer.parseInt(cmdParts[0]);
		
		List<Foundation> foundate = g.getFoundate();
		List<Tableau> tab = g.getTab();
		
		if(moveFrom -1 <0 || moveFrom-1 > 6) {
			System.out.printf("Move invalid.\n\n");
			return;
		}
		
		//Check from waste or not
		c= tab.get(moveFrom-1).peek();
		
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
			tabIndex = moveFrom-1;
			foundate.get(founIndex).push(c);
			removedCard = tab.get(moveFrom-1).pop();
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
		g.getFoundate().get(founIndex).pop();
		g.getTab().get(tabIndex).push(removedCard);
		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		GameManager g = GameManager.getInstance();
		g.getFoundate().get(founIndex).push(removedCard);
		g.getTab().get(tabIndex).pop();
		addUndoCommand(this);	
	}

}
