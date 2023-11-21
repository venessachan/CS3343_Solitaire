package stackManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import card.Card;
import card.Rank;
import card.Suit;

public class Deck extends CardListAbstract{
	
	private static List<Card> cards = new ArrayList<Card>();
	private final int totalNum = 52;

	
	public Deck() {		//create and place the 52 different cards into cards[]
		super();
		cards.clear();
		setCard();	
	}
	
	public void shuffle(long seed) {	//shuffle the cards
        Random random = new Random(seed);
        for (int i = 0; i < totalNum; i++) {
            int randNum = random.nextInt(52);
            Collections.swap(cards,randNum,i);
        }
	}
	
	public void setCard() {	
		for (Suit suit : Suit.values()) { 
			for(Rank rank : Rank.values())
				cards.add(new Card(suit, rank));
		}
	}
	
	public List<Card> getCards() {
		return Deck.cards;
	}

	@Override
	public String print() {
		return null;
	}
		
}
