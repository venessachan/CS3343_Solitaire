package Testing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import card.Card;
import stackManager.Deck;

public class TestDeck {
	Deck deck;
	@Before
	public void setup() {
		deck = new Deck();
	}
	
	@Test
	public void testInitCardList1(){
		deck.setCard(deck.getCards());
		assertEquals(52, deck.getCards().size());
	}
	
	@Test
	public void testInitCardList2(){
		deck.setCard(deck.getCards());
		String expectedResult = "[♠A, ♠2, ♠3, ♠4, ♠5, ♠6, ♠7, ♠8, ♠9, ♠10, ♠J, ♠Q, ♠K, "
									+ "♥A, ♥2, ♥3, ♥4, ♥5, ♥6, ♥7, ♥8, ♥9, ♥10, ♥J, ♥Q, ♥K, "
									+ "♣A, ♣2, ♣3, ♣4, ♣5, ♣6, ♣7, ♣8, ♣9, ♣10, ♣J, ♣Q, ♣K, "
									+ "♦A, ♦2, ♦3, ♦4, ♦5, ♦6, ♦7, ♦8, ♦9, ♦10, ♦J, ♦Q, ♦K]";
		deck.getCards().forEach((c)->c.flip());
		assertEquals(expectedResult, deck.getCards().toString());
	}
	
	@Test
	public void testShuffle1() {
		deck.shuffle(0);
		assertEquals(52, deck.getCards().size());
	}
	
	
	@Test
	public void testShuffle2() {
		boolean isSameCard = true;		
		deck.shuffle(0);
		Deck deck2 = new Deck();
		deck2.shuffle(3);
		for(int i = 0; i < deck.getCards().size(); i++) {
			if(deck.getCards().get(i).getSuit() !=  deck2.getCards().get(i).getSuit() || 
				deck.getCards().get(i).getRank() !=  deck2.getCards().get(i).getRank()) {
				isSameCard = false;
			}
		}
		assertEquals(false, isSameCard);
	}
	
	@Test
	public void testPrint() {
		assertEquals(null, deck.print());
	}
	
//	@Test
//	public void testShuffle10() {
//		deck.shuffle(0);
//		deck.getCards().forEach((c)->c.flip());
//		assertEquals("", deck.getCards().toString());
//	}
}
