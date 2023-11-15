package stackManager;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public abstract class CardListAbstract implements CardList{
	
	protected List<Card> cardList;
	
	public CardListAbstract() {
		cardList = new ArrayList<Card>();
		cardList.clear();
	}
	
	public Card pop(List<Card> cardList) {
    	return cardList.remove(cardList.size()-1);
    }
    
    public void push(List<Card> cardList, Card card, boolean isFoundation) {
    	//not check isFull -> chock bug
    	if(isFoundation && isFull(cardList)) {
    		//cannot add message
    	}else {
    		cardList.add(card);
    	}
    }
    
    public Card peek(List<Card> cardList) {
    	if(!isEmpty(cardList)) {
			return cardList.get(cardList.size()-1);
		}
		return null;
    }
    
    private boolean isEmpty(List<Card> cardList) {
    	return cardList.isEmpty();
	}

    //may only in foundation
	public boolean isFull(List<Card> cardList) {
		if(cardList.size() >= 13) {
			return true;
		}else{
			return false;
		}
	}

	public void clear(List<Card> cardList) {
		cardList.clear();
		
	}
	
}
