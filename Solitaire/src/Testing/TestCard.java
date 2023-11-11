package Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import card.Card;
import card.Color;
import card.Rank;
import card.Suit;

public class TestCard {
	
	//Check flips
	@Test
	public void testFlip1() { //?? -> ♠K
		Card result = new Card(Suit.SPADES, Rank.K);
		result.flip();
		assertEquals(true, result.getShow());
	}
	
	@Test
	public void testFlip2() { //♠K -> ??
		Card result = new Card(Suit.SPADES, Rank.K);
		result.setShow(true);
		result.flip();
		assertEquals(false, result.getShow());
	}
	
	//Check show
	@Test
	public void testShow1() {
		Card result = new Card(Suit.SPADES, Rank.K);
		result.setShow(true);
		assertEquals(true, result.getShow());
	}
	
	@Test
	public void testShow2() {
		Card result = new Card(Suit.SPADES, Rank.K);
		assertEquals(false, result.getShow());
	}
	
	//Check getRank()
	@Test
	public void testgetRank() {
		Card result = new Card(Suit.SPADES, Rank.K);
		assertEquals(Rank.K, result.getRank());
	}
	
	@Test
	public void testgetRank2() {
		Card result = new Card(Suit.SPADES, Rank.K);
		Integer ans = 13;
		assertEquals(ans, result.getRank().getNum());
	}

	//Check getSuit()
	@Test
	public void testgetSuit1() {
		Card result = new Card(Suit.SPADES, Rank.K);
		assertEquals(Suit.SPADES, result.getSuit());
	}
	
	@Test
	public void testgetSuit2() {
		Card result = new Card(Suit.SPADES, Rank.K);
		assertEquals(Color.BLACK, result.getSuit().getColor());
	}
	
	//Check all print(toString Method)
	@Test
	public void testPrint0() {
		Card result = new Card(Suit.SPADES, Rank.K);
		assertEquals("??", result.toString());
	}
	
	@Test
	public void testPrint1() {//A
		Card result = new Card(Suit.SPADES, Rank.A);
		result.flip();
		String ans = "♠A";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint2() {//2
		Card result = new Card(Suit.SPADES, Rank._2);
		result.flip();
		String ans = "♠2";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint3() {//3
		Card result = new Card(Suit.SPADES, Rank._3);
		result.flip();
		String ans = "♠3";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint4() {//4
		Card result = new Card(Suit.SPADES, Rank._4);
		result.flip();
		String ans = "♠4";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint5() {//5
		Card result = new Card(Suit.SPADES, Rank._5);
		result.flip();
		String ans = "♠5";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint6() {//6
		Card result = new Card(Suit.SPADES, Rank._6);
		result.flip();
		String ans = "♠6";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint7() {//7
		Card result = new Card(Suit.SPADES, Rank._7);
		result.flip();
		String ans = "♠7";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint8() {//8
		Card result = new Card(Suit.SPADES, Rank._8);
		result.flip();
		String ans = "♠8";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint9() {//9
		Card result = new Card(Suit.SPADES, Rank._9);
		result.flip();
		String ans = "♠9";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint10() {//10
		Card result = new Card(Suit.SPADES, Rank._10);
		result.flip();
		String ans = "♠10";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint11() {//J
		Card result = new Card(Suit.SPADES, Rank.J);
		result.flip();
		String ans = "♠J";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint12() {//Q
		Card result = new Card(Suit.SPADES, Rank.Q);
		result.flip();
		String ans = "♠Q";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint13() {//K
		Card result = new Card(Suit.SPADES, Rank.K);
		result.flip();
		String ans = "♠K";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint14() {//♥
		Card result = new Card(Suit.HEARTS, Rank.K);
		result.flip();
		String ans = "♥K";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint15() {//♣
		Card result = new Card(Suit.CLUBS, Rank.K);
		result.flip();
		String ans = "♣K";
		assertEquals(ans, result.toString());
	}
	
	@Test
	public void testPrint16() {//♦
		Card result = new Card(Suit.DIAMONDS, Rank.K);
		result.flip();
		String ans = "♦K";
		assertEquals(ans, result.toString());
	}
}