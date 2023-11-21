package stackManager;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public class Waste extends CardListAbstract{
	
	private static List<Card> cardList  = new ArrayList<Card>();
	
	public Waste() {
		super();
		cardList.clear();
	}
	
	public List<Card> getCardList(){
		return cardList;
	}
	
	@Override
	public String print(){
		if(!isEmpty(cardList)){
			if(!peek(cardList).getShow()) {
				peek(cardList).flip();
			}
			return peek(cardList).toString();
		}else {
			return "XX";
		}	
	}
	
}
