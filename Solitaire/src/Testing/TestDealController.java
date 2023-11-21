package Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import controller.DealController;
import stackManager.Stock;
import stackManager.Waste;

public class TestDealController {
	private DealController dealController;
	//check waste after deal with empty stock and !empty waste
	@Test
	public void testDeal1() {
		dealController = DealController.getInstance();
		Stock stock = new Stock();
		Waste waste = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank._4);
		Card card2 = new Card(Suit.HEARTS, Rank.K);
		Card card3 = new Card(Suit.CLUBS, Rank.A);
		Card card4 = new Card(Suit.SPADES, Rank._10);
		Card card5 = new Card(Suit.DIAMONDS, Rank._5);
		Card card6 = new Card(Suit.CLUBS, Rank.Q);
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		waste.push(waste.getCardList(), card5);
		waste.push(waste.getCardList(), card6);
		dealController.deal(stock, waste);
		assertEquals("[]",waste.getCardList().toString());
	}
	
	@Before
	public void setup() {
		DealController.resetInstance();
		dealController = DealController.getInstance();
	}
	
	//check stock after deal with empty stock and !empty waste
	@Test
	public void testDeal2() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank._4);
		Card card2 = new Card(Suit.HEARTS, Rank.K);
		Card card3 = new Card(Suit.CLUBS, Rank.A);
		Card card4 = new Card(Suit.SPADES, Rank._10);
		Card card5 = new Card(Suit.DIAMONDS, Rank._5);
		Card card6 = new Card(Suit.CLUBS, Rank.Q);
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		waste.push(waste.getCardList(), card5);
		waste.push(waste.getCardList(), card6);
		dealController.deal(stock, waste);
		stock.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♣Q, ♦5, ♠10, ♣A, ♥K, ♠4]",stock.getCardList().toString());
	}
	
	//check card visibility after deal with empty stock and !empty waste
	@Test
	public void testDeal3() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank._4);
		Card card2 = new Card(Suit.HEARTS, Rank.K);
		Card card3 = new Card(Suit.CLUBS, Rank.A);
		Card card4 = new Card(Suit.SPADES, Rank._10);
		Card card5 = new Card(Suit.DIAMONDS, Rank._5);
		Card card6 = new Card(Suit.CLUBS, Rank.Q);
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		waste.push(waste.getCardList(), card5);
		waste.push(waste.getCardList(), card6);
		waste.peek(waste.getCardList()).setShow(true);
		
		dealController.deal(stock, waste);
		assertEquals("[??, ??, ??, ??, ??, ??]",stock.getCardList().toString());
	}
		
	//check return value of deal() with empty stock and empty waste
	@Test
	public void testDeal4() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		assertEquals(-1,dealController.deal(stock, waste));
	}
	
	//check waste after deal with !empty stock and !empty waste
	@Test
	public void testDeal5() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		
		Card card1 = new Card(Suit.HEARTS, Rank.A);
		Card card2 = new Card(Suit.CLUBS, Rank._10);
		Card card3 = new Card(Suit.DIAMONDS, Rank._2);
		Card card4 = new Card(Suit.DIAMONDS, Rank._8);
		Card card5 = new Card(Suit.SPADES, Rank.J);
		Card card6 = new Card(Suit.CLUBS, Rank._6);
		
		stock.push(stock.getCardList(), card1);
		stock.push(stock.getCardList(), card2);
		stock.push(stock.getCardList(), card3);
		
		waste.push(waste.getCardList(), card4);
		waste.push(waste.getCardList(), card5);
		waste.push(waste.getCardList(), card6);
		
		
		dealController.deal(stock, waste);
		waste.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♦8, ♠J, ♣6, ♦2]",waste.getCardList().toString());
	}
		
	//check stock after deal with !empty stock and !empty waste
	@Test
	public void testDeal6() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		
		Card card1 = new Card(Suit.HEARTS, Rank.A);
		Card card2 = new Card(Suit.CLUBS, Rank._10);
		Card card3 = new Card(Suit.DIAMONDS, Rank._2);
		Card card4 = new Card(Suit.DIAMONDS, Rank._8);
		Card card5 = new Card(Suit.SPADES, Rank.J);
		Card card6 = new Card(Suit.CLUBS, Rank._6);
		
		stock.push(stock.getCardList(), card1);
		stock.push(stock.getCardList(), card2);
		stock.push(stock.getCardList(), card3);
		
		waste.push(waste.getCardList(), card4);
		waste.push(waste.getCardList(), card5);
		waste.push(waste.getCardList(), card6);
		
		
		dealController.deal(stock, waste);
		stock.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♥A, ♣10]",stock.getCardList().toString());
	}
		
		
	//check waste after deal with !empty stock and !empty waste
	@Test
	public void testDeal8() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		
		Card card1 = new Card(Suit.HEARTS, Rank.A);
		Card card2 = new Card(Suit.CLUBS, Rank._10);
		Card card3 = new Card(Suit.DIAMONDS, Rank._2);
		Card card4 = new Card(Suit.DIAMONDS, Rank._8);
		Card card5 = new Card(Suit.SPADES, Rank.J);
		Card card6 = new Card(Suit.CLUBS, Rank._6);
		card6.setShow(true);
		
		stock.push(stock.getCardList(), card1);
		stock.push(stock.getCardList(), card2);
		stock.push(stock.getCardList(), card3);
		
		waste.push(waste.getCardList(), card4);
		waste.push(waste.getCardList(), card5);
		waste.push(waste.getCardList(), card6);
		
		
		dealController.deal(stock, waste);
		assertEquals("[??, ??, ??, ♦2]",waste.getCardList().toString());
	}
}
