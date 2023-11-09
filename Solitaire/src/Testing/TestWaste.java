package Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import stackManager.Waste;

public class TestWaste {
	@Test
	public void testWastePushCard1() {
		Waste waste = new Waste();
		waste.push(new Card(Suit.CLUBS, Rank._7));
		waste.push(new Card(Suit.DIAMONDS, Rank._3));
		waste.push(new Card(Suit.SPADES, Rank._10));
		waste.push(new Card(Suit.SPADES, Rank._5));
		waste.push(new Card(Suit.HEARTS, Rank.J));
		waste.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♣7, ♦3, ♠10, ♠5, ♥J]",waste.getCardList().toString());
	}
	
	@Test
	public void testWasteGetTopCard1() {
		Waste waste = new Waste();
		waste.push(new Card(Suit.SPADES, Rank.A));
		waste.push(new Card(Suit.HEARTS, Rank.Q));
		waste.push(new Card(Suit.CLUBS, Rank._8));
		waste.push(new Card(Suit.DIAMONDS, Rank._2));
		waste.push(new Card(Suit.HEARTS, Rank._4));
		waste.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♥4", waste.peak().toString());
	}
	
	@Test	
	public void testWastePopCard1() {
		Waste waste = new Waste();
		waste.push(new Card(Suit.DIAMONDS, Rank._3));
		waste.push(new Card(Suit.SPADES, Rank._6));
		waste.push(new Card(Suit.HEARTS, Rank._8));
		waste.push(new Card(Suit.DIAMONDS, Rank.A));
		waste.push(new Card(Suit.CLUBS, Rank._9));
		waste.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♣9", waste.pop().toString());
	}
	
	
	@Test
	public void testWastePrint1() {
		Waste waste = new Waste();
		waste.push(new Card(Suit.SPADES, Rank.A));
		waste.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♠A", waste.print());
	}
	
	@Test
	public void testWastePrint2() {
		Waste waste = new Waste();
		waste.push(new Card(Suit.DIAMONDS, Rank._4));
		waste.push(new Card(Suit.CLUBS, Rank._8));
		waste.push(new Card(Suit.DIAMONDS, Rank.K));
		waste.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♦K", waste.print());
	}
	
	@Test
	public void testWastePrint3() {
		Waste waste = new Waste();
		assertEquals("XX", waste.print());
	}
}
