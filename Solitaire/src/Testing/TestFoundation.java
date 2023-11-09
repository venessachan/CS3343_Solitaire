package Testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import stackManager.Foundation;

public class TestFoundation {
	//check card list after push
	@Test
	public void testFoundationPushCard() {
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push(new Card(Suit.SPADES, Rank.A));
		foundation.push(new Card(Suit.SPADES, Rank._2));
		foundation.push(new Card(Suit.SPADES, Rank._3));
		foundation.push(new Card(Suit.SPADES, Rank._4));
		foundation.push(new Card(Suit.SPADES, Rank._5));
		foundation.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♠A, ♠2, ♠3, ♠4, ♠5]", foundation.getCardList().toString());
	}
	
	//check card list after pop
	@Test
	public void testFoundationPopCard1() {
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push(new Card(Suit.CLUBS, Rank.A));
		foundation.push(new Card(Suit.CLUBS, Rank._2));
		foundation.push(new Card(Suit.CLUBS, Rank._3));
		foundation.push(new Card(Suit.CLUBS, Rank._4));
		foundation.push(new Card(Suit.CLUBS, Rank._5));
		foundation.getCardList().forEach((c)->c.setShow(true));
		foundation.pop();
		assertEquals("[♣A, ♣2, ♣3, ♣4]", foundation.getCardList().toString());
	}
	
	@Test
	public void testFoundationPopCard2() {
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push(new Card(Suit.SPADES, Rank.A));
		foundation.pop();
		assertEquals("[]", foundation.getCardList().toString());
	}
	
	@Test//***********error
	public void testFoundationPopCard3() {
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.pop();
		foundation.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[]", foundation.getCardList().toString());
	}
	
	
	//check get last card in foundation
	@Test
	public void testFoundationGetLastCard1(){
		Foundation foundation = new Foundation(Suit.HEARTS);
		foundation.push(new Card(Suit.HEARTS, Rank._10));
		foundation.push(new Card(Suit.HEARTS, Rank.J));
		foundation.push(new Card(Suit.HEARTS, Rank.Q));
		foundation.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♥Q", foundation.getLastCard().toString());
	}
	
	@Test
	public void testFoundationGetLastCard2(){
		Foundation foundation = new Foundation(Suit.HEARTS);
		assertEquals(null, foundation.getLastCard());
	}
	//check full list
	@Test
	public void testFoundationFullList1() {
		Foundation foundation = new Foundation(Suit.CLUBS);
		foundation.push((new Card(Suit.CLUBS, Rank.A)));
		foundation.push((new Card(Suit.CLUBS, Rank._2)));
		foundation.push((new Card(Suit.CLUBS, Rank._3)));
		foundation.push((new Card(Suit.CLUBS, Rank._4)));
		foundation.push((new Card(Suit.CLUBS, Rank._5)));
		foundation.push((new Card(Suit.CLUBS, Rank._6)));
		foundation.push((new Card(Suit.CLUBS, Rank._7)));
		foundation.push((new Card(Suit.CLUBS, Rank._8)));
		foundation.push((new Card(Suit.CLUBS, Rank._9)));
		foundation.push((new Card(Suit.CLUBS, Rank._10)));
		foundation.push((new Card(Suit.CLUBS, Rank.J)));
		foundation.push((new Card(Suit.CLUBS, Rank.Q)));
		foundation.push((new Card(Suit.CLUBS, Rank.K)));
		assertEquals(true, foundation.full());
	}
	
	//not full
	@Test
	public void testFoundationFullList2() {
		Foundation foundation = new Foundation(Suit.DIAMONDS);
		foundation.push((new Card(Suit.DIAMONDS, Rank.A)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._2)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._3)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._4)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._5)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._6)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._7)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._8)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._9)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._10)));
		foundation.push((new Card(Suit.DIAMONDS, Rank.J)));
		foundation.push((new Card(Suit.DIAMONDS, Rank.Q)));
		assertEquals(false, foundation.full());
	}
	
	//check print card
	@Test
	public void testPrintFoundation1() {
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push((new Card(Suit.SPADES, Rank.A)));
		foundation.push((new Card(Suit.SPADES, Rank._2)));
		foundation.push((new Card(Suit.SPADES, Rank._3)));
		foundation.push((new Card(Suit.SPADES, Rank._4)));
		foundation.push((new Card(Suit.SPADES, Rank._5)));
		foundation.push((new Card(Suit.SPADES, Rank._6)));
		foundation.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♠6", foundation.print());
	}
	
	@Test
	public void testPrintFoundation2() {
		Foundation foundation = new Foundation(Suit.SPADES);
		assertEquals("♠", foundation.print());
		
	}
	
		
	//check first valid card in foundation
	//same suit with rank A
	@Test 
	public void testFoundationValidAce1() {
		Card card = new Card(Suit.SPADES, Rank.A);
		Foundation foundation = new Foundation(Suit.SPADES);
		assertEquals(true, foundation.checkValidAce(card));
	}
	
	@Test 
	public void testFoundationValidAce2() {
		Card card = new Card(Suit.HEARTS, Rank.A);
		Foundation foundation = new Foundation(Suit.HEARTS);
		assertEquals(true, foundation.checkValidAce(card));
	}
	
	@Test 
	public void testFoundationValidAce3() {
		Card card = new Card(Suit.CLUBS, Rank.A);
		Foundation foundation = new Foundation(Suit.CLUBS);
		assertEquals(true, foundation.checkValidAce(card));
	}
	
	@Test 
	public void testFoundationValidAce4() {
		Card card = new Card(Suit.DIAMONDS, Rank.A);
		Foundation foundation = new Foundation(Suit.DIAMONDS);
		assertEquals(true, foundation.checkValidAce(card));
	}
	//same suit with other rank
	@Test 
	public void testFoundationValidAce5() {
		Card card = new Card(Suit.SPADES, Rank._2);
		Foundation foundation = new Foundation(Suit.SPADES);
		assertEquals(false, foundation.checkValidAce(card));
	}
	
	@Test 
	public void testFoundationValidAce6() {
		Card card = new Card(Suit.HEARTS, Rank.K);
		Foundation foundation = new Foundation(Suit.HEARTS);
		assertEquals(false, foundation.checkValidAce(card));
	}
	
	@Test 
	public void testFoundationValidAce7() {
		Card card = new Card(Suit.CLUBS, Rank._3);
		Foundation foundation = new Foundation(Suit.CLUBS);
		assertEquals(false, foundation.checkValidAce(card));
	}
	
	@Test 
	public void testFoundationValidAce8() {
		Card card = new Card(Suit.DIAMONDS, Rank.Q);
		Foundation foundation = new Foundation(Suit.DIAMONDS);
		assertEquals(false, foundation.checkValidAce(card));
	}
	
	
	//different suit with rank A
	@Test 
	public void testFoundationValidAce9() {
		Card card = new Card(Suit.SPADES, Rank.A);
		Foundation foundation = new Foundation(Suit.HEARTS);
		assertEquals(false, foundation.checkValidAce(card));
	}
	
	@Test 
	public void testFoundationValidAce10() {
		Card card = new Card(Suit.DIAMONDS, Rank.A);
		Foundation foundation = new Foundation(Suit.CLUBS);
		assertEquals(false, foundation.checkValidAce(card));
	}
	
	
	//check next valid cards in foundation
	//valid suit and rank
	@Test
	public void testFoundationValidNext1() {
		Foundation foundation = new Foundation(Suit.DIAMONDS);
		foundation.push(new Card(Suit.DIAMONDS, Rank.A));
		foundation.push(new Card(Suit.DIAMONDS, Rank._2));
		foundation.push(new Card(Suit.DIAMONDS, Rank._3));
		Card card = new Card(Suit.DIAMONDS, Rank._4);
		assertEquals(true, foundation.checkValidNext(card));
	}
	
	//invalid suit and valid rank
	@Test
	public void testFoundationValidNext2() {
		Foundation foundation = new Foundation(Suit.CLUBS);
		foundation.push(new Card(Suit.CLUBS, Rank._5));
		foundation.push(new Card(Suit.CLUBS, Rank._6));
		foundation.push(new Card(Suit.CLUBS, Rank._7));
		Card card = new Card(Suit.SPADES, Rank._8);
		assertEquals(false, foundation.checkValidNext(card));
	}
	
	//valid suit and invalid rank
	@Test
	public void testFoundationValidNext3() {
		Foundation foundation = new Foundation(Suit.HEARTS);
		foundation.push(new Card(Suit.HEARTS, Rank._8));
		foundation.push(new Card(Suit.HEARTS, Rank._9));
		foundation.push(new Card(Suit.HEARTS, Rank._10));
		Card card = new Card(Suit.HEARTS, Rank.Q);
		assertEquals(false, foundation.checkValidNext(card));
	}
	
	@Test
	public void testFoundationValidNext4() {
		Foundation foundation = new Foundation(Suit.DIAMONDS);
		foundation.push(new Card(Suit.DIAMONDS, Rank.J));
		foundation.push(new Card(Suit.DIAMONDS, Rank.Q));
		foundation.push(new Card(Suit.DIAMONDS, Rank.K));
		Card card = new Card(Suit.DIAMONDS, Rank.A);
		assertEquals(false, foundation.checkValidNext(card));
	}
	
	@Test
	public void testFoundationValidNext5() {
		Foundation foundation = new Foundation(Suit.CLUBS);
		foundation.push(new Card(Suit.CLUBS, Rank._3));
		foundation.push(new Card(Suit.CLUBS, Rank._4));
		foundation.push(new Card(Suit.CLUBS, Rank._5));
		Card card = new Card(Suit.CLUBS, Rank._2);
		assertEquals(false, foundation.checkValidNext(card));
	}
	
	//check valid action
	//empty list and valid card
	@Test
	public void testFoundationValidAction1() {
		Foundation foundation = new Foundation(Suit.SPADES);
		Card card = new Card(Suit.SPADES, Rank.A);
		assertEquals(true, foundation.checkValidAction(card));
	}
		
	//empty list and invalid card (wrong rank)
	@Test
	public void testFoundationValidAction2() {
		Foundation foundation = new Foundation(Suit.HEARTS);
		Card card = new Card(Suit.HEARTS, Rank.Q);
		assertEquals(false, foundation.checkValidAction(card));
	}
	
	//empty list and invalid card (wrong suit)
	@Test
	public void testFoundationValidAction3() {
		Foundation foundation = new Foundation(Suit.HEARTS);
		Card card = new Card(Suit.CLUBS, Rank._2);
		assertEquals(false, foundation.checkValidAction(card));
	}
	
	//not empty list and valid card
	@Test
	public void testFoundationValidAction4() {
		Foundation foundation = new Foundation(Suit.CLUBS);
		foundation.push((new Card(Suit.CLUBS, Rank.A)));
		foundation.push((new Card(Suit.CLUBS, Rank._2)));
		foundation.push((new Card(Suit.CLUBS, Rank._3)));
		foundation.push((new Card(Suit.CLUBS, Rank._4)));
		foundation.push((new Card(Suit.CLUBS, Rank._5)));
		foundation.push((new Card(Suit.CLUBS, Rank._6)));
		foundation.push((new Card(Suit.CLUBS, Rank._7)));
		foundation.push((new Card(Suit.CLUBS, Rank._8)));
		foundation.push((new Card(Suit.CLUBS, Rank._9)));
		foundation.push((new Card(Suit.CLUBS, Rank._10)));
		foundation.push((new Card(Suit.CLUBS, Rank.J)));
		foundation.push((new Card(Suit.CLUBS, Rank.Q)));
		Card card = new Card(Suit.CLUBS, Rank.K);
		assertEquals(true, foundation.checkValidAction(card));
	}
	
	//not empty list and invalid card(wrong rank)
	@Test
	public void testFoundationValidAction5() {
		Foundation foundation = new Foundation(Suit.DIAMONDS);
		foundation.push((new Card(Suit.DIAMONDS, Rank.A)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._2)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._3)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._4)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._5)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._6)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._7)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._8)));
		foundation.push((new Card(Suit.DIAMONDS, Rank._9)));
		Card card = new Card(Suit.DIAMONDS, Rank.J);
		assertEquals(false, foundation.checkValidAction(card));
	}
	
	//not empty list and invalid card(wrong suit)
	@Test
	public void testFoundationValidAction6() {
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push((new Card(Suit.SPADES, Rank.A)));
		foundation.push((new Card(Suit.SPADES, Rank._2)));
		foundation.push((new Card(Suit.SPADES, Rank._3)));
		foundation.push((new Card(Suit.SPADES, Rank._4)));
		foundation.push((new Card(Suit.SPADES, Rank._5)));
		foundation.push((new Card(Suit.SPADES, Rank._6)));
		foundation.push((new Card(Suit.SPADES, Rank._7)));
		foundation.push((new Card(Suit.SPADES, Rank._8)));
		foundation.push((new Card(Suit.SPADES, Rank._9)));
		foundation.push((new Card(Suit.SPADES, Rank._10)));
		foundation.push((new Card(Suit.SPADES, Rank.J)));
		foundation.push((new Card(Suit.SPADES, Rank.Q)));
		Card card = new Card(Suit.DIAMONDS, Rank.K);
		assertEquals(false, foundation.checkValidAction(card));
	}
		
}
