package Testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import stackManager.Foundation;

public class TestFoundation {
	@Test
	public void testGetFoundationSuit() {
		Foundation foundation = new Foundation(Suit.SPADES);
		assertEquals("♠", foundation.getSuit().getSign());
	}
	
	//check card list after push
	@Test
	public void testPush1() {
		Foundation foundation = new Foundation(Suit.HEARTS);
		foundation.push(new Card(Suit.HEARTS, Rank.A));
		foundation.push(new Card(Suit.HEARTS, Rank._2));
		foundation.push(new Card(Suit.HEARTS, Rank._3));
		foundation.push(new Card(Suit.HEARTS, Rank._4));
		foundation.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♥A, ♥2, ♥3, ♥4]", foundation.getCardList().toString());
	}
	
	//check card list after pop
	@Test
	public void testPopCard1() {
		Foundation foundation = new Foundation(Suit.CLUBS);
		foundation.push(new Card(Suit.CLUBS, Rank._6));
		foundation.push(new Card(Suit.CLUBS, Rank._7));
		foundation.push(new Card(Suit.CLUBS, Rank._8));
		foundation.push(new Card(Suit.CLUBS, Rank._9));
		foundation.getCardList().forEach((c)->c.setShow(true));
		foundation.pop();
		assertEquals("[♣6, ♣7, ♣8]", foundation.getCardList().toString());
	}
	
	//check pop card
	@Test
	public void testPopCard2() {
		Foundation foundation = new Foundation(Suit.CLUBS);
		foundation.push(new Card(Suit.CLUBS, Rank._6));
		foundation.push(new Card(Suit.CLUBS, Rank._7));
		foundation.push(new Card(Suit.CLUBS, Rank._8));
		foundation.push(new Card(Suit.CLUBS, Rank._9));
		foundation.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♣9", foundation.pop().toString());
	}
	
	//check pop empty foundation
	@Test
	public void testPopCard3() {
		Foundation foundation = new Foundation(Suit.CLUBS);
		assertEquals(null, foundation.pop());
	}
	
	//check foundation top card
	@Test
	public void testPeek1() {
		Foundation foundation = new Foundation(Suit.CLUBS);
		assertEquals(null, foundation.peek());
	}
	
	@Test
	public void testPeek2() {
		Foundation foundation = new Foundation(Suit.DIAMONDS);	
		foundation.push(new Card(Suit.DIAMONDS, Rank._6));
		foundation.push(new Card(Suit.DIAMONDS, Rank._7));
		foundation.push(new Card(Suit.DIAMONDS, Rank._8));
		foundation.push(new Card(Suit.DIAMONDS, Rank._9));
		foundation.push(new Card(Suit.DIAMONDS, Rank._10));
		foundation.push(new Card(Suit.DIAMONDS, Rank.J));
		foundation.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♦J", foundation.peek().toString());
	}
	
	@Test
	public void testPrint1() {
		Foundation foundation = new Foundation(Suit.SPADES);
		assertEquals("♠", foundation.print());
	}
	
	@Test
	public void testPrint2() {
		Foundation foundation = new Foundation(Suit.HEARTS);
		foundation.push(new Card(Suit.HEARTS, Rank.A));
		foundation.push(new Card(Suit.HEARTS, Rank._2));
		foundation.push(new Card(Suit.HEARTS, Rank._3));
		foundation.push(new Card(Suit.HEARTS, Rank._4));
		foundation.push(new Card(Suit.HEARTS, Rank._5));
		foundation.push(new Card(Suit.HEARTS, Rank._6));
		foundation.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♥6", foundation.print());
	}
		
	@Test
	public void testClearList1() {
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push(new Card(Suit.SPADES, Rank.A));
		foundation.push(new Card(Suit.SPADES, Rank._2));
		foundation.push(new Card(Suit.SPADES, Rank._3));
		foundation.push(new Card(Suit.SPADES, Rank._4));
		
		foundation.clear();
		List<Card> expectedResult = new ArrayList<>();
		expectedResult.clear();
		assertEquals(expectedResult, foundation.getCardList());
	}
	
	@Test
	public void testCount1() {
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push(new Card(Suit.SPADES, Rank.A));
		foundation.push(new Card(Suit.SPADES, Rank._2));
		foundation.push(new Card(Suit.SPADES, Rank._3));
		foundation.push(new Card(Suit.SPADES, Rank._4));
		assertEquals(4, foundation.count());
	}
	
	//check if foundation full
	@Test
	public void testIsFull1() {
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push(new Card(Suit.SPADES, Rank.A));
		foundation.push(new Card(Suit.SPADES, Rank._2));
		foundation.push(new Card(Suit.SPADES, Rank._3));
		foundation.push(new Card(Suit.SPADES, Rank._4));
		assertEquals(false, foundation.isFull());
	}
	
	@Test
	public void testIsFull2() {
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push(new Card(Suit.SPADES, Rank.A));
		foundation.push(new Card(Suit.SPADES, Rank._2));
		foundation.push(new Card(Suit.SPADES, Rank._3));
		foundation.push(new Card(Suit.SPADES, Rank._4));
		foundation.push(new Card(Suit.SPADES, Rank._5));
		foundation.push(new Card(Suit.SPADES, Rank._6));
		foundation.push(new Card(Suit.SPADES, Rank._7));
		foundation.push(new Card(Suit.SPADES, Rank._8));
		foundation.push(new Card(Suit.SPADES, Rank._9));
		foundation.push(new Card(Suit.SPADES, Rank._10));
		foundation.push(new Card(Suit.SPADES, Rank.J));
		foundation.push(new Card(Suit.SPADES, Rank.Q));
		foundation.push(new Card(Suit.SPADES, Rank.K));
		
		assertEquals(true, foundation.isFull());
	}
	
	//check valid card
	@Test
	public void testValidCard1() {
		Foundation foundation = new Foundation(Suit.SPADES);
		Card card = new Card(Suit.SPADES, Rank.A);
		assertEquals(true, foundation.checkValidAction(card));
	}
	
	@Test
	public void testValidCard2() {
		Foundation foundation = new Foundation(Suit.SPADES);
		Card card = new Card(Suit.HEARTS, Rank.A);
		assertEquals(false, foundation.checkValidAction(card));
	}
	
	@Test
	public void testValidCard3() {
		Foundation foundation = new Foundation(Suit.SPADES);
		Card card = new Card(Suit.SPADES, Rank._2);
		assertEquals(false, foundation.checkValidAction(card));
	}
	
	@Test
	public void testValidCard4() {
		Foundation foundation = new Foundation(Suit.HEARTS);
		foundation.push(new Card(Suit.HEARTS, Rank.A));
		foundation.push(new Card(Suit.HEARTS, Rank._2));
		foundation.push(new Card(Suit.HEARTS, Rank._3));
		
		Card card = new Card(Suit.DIAMONDS, Rank.A);
		assertEquals(false, foundation.checkValidAction(card));
	}
	
	@Test
	public void testValidCard5() {
		Foundation foundation = new Foundation(Suit.HEARTS);
		foundation.push(new Card(Suit.HEARTS, Rank.A));
		foundation.push(new Card(Suit.HEARTS, Rank._2));
		foundation.push(new Card(Suit.HEARTS, Rank._3));
		
		Card card = new Card(Suit.DIAMONDS, Rank._4);
		assertEquals(false, foundation.checkValidAction(card));
	}
	
	@Test
	public void testValidCard6() {
		Foundation foundation = new Foundation(Suit.HEARTS);
		foundation.push(new Card(Suit.HEARTS, Rank.A));
		foundation.push(new Card(Suit.HEARTS, Rank._2));
		foundation.push(new Card(Suit.HEARTS, Rank._3));
		
		Card card = new Card(Suit.HEARTS, Rank._4);
		assertEquals(true, foundation.checkValidAction(card));
	}
	
	@Test
	public void testValidCard7() {
		Foundation foundation = new Foundation(Suit.HEARTS);
		foundation.push(new Card(Suit.HEARTS, Rank.A));
		foundation.push(new Card(Suit.HEARTS, Rank._2));
		foundation.push(new Card(Suit.HEARTS, Rank._3));
		foundation.push(new Card(Suit.HEARTS, Rank._4));
		foundation.push(new Card(Suit.HEARTS, Rank._5));
		foundation.push(new Card(Suit.HEARTS, Rank._6));
		foundation.push(new Card(Suit.HEARTS, Rank._7));
		foundation.push(new Card(Suit.HEARTS, Rank._8));
		foundation.push(new Card(Suit.HEARTS, Rank._9));
		foundation.push(new Card(Suit.HEARTS, Rank._10));
		foundation.push(new Card(Suit.HEARTS, Rank.J));
		foundation.push(new Card(Suit.HEARTS, Rank.Q));
		foundation.push(new Card(Suit.HEARTS, Rank.K));
		
		Card card = new Card(Suit.HEARTS, Rank._4);
		assertEquals(false, foundation.checkValidAction(card));
	}
		
}
