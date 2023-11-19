package controller;

import stackManager.Stock;
import stackManager.Waste;

public class DealController extends ControlHandler{
	private static DealController instance = new DealController();
	
	private DealController() {}
	
	public static DealController getInstance() {
		return instance;
	}
	
	
	//restart to reset the variable?
	
	public int deal(Stock stock, Waste waste) {

		
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
			
			
			//push all the card back to stock from waste
			if(!waste.isEmpty(waste.getCardList())) {
				waste.peek(waste.getCardList()).flip();	//hide the top card
				while(!waste.isEmpty(waste.getCardList())) {
					stock.push(stock.getCardList(), waste.pop(waste.getCardList()));
				}
				return 1;
			}else {
				//stock and waste are empty
				//error
				return -1;
			}
			
		}else {
			//deal 1 card from stock to waste
			waste.peek(waste.getCardList()).flip();	//hide the top card
			waste.push(waste.getCardList(), stock.pop(stock.getCardList()));
			waste.peek(waste.getCardList()).flip();	//show the new top card
			return 1;
		}
		
	}

}
