package stackManager;

import card.Card;

public class Waste extends CardListAbstract{
	
	public Waste() {
		super();
	}
	
	public Card peak() {
		return cardList.get(cardList.size()-1);
	
	}

	@Override
	public Card pop() {
		return cardList.remove(cardList.size()-1);
	
	}

	@Override
	public void push(Card card) {
		cardList.add(card);
	}

	@Override
	public String print(){
		if(!empty()) 
			return cardList.get(cardList.size()-1).toString();
		else 
			return "XX";
	}
	
}
