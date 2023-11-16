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
	
	private DealController() {}
	
	public static DealController getInstance() {
		return instance;
	}
	
	
	//restart to reset the variable?
	
	public void execute(Stock stock, Waste waste) {

		
		if(stock.isEmpty(stock.getCardList())) {
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
			waste.peek(waste.getCardList()).flip();
			while(!waste.isEmpty(waste.getCardList())) {
				stock.push(stock.getCardList(), waste.pop(waste.getCardList()));
			}
		}else {
			waste.peek(waste.getCardList()).flip();
			waste.push(waste.getCardList(), stock.pop(stock.getCardList()));
			waste.peek(waste.getCardList()).flip();
		}
		
	}

}
