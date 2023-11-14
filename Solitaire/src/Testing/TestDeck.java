package Testing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import card.Card;
import card.Color;
import card.Deck;

public class TestDeck {
	
	private static boolean deckEquality(List<Card> c1, List<Card> c2) {
		if(c1.size() != c2.size())
			return false;
		
		for(int i=0; i<c1.size(); i++) {
			if(c1.get(i).getSuit() != c2.get(i).getSuit() || c1.get(i).getRank() != c2.get(i).getRank()) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testInitialCardsSize() {//initial 52 cards
		Deck deck = new Deck();
		int ans = 52;
		assertEquals(ans, deck.getCards().size());	
	}
	
	@Test
	public void testInitialCardsEquality() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		boolean ans = true;
		assertEquals(ans, deckEquality(deck1.getCards(), deck2.getCards()));
	}
	
	@Test
	public void testShuffleCardsSize() {//After shuffle 52 cards
		Deck deck = new Deck();
		deck.shuffle(0);
		int ans = 52;
		assertEquals(ans, deck.getCards().size());	
	}
	
	@Test
	public void testShuffleCardsEquality1() {
		Deck deck1 = new Deck();
		deck1.shuffle(1);
		Deck deck2 = new Deck();
		deck2.shuffle(0);
		boolean ans = false;
		assertEquals(ans, deckEquality(deck1.getCards(), deck2.getCards()));
	}
	
	@Test
	public void testShuffleCardsEquality2() {
		Deck deck1 = new Deck();
		deck1.shuffle(1);
		Deck deck2 = new Deck();
		deck2.shuffle(0);
		boolean ans = false;
		assertEquals(ans, deckEquality(deck1.getCards(), deck2.getCards()));
	}
	
	@Test
	public void testShuffleCardsEquality3() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		deck2.shuffle(9);
		boolean ans = false;
		assertEquals(ans, deckEquality(deck1.getCards(), deck2.getCards()));
	}
	
	@Test
	public void testShuffleCardsEquality4() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		deck2.getCards().remove(0);
		boolean ans = false;
		assertEquals(ans, deckEquality(deck1.getCards(), deck2.getCards()));
	}
	
	
}
