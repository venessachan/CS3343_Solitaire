package Testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import stackManager.Stock;

public class TestStock {
	@Test
	public void testGetCardList1() {
		Stock stock = new Stock();
		List<Card> expectedResult = new ArrayList<Card>();
		expectedResult.clear();
		assertEquals(expectedResult, stock.getCardList());
	}
	
	@Test
	public void testGetCardList2() {		//push->pop->get
		Stock stock = new Stock();
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);
		Card card3 = new Card(Suit.CLUBS, Rank._2);
		Card card4 = new Card(Suit.DIAMONDS, Rank._9);
		Card card5 = new Card(Suit.CLUBS, Rank.Q);
		stock.push(card1);
		stock.push(card2);
		stock.push(card3);
		stock.push(card4);
		stock.push(card5);
		stock.pop();
		stock.pop();
		stock.getCardList().forEach((c)->c.setShow(true));

		assertEquals("[♠A, ♥2, ♣2]", stock.getCardList().toString());
	}
	
	//pop empty stock
	@Test
	public void testPop1() {
		Stock stock = new Stock();
		assertEquals(null, stock.pop());
	}
	
	@Test
	public void testPeek1() {
		Stock stock = new Stock();
		assertEquals(null, stock.peek());
	}
	
	@Test
	public void testPeek2() {
		Stock stock = new Stock();
		Card card1 = new Card(Suit.DIAMONDS, Rank._6);
		Card card2 = new Card(Suit.HEARTS, Rank.A);
		stock.push(card1);
		stock.push(card2);
		assertEquals(card2, stock.peek());
	}
	
	
	@Test
	public void testPrint1() {
		Stock stock = new Stock();
		stock.push(new Card(Suit.DIAMONDS, Rank._3));
		stock.push(new Card(Suit.HEARTS, Rank._7));
		assertEquals(null, stock.print());
	}
	
	@Test
	public void testClearList1() {
		Stock stock = new Stock();

		stock.push(new Card(Suit.SPADES, Rank._5));
		stock.push(new Card(Suit.DIAMONDS, Rank._6));
		stock.push(new Card(Suit.CLUBS, Rank._7));
		stock.push(new Card(Suit.HEARTS, Rank._8));
		
		stock.clear();
		List<Card> expectedResult = new ArrayList<>();
		expectedResult.clear();
		assertEquals(expectedResult, stock.getCardList());
	}
	
	@Test
	public void testCount() {
		Stock stock = new Stock();
		stock.push(new Card(Suit.SPADES, Rank.A));
		stock.push(new Card(Suit.DIAMONDS, Rank._2));
		stock.push(new Card(Suit.CLUBS, Rank._3));
		stock.push(new Card(Suit.HEARTS, Rank._6));
		stock.push(new Card(Suit.HEARTS, Rank._10));
		stock.push(new Card(Suit.SPADES, Rank._9));
		stock.push(new Card(Suit.CLUBS, Rank.K));
		stock.push(new Card(Suit.DIAMONDS, Rank.Q));
		stock.push(new Card(Suit.SPADES, Rank.J));
		stock.push(new Card(Suit.DIAMONDS, Rank._7));
		stock.push(new Card(Suit.CLUBS, Rank._8));
		stock.push(new Card(Suit.SPADES, Rank._4));
		stock.push(new Card(Suit.CLUBS, Rank._5));
		
		assertEquals(13, stock.count());
	}
	
}
