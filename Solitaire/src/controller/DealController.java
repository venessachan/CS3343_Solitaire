package controller;

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
		if(stock.isEmpty()) {			
			//push all the card back to stock from waste
			if(!waste.isEmpty()) {
				waste.peek().flip();	//hide the top card
				while(!waste.isEmpty()) {
					stock.push(waste.pop());
				}
				return 1;
			}
			return -1;
			
		}else {
			//deal 1 card from stock to waste
			if(!waste.isEmpty()) {
				waste.peek().flip();	//hide the top card	
			}
			waste.push(stock.pop());
			waste.peek().flip();	//show the new top card
			return 2;
			
		}
		
	}

}
