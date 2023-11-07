package Testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import card.Card;
import card.Color;
import card.Rank;
import card.Suit;

public class TestCard {
	
	//Check flip + print
	@Test
	public void testDefault() {
		Card result = new Card(Suit.SPADES, Rank.K);
		assertEquals("??", result.toString());
	}
	
	@Test
	public void testFlipTrue() { //?? -> ♠K
		Card result = new Card(Suit.SPADES, Rank.K);
		result.flip();
		assertEquals("♠K", result.toString());
	}
	
	@Test
	public void testFlipFalse() { //♠K -> ??
		Card result = new Card(Suit.SPADES, Rank.K);
		result.setShow(true);
		result.flip();
		assertEquals("??", result.toString());
	}
	
	//Check show
	@Test
	public void testShowTrue() {
		Card result = new Card(Suit.SPADES, Rank.K);
		result.setShow(true);
		assertEquals(true, result.getShow());
	}
	
	@Test
	public void testShowFalse() {
		Card result = new Card(Suit.SPADES, Rank.K);
		assertEquals(false, result.getShow());
	}
	
	//Check suit colour
	@Test
	public void testColorBlack() {//black
		Card result = new Card(Suit.SPADES, Rank.K);
		assertEquals(Color.BLACK, result.getSuit().getColor());
	}
	
	@Test
	public void testColorRed() {//red
		Card result = new Card(Suit.HEARTS, Rank.K);
		assertEquals(Color.RED, result.getSuit().getColor());
	}
	
	//Check suit
	@Test
	public void testSuitSPADES() {//♠
		Card result = new Card(Suit.SPADES, Rank.K);
		assertEquals("♠", result.getSuit().getSign());
	}
	
	@Test
	public void testSuitHEARTS() {//♥
		Card result = new Card(Suit.HEARTS, Rank.K);
		assertEquals("♥", result.getSuit().getSign());
	}
	
	@Test
	public void testSuitCLUBS() {//♣
		Card result = new Card(Suit.CLUBS, Rank.K);
		assertEquals("♣", result.getSuit().getSign());
	}
	
	@Test
	public void testSuitDIAMONDS() {//♦
		Card result = new Card(Suit.DIAMONDS, Rank.K);
		assertEquals("♦", result.getSuit().getSign());
	}
	
	//Check rank
	@Test
	public void testRankSign() {
		Card result = new Card(Suit.HEARTS, Rank.Q);
		assertEquals("Q", result.getRank().getSign());
	}
	
	@Test
	public void testRankNum() {
		Card result = new Card(Suit.HEARTS, Rank.Q);
		Integer ans = 12;
		assertEquals(ans, result.getRank().getNum());
	}
	
}