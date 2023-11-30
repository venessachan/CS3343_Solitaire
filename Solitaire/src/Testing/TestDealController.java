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
		waste.push(new Card(Suit.SPADES, Rank._4));
		waste.push(new Card(Suit.HEARTS, Rank.K));
		waste.push(new Card(Suit.CLUBS, Rank.A));
		waste.push(new Card(Suit.SPADES, Rank._10));
		waste.push(new Card(Suit.DIAMONDS, Rank._5));
		waste.push(new Card(Suit.CLUBS, Rank.Q));
		dealController.execute("D");
		assertEquals("[]",waste.getCardList().toString());
	}
	
	@Before
	public void setup() {
		DealController.resetInstance();
		dealController = DealController.getInstance();
	}
//	
//	//check stock after deal with empty stock and !empty waste
//	@Test
//	public void testDeal2() {
//		Stock stock = new Stock();
//		Waste waste = new Waste();
//		waste.push(new Card(Suit.SPADES, Rank._4));
//		waste.push(new Card(Suit.HEARTS, Rank.K));
//		waste.push(new Card(Suit.CLUBS, Rank.A));
//		waste.push(new Card(Suit.SPADES, Rank._10));
//		waste.push(new Card(Suit.DIAMONDS, Rank._5));
//		waste.push(new Card(Suit.CLUBS, Rank.Q));
//		dealController.deal(stock, waste);
//		stock.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("[♣Q, ♦5, ♠10, ♣A, ♥K, ♠4]",stock.getCardList().toString());
//	}
//	
//	//check card visibility after deal with empty stock and !empty waste
//	@Test
//	public void testDeal3() {
//		Stock stock = new Stock();
//		Waste waste = new Waste();
//		waste.push(new Card(Suit.SPADES, Rank._4));
//		waste.push(new Card(Suit.HEARTS, Rank.K));
//		waste.push(new Card(Suit.CLUBS, Rank.A));
//		waste.push(new Card(Suit.SPADES, Rank._10));
//		waste.push(new Card(Suit.DIAMONDS, Rank._5));
//		waste.push(new Card(Suit.CLUBS, Rank.Q));
//		waste.peek().setShow(true);
//		
//		dealController.deal(stock, waste);
//		assertEquals("[]",waste.getCardList().toString());
//	}
//		
//	//check return value of deal() with empty stock and empty waste
//	@Test
//	public void testDeal4() {
//		Stock stock = new Stock();
//		Waste waste = new Waste();
//		assertEquals(-1,dealController.deal(stock, waste));
//	}
//	
//	//check waste after deal with !empty stock and !empty waste
//	@Test
//	public void testDeal5() {
//		Stock stock = new Stock();
//		Waste waste = new Waste();
//
//		stock.push(new Card(Suit.HEARTS, Rank.A));
//		stock.push(new Card(Suit.CLUBS, Rank._10));
//		stock.push(new Card(Suit.DIAMONDS, Rank._2));
//		
//		waste.push(new Card(Suit.DIAMONDS, Rank._8));
//		waste.push(new Card(Suit.SPADES, Rank.J));
//		waste.push(new Card(Suit.CLUBS, Rank._6));
//		
//		
//		dealController.deal(stock, waste);
//		waste.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("[♦8, ♠J, ♣6, ♦2]",waste.getCardList().toString());
//	}
//		
//	//check stock after deal with !empty stock and !empty waste
//	@Test
//	public void testDeal6() {
//		Stock stock = new Stock();
//		Waste waste = new Waste();
//		
//		stock.push(new Card(Suit.HEARTS, Rank.A));
//		stock.push(new Card(Suit.CLUBS, Rank._10));
//		stock.push(new Card(Suit.DIAMONDS, Rank._2));
//		
//		waste.push(new Card(Suit.DIAMONDS, Rank._8));
//		waste.push(new Card(Suit.SPADES, Rank.J));
//		waste.push(new Card(Suit.CLUBS, Rank._6));
//		
//		
//		dealController.deal(stock, waste);
//		stock.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("[♥A, ♣10]",stock.getCardList().toString());
//	}
//		
//		
//	//check waste after deal with !empty stock and !empty waste
//	@Test
//	public void testDeal7() {
//		Stock stock = new Stock();
//		Waste waste = new Waste();
//		
//		stock.push(new Card(Suit.HEARTS, Rank.A));
//		stock.push(new Card(Suit.CLUBS, Rank._10));
//		stock.push(new Card(Suit.DIAMONDS, Rank._2));
//		
//		waste.push(new Card(Suit.DIAMONDS, Rank._8));
//		waste.push(new Card(Suit.SPADES, Rank.J));
//		waste.push(new Card(Suit.CLUBS, Rank._6));
//		waste.peek().setShow(true);
//		
//		dealController.deal(stock, waste);
//		assertEquals("[??, ??, ??, ♦2]",waste.getCardList().toString());
//	}
//	
//	
//	//check waste after deal with !empty stock and empty waste
//	@Test
//	public void testDeal8() {
//		Stock stock = new Stock();
//		Waste waste = new Waste();
//		
//		stock.push(new Card(Suit.HEARTS, Rank.A));
//		stock.push(new Card(Suit.CLUBS, Rank._10));
//		stock.push(new Card(Suit.DIAMONDS, Rank._2));
//		
//		dealController.deal(stock, waste);
//		assertEquals("[♦2]",waste.getCardList().toString());
//	}
//	
//	//check stock after deal with !empty stock and empty waste
//	@Test
//	public void testDeal9() {
//		Stock stock = new Stock();
//		Waste waste = new Waste();
//		
//		stock.push(new Card(Suit.HEARTS, Rank.A));
//		stock.push(new Card(Suit.CLUBS, Rank._10));
//		stock.push(new Card(Suit.DIAMONDS, Rank._2));
//		
//		
//		dealController.deal(stock, waste);
//		stock.getCardList().forEach((c)->c.flip());
//		assertEquals("[♥A, ♣10]",stock.getCardList().toString());
//	}
//	
//	
//	//check waste after deal with !empty stock and !empty waste
//	@Test
//	public void testDeal10() {
//		Stock stock = new Stock();
//		Waste waste = new Waste();
//
//		stock.push(new Card(Suit.HEARTS, Rank.A));
//		stock.push(new Card(Suit.CLUBS, Rank._10));
//		stock.push(new Card(Suit.DIAMONDS, Rank._2));
//		
//		waste.push(new Card(Suit.DIAMONDS, Rank._8));
//		waste.push(new Card(Suit.SPADES, Rank.J));
//		waste.push(new Card(Suit.CLUBS, Rank._6));
//		waste.peek().setShow(true);
//		
//		dealController.deal(stock, waste);
//		assertEquals("[??, ??, ??, ♦2]",waste.getCardList().toString());
//	}
}
