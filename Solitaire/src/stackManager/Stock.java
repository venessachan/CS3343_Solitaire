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
		if(empty()) 
			cardList.addAll(cards);
	}
	
	@Override
	public void push(Card card) {
		cardList.add(card);
	}
	
	@Override
	public Card pop() {
		Card card = cardList.remove(0);
		return card;
	}
	
	@Override
	public String print() {
		return null;
	}
}
