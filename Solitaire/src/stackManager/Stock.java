package stackManager;
import java.util.ArrayList;
import java.util.List;

import card.Card;

public class Stock extends CardListAbstract{
	private static List<Card> cardList  = new ArrayList<Card>();
	
	public Stock() {
		super(cardList);
	}
	
//	public Card deal() {
//		return pop();
//		
//	}
	
//	public void setStock(List<Card> cards) {
//		if(isEmpty()) 
//			cardList.addAll(cards);
//	}

	public List<Card> getCardList() {
		return cardList;
	}
	
	@Override
	public String print() {
		return null;
	}
}
