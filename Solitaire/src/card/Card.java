package card;

public class Card {
	
	private Integer rank;
	private Integer suit;
	private Boolean show;
	
	public Card(Integer rankNum, Integer SuitNum) {
		this.rank = rankNum;
		this.suit = SuitNum;
		this.show = false;
		
	}
	
	public String print() {
		if(this.show) {
			
			return this.printSuit()+ this.printRank();
			
		}else {
			return "??";
		}
	}
	
	private String printSuit() {
		String result;
		
		switch(this.suit) {
		  case 1:
		    result = "\u2660"; // ♠
		    break;
		  case 2:
		    result = "\u2665"; // ♥
		    break;
		  case 3:
			result = "\u2663"; // ♣
			break;
		  case 4:
			result = "\u2666"; // ♦
			break;
		  default:
		    result = "Error";
		}
		
		return result;	
	}
	
	private String printRank() {
		String result;
		
		switch(this.rank) {
		  case 1:
		    result = "A";
		    break;
		  case 11:
		    result = "J";
		    break;
		  case 12:
			result = "Q";
			break;
		  case 13:
			result = "K";
			break;
		  default:
		    result = this.rank.toString();
		}
		
		return result;	
	}
	
	public void flip(){
		if(this.show)
			this.show = false;
		else
			this.show = true;
	};
	
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getSuit() {
		return suit;
	}
	public void setSuit(Integer suit) {
		this.suit = suit;
	}
	public Boolean getShow() {
		return show;
	}
	public void setShow(Boolean show) {
		this.show = show;
	}
	
	
}