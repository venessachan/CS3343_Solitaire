package Testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import controller.MoveToTableauController;
import stackManager.Foundation;
import stackManager.Tableau;
import stackManager.Waste;

public class TestMoveToTableauController {
	private MoveToTableauController moveToTableauController;

	//tableau to tableau
	@Test
	public void testMoveToTableau1() {
		moveToTableauController = MoveToTableauController.getInstance();
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(new Card(Suit.CLUBS, Rank.K));
	    moveFromT.push(new Card(Suit.HEARTS, Rank._2));
	    moveFromT.push(new Card(Suit.CLUBS, Rank._7));
	    moveFromT.push(new Card(Suit.DIAMONDS, Rank._6));
	    moveFromT.push(new Card(Suit.SPADES, Rank._5));
	    moveFromT.push(new Card(Suit.HEARTS, Rank._4));
	    moveFromT.push(new Card(Suit.CLUBS, Rank._3));

	    moveToT.push(new Card(Suit.DIAMONDS, Rank._2));
	    moveToT.push(new Card(Suit.DIAMONDS, Rank._8));

		moveToTableauController.execute(moveFromT, moveToT, 5);
		assertEquals(false, moveToT.getCardList().equals(moveFromT.getCardList()));
	}

	@Before
	public void setup() {
		MoveToTableauController.resetInstance();
		moveToTableauController = MoveToTableauController.getInstance();
	}

