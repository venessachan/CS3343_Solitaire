package stackManager;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public class Waste extends CardListAbstract{
	
	private static List<Card> cardList  = new ArrayList<Card>();
	
	public Waste() {
		super(cardList);
	}
	
	public List<Card> getCardList(){
		return cardList;
	}
	
	@Override
	public String print(){
		if(!isEmpty(cardList)) 
			return cardList.get(cardList.size()-1).toString();
		else 
			return "XX";
	}
	
}
