package stackManager;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public abstract class CardListAbstract implements CardList{
	
	protected List<Card> cardList;
	
	public CardListAbstract() {
		cardList = new ArrayList<Card>();
	}
	
	@Override
	public boolean empty() {
		return cardList.isEmpty();
	}
	
	@Override
	public List<Card> getCardList(){
		return cardList;
	}
	
}
