package stackManager;
import java.util.List;

import card.Card;

public class Stock extends CardListAbstract{
	
	public Stock() {
		super();
	}
	
	public int count() {
		return cardList.size();
	}
	
//	public Card deal() {
//		return pop();
//		
//	}
	
	public void setStock(List<Card> cards) {
		if(isEmpty()) 
			cardList.addAll(cards);
	}

}
