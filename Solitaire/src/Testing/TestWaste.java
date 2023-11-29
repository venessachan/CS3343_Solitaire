package Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import stackManager.Waste;

public class TestWaste {
	
	//push->pop->get
	@Test
	public void testGetCardList1() {		
		Waste waste = new Waste();
		waste.push(new Card(Suit.SPADES, Rank._9));
		waste.push(new Card(Suit.HEARTS, Rank._6));
		waste.push(new Card(Suit.CLUBS, Rank.J));
		waste.push(new Card(Suit.DIAMONDS, Rank._7));
		waste.push(new Card(Suit.DIAMONDS, Rank._8));
		waste.pop();
		waste.pop();
		waste.getCardList().forEach((c)->c.setShow(true));;
		assertEquals("[♠9, ♥6, ♣J]", waste.getCardList().toString());
	}
	
	//pop empty waste
	@Test
	public void testGetCardList2() {
		Waste waste = new Waste();
		assertEquals(null, waste.pop());
	}
	
	//get top card when waste is empty
	@Test
	public void testPeek1() {
		Waste waste = new Waste();
		assertEquals("XX", waste.print());
		assertEquals(null, waste.peek());
	}
	
	//get waste when top card is hidden
	@Test
	public void testPeek2() {
		Waste waste = new Waste();
		waste.push(new Card(Suit.CLUBS, Rank.K));
		waste.push(new Card(Suit.SPADES, Rank._3));
		waste.peek().setShow(false);
		assertEquals("♠3", waste.print());
	}

	//get waste when top card is shown
	@Test
	public void testPeek3() {
		Waste waste = new Waste();
		waste.push(new Card(Suit.DIAMONDS, Rank._7));
		waste.push(new Card(Suit.DIAMONDS, Rank._8));
		waste.peek().setShow(true);
		assertEquals("♦8", waste.print());
	}
		
	//waste clear
	@Test
	public void testClearList1() {
		Waste waste = new Waste();
		waste.push(new Card(Suit.SPADES, Rank.A));
		waste.push(new Card(Suit.DIAMONDS, Rank._2));
		waste.push(new Card(Suit.CLUBS, Rank._3));
		waste.push(new Card(Suit.HEARTS, Rank._4));
		waste.clear();

		assertEquals(true, waste.isEmpty());
	}
	
	//test waste count
	@Test
	public void testCount() {
		Waste waste = new Waste();
		waste.push(new Card(Suit.SPADES, Rank.A));
		waste.push(new Card(Suit.SPADES, Rank._2));
		waste.push(new Card(Suit.SPADES, Rank._3));
		waste.push(new Card(Suit.SPADES, Rank._4));
		waste.push(new Card(Suit.SPADES, Rank._5));
		waste.push(new Card(Suit.SPADES, Rank._6));
		waste.push(new Card(Suit.SPADES, Rank._7));

		assertEquals(7, waste.count());
	}
}
