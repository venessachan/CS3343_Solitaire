package stackManager;

import java.util.List;

import card.Card;

public class Waste extends CardListAbstract{
	
	//private static List<Card> cardList  = new ArrayList<Card>();
	
	public Waste() {
		super();
		clear();
	}
	
	public List<Card> getCardList(){
		return super.getCardList();
	}
	
	@Override
	public String print(){
		if(!isEmpty()){
			if(!peek().getShow()) {
				peek().flip();
			}
			return peek().toString();
		}else {
			return "XX";
		}	
	}
	
}
