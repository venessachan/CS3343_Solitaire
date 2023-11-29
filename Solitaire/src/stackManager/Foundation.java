package stackManager;
import java.util.List;

import card.Card;
import card.Rank;
import card.Suit;

public class Foundation extends CardListAbstract{
	
	//private List<Card> cardList  = new ArrayList<Card>();
	private Suit foundationSuit;
	
	public Foundation(Suit suit) {
		super();
		super.clear();
		setSuit(suit);
	}
	
	public boolean checkValidAction(Card card) {
		if(isFull()) {
			return false;
		}
        if(isEmpty()) {
        	return checkValidAce(card);
        }
        return checkValidNext(card);
    }
	
	public boolean checkValidAce(Card card){
		if(getSuit() == card.getSuit() 
				&& card.getRank() == Rank.A) {
			return true;
		}
		
		return false;
	}
	
	public boolean checkValidNext(Card card) {
		if(peek().getRank().getNum()+1 == card.getRank().getNum() 
				&& getSuit() == card.getSuit()) {
			return true;
		}
		
		return false;
	}
	
	public Suit getSuit() {
		return foundationSuit;
	}
	
	public void setSuit(Suit suit) {
		foundationSuit = suit;
	}
	
	
	public boolean isFull() {
		if(count() >= 13) {
			return true;
		}else{
			return false;
		}
	}
	
	public List<Card> getCardList(){
		return super.getCardList();
	}
	
	@Override
	public String print() {
		Card card = peek();
		if(card != null)
			return card.toString();
		else
			return foundationSuit.getSign();
	}
}
