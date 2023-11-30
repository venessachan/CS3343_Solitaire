package stackManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import card.Card;
import card.Rank;
import card.Suit;

public class Deck extends CardListAbstract{
	private List<Card> cards = new ArrayList<Card>();
	private int totalNum = 52;

	
	public Deck() {		//create and place the 52 different cards into cards[]
		super();
		setCard(cards);	
	}
	
	public void shuffle(long seed) {	//shuffle the cards
        Random random = new Random(seed);
        for (int i = 0; i < totalNum; i++) {
            int randNum = random.nextInt(52);
            Collections.swap(cards,randNum,i);
        }
	}
	
	public void setCard(List<Card> cards) {	
		cards.clear();
		for (Suit suit : Suit.values()) { 
			for(Rank rank : Rank.values())
				cards.add(new Card(suit, rank));
		}
	}
	
	public List<Card> getCards() {
		return this.cards;
	}

	@Override
	public String print() {
		return null;
	}
		
}