	//Move multiple cards from one tableau to target tableau
	@Test
	public void testMoveToTableau2() {
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(new Card(Suit.CLUBS, Rank.K));
	    moveFromT.push(new Card(Suit.HEARTS, Rank._2));
	    moveFromT.push(new Card(Suit.CLUBS, Rank._7));
	    moveFromT.push(new Card(Suit.DIAMONDS, Rank._6));
	    moveFromT.push(new Card(Suit.SPADES, Rank._5));
	    moveFromT.push(new Card(Suit.HEARTS, Rank._4));
	    moveFromT.push(new Card(Suit.CLUBS, Rank._3));

	    moveToT.push(new Card(Suit.DIAMONDS, Rank._2));
	    moveToT.push(new Card(Suit.DIAMONDS, Rank._8));

		moveToTableauController.execute(moveFromT, moveToT, 5);
		moveToT.getCardList().forEach((c) -> c.setShow(true));
		moveFromT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2]", moveFromT.getCardList().toString());
		assertEquals("[♦2, ♦8, ♣7, ♦6, ♠5, ♥4, ♣3]", moveToT.getCardList().toString());
		
	}

	//tableau to tableau , no card is available
	@Test
	public void testMoveToTableau3() {
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(new Card(Suit.CLUBS, Rank.K));
	    moveFromT.push(new Card(Suit.HEARTS, Rank._2));
	    moveFromT.push(new Card(Suit.DIAMONDS, Rank._6));
	    moveFromT.push(new Card(Suit.SPADES, Rank._5));
	    moveFromT.push(new Card(Suit.HEARTS, Rank._4));
	    moveFromT.push(new Card(Suit.CLUBS, Rank._3));
	    moveFromT.push(new Card(Suit.CLUBS, Rank._7));

	    moveToT.push(new Card(Suit.DIAMONDS, Rank._2));

		moveToTableauController.execute(moveFromT, moveToT, 0);
		moveFromT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3, ♣7]", moveFromT.getCardList().toString());
	}
	
	//tableau to tableau , one card is available
		@Test
		public void testMoveToTableau4() {
			Tableau moveFromT = new Tableau();
			Tableau moveToT = new Tableau();
			moveFromT.push(new Card(Suit.CLUBS, Rank.K));
		    moveFromT.push(new Card(Suit.CLUBS, Rank._3));
		    moveFromT.push(new Card(Suit.CLUBS, Rank._7));

		    moveToT.push(new Card(Suit.DIAMONDS, Rank._8));

			moveToTableauController.execute(moveFromT, moveToT, 1);
			moveFromT.getCardList().forEach((c) -> c.setShow(true));
			moveToT.getCardList().forEach((c) -> c.setShow(true));
			assertEquals("[♣K, ♣3]", moveFromT.getCardList().toString());
			assertEquals("[♦8, ♣7]", moveToT.getCardList().toString());
		}

	//waste to tableau
	@Test
	public void testMoveToTableau5() {
		Tableau moveTo = new Tableau();
		Waste moveFrom = new Waste();
		moveTo.push(new Card(Suit.CLUBS, Rank.K));
	    moveTo.push(new Card(Suit.HEARTS, Rank._2));
	    moveTo.push(new Card(Suit.DIAMONDS, Rank._6));
	    moveTo.push(new Card(Suit.SPADES, Rank._5));
	    moveTo.push(new Card(Suit.HEARTS, Rank._4));
	    moveTo.push(new Card(Suit.CLUBS, Rank._3));
	    moveTo.push(new Card(Suit.CLUBS, Rank._7));

	    moveFrom.push(new Card(Suit.CLUBS, Rank._8));

		moveToTableauController.execute(moveFrom, moveTo, 1);
		moveTo.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3, ♣7, ♣8]", moveTo.getCardList().toString());

	}

	//foundation to tableau (for undo)
	@Test
	public void testMoveToTableau6() {
		Tableau moveTo = new Tableau();
		Foundation moveFrom = new Foundation(Suit.CLUBS);
		moveTo.push(new Card(Suit.CLUBS, Rank.K));
	    moveTo.push(new Card(Suit.HEARTS, Rank._2));
	    moveTo.push(new Card(Suit.DIAMONDS, Rank._6));
	    moveTo.push(new Card(Suit.SPADES, Rank._5));
	    moveTo.push(new Card(Suit.HEARTS, Rank._4));
	    moveTo.push(new Card(Suit.CLUBS, Rank._3));
	    moveTo.push(new Card(Suit.CLUBS, Rank._7));

	    moveFrom.push(new Card(Suit.CLUBS, Rank.A));

		moveToTableauController.execute(moveFrom, moveTo, 1);
		moveTo.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3, ♣7, ♣A]", moveTo.getCardList().toString());
	}

	//check available card(s) count
	//No available card(s) can move to tableau
	@Test
	public void testMoveToTableau7() {
		Tableau target = new Tableau();
		Card moveFrom = new Card(Suit.CLUBS, Rank._8);
		
		target.push(new Card(Suit.CLUBS, Rank.K));
		target.push(new Card(Suit.HEARTS, Rank._2));
		target.push(new Card(Suit.DIAMONDS, Rank._6));

		assertEquals(-1, moveToTableauController.getMoveCardCount(moveFrom, target));
	}

	//One available card(s) can move from waste to tableau
	@Test
	public void testMoveToTableau8() {
		Tableau target = new Tableau();
		Waste waste = new Waste();
		waste.push(new Card(Suit.CLUBS, Rank._5));
		
		target.push(new Card(Suit.CLUBS, Rank.K));
		target.push(new Card(Suit.HEARTS, Rank._2));
		target.push(new Card(Suit.DIAMONDS, Rank._6));

		assertEquals(1, moveToTableauController.getMoveCardCount(waste.peek(), target));
	}
	
	//Find multiple available card(s) can move from tableau to another tableau
	
	//No match card is visible
	@Test
	public void testMoveToTableau9() {
		Tableau moveFrom = new Tableau();
		Tableau target = new Tableau();
		moveFrom.push(new Card(Suit.SPADES, Rank._10));
		moveFrom.push(new Card(Suit.HEARTS, Rank._10));
		
		target.push(new Card(Suit.HEARTS, Rank.K));
		target.push(new Card(Suit.CLUBS, Rank.Q));
		target.push(new Card(Suit.HEARTS, Rank.J));

		assertEquals(-1, moveToTableauController.getMoveCardCount(moveFrom, target, 1));
	}
	
	//Valid card exist
	//move multiple card tableau to tableau
	@Test
	public void testMoveToTableau10() {
		Tableau moveFrom = new Tableau();
		Tableau target = new Tableau();
		moveFrom.push(new Card(Suit.CLUBS, Rank._10));
	    moveFrom.push(new Card(Suit.SPADES, Rank.K));
	    moveFrom.push(new Card(Suit.SPADES, Rank._10));
	    moveFrom.push(new Card(Suit.HEARTS, Rank._9));
	    moveFrom.push(new Card(Suit.SPADES, Rank._8));
	    moveFrom.push(new Card(Suit.DIAMONDS, Rank._7));
	    moveFrom.push(new Card(Suit.CLUBS, Rank._6));
	    moveFrom.push(new Card(Suit.HEARTS, Rank._5));

	    target.push(new Card(Suit.HEARTS, Rank.K));
	    target.push(new Card(Suit.CLUBS, Rank.Q));
	    target.push(new Card(Suit.HEARTS, Rank.J));

		
		assertEquals(6, moveToTableauController.getMoveCardCount(moveFrom, target, 8));
	}

	//have a match card to target but whole column is invalid
	@Test
	public void testMoveToTableau11() {
		Tableau moveFrom = new Tableau();
		Tableau target = new Tableau();
		moveFrom.push(new Card(Suit.CLUBS, Rank._10));
	    moveFrom.push(new Card(Suit.SPADES, Rank.K));
	    moveFrom.push(new Card(Suit.SPADES, Rank._10));
	    moveFrom.push(new Card(Suit.HEARTS, Rank._9));
	    moveFrom.push(new Card(Suit.SPADES, Rank._8));
	    moveFrom.push(new Card(Suit.DIAMONDS, Rank._7));
	    moveFrom.push(new Card(Suit.CLUBS, Rank._6));
	    moveFrom.push(new Card(Suit.HEARTS, Rank._5));
	    moveFrom.push(new Card(Suit.DIAMONDS, Rank._5));

	    target.push(new Card(Suit.HEARTS, Rank.K));
	    target.push(new Card(Suit.CLUBS, Rank.Q));
	    target.push(new Card(Suit.HEARTS, Rank.J));

		assertEquals(-2, moveToTableauController.getMoveCardCount(moveFrom, target, 8));
	}
	
	@Test
	public void testMoveToTableau12() {
		List<Card> moveFromList = new ArrayList<Card>();
		
		moveFromList.add(new Card(Suit.DIAMONDS, Rank.A));
		moveFromList.add(new Card(Suit.DIAMONDS, Rank._2));
		moveFromList.add(new Card(Suit.DIAMONDS, Rank._3));
		moveFromList.add(new Card(Suit.DIAMONDS, Rank._10));
		moveFromList.get(3).setShow(true); 
		assertEquals(1, moveToTableauController.getShowCard(moveFromList));
	}
	
	@Test
	public void testMoveToTableau13() {
		List<Card> moveFromList = new ArrayList<Card>();
		moveFromList.add(new Card(Suit.DIAMONDS, Rank.A));
		moveFromList.add(new Card(Suit.DIAMONDS, Rank._2));
		moveFromList.add(new Card(Suit.DIAMONDS, Rank._3));
		moveFromList.add(new Card(Suit.DIAMONDS, Rank._10));
		moveFromList.forEach((c)->c.setShow(true));
		assertEquals(4, moveToTableauController.getShowCard(moveFromList));
	}
}
