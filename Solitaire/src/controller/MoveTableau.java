package controller;

import java.util.List;
import java.util.Stack;

import card.Card;
import main.GameManager;
import stackManager.Tableau;

public class MoveTableau extends RecordedCommand{

	private int From;
	private int To;
	private Stack<Card> cards = new Stack<>();
	private int times;
	
	@Override
	public void execute(String[] cmdParts) {
		
		int moveFrom = Integer.parseInt(cmdParts[0]);
		int moveTo = Integer.parseInt(cmdParts[1]);
		
		GameManager g = GameManager.getInstance();
		List<Tableau> tab = g.getTab();
		
		if(moveFrom -1 <0 || moveFrom-1 > 6) {
			System.out.printf("Move invalid.\n\n");
			return;
		}
		if(moveTo -1 <0 || moveTo-1 > 6) {
			System.out.printf("Move invalid.\n\n");
			return;
		}
		
		//Revised
//		if(moveFrom == moveTo) {
//			System.out.printf("Move invalid.\n\n");
//			return;
//		}
		
		Tableau tabFrom = tab.get(moveFrom-1);
		Tableau tabTo = tab.get(moveTo-1);
		
		From = moveFrom-1;
		To = moveTo-1;
		
		if(tabFrom.empty()) {
			System.out.printf("Move invalid\n\n");
			return;
		}
	
		int tabIndex=0;
		for(Card c: tabFrom.getCardList()) {
			if(c.getShow())
				break;
			tabIndex++;
		}
		
		boolean isPut = false;
		while(tabIndex < tabFrom.getCardList().size()) {
			Card cardFrom = tabFrom.getCardList().get(tabIndex);
			if(tabTo.checkValidAction(cardFrom)) {
				isPut = true;
				break;
			}
			tabIndex ++;
		}
		
		if(isPut) {
			List<Card> range = tabFrom.getCardList().subList(tabIndex, tabFrom.getCardList().size());
			tabTo.put(range);
			
			times = range.size();
			
			for(int i=0; i<times;i++) {
				tabFrom.pop();
			}
			
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
		Tableau tabFrom = g.getTab().get(From);
		Tableau tabTo = g.getTab().get(To);
		
		for(int i=0; i<times;i++) {
			cards.push(tabTo.pop());
		}
		
		for(int i=0; i<times;i++) {
			tabFrom.push(cards.pop());
		}
		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		GameManager g = GameManager.getInstance();
		Tableau tabFrom = g.getTab().get(From);
		Tableau tabTo = g.getTab().get(To);
		
		for(int i=0; i<times;i++) {
			cards.push(tabFrom.pop());
		}
		
		for(int i=0; i<times;i++) {
			tabTo.push(cards.pop());
		}
		addUndoCommand(this);	
	}

}
