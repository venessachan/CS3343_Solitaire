package card;

public class Card {
	
	private Rank rank;
	private Suit suit;
	private Boolean show;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		this.show = false;
		
	}
	
	@Override
	public String toString() {
		if(this.show) {
			
			return this.printSuit()+ this.printRank();
			
		}else {
			return "??";
		}
	}
	
	private String printSuit() {
//		switch(this.suit) {
//		  case SPADES:
//		    result = "\u2660"; // ♠
//		    break;
//		  case HEARTS:
//		    result = "\u2665"; // ♥
//		    break;
//		  case DIAMONDS:
//			result = "\u2663"; // ♣
//			break;
//		  case CLUBS:
//			result = "\u2666"; // ♦
//			break;
//		  default:
//		    result = "Error";
//		    //throw new Exception();
//		}
		return suit.getSign();	
	}
	
	private String printRank() {
//		String result;
//		switch(this.rank) {
//		  case 1:
//		    result = "A";
//		    break;
//		  case 11:
//		    result = "J";
//		    break;
//		  case 12:
//			result = "Q";
//			break;
//		  case 13:
//			result = "K";
//			break;
//		  default:
//		    result = this.rank.toString();
//		}
		
		return rank.getSign();	
	}
	
	public void flip(){
		if(getShow())
			setShow(false);
		else
			setShow(true);
	};
	
	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public Boolean getShow() {
		return show;
	}
	
	public void setShow(Boolean show) {
		this.show = show;
	}
	
}