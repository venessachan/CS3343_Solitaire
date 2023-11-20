package Testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import stackManager.Waste;

public class TestWaste {
	
	@Test
	public void testGetCardList1() {
		Waste waste = new Waste();
		List<Card> expectedResult = new ArrayList<Card>();
		expectedResult.clear();
		assertEquals(expectedResult, waste.getCardList());
	}
	
	@Test
	public void testGetCardList2() {		//push->get
		Waste waste = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank._9);
		Card card2 = new Card(Suit.HEARTS, Rank._6);
		Card card3 = new Card(Suit.CLUBS, Rank.J);
		Card card4 = new Card(Suit.DIAMONDS, Rank._7);
		Card card5 = new Card(Suit.DIAMONDS, Rank._8);
		
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		waste.push(waste.getCardList(), card5);
		
		List<Card> expectedResult = new ArrayList<>();
	    expectedResult.add(card1);
	    expectedResult.add(card2);
	    expectedResult.add(card3);
	    expectedResult.add(card4);
	    expectedResult.add(card5);
		
		assertEquals(expectedResult, waste.getCardList());
	}
	
	@Test
	public void testGetCardList3() {		//push->pop->get
		Waste waste = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank._9);
		Card card2 = new Card(Suit.HEARTS, Rank._6);
		Card card3 = new Card(Suit.CLUBS, Rank.J);
		Card card4 = new Card(Suit.DIAMONDS, Rank._7);
		Card card5 = new Card(Suit.DIAMONDS, Rank._8);
		
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		waste.push(waste.getCardList(), card5);
		waste.pop(waste.getCardList());
		waste.pop(waste.getCardList());
		
		List<Card> expectedResult = new ArrayList<>();
	    expectedResult.add(card1);
	    expectedResult.add(card2);
	    expectedResult.add(card3);
	    expectedResult.add(card4);
	    expectedResult.add(card5);
	    expectedResult.remove(4);
	    expectedResult.remove(3);
		
		assertEquals(expectedResult, waste.getCardList());
	}
	

	@Test
	public void testPeek1() {
		Waste waste = new Waste();
		Card card1 = new Card(Suit.CLUBS, Rank.K);
		Card card2 = new Card(Suit.SPADES, Rank._3);
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		assertEquals(card2, waste.peek(waste.getCardList()));
	}
	
	@Test
	public void testPeek2() {
		Waste waste = new Waste();
		assertEquals(null, waste.peek(waste.getCardList()));
	}
	
	@Test
	public void testPrintCardList1() {
		Waste waste = new Waste();
		String expectedResult = "XX";
		assertEquals(expectedResult,waste.print());
	}
	
	@Test
	public void testPrintCardList2() {
		Waste waste = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);
		Card card3 = new Card(Suit.CLUBS, Rank.K);
		Card card4 = new Card(Suit.DIAMONDS, Rank._10);
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		waste.peek(waste.getCardList()).setShow(true);
		String expectedResult = "♦10";
		assertEquals(expectedResult,waste.print());
	}
	
	@Test
	public void testPrintCardList3() {
		Waste waste = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank._3);
		Card card2 = new Card(Suit.DIAMONDS, Rank._4);
		Card card3 = new Card(Suit.CLUBS, Rank.J);
		Card card4 = new Card(Suit.HEARTS, Rank.Q);
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		waste.peek(waste.getCardList()).setShow(false);
		String expectedResult = "♥Q";
		assertEquals(expectedResult,waste.print());
	}
	
	@Test
	public void testClearList1() {
		Waste waste = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		Card card3 = new Card(Suit.CLUBS, Rank._3);
		Card card4 = new Card(Suit.HEARTS, Rank._4);
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		
		waste.clear(waste.getCardList());
		List<Card> expectedResult = new ArrayList<>();
		expectedResult.clear();
		assertEquals(expectedResult, waste.getCardList());
	}
	
	@Test
	public void testWasteCount() {
		Waste waste = new Waste();
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		Card card3 = new Card(Suit.CLUBS, Rank._3);
		Card card4 = new Card(Suit.HEARTS, Rank.A);
		Card card5 = new Card(Suit.HEARTS, Rank._10);
		Card card6 = new Card(Suit.SPADES, Rank._9);
		Card card7 = new Card(Suit.DIAMONDS, Rank._7);
		
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		waste.push(waste.getCardList(), card3);
		waste.push(waste.getCardList(), card4);
		waste.push(waste.getCardList(), card5);
		waste.push(waste.getCardList(), card6);
		waste.push(waste.getCardList(), card7);

		assertEquals(7, waste.count(waste.getCardList()));
	}
//	
//	
//	@Test
//	public void testWastePushCard1() {
//		Waste waste = new Waste();
//		waste.push(new Card(Suit.CLUBS, Rank._7));
//		waste.push(new Card(Suit.DIAMONDS, Rank._3));
//		waste.push(new Card(Suit.SPADES, Rank._10));
//		waste.push(new Card(Suit.SPADES, Rank._5));
//		waste.push(new Card(Suit.HEARTS, Rank.J));
//		waste.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("[♣7, ♦3, ♠10, ♠5, ♥J]",waste.getCardList().toString());
//	}
//	
//	@Test
//	public void testWasteGetTopCard1() {
//		Waste waste = new Waste();
//		waste.push(new Card(Suit.SPADES, Rank.A));
//		waste.push(new Card(Suit.HEARTS, Rank.Q));
//		waste.push(new Card(Suit.CLUBS, Rank._8));
//		waste.push(new Card(Suit.DIAMONDS, Rank._2));
//		waste.push(new Card(Suit.HEARTS, Rank._4));
//		waste.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("♥4", waste.peak().toString());
//	}
//	
//	@Test	
//	public void testWastePopCard1() {
//		Waste waste = new Waste();
//		waste.push(new Card(Suit.DIAMONDS, Rank._3));
//		waste.push(new Card(Suit.SPADES, Rank._6));
//		waste.push(new Card(Suit.HEARTS, Rank._8));
//		waste.push(new Card(Suit.DIAMONDS, Rank.A));
//		waste.push(new Card(Suit.CLUBS, Rank._9));
//		waste.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("♣9", waste.pop().toString());
//	}
//	
//	
//	@Test
//	public void testWastePrint1() {
//		Waste waste = new Waste();
//		waste.push(new Card(Suit.SPADES, Rank.A));
//		waste.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("♠A", waste.print());
//	}
//	
//	@Test
//	public void testWastePrint2() {
//		Waste waste = new Waste();
//		waste.push(new Card(Suit.DIAMONDS, Rank._4));
//		waste.push(new Card(Suit.CLUBS, Rank._8));
//		waste.push(new Card(Suit.DIAMONDS, Rank.K));
//		waste.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("♦K", waste.print());
//	}
//	
//	@Test
//	public void testWastePrint3() {
//		Waste waste = new Waste();
//		assertEquals("XX", waste.print());
//	}
}
