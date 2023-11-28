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
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));

		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));

		moveToTableauController.execute(moveFromT, moveToT, 5);
		assertEquals(false, moveToT.getCardList().equals(moveFromT.getCardList()));
	}

	@Before
	public void setup() {
		MoveToTableauController.resetInstance();
		moveToTableauController = MoveToTableauController.getInstance();
	}

	@Test
	public void testMoveToTableau2() {
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));

		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));

		moveToTableauController.execute(moveFromT, moveToT, 5);
		moveToT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♦2, ♦8, ♣7, ♦6, ♠5, ♥4, ♣3]", moveToT.getCardList().toString());
	}

	@Test
	public void testMoveToTableau3() {
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));

		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));

		moveToTableauController.execute(moveFromT, moveToT, 5);
		moveFromT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2]", moveFromT.getCardList().toString());
	}

	@Test
	public void testMoveToTableau4() {
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));

		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));

		moveToTableauController.execute(moveFromT, moveToT, 1);
		moveToT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♦2, ♦8, ♣7]", moveToT.getCardList().toString());
	}

	@Test
	public void testMoveToTableau5() {
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));

		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));

		moveToTableauController.execute(moveFromT, moveToT, 1);
		moveFromT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3]", moveFromT.getCardList().toString());
	}

	//tableau to tableau , no card is available
	@Test
	public void testMoveToTableau6() {
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));

		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));

		moveToTableauController.execute(moveFromT, moveToT, 0);
		moveFromT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3, ♣7]", moveFromT.getCardList().toString());
	}

	//waste to tableau
	@Test
	public void testMoveToTableau7() {
		Tableau moveTo = new Tableau();
		Waste moveFrom = new Waste();
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveTo.push(moveTo.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveTo.push(moveTo.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveTo.push(moveTo.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveTo.push(moveTo.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank._7));

		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._8));

		moveToTableauController.execute(moveFrom, moveTo, 1);
		moveTo.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3, ♣7, ♣8]", moveTo.getCardList().toString());

	}

	//foundation to tableau (for undo)
	@Test
	public void testMoveToTableau8() {
		Tableau moveTo = new Tableau();
		Foundation moveFrom = new Foundation(Suit.CLUBS);
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveTo.push(moveTo.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveTo.push(moveTo.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveTo.push(moveTo.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveTo.push(moveTo.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank._7));

		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank.A));

		moveToTableauController.execute(moveFrom, moveTo, 1);
		moveTo.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3, ♣7, ♣A]", moveTo.getCardList().toString());
	}

	//check available card(s) count
	@Test
	public void testMoveToTableau9() {
		Tableau target = new Tableau();
		Card moveFrom = new Card(Suit.CLUBS, Rank._8);
		target.push(target.getCardList(), new Card(Suit.CLUBS, Rank.K));
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank._2));
		target.push(target.getCardList(), new Card(Suit.DIAMONDS, Rank._6));

		int testUnit = moveToTableauController.getMoveCardCount(moveFrom, target);
		assertEquals(-1, testUnit);
	}

	@Test
	public void testMoveToTableau10() {
		Tableau target = new Tableau();
		Card moveFrom = new Card(Suit.CLUBS, Rank._5);
		target.push(target.getCardList(), new Card(Suit.CLUBS, Rank.K));
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank._2));
		target.push(target.getCardList(), new Card(Suit.DIAMONDS, Rank._6));

		int testUnit = moveToTableauController.getMoveCardCount(moveFrom, target);
		assertEquals(1, testUnit);
	}
	//find valid cards when moving a tableau to another tableau
	
	//No card is valid to move
	//one match card but it is invisible
	@Test
	public void testMoveToTableau11() {
		Tableau moveFrom = new Tableau();
		Tableau target = new Tableau();
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank._10));
		
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.K));
		target.push(target.getCardList(), new Card(Suit.CLUBS, Rank.Q));
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.J));

		
		assertEquals(-1, moveToTableauController.getMoveCardCount(moveFrom, target, 0));
	}
	@Test
	public void testMoveToTableau12() {
		Tableau moveFrom = new Tableau();
		Tableau target = new Tableau();
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank._10));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.HEARTS, Rank._10));
		

		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.K));
		target.push(target.getCardList(), new Card(Suit.CLUBS, Rank.Q));
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.J));

		
		assertEquals(-1, moveToTableauController.getMoveCardCount(moveFrom, target, 1));
	}
	
	@Test
	public void testMoveToTableau13() {
		Tableau moveFrom = new Tableau();
		Tableau target = new Tableau();
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.HEARTS, Rank._10));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._4));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank._8));

		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.K));
		target.push(target.getCardList(), new Card(Suit.CLUBS, Rank.Q));
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.J));

		
		assertEquals(-1, moveToTableauController.getMoveCardCount(moveFrom, target, 3));
	}
	
	
	//Valid card exist
	//move multiple card tableau to tableau
	@Test
	public void testMoveToTableau14() {
		Tableau moveFrom = new Tableau();
		Tableau target = new Tableau();
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._10));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank.K));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank._10));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.HEARTS, Rank._9));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank._8));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.DIAMONDS, Rank._7));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._6));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.HEARTS, Rank._5));

		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.K));
		target.push(target.getCardList(), new Card(Suit.CLUBS, Rank.Q));
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.J));

		
		assertEquals(6, moveToTableauController.getMoveCardCount(moveFrom, target, 8));
	}
	
	//move 1 card tableau to tableau
	@Test
	public void testMoveToTableau15() {
		Tableau moveFrom = new Tableau();
		Tableau target = new Tableau();
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._10));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank.K));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank._10));

		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.K));
		target.push(target.getCardList(), new Card(Suit.CLUBS, Rank.Q));
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.J));

		
		assertEquals(1, moveToTableauController.getMoveCardCount(moveFrom, target, 3));
	}

	//have a match card to target but whole column is invalid
	@Test
	public void testMoveToTableau16() {
		Tableau moveFrom = new Tableau();
		Tableau target = new Tableau();
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._10));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank.K));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank._10));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.HEARTS, Rank._9));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank._8));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.DIAMONDS, Rank._7));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._6));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.HEARTS, Rank._5));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.DIAMONDS, Rank._5));

		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.K));
		target.push(target.getCardList(), new Card(Suit.CLUBS, Rank.Q));
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank.J));

		
		assertEquals(-2, moveToTableauController.getMoveCardCount(moveFrom, target, 8));
	}
	
	@Test
	public void testMoveToTableau17() {
		List<Card> moveFromList = new ArrayList<Card>();
		
		Card cardA = new Card(Suit.DIAMONDS, Rank.A);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		Card card3 = new Card(Suit.DIAMONDS, Rank._3);
		Card card10 = new Card(Suit.DIAMONDS, Rank._10);
		card10.setShow(true);
		
		moveFromList.add(cardA);
		moveFromList.add(card2);
		moveFromList.add(card3);
		moveFromList.add(card10);
		
		int moveCardCount = moveToTableauController.getShowCard(moveFromList);
		assertEquals(1, moveCardCount);
	}
	
	@Test
	public void testMoveToTableau18() {
		List<Card> moveFromList = new ArrayList<Card>();
		
		Card cardA = new Card(Suit.DIAMONDS, Rank.A);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		Card card3 = new Card(Suit.DIAMONDS, Rank._3);
		Card card10 = new Card(Suit.DIAMONDS, Rank._10);
		
		moveFromList.add(cardA);
		moveFromList.add(card2);
		moveFromList.add(card3);
		moveFromList.add(card10);
		
		int moveCardCount = moveToTableauController.getShowCard(moveFromList);
		assertEquals(0, moveCardCount);
	}

	@Test
	public void testMoveToTableau19() {
		List<Card> moveFromList = new ArrayList<Card>();
		
		Card cardA = new Card(Suit.DIAMONDS, Rank.A);
		cardA.setShow(true);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		card2.setShow(true);
		Card card3 = new Card(Suit.DIAMONDS, Rank._3);
		card3.setShow(true);
		Card card10 = new Card(Suit.DIAMONDS, Rank._10);
		card10.setShow(true);
		
		moveFromList.add(cardA);
		moveFromList.add(card2);
		moveFromList.add(card3);
		moveFromList.add(card10);
		
		int moveCardCount = moveToTableauController.getShowCard(moveFromList);
		assertEquals(4, moveCardCount);
	}
}
