package stackManager;

import card.Card;

public class Waste extends CardListAbstract{
	
	public Waste() {
		super();
	}
	
	@Override
	public String print(){
		if(!isEmpty()) 
			return cardList.get(cardList.size()-1).toString();
		else 
			return "XX";
	}
	
}
