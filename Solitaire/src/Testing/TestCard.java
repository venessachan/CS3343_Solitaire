package Testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import card.Card;
import card.Suit;

public class TestCard {
	
	//Check flip
	@Test
	public void testPrint0() {
		Card result = new Card(13,Suit.SPADES);
		result.setShow(false);
		assertEquals("??", result.print());
	}
	
	//Check suit
	@Test
	public void testPrint1() {
		Card result = new Card(13,Suit.SPADES);
		result.setShow(true);
		assertEquals("♠K", result.print());
	}
	
	@Test
	public void testPrint2() {
		Card result = new Card(13,Suit.HEARTS);
		result.setShow(true);
		assertEquals("♥K", result.print());
	}
	
	@Test
	public void testPrint3() {
		Card result = new Card(13,Suit.DIAMONDS);
		result.setShow(true);
		assertEquals("♣K", result.print());
	}
	
	@Test
	public void testPrint4() {
		Card result = new Card(13,Suit.CLUBS);
		result.setShow(true);
		assertEquals("♦K", result.print());
	}
	
//	@Test
//	public void testPrint5() {
//		Card result = new Card(13, Suit.OTHERS);
//		result.setShow(true);
//		assertEquals("ErrorK", result.print());
//	}
	
	//Check rank
	@Test
	public void testPrint6() {
		Card result = new Card(12,Suit.HEARTS);
		result.setShow(true);
		assertEquals("♥Q", result.print());
	}
	
	@Test
	public void testPrint7() {
		Card result = new Card(11,Suit.HEARTS);
		result.setShow(true);
		assertEquals("♥J", result.print());
	}
	
	@Test
	public void testPrint8() {
		Card result = new Card(1,Suit.HEARTS);
		result.setShow(true);
		assertEquals("♥A", result.print());
	}
	
	@Test
	public void testPrint9() {
		Card result = new Card(2,Suit.HEARTS);
		result.setShow(true);
		assertEquals("♥2", result.print());
	}
	
}