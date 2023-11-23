package controller;

import card.Card;
import stackManager.Stock;
import stackManager.Waste;

public class DealController extends ControlHandler{
	private static DealController instance = new DealController();
	
	private DealController() {}
	
	public static DealController getInstance() {
	  if (instance == null) {
		  instance = new DealController();
	  }
	  return instance;
	}
		
	public static void resetInstance() {
        instance = null;
    }

	public int deal(Stock stock, Waste waste) {
		if(stock.isEmpty(stock.getCardList())) {
			//Error Part chock bug
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
			
			//push all the card back to stock from waste
			if(!waste.isEmpty(waste.getCardList())) {
				waste.peek(waste.getCardList()).flip();	//hide the top card
				while(!waste.isEmpty(waste.getCardList())) {
					stock.push(stock.getCardList(), waste.pop(waste.getCardList()));
				}
				return 1;
			}
			return -1;
			
		}else {
			//deal 1 card from stock to waste
			if(!waste.isEmpty(waste.getCardList())) {
				waste.peek(waste.getCardList()).flip();	//hide the top card	
			}
			waste.push(waste.getCardList(), stock.pop(stock.getCardList()));
			waste.peek(waste.getCardList()).flip();	//show the new top card
			return 2;
			
		}
		
	}

}
