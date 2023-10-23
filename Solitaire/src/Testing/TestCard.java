package Testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import card.Card;
import card.Rank;
import card.Suit;

public class TestCard {
	
	//Check flip
	@Test
	public void testtoString0() {
		Card result = new Card(Suit.SPADES, Rank.K);
		result.setShow(false);
		assertEquals("??", result.toString());
	}
	
	//Check suit
	@Test
	public void testtoString1() {
		Card result = new Card(Suit.SPADES, Rank.K);
		result.setShow(true);
		assertEquals("♠K", result.toString());
	}
	
	@Test
	public void testtoString2() {
		Card result = new Card(Suit.HEARTS, Rank.K);
		result.setShow(true);
		assertEquals("♥K", result.toString());
	}
	
	@Test
	public void testtoString3() {
		Card result = new Card(Suit.DIAMONDS, Rank.K);
		result.setShow(true);
		assertEquals("♣K", result.toString());
	}
	
	@Test
	public void testtoString4() {
		Card result = new Card(Suit.CLUBS, Rank.K);
		result.setShow(true);
		assertEquals("♦K", result.toString());
	}
	
//	@Test
//	public void testtoString5() {
//		Card result = new Card(13, Suit.OTHERS);
//		result.setShow(true);
//		assertEquals("ErrorK", result.toString());
//	}
	
	//Check rank
	@Test
	public void testtoString6() {
		Card result = new Card(Suit.HEARTS, Rank.Q);
		result.setShow(true);
		assertEquals("♥Q", result.toString());
	}
	
	@Test
	public void testtoString7() {
		Card result = new Card(Suit.HEARTS, Rank.J);
		result.setShow(true);
		assertEquals("♥J", result.toString());
	}
	
	@Test
	public void testtoString8() {
		Card result = new Card(Suit.HEARTS, Rank.A);
		result.setShow(true);
		assertEquals("♥A", result.toString());
	}
	
	@Test
	public void testtoString9() {
		Card result = new Card(Suit.HEARTS, Rank._2);
		result.setShow(true);
		assertEquals("♥2", result.toString());
	}
	
}