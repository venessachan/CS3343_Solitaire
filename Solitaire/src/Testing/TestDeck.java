package Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import card.Card;
import card.Deck;

public class TestDeck {
	
	@Test
	public void testInitialCards() {
		
		String ans = "♠A ♠2 ♠3 ♠4 ♠5 ♠6 ♠7 ♠8 ♠9 ♠10 ♠J ♠Q ♠K "
					+ "♥A ♥2 ♥3 ♥4 ♥5 ♥6 ♥7 ♥8 ♥9 ♥10 ♥J ♥Q ♥K "
					+ "♣A ♣2 ♣3 ♣4 ♣5 ♣6 ♣7 ♣8 ♣9 ♣10 ♣J ♣Q ♣K "
					+ "♦A ♦2 ♦3 ♦4 ♦5 ♦6 ♦7 ♦8 ♦9 ♦10 ♦J ♦Q ♦K";
		
		String result= "";
		Deck deck = new Deck();
		for(Card c: deck.getCards()) 
		{
			c.flip();
			result += c.toString() + " ";
		}
		result = result.trim();
		assertEquals(ans, result);
		
	}
	
	@Test
	public void testShuffleCards() {//seed 0
		
		String ans = "♥3 ♠A ♥A ♠6 ♥J ♠10 ♠J ♦3 ♦9 ♦4 ♣9 ♣Q ♥5 "
					+ "♦J ♦5 ♣A ♠2 ♥7 ♣K ♥Q ♣2 ♣6 ♦10 ♣8 ♥9 ♥K "
					+ "♠5 ♦Q ♣J ♥2 ♠Q ♦2 ♥10 ♠4 ♣4 ♠7 ♣5 ♦K ♠K "
					+ "♦6 ♥4 ♠8 ♥6 ♣10 ♥8 ♠3 ♦8 ♦A ♣7 ♠9 ♣3 ♦7";
		
		String result= "";
		Deck deck = new Deck();
		deck.shuffle(0);
		for(Card c: deck.getCards()) 
		{
			c.flip();
			result += c.toString() + " ";
		}
		result = result.trim();
		assertEquals(ans, result);
		
	}
	
}
