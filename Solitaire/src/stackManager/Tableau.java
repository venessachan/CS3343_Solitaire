package stackManager;
import java.util.List;

import card.Card;

public class Tableau extends CardListAbstract{
	//private List<Card> cardList  = new ArrayList<Card>();
	
	public Tableau() {
		super();
		clear();
	}
	
	public boolean checkValidAction(Card card) {	//check if the card fulfil the requirement to push into tableau
		if(isEmpty()) {			//if tableau is empty, only 'K' rank can put
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
	public boolean checkValidCard(Card moveFromCard, Card moveToCard) {
		if((moveToCard.getRank().getNum() - moveFromCard.getRank().getNum()) == 1 //Check difference is 1
				&& (moveFromCard.getSuit().getColor() != moveToCard.getSuit().getColor())) {// Check not the same color
			return true;
		}else{
			return false;
		}
	}
	
	public List<Card> getCardList(){
		return super.getCardList();
	}
	
	public void addAll(List<Card> cardList) {
		super.getCardList().addAll(cardList);
	}
	
	@Override
	public String print() {
		String results = "";
		for(Card c: getCardList()) {
			results += " "+ c.toString() +" ";
		}
		return results;
	}
	
}
	
