package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.Card;
import main.GameManager;
import stackManager.Stock;
import stackManager.Waste;

public class DealController extends ControlHandler{
	private static DealController instance = new DealController();
	
	private DealController() {

	}
	
	//restart to reset the variable?
	
	public void execute(String[] cmdParts) {
		Stock stock = gameManager.getStock();
		Waste waste = gameManager.getWaste();
		
		if(stock.isEmpty()) {
			//Error Part cock bug
//			for(Card wastedCard: waste.getCardList()) {
//				stock.push(wastedCard);
//				wastedCard.setShow(false);
//			}
			
			//Revised
//			Collections.reverse(waste.getCardList());
//			for(Card wastedCard: waste.getCardList()) {
//				wastedCard.setShow(false);
//				stock.push(wastedCard);
//			}
			for(int i = 0; i < waste.getCardList().size(); i++) {
				stock.push(waste.pop());
			}
			
			waste.clear();
		}
		
		card = stock.pop();
		card.setShow(true);
		waste.push(card);
		
		addUndoCommand(this);
		clearRedoList();
		System.out.print("A card added to Waste. \n\n");
	}

}
