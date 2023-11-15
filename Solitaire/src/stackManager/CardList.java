package stackManager;

import java.util.List;

import card.Card;

public interface CardList {

	public void push(Card card);
	public Card pop();
	public Card peek();
	public boolean isEmpty();
	public void clear();
	public List<Card> getCardList();
	public String print();
}
