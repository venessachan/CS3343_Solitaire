package stackManager;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public abstract class CardListAbstract implements CardList{
	public abstract String print();
	private List<Card> cardList  = new ArrayList<Card>();
	public CardListAbstract() {}

	public Card pop() {
		if(!cardList.isEmpty()) {
			return cardList.remove(cardList.size()-1);
		}
    	return null;
    }

    public void push(Card card) {
    	cardList.add(card);
    }

    public Card peek() {
    	if(!isEmpty()) {
			return cardList.get(cardList.size()-1);
		}
		return null;
    }
	
	public boolean isEmpty() {
    	return cardList.isEmpty();
	}
	
	public void clear() {
		cardList.clear();
	}
	
	public int count() {
		return cardList.size();
	}

	public List<Card> getCardList(){
		return cardList;
	}
}
