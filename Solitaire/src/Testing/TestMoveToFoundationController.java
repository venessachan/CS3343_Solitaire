package Testing;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import controller.MoveToFoundationController;
import stackManager.Foundation;

public class TestMoveToFoundationController {
	private MoveToFoundationController moveToFoundationController;
	
	@Test
	public void testPush1() {
		moveToFoundationController = MoveToFoundationController.getInstance();
		Card moveFromCard = new Card(Suit.SPADES, Rank._3);
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push(new Card(Suit.SPADES, Rank.A));
		foundation.push(new Card(Suit.SPADES, Rank._2));
		
		moveToFoundationController.execute(moveFromCard, foundation);
		foundation.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♠A, ♠2, ♠3]", foundation.getCardList().toString());
	}
	
	@Before
	public void setup() {
		MoveToFoundationController.resetInstance();
		moveToFoundationController = MoveToFoundationController.getInstance();
	}
	
	@Test
	public void testGetListIndex1() {
		List<Foundation> foundation = new ArrayList<Foundation>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(0).push(new Card(Suit.SPADES, Rank.A));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._2));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._3));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._4));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._5));

		assertEquals(false, foundation.get(0).getCardList().equals(foundation.get(2).getCardList()));
	}
	
	@Test
	public void testGetListIndex2() {
		List<Foundation> foundation = new ArrayList<Foundation>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(0).push(new Card(Suit.SPADES, Rank.A));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._2));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._3));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._4));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._5));
		
		foundation.get(0).getCardList().forEach((c)->c.setShow(true));
		assertEquals(0, moveToFoundationController.getListIndex(new Card(Suit.SPADES, Rank._6), foundation));
	}
	
	@Test
	public void testGetListIndex3() {
		List<Foundation> foundation = new ArrayList<Foundation>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(1).push(new Card(Suit.HEARTS, Rank.A));
		foundation.get(1).push(new Card(Suit.HEARTS, Rank._2));
		foundation.get(1).push(new Card(Suit.HEARTS, Rank._3));
		foundation.get(1).push(new Card(Suit.HEARTS, Rank._4));
		
		Card moveFromCard = new Card(Suit.HEARTS, Rank._5);
		assertEquals(1, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}

	@Test
	public void testGetListIndex4() {
		List<Foundation> foundation = new ArrayList<Foundation>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(2).push(new Card(Suit.CLUBS, Rank.A));
		foundation.get(2).push(new Card(Suit.CLUBS, Rank._2));
		foundation.get(2).push(new Card(Suit.CLUBS, Rank._3));
		foundation.get(2).push(new Card(Suit.CLUBS, Rank._4));
		
		Card moveFromCard = new Card(Suit.CLUBS, Rank._5);
		assertEquals(2, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}
	
	@Test
	public void testGetListIndex5() {
		List<Foundation> foundation = new ArrayList<Foundation>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(3).push(new Card(Suit.DIAMONDS, Rank.A));
		foundation.get(3).push(new Card(Suit.DIAMONDS, Rank._2));
		foundation.get(3).push(new Card(Suit.DIAMONDS, Rank._3));
		foundation.get(3).push(new Card(Suit.DIAMONDS, Rank._4));
		
		Card moveFromCard = new Card(Suit.DIAMONDS, Rank._5);
		assertEquals(3, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}
	
	@Test
	public void testGetListIndex6() {
		List<Foundation> foundation = new ArrayList<Foundation>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(0).push(new Card(Suit.SPADES, Rank.A));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._2));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._3));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._4));
		foundation.get(0).push(new Card(Suit.SPADES, Rank._5));
		
		Card moveFromCard = new Card(Suit.SPADES, Rank._7);
		assertEquals(-1, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}
	
	@Test
	public void testGetListIndex7() {
		List<Foundation> foundation = new ArrayList<Foundation>();
		foundation = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(3).push(new Card(Suit.DIAMONDS, Rank.A));
		foundation.get(3).push(new Card(Suit.DIAMONDS, Rank._2));
		foundation.get(3).push(new Card(Suit.DIAMONDS, Rank._3));
		foundation.get(3).push(new Card(Suit.DIAMONDS, Rank._4));
		
		Card moveFromCard = new Card(Suit.HEARTS, Rank._5);
		assertEquals(-1, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}  
}
