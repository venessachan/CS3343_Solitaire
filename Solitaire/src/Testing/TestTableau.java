package Testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import stackManager.Tableau;

public class TestTableau {
	//check card list after push
	@Test
	public void testTableauPushCard() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.HEARTS, Rank.K));
		tableau.push(new Card(Suit.SPADES, Rank.Q));
		tableau.push(new Card(Suit.HEARTS, Rank.J));
		tableau.push(new Card(Suit.CLUBS, Rank._10));
		tableau.push(new Card(Suit.DIAMONDS, Rank._9));
		tableau.getCardList().forEach((c)->c.setShow(true));
		assertEquals(" ♥K  ♠Q  ♥J  ♣10  ♦9 ", tableau.print());
	}
	
	//check card list after pop
	@Test
	public void testTableauPopCard1() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.CLUBS, Rank._8));
		tableau.push(new Card(Suit.DIAMONDS, Rank._7));
		tableau.push(new Card(Suit.SPADES, Rank._6));
		tableau.push(new Card(Suit.HEARTS, Rank._5));
		tableau.push(new Card(Suit.SPADES, Rank._4));
		tableau.getCardList().forEach((c)->c.setShow(true));
		tableau.pop();
		assertEquals("[♣8, ♦7, ♠6, ♥5]", tableau.getCardList().toString());
	}
	
	//check the top card on the tableau
	@Test
	public void testPeek() {
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.SPADES, Rank.K));
		tableau.push(new Card(Suit.HEARTS, Rank.Q));
		tableau.push(new Card(Suit.CLUBS, Rank.J));
		tableau.push(new Card(Suit.DIAMONDS, Rank._10));
		tableau.getCardList().forEach((c)->c.setShow(true));
		assertEquals("♦10", tableau.peek().toString());
	}
	
	//check valid card
	//valid rank and color
	@Test
	public void testValidCard1(){
		Card moveFromCard = new Card(Suit.SPADES, Rank.A);
		Card moveToCard = new Card(Suit.HEARTS, Rank._2);
		Tableau tableau = new Tableau();
		assertEquals(true, tableau.checkValidCard(moveFromCard, moveToCard));
	}
	
	//valid rank and invalid color
	@Test
	public void testValidCard2(){
		Card moveFromCard = new Card(Suit.CLUBS, Rank.Q);
		Card moveToCard = new Card(Suit.CLUBS, Rank.K);
		Tableau tableau = new Tableau();
		assertEquals(false, tableau.checkValidCard(moveFromCard, moveToCard));
	}
	
	//invalid rank and valid color
	@Test
	public void testValidCard3(){
		Card moveFromCard = new Card(Suit.DIAMONDS, Rank._9);
		Card moveToCard = new Card(Suit.SPADES, Rank.J);
		Tableau tableau = new Tableau();
		assertEquals(false, tableau.checkValidCard(moveFromCard, moveToCard));
	}
	
	@Test
	public void testValidCard4(){
		Card moveFromCard = new Card(Suit.DIAMONDS, Rank.Q);
		Card moveToCard = new Card(Suit.SPADES, Rank.J);
		Tableau tableau = new Tableau();
		assertEquals(false, tableau.checkValidCard(moveFromCard, moveToCard));
	}
	
	@Test
	public void testValidCard5(){
		Card moveFromCard = new Card(Suit.DIAMONDS, Rank.J);
		Card moveToCard = new Card(Suit.SPADES, Rank.J);
		Tableau tableau = new Tableau();
		assertEquals(false, tableau.checkValidCard(moveFromCard, moveToCard));
	}
	
	//check valid action
	//check if empty tableau with valid card
	@Test
	public void testValidAction1(){
		Card card = new Card(Suit.SPADES, Rank.K);
		Tableau tableau = new Tableau();
		assertEquals(true, tableau.checkValidAction(card));
	}
	@Test
	public void testValidAction2(){
		Card card = new Card(Suit.HEARTS, Rank.K);
		Tableau tableau = new Tableau();
		assertEquals(true, tableau.checkValidAction(card));
	}
	@Test
	public void testValidAction3(){
		Card card = new Card(Suit.CLUBS, Rank.K);
		Tableau tableau = new Tableau();
		assertEquals(true, tableau.checkValidAction(card));
	}
	@Test
	public void testValidAction4(){
		Card card = new Card(Suit.DIAMONDS, Rank.K);
		Tableau tableau = new Tableau();
		assertEquals(true, tableau.checkValidAction(card));
	}
	
	//check if empty tableau with invalid card
	@Test
	public void testValidAction5(){
		Card card = new Card(Suit.HEARTS, Rank.A);
		Tableau tableau = new Tableau();
		assertEquals(false, tableau.checkValidAction(card));
	}
	
	@Test
	public void testValidAction6(){
		Card card = new Card(Suit.SPADES, Rank.Q);
		Tableau tableau = new Tableau();
		assertEquals(false, tableau.checkValidAction(card));
	}
	
	//check if not empty tableau with valid card
	@Test
	public void testValidAction7(){
		Card card = new Card(Suit.HEARTS, Rank._5);
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.DIAMONDS, Rank._9));
		tableau.push(new Card(Suit.CLUBS, Rank._8));
		tableau.push(new Card(Suit.HEARTS, Rank._7));
		tableau.push(new Card(Suit.SPADES, Rank._6));
		assertEquals(true, tableau.checkValidAction(card));
	}
	
	//check if not empty tableau with invalid color
	@Test
	public void testValidAction8(){
		Card card = new Card(Suit.HEARTS, Rank._9);
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.DIAMONDS, Rank.Q));
		tableau.push(new Card(Suit.CLUBS, Rank.J));
		tableau.push(new Card(Suit.HEARTS, Rank._10));
		assertEquals(false, tableau.checkValidAction(card));
	}
	
	//check if not empty tableau with invalid rank
	@Test
	public void testValidAction9(){
		Card card = new Card(Suit.SPADES, Rank.K);
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.DIAMONDS, Rank._3));
		tableau.push(new Card(Suit.CLUBS, Rank._2));
		tableau.push(new Card(Suit.HEARTS, Rank.A));
		assertEquals(false, tableau.checkValidAction(card));
	}
	
	//check move card list to tableau
	@Test
	public void testTableauPut() {
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.HEARTS, Rank._7));
		cards.add(new Card(Suit.CLUBS, Rank._6));
		cards.add(new Card(Suit.DIAMONDS, Rank._5));
		cards.add(new Card(Suit.SPADES, Rank._4));
		cards.add(new Card(Suit.DIAMONDS, Rank._3));
		cards.add(new Card(Suit.CLUBS, Rank._2));
		cards.add(new Card(Suit.HEARTS, Rank.A));
		Tableau tableau = new Tableau();
		tableau.push(new Card(Suit.HEARTS, Rank.K));
		tableau.push(new Card(Suit.CLUBS, Rank.Q));
		tableau.push(new Card(Suit.DIAMONDS, Rank.J));
		tableau.push(new Card(Suit.SPADES, Rank._10));
		tableau.push(new Card(Suit.DIAMONDS, Rank._9));
		tableau.push(new Card(Suit.CLUBS, Rank._8));
		tableau.put(cards);
		tableau.getCardList().forEach((c)->c.setShow(true));
		assertEquals(" ♥K  ♣Q  ♦J  ♠10  ♦9  ♣8  ♥7  ♣6  ♦5  ♠4  ♦3  ♣2  ♥A ", tableau.print());
	}
}
