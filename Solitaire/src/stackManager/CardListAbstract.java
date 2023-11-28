package stackManager;

import java.util.List;

import card.Card;

public abstract class CardListAbstract implements CardList{
	public abstract String print();
	
	public CardListAbstract() {}

	public Card pop(List<Card> cardList) {
    	return cardList.remove(cardList.size()-1);
    }

    public void push(List<Card> cardList, Card card) {
    	//not check isFull -> chock bug
//    	if(isFoundation && isFull(cardList)) {
//    		//cannot add message
//    	}else {
//    		cardList.add(card);
//    	}
    	cardList.add(card);
    }

    public Card peek(List<Card> cardList) {
    	if(!isEmpty(cardList)) {
			return cardList.get(cardList.size()-1);
		}
		return null;
    }
	
	public boolean isEmpty(List<Card> cardList) {
    	return cardList.isEmpty();
	}
	
	public void clear(List<Card> cardList) {
		cardList.clear();
	}
	
	public int count(List<Card> cardList) {
		return cardList.size();
	}

}
