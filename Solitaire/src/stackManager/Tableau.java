package stackManager;
import java.util.List;

import card.Card;

public class Tableau extends CardListAbstract{
	private int topIndex;
	
	public Tableau() {
		super();
		topIndex = -1;
	}
	
	public boolean checkValidAction(Card card) {	//check if the card fulfil the requirement to push into tableau
		if(empty()) {			//if tableau is empty, only 'K' rank can put
			if(card.getRank().getNum() == 13)
				return true;
			else
				return false;
			
		}
		else {					//if tableau is not empty, check whether the rank of (the last card - put card = 1) and have different color
			return checkValidCard(card, peek());
		}
		
	}
	
	//check correct rank and suit
	private boolean checkValidCard(Card moveFromCard, Card moveToCard) {
		if((moveToCard.getRank().getNum() - moveFromCard.getRank().getNum()) == 1 //Check difference is 1
				&& (moveFromCard.getSuit().getColor() != moveToCard.getSuit().getColor())) {// Check not the same color
			return true;
		}else{
			return false;
		}
	}
	
	//put card(s) from another Tableau
	public void put(List<Card> cards) {
		for(Card c :cards) {
			cardList.add(c);
			topIndex++;
		}
	}
	
	@Override
	public void push(Card card) {
		cardList.add(card);
		topIndex++;
	}
	
	//remove last card
	@Override
	public Card pop() {
		Card removed = cardList.remove(topIndex);
		topIndex--;
		return removed;
	}
	
	@Override
	public String print() {
		String results = "";
		for(Card c: cardList) {
			results += " "+ c.toString() +" ";
		}
		return results;
		
	}
	
	public Card peek() {	//return the top card
		return cardList.get(topIndex);
	}
	
}
	
