package stackManager;
import java.util.List;

import card.Card;

public class Stock extends CardListAbstract{
	//private static List<Card> cardList  = new ArrayList<Card>();
	
	public Stock() {
		super();
		clear();
	}

	public List<Card> getCardList() {
		return super.getCardList();
	}
	
	@Override
	public String print() {
		return null;
	}
}
