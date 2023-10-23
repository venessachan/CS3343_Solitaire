package stackManager;
import card.Card;
import card.Rank;
import card.Suit;

public class Foundation extends CardListAbstract{

	private Suit suit;
	
	public Foundation(Suit suit) {
		super();
		this.suit = suit;
	}
	
	public boolean checkValidAction(Card card) {
		if(empty()) 
			return checkValidAce(card);
		else 
			return checkValidNext(card);
		
	}
	
	private boolean checkValidAce(Card card){
		if(suit == card.getSuit()) 
			return card.getRank() == Rank.A? true: false;
		else
			return false;
	}
	
	private boolean checkValidNext(Card card) {
		if(getLastCard().getRank().getNum()+1 == card.getRank().getNum() 
				&& getLastCard().getSuit() == card.getSuit()) {
			return true;
		}
		return false;
	}
	
	@Override
	public void push(Card card) {
		cardList.add(card);
	}
	
	@Override
	public Card pop() {
		return null;
	}
	
	@Override
	public String print() {
		Card c = getLastCard();
		if(c != null)
			return c.toString();
		else
			return suit.getSign();
	}
	
	public boolean full() {
		return cardList.size() >= 13? true: false;
	}
	
	public Card getLastCard(){
		if(!empty()) {
			return cardList.get(cardList.size()-1);
		}
		return null;
	}

	public Suit getSuit() {
		return suit;
	}

	
}
