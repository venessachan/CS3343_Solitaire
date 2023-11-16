package stackManager;

import java.util.List;

import card.Card;

public interface CardList {

	public void push(List<Card> cardList, Card card);
	public Card pop(List<Card> cardList);
	public Card peek(List<Card> cardList);
	public boolean isEmpty(List<Card> cardList);
	public void clear(List<Card> cardList);
	public String print();
	int count(List<Card> cardList);
}
