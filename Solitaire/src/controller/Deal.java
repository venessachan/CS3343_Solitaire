package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.Card;
import main.GameManager;
import stackManager.Stock;
import stackManager.Waste;

public class Deal extends RecordedCommand{
	
	private Card c;

	@Override
	public void execute(String[] cmdParts) {
		GameManager g = GameManager.getInstance();
		Stock stock = g.getStock();
		Waste waste = g.getWaste();
		
		if(stock.empty()) {
			//Error Part
//			for(Card wastedCard: waste.getCardList()) {
//				stock.push(wastedCard);
//				wastedCard.setShow(false);
//			}
			
			//Revised
			Collections.reverse(waste.getCardList());
			for(Card wastedCard: waste.getCardList()) {
				wastedCard.setShow(false);
				stock.push(wastedCard);
			}
			waste.getCardList().clear();
		}
		
		c = stock.pop();
		c.setShow(true);
		waste.push(c);
		
		addUndoCommand(this);
		clearRedoList();
		System.out.print("A card added to Waste. \n\n");
	}

	@Override
	public void undoMe() {
		GameManager g = GameManager.getInstance();
		Stock stock = g.getStock();
		Waste waste = g.getWaste();
		c.setShow(false);
		stock.push(c);
		waste.pop();
    	addRedoCommand(this);
		
	}

	@Override
	public void redoMe() {
		GameManager g = GameManager.getInstance();
		Stock stock = g.getStock();
		Waste waste = g.getWaste();
		c.setShow(true);
		stock.pop();
		waste.push(c);
		addUndoCommand(this);
	}

}
