package Testing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import card.Card;
import card.Deck;

public class TestDeck {
	
	private static String printDeck(List<Card> cards) {
		String result = "";
		for(Card c: cards) 
		{
			c.flip();
			result += c.toString() + " ";
		}
		result = result.trim();
		return result;
	}
	
	private static boolean deckEquality(List<Card> c1, List<Card> c2) {
		if(c1.size() != c2.size())
			return false;
		
		for(int i=0; i<c1.size(); i++) {
			if(!(c1.get(i).getSuit() == c2.get(i).getSuit() 
					&& c1.get(i).getRank() == c2.get(i).getRank())) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testInitialCards() {
		
		String ans =  "♠A ♠2 ♠3 ♠4 ♠5 ♠6 ♠7 ♠8 ♠9 ♠10 ♠J ♠Q ♠K "
					+ "♥A ♥2 ♥3 ♥4 ♥5 ♥6 ♥7 ♥8 ♥9 ♥10 ♥J ♥Q ♥K "
					+ "♣A ♣2 ♣3 ♣4 ♣5 ♣6 ♣7 ♣8 ♣9 ♣10 ♣J ♣Q ♣K "
					+ "♦A ♦2 ♦3 ♦4 ♦5 ♦6 ♦7 ♦8 ♦9 ♦10 ♦J ♦Q ♦K";
		
		Deck deck = new Deck();
		String result= printDeck(deck.getCards());
		assertEquals(ans, result);
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
	public void testShuffleCards1() {//same seed give same result every time seed(0)
		
		String ans =  "♥3 ♠A ♥A ♠6 ♥J ♠10 ♠J ♦3 ♦9 ♦4 ♣9 ♣Q ♥5 "
					+ "♦J ♦5 ♣A ♠2 ♥7 ♣K ♥Q ♣2 ♣6 ♦10 ♣8 ♥9 ♥K "
					+ "♠5 ♦Q ♣J ♥2 ♠Q ♦2 ♥10 ♠4 ♣4 ♠7 ♣5 ♦K ♠K "
					+ "♦6 ♥4 ♠8 ♥6 ♣10 ♥8 ♠3 ♦8 ♦A ♣7 ♠9 ♣3 ♦7";
		
		Deck deck = new Deck();
		deck.shuffle(0);
		String result= printDeck(deck.getCards());
		assertEquals(ans, result);
	}
	
	@Test
	public void testShuffleCards2() {//seed(100)
		
		String ans =  "♦A ♠10 ♣A ♣6 ♠Q ♦4 ♦9 ♥2 ♣2 ♦8 ♦Q ♦3 ♣3 "
					+ "♥5 ♥8 ♠4 ♣4 ♣8 ♥10 ♦5 ♥J ♣J ♣5 ♥K ♥3 ♠2 "
					+ "♥7 ♠K ♣9 ♥9 ♣K ♦6 ♠8 ♥6 ♦10 ♠J ♠A ♠7 ♦7 "
					+ "♦J ♠5 ♣Q ♠9 ♣10 ♦2 ♠3 ♥Q ♠6 ♥A ♦K ♣7 ♥4";
		
		Deck deck = new Deck();
		deck.shuffle(100);
		String result= printDeck(deck.getCards());
		assertEquals(ans, result);
	}
	
	public void testShuffleCards3() {//different seed give different result
		
		String ans =  "♦A ♠10 ♣A ♣6 ♠Q ♦4 ♦9 ♥2 ♣2 ♦8 ♦Q ♦3 ♣3 "
					+ "♥5 ♥8 ♠4 ♣4 ♣8 ♥10 ♦5 ♥J ♣J ♣5 ♥K ♥3 ♠2 "
					+ "♥7 ♠K ♣9 ♥9 ♣K ♦6 ♠8 ♥6 ♦10 ♠J ♠A ♠7 ♦7 "
					+ "♦J ♠5 ♣Q ♠9 ♣10 ♦2 ♠3 ♥Q ♠6 ♥A ♦K ♣7 ♥4";
		
		Deck deck = new Deck();
		deck.shuffle(0);
		String result= printDeck(deck.getCards());
		assertEquals(false, ans.equals(result));
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
		deck1.shuffle(0);
		Deck deck2 = new Deck();
		deck2.shuffle(0);
		boolean ans = true;
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
		deck2.shuffle(0);
		boolean ans = false;
		assertEquals(ans, deckEquality(deck1.getCards(), deck2.getCards()));
	}
	
	
}
