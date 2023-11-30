package Testing;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;

import org.junit.Before;

import controller.UndoController;
import stackManager.CommandHistory;
import stackManager.Foundation;
import stackManager.Stock;
import stackManager.Tableau;
import stackManager.Waste;

public class TestUndoController {
	private static UndoController undoController;
	private static CommandHistory commandHistory;

	@Test
	public void testUndoController1() {
		undoController = UndoController.getInstance();
		commandHistory = new CommandHistory();
		
		undoController.addUndoCommand(commandHistory, "T 1 2");
		undoController.addUndoCommand(commandHistory, "T 5 2");
		undoController.addUndoCommand(commandHistory, "D");
		List<String> actual = commandHistory.getUndoCommandList();
		List<String> expected = Arrays.asList("T 1 2", "T 5 2", "D");

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Before
	public void setup() {
		UndoController.resetInstance();
		undoController = UndoController.getInstance();
		commandHistory = new CommandHistory();
	}
	
	@Test
	public void testUndoController2() {
		String result = undoController.popUndoCommand(commandHistory);
		assertEquals(null, result);
	}
	
	@Test
	public void testUndoController3() {
		undoController.addUndoCommand(commandHistory, "T 3 4");
		String result = undoController.popUndoCommand(commandHistory);
		assertEquals("T 3 4", result);
	}
	
	@Test
	public void testUndoController4() {
		undoController.addUndoCommand(commandHistory, "W 0");
		undoController.addUndoCommand(commandHistory, "T 1 3");
		undoController.addUndoCommand(commandHistory, "W 7");
		String result = undoController.peekUndoCommand(commandHistory);
		assertEquals("W 7", result);
	}
	
	@Test
	public void testUndoController5() {
		String result = undoController.peekUndoCommand(commandHistory);
		assertEquals(null, result);
	}
	
	@Test
	public void testUndoController6() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		undoController.addUndoCommand(commandHistory, "D");
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);
		assertEquals(-3, result);
	}
	
	@Test
	public void testUndoController7() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		stock.push(new Card(Suit.SPADES, Rank.A));
		stock.push(new Card(Suit.HEARTS, Rank._2));
		stock.push(new Card(Suit.CLUBS, Rank._2));
		stock.push(new Card(Suit.DIAMONDS, Rank._9));
		
		undoController.addUndoCommand(commandHistory, "D");
		undoController.execute(commandHistory, stock, waste, tableaus, foundation);
		waste.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♦9, ♣2, ♥2, ♠A]", waste.getCardList().toString());
	}
	
	@Test
	public void testUndoController8() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		
		waste.push(new Card(Suit.SPADES, Rank.A));
		waste.push(new Card(Suit.HEARTS, Rank._2));
		
		undoController.addUndoCommand(commandHistory, "D");
		undoController.execute(commandHistory, stock, waste, tableaus, foundation);
		waste.getCardList().forEach((c)->c.setShow(true));
		

		assertEquals("[♠A]", waste.getCardList().toString()); 
		assertEquals("[♥2]", stock.getCardList().toString()); 
	}
	
	@Test
	public void testUndoController9() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		waste.push(new Card(Suit.HEARTS, Rank._2));
		waste.peek().setShow(true);
		undoController.addUndoCommand(commandHistory, "D");
		undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals("XX", waste.print()); 
		stock.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♥2]", stock.getCardList().toString()); 
	}
	
	@Test
	public void testUndoController10() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();

		tableaus.add(new Tableau());
		tableaus.get(0).push(new Card(Suit.HEARTS, Rank._2));
		tableaus.get(0).peek().setShow(true);
		
		foundation.add(new Foundation(Suit.SPADES));
		foundation.get(0).push(new Card(Suit.SPADES, Rank.A));
		foundation.get(0).peek().setShow(true);
		
		undoController.addUndoCommand(commandHistory, "T 1 0 0");
		undoController.execute(commandHistory, stock, waste, tableaus, foundation);
		
		assertEquals("[??, ♠A]", tableaus.get(0).getCardList().toString());
		assertEquals("[]", foundation.get(0).getCardList().toString());
	}
	
	@Test
	public void testUndoController11() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		foundation.add(new Foundation(Suit.SPADES));
		tableaus.add(new Tableau());
		tableaus.add(new Tableau());
		tableaus.get(0).push(new Card(Suit.HEARTS, Rank._5));
		tableaus.get(0).push(new Card(Suit.SPADES, Rank._4));
		tableaus.get(0).push(new Card(Suit.DIAMONDS, Rank._3));
		tableaus.get(0).push(new Card(Suit.SPADES, Rank._2));
		tableaus.get(0).getCardList().forEach((c)->c.setShow(true));
		
		tableaus.get(1).push(new Card(Suit.HEARTS, Rank.J));
		tableaus.get(1).getCardList().forEach((c)->c.setShow(true));
		
		undoController.addUndoCommand(commandHistory, "T 2 1 3");
		undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals("[♥5]", tableaus.get(0).getCardList().toString());
		assertEquals("[??, ♠4, ♦3, ♠2]", tableaus.get(1).getCardList().toString()); 
	}
	
	@Test
	public void testUndoController12() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		undoController.addUndoCommand(commandHistory, "T 1 A 0");
		
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(-4, result); 
	}
	//test foundation back to waste
	@Test
	public void testUndoController13() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();

		foundation.add(new Foundation(Suit.SPADES));
		foundation.add(new Foundation(Suit.HEARTS));
		waste.push(new Card(Suit.DIAMONDS, Rank.Q));
		waste.push(new Card(Suit.CLUBS, Rank._6));
		waste.peek().setShow(true);
		
		foundation.get(1).push(new Card(Suit.HEARTS, Rank.A));
		foundation.get(1).peek().setShow(true);
		
		undoController.addUndoCommand(commandHistory, "W 0 1");
		undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals("[??, ??, ♥A]", waste.getCardList().toString());
		waste.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♦Q, ♣6, ♥A]", waste.getCardList().toString());
		assertEquals("[]", foundation.get(1).getCardList().toString());
	}
	
	//invalid foundation back to waste, no card in foundation
	@Test
	public void testUndoController33() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();

		foundation.add(new Foundation(Suit.SPADES));
		foundation.add(new Foundation(Suit.HEARTS));
		waste.push(new Card(Suit.DIAMONDS, Rank.Q));
		waste.push(new Card(Suit.CLUBS, Rank._6));
		waste.peek().setShow(true);
				
		undoController.addUndoCommand(commandHistory, "W 0 1");
		assertEquals(-5, undoController.execute(commandHistory, stock, waste, tableaus, foundation));
	}
		
		

	//test tableau back to waste
	@Test
	public void testUndoController14() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		
		waste.push(new Card(Suit.DIAMONDS, Rank.Q));
		waste.push(new Card(Suit.CLUBS, Rank._6));
		waste.peek().setShow(true);
		
		tableaus.add(new Tableau());
		tableaus.get(0).push(new Card(Suit.SPADES, Rank._3));
		tableaus.get(0).push(new Card(Suit.SPADES, Rank._7));
		tableaus.get(0).push(new Card(Suit.HEARTS, Rank._6));
		tableaus.get(0).getCardList().forEach((c)->c.setShow(true));
		
		
		undoController.addUndoCommand(commandHistory, "W 1");
		undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals("[??, ??, ♥6]", waste.getCardList().toString());
		waste.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♦Q, ♣6, ♥6]", waste.getCardList().toString());
		assertEquals("[♠3, ♠7]", tableaus.get(0).getCardList().toString());
	}
	
	//Invalid tableau back to waste, no cards in tableau
	@Test
	public void testUndoController44() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		
		waste.push(new Card(Suit.DIAMONDS, Rank.Q));
		waste.push(new Card(Suit.CLUBS, Rank._6));
		waste.peek().setShow(true);
		
		tableaus.add(new Tableau());
		undoController.addUndoCommand(commandHistory, "W 1");

		assertEquals(-6, undoController.execute(commandHistory, stock, waste, tableaus, foundation));
	}
	
	//Invalid instruction
	@Test
	public void testUndoController15() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		
		undoController.addUndoCommand(commandHistory, "W A 0");
		
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(-7, result); 
	}
	
	@Test
	public void testUndoController16() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		undoController.addUndoCommand(commandHistory, "R");
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(-1, result); 
	}
	
	//no previousCmd found
	@Test
	public void testUndoController17() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(-2, result); 
	}
	
	@Test
	public void testUndoController18() {
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		commandHistory.clear();

		assertEquals(null, undoController.peekUndoCommand(commandHistory)); 
	}
	
}
