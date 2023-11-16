package stackManager;
import java.util.ArrayList;
import java.util.List;

import card.Card;
import card.Rank;
import card.Suit;

public class Foundation extends CardListAbstract{
	
	private static List<Card> cardList  = new ArrayList<Card>();
	private Suit foundationSuit;
	
	public Foundation(Suit suit) {
		super(cardList);
		foundationSuit = suit;
	}
	
	public boolean checkValidAction(Card card) {
		if(isEmpty(cardList)) 
			return checkValidAce(card);
		else 
			return checkValidNext(card);
	}
	
	public boolean checkValidAce(Card card){
		if(getSuit() == card.getSuit()) {
			if(card.getRank() == Rank.A) {
				return true;
			}else{
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean checkValidNext(Card card) {
		if(peek(cardList).getRank().getNum()+1 == card.getRank().getNum() 
				&& getSuit() == card.getSuit()) {
			return true;
		}
		return false;
	}
	
	public Suit getSuit() {
		return foundationSuit;
	}
	
	
	public boolean isFull() {
		if(cardList.size() >= 13) {
			return true;
		}else{
			return false;
		}
	}
	
	public List<Card> getCardList(){
		return cardList;
	}
	
	@Override
	public String print() {
		Card card = peek(cardList);
		if(card != null)
			return card.toString();
		else
			return foundationSuit.getSign();
	}
	
}
