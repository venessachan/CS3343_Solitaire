package Testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import card.Card;
import card.Color;
import card.Rank;
import card.Suit;

public class TestCard {
	
	//Initial
	@Test
	public void testDefault() {
		Card result = new Card(Suit.SPADES, Rank.K);
		assertEquals("??", result.toString());
	}
	
	//Check flip
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
	public void testRankSign1() {//K
		Card result = new Card(Suit.HEARTS, Rank.K);
		assertEquals("K", result.getRank().getSign());
	}
	
	@Test
	public void testRankSign2() {//Q
		Card result = new Card(Suit.HEARTS, Rank.Q);
		assertEquals("Q", result.getRank().getSign());
	}
	
	@Test
	public void testRankSign3() {//J
		Card result = new Card(Suit.HEARTS, Rank.J);
		assertEquals("J", result.getRank().getSign());
	}
	
	public void testRankSign4() {//A
		Card result = new Card(Suit.HEARTS, Rank.A);
		assertEquals("A", result.getRank().getSign());
	}
	
	@Test
	public void testRankSign5() {//5
		Card result = new Card(Suit.HEARTS, Rank._5);
		assertEquals("5", result.getRank().getSign());
	}
	
	@Test
	public void testRankNum1() {//K(13)
		Card result = new Card(Suit.HEARTS, Rank.K);
		Integer ans = 13;
		assertEquals(ans, result.getRank().getNum());
	}
	
	@Test
	public void testRankNum2() {//Q(12)
		Card result = new Card(Suit.HEARTS, Rank.Q);
		Integer ans = 12;
		assertEquals(ans, result.getRank().getNum());
	}
	
	@Test
	public void testRankNum3() {//J(11)
		Card result = new Card(Suit.HEARTS, Rank.J);
		Integer ans = 11;
		assertEquals(ans, result.getRank().getNum());
	}
	
	@Test
	public void testRankNum4() {//A(1)
		Card result = new Card(Suit.HEARTS, Rank.A);
		Integer ans = 1;
		assertEquals(ans, result.getRank().getNum());
	}
	
	@Test
	public void testRankNum5() {//5(5)
		Card result = new Card(Suit.HEARTS, Rank._5);
		Integer ans = 5;
		assertEquals(ans, result.getRank().getNum());
	}
	
	@Test
	public void testRanking() {//K > Q(True)
		Card result1 = new Card(Suit.HEARTS, Rank.K);
		Card result2 = new Card(Suit.HEARTS, Rank.Q);
		assertEquals(true, result1.getRank().getNum() > result2.getRank().getNum());
	}
	
	@Test
	public void testRanking2() {//Q > K(False)
		Card result1 = new Card(Suit.HEARTS, Rank.Q);
		Card result2 = new Card(Suit.HEARTS, Rank.K);
		assertEquals(false, result1.getRank().getNum() > result2.getRank().getNum());
	}
	
	//Check all print(toString Method)
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