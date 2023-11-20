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
