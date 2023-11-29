package Testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import stackManager.Tableau;

public class TestTableau {
	//check card list after push and pop
	@Test
	public void testPush1() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.HEARTS, Rank._5));
		tableau.push(new Card(Suit.DIAMONDS, Rank._8));
		tableau.push(new Card(Suit.SPADES, Rank._3));
		tableau.push(new Card(Suit.CLUBS, Rank.K));
		tableau.pop();
		tableau.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♥5, ♦8, ♠3]", tableau.getCardList().toString());
	}

	//check card list after push and pop
	@Test
	public void testPop1() {
		Tableau tableau = new Tableau();
		assertEquals(null, tableau.pop());
	}
		
	//check top card with empty tableau
	@Test
	public void testPeek1() {
		Tableau tableau = new Tableau();
		assertEquals(null, tableau.peek());
		assertEquals("", tableau.print());
	}
	
	//get peek from !empty tableau
	@Test
	public void testPeek2() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.CLUBS, Rank.J));
		tableau.push(new Card(Suit.SPADES, Rank._7));
		tableau.push(new Card(Suit.HEARTS, Rank._4));
		tableau.push(new Card(Suit.DIAMONDS, Rank._5));
		tableau.push(new Card(Suit.CLUBS, Rank.Q));
		tableau.push(new Card(Suit.HEARTS, Rank.A));
		tableau.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♥A", tableau.peek().toString());
	}
	
	//print !empty tableau with 3 hidden cards
	@Test
	public void testPrint1() {
		Tableau tableau = new Tableau();
		Card card1 = new Card(Suit.CLUBS, Rank.J);
		Card card2 = new Card(Suit.SPADES, Rank._7);
		Card card3 = new Card(Suit.HEARTS, Rank._4);
		Card card4 = new Card(Suit.DIAMONDS, Rank._5);
		Card card5 = new Card(Suit.CLUBS, Rank.Q);
		Card card6 = new Card(Suit.HEARTS, Rank.A);
		
		card4.setShow(true);
		card5.setShow(true);
		card6.setShow(true);
		
		tableau.push(card1);
		tableau.push(card2);
		tableau.push(card3);
		tableau.push(card4);
		tableau.push(card5);
		tableau.push(card6);
		assertEquals(" ??  ??  ??  ♦5  ♣Q  ♥A ", tableau.print());
	}
	
	//table clear
	@Test
	public void testClearList1() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.CLUBS, Rank.J));
		tableau.push(new Card(Suit.SPADES, Rank._7));
		tableau.push(new Card(Suit.HEARTS, Rank._4));
		tableau.push(new Card(Suit.DIAMONDS, Rank._5));
		tableau.push(new Card(Suit.CLUBS, Rank.Q));
		tableau.push(new Card(Suit.HEARTS, Rank.A));
		tableau.clear();
		
		assertEquals(true, tableau.isEmpty());
	}
	
	//tableau count
	@Test
	public void testCount1() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.CLUBS, Rank.J));
		tableau.push(new Card(Suit.SPADES, Rank._7));
		tableau.push(new Card(Suit.HEARTS, Rank._4));
		tableau.push(new Card(Suit.DIAMONDS, Rank._5));
		tableau.push(new Card(Suit.CLUBS, Rank.Q));
		tableau.push(new Card(Suit.HEARTS, Rank.A));
		
		assertEquals(6, tableau.count());
	}
	
	//add another card list into tableau
	@Test
	public void testAddAll1() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.SPADES, Rank._5));
		tableau.push(new Card(Suit.HEARTS, Rank._9));
		tableau.push(new Card(Suit.CLUBS, Rank._2));
		tableau.push(new Card(Suit.DIAMONDS, Rank.A));
		tableau.push(new Card(Suit.CLUBS, Rank.K));
		tableau.push(new Card(Suit.SPADES, Rank._10));
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Suit.DIAMONDS, Rank._4));
		cardList.add(new Card(Suit.CLUBS, Rank._3));
		cardList.add(new Card(Suit.CLUBS, Rank.Q));
		cardList.add(new Card(Suit.SPADES, Rank.J));
		cardList.add(new Card(Suit.HEARTS, Rank._7));
		
		tableau.addAll(cardList);
		tableau.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♠5, ♥9, ♣2, ♦A, ♣K, ♠10, ♦4, ♣3, ♣Q, ♠J, ♥7]", tableau.getCardList().toString());
	}
	
	@Test
	public void testValidCard1() {
		Tableau tableau = new Tableau();
		Card card = new Card(Suit.HEARTS, Rank.K);
		assertEquals(true, tableau.checkValidAction(card));
	}
	
	@Test
	public void testValidCard2() {
		Tableau tableau = new Tableau();
		Card card = new Card(Suit.CLUBS, Rank.A);
		assertEquals(false, tableau.checkValidAction(card));
	}
	
	@Test
	public void testValidCard3() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.CLUBS, Rank._8));
		tableau.push(new Card(Suit.DIAMONDS, Rank._7));
		tableau.push(new Card(Suit.CLUBS, Rank.Q));
		tableau.push(new Card(Suit.SPADES, Rank._3));
		tableau.push(new Card(Suit.SPADES, Rank._6));
		tableau.push(new Card(Suit.HEARTS, Rank.A));
		
		Card card = new Card(Suit.CLUBS, Rank._2);
		assertEquals(false, tableau.checkValidAction(card));
	}
	
	@Test
	public void testValidCard4() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.CLUBS, Rank._8));
		tableau.push(new Card(Suit.DIAMONDS, Rank._7));
		tableau.push(new Card(Suit.CLUBS, Rank.Q));
		tableau.push(new Card(Suit.SPADES, Rank._3));
		tableau.push(new Card(Suit.SPADES, Rank._6));
		
		Card card = new Card(Suit.SPADES, Rank._5);
		assertEquals(false, tableau.checkValidAction(card));
	}
	
	@Test
	public void testValidCard5() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.CLUBS, Rank._8));
		tableau.push(new Card(Suit.DIAMONDS, Rank._7));
		tableau.push(new Card(Suit.CLUBS, Rank.Q));
		tableau.push(new Card(Suit.SPADES, Rank._3));
		tableau.push(new Card(Suit.SPADES, Rank._6));
		
		Card card = new Card(Suit.DIAMONDS, Rank._5);
		assertEquals(true, tableau.checkValidAction(card));
	}
}
