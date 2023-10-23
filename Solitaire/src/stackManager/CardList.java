package stackManager;

import java.util.List;

import card.Card;

public interface CardList {

	public Card pop();
	public void push(Card card);
	public boolean empty();
	public List<Card> getCardList();
	public String print();
}
