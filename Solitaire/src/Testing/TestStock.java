package Testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import stackManager.Stock;
import stackManager.Waste;

public class TestStock {
	@Test
	public void testGetCardList1() {
		Stock stock = new Stock();
		List<Card> expectedResult = new ArrayList<Card>();
		expectedResult.clear();
		assertEquals(expectedResult, stock.getCardList());
	}
	
	@Test
	public void testGetCardList2() {		//push->get
		Waste waste = new Waste();
		Card card1 = new Card(Suit.DIAMONDS, Rank.A);
		Card card2 = new Card(Suit.SPADES, Rank._5);
		Card card3 = new Card(Suit.CLUBS, Rank.K);
		Card card4 = new Card(Suit.HEARTS, Rank.K);
		
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		
		List<Card> expectedResult = new ArrayList<>();
	    expectedResult.add(card1);
	    expectedResult.add(card2);
	    expectedResult.add(card3);
	    expectedResult.add(card4);
		
		assertEquals(expectedResult, waste.getCardList());
	}
	
	@Test
	public void testGetCardList3() {		//push->pop->get
		Waste stock = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);
		Card card3 = new Card(Suit.CLUBS, Rank._2);
		Card card4 = new Card(Suit.DIAMONDS, Rank._9);
		Card card5 = new Card(Suit.CLUBS, Rank.Q);
		
		stock.push(stock.getCardList(), card1);
		stock.push(stock.getCardList(), card2);
		stock.push(stock.getCardList(), card3);
		stock.push(stock.getCardList(), card4);
		stock.push(stock.getCardList(), card5);
		stock.pop(stock.getCardList());
		stock.pop(stock.getCardList());
		
		List<Card> expectedResult = new ArrayList<>();
	    expectedResult.add(card1);
	    expectedResult.add(card2);
	    expectedResult.add(card3);
	    expectedResult.add(card4);
	    expectedResult.add(card5);
	    expectedResult.remove(4);
	    expectedResult.remove(3);
		
		assertEquals(expectedResult, stock.getCardList());
	}
	
	@Test
	public void testPeek1() {
		Stock stock = new Stock();
		assertEquals(null, stock.peek(stock.getCardList()));
	}
	
	@Test
	public void testPeek2() {
		Stock stock = new Stock();
		Card card1 = new Card(Suit.DIAMONDS, Rank._6);
		Card card2 = new Card(Suit.HEARTS, Rank.A);
		stock.push(stock.getCardList(), card1);
		stock.push(stock.getCardList(), card2);
		assertEquals(card2, stock.peek(stock.getCardList()));
	}
	
	
	@Test
	public void testPrint1() {
		Stock stock = new Stock();
		Card card1 = new Card(Suit.DIAMONDS, Rank._3);
		Card card2 = new Card(Suit.HEARTS, Rank._7);
		stock.push(stock.getCardList(), card1);
		stock.push(stock.getCardList(), card2);
		assertEquals(null, stock.print());
	}
	
	@Test
	public void testClearList1() {
		Stock stock = new Stock();
		Card card1 = new Card(Suit.SPADES, Rank._5);
		Card card2 = new Card(Suit.DIAMONDS, Rank._6);
		Card card3 = new Card(Suit.CLUBS, Rank._7);
		Card card4 = new Card(Suit.HEARTS, Rank._8);
		stock.push(stock.getCardList(), card1);
		stock.push(stock.getCardList(), card2);
		stock.push(stock.getCardList(), card3);
		stock.push(stock.getCardList(), card4);
		
		stock.clear(stock.getCardList());
		List<Card> expectedResult = new ArrayList<>();
		expectedResult.clear();
		assertEquals(expectedResult, stock.getCardList());
	}
	
	@Test
	public void testCount() {
		Waste waste = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		Card card3 = new Card(Suit.CLUBS, Rank._3);
		Card card4 = new Card(Suit.HEARTS, Rank._6);
		Card card5 = new Card(Suit.HEARTS, Rank._10);
		Card card6 = new Card(Suit.SPADES, Rank._9);
		Card card7 = new Card(Suit.CLUBS, Rank.K);
		Card card8 = new Card(Suit.DIAMONDS, Rank.Q);
		Card card9 = new Card(Suit.SPADES, Rank.J);
		Card card10 = new Card(Suit.DIAMONDS, Rank._7);
		Card card11 = new Card(Suit.CLUBS, Rank._8);
		Card card12 = new Card(Suit.SPADES, Rank._4);
		Card card13 = new Card(Suit.CLUBS, Rank._5);
		
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		waste.push(waste.getCardList(), card5);
		waste.push(waste.getCardList(), card6);
		waste.push(waste.getCardList(), card7);
		waste.push(waste.getCardList(), card8);
		waste.push(waste.getCardList(), card9);
		waste.push(waste.getCardList(), card10);
		waste.push(waste.getCardList(), card11);
		waste.push(waste.getCardList(), card12);
		waste.push(waste.getCardList(), card13);
		
		assertEquals(13, waste.count(waste.getCardList()));
	}
	
	
