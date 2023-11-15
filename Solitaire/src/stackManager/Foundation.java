package stackManager;
import card.Card;
import card.Rank;
import card.Suit;

public class Foundation extends CardListAbstract{

	private Suit foundationSuit;
	public Foundation(Suit suit) {
		super();
		foundationSuit = suit;
	}
	
	public boolean checkValidAction(Card card) {
		if(empty()) 
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
		if(getLastCard().getRank().getNum()+1 == card.getRank().getNum() 
				&& getSuit() == card.getSuit()) {
			return true;
		}
		return false;
	}
	
	public boolean full() {
		if(cardList.size() >= 13) {
			return true;
		}else{
			return false;
		}
	}
	
	public Card getLastCard(){
		if(!empty()) {
			return cardList.get(cardList.size()-1);
		}
		return null;
	}

	public Suit getSuit() {
		return foundationSuit;
	}
	
	@Override
	public String print() {
		Card card = getLastCard();
		if(card != null)
			return card.toString();
		else
			return foundationSuit.getSign();
	}

	
}