//	@Test
//	public void testStockPush1() {
//		Stock stock = new Stock();
//		stock.push(new Card(Suit.DIAMONDS, Rank._10));
//		stock.push(new Card(Suit.HEARTS, Rank._3));
//		stock.push(new Card(Suit.HEARTS, Rank._6));
//		stock.push(new Card(Suit.SPADES, Rank.J));
//		stock.push(new Card(Suit.CLUBS, Rank.A));
//		stock.push(new Card(Suit.DIAMONDS, Rank._3));
//		stock.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("[♦3, ♣A, ♠J, ♥6, ♥3, ♦10]",stock.getCardList().toString());
//		
//	}
//	
//	@Test
//	public void testStockCount1() {
//		Stock stock = new Stock();
//		stock.push(new Card(Suit.DIAMONDS, Rank._2));
//		stock.push(new Card(Suit.HEARTS, Rank._5));
//		stock.push(new Card(Suit.HEARTS, Rank._8));
//		stock.push(new Card(Suit.SPADES, Rank.A));
//		stock.push(new Card(Suit.DIAMONDS, Rank._5));
//		stock.push(new Card(Suit.CLUBS, Rank._4));
//		stock.push(new Card(Suit.DIAMONDS, Rank._9));
//		stock.push(new Card(Suit.SPADES, Rank._10));
//		stock.push(new Card(Suit.SPADES, Rank.J));
//		stock.push(new Card(Suit.DIAMONDS, Rank._10));
//		stock.push(new Card(Suit.SPADES, Rank._4));
//		stock.push(new Card(Suit.SPADES, Rank._7));
//		stock.push(new Card(Suit.DIAMONDS, Rank.K));
//		assertEquals(13,stock.count());
//	}
//	
//	@Test
//	public void testStockPop1() {
//		Stock stock = new Stock();
//		stock.push(new Card(Suit.CLUBS, Rank.Q));
//		stock.push(new Card(Suit.HEARTS, Rank._2));
//		stock.push(new Card(Suit.SPADES, Rank._3));
//		stock.push(new Card(Suit.SPADES, Rank._7));
//		stock.push(new Card(Suit.DIAMONDS, Rank._7));
//		stock.push(new Card(Suit.CLUBS, Rank._10));
//		stock.push(new Card(Suit.DIAMONDS, Rank._10));
//		stock.push(new Card(Suit.SPADES, Rank._6));
//		stock.push(new Card(Suit.DIAMONDS, Rank.J));
//		stock.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("♦J",stock.pop().toString());
//	}
//	
//	@Test
//	public void testSetStock1() {
//		List<Card> cardList = new ArrayList<Card>();
//		cardList.add(new Card(Suit.SPADES, Rank.A));
//		cardList.add(new Card(Suit.CLUBS, Rank._2));
//		cardList.add(new Card(Suit.SPADES, Rank._3));
//		cardList.add(new Card(Suit.DIAMONDS, Rank._4));
//		cardList.add(new Card(Suit.HEARTS, Rank._5));
//		cardList.forEach((c)->c.setShow(true));
//		Stock stock = new Stock();
//		stock.setStock(cardList);
//		assertEquals("[♠A, ♣2, ♠3, ♦4, ♥5]", stock.getCardList().toString());
//	}
//	
//	@Test
//	public void testStockPrint() {
//		Stock stock = new Stock();
//		stock.push(new Card(Suit.SPADES, Rank.K));
//		stock.push(new Card(Suit.HEARTS, Rank._10));
//		stock.push(new Card(Suit.CLUBS, Rank._5));
//		stock.push(new Card(Suit.DIAMONDS, Rank._8));
//		stock.getCardList().forEach((c)->c.setShow(true));
//		assertEquals(null,stock.print());
//	}
	
}
