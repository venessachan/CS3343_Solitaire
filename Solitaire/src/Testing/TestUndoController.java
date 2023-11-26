package Testing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import card.Card;
import card.Rank;
import card.Suit;

import org.junit.Before;

import controller.CommandHistory;
import controller.UndoController;
import stackManager.Foundation;
import stackManager.Stock;
import stackManager.Tableau;
import stackManager.Waste;

public class TestUndoController {
	private static UndoController undoController;

	@Test
	public void testUndoController1() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();

		undoController.addUndoCommand(commandHistory, "T");

		List<String> actual = commandHistory.getUndoCommandList();
		List<String> expected = Arrays.asList("T");

		Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	public void testUndoController2() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		
		String result = undoController.popUndoCommand(commandHistory);

		assertEquals(null, result);
	}
	
	@Test
	public void testUndoController3() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();

		undoController.addUndoCommand(commandHistory, "T");

		String result = undoController.popUndoCommand(commandHistory);

		assertEquals("T", result);
	}
	
	@Test
	public void testUndoController4() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();

		undoController.addUndoCommand(commandHistory, "T");

		String result = undoController.peekUndoCommand(commandHistory);

		assertEquals("T", result);
	}
	
	@Test
	public void testUndoController5() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();

		String result = undoController.getPreviousCmdList(commandHistory);

		assertEquals(null, result);
	}

	@Test
	public void testUndoController6() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();

		undoController.addUndoCommand(commandHistory, "T");

		String result = undoController.getPreviousCmdList(commandHistory);

		assertEquals("T", result);
	}
	
	@Test
	public void testUndoController7() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();

		undoController.addUndoCommand(commandHistory, "D");

		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(-2, result);
	}
	
	@Test
	public void testUndoController8() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();

		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);
		Card card3 = new Card(Suit.CLUBS, Rank._2);
		Card card4 = new Card(Suit.DIAMONDS, Rank._9);
		Card card5 = new Card(Suit.CLUBS, Rank.Q);
		
		stock.push(stock.getCardList(), card1);
		stock.push(stock.getCardList(), card2);
		stock.push(stock.getCardList(), card3);
		stock.push(stock.getCardList(), card4);
		stock.push(stock.getCardList(), card5);
		
		undoController.addUndoCommand(commandHistory, "D");
		undoController.execute(commandHistory, stock, waste, tableaus, foundation);
		
		String result = waste.print();

		assertEquals("♠A", result);
	}
	
	@Test
	public void testUndoController9() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();

		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);
		Card card3 = new Card(Suit.CLUBS, Rank._2);
		Card card4 = new Card(Suit.DIAMONDS, Rank._9);
		
		stock.push(stock.getCardList(), card1);
		stock.push(stock.getCardList(), card2);
		stock.push(stock.getCardList(), card3);
		stock.push(stock.getCardList(), card4);
		
		undoController.addUndoCommand(commandHistory, "D");
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);
		
		assertEquals(-1, result);
	}
	
	@Test
	public void testUndoController10() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);
		
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		
		undoController.addUndoCommand(commandHistory, "D");
		int result1 = undoController.execute(commandHistory, stock, waste, tableaus, foundation);
		
		String result = waste.print();

		assertEquals("♠A", result); 
	}
	
	@Test
	public void testUndoController11() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();

		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);
		
		waste.push(waste.getCardList(), card1);
		waste.push(waste.getCardList(), card2);
		
		tableaus.add(new Tableau());
		tableaus.get(0).push(tableaus.get(0).getCardList(), card2);
		
		foundation.add(new Foundation(Suit.SPADES));
		foundation.get(0).push(foundation.get(0).getCardList(), card1);
		
		undoController.addUndoCommand(commandHistory, "T 1 0 0");
		
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(2, result); 
	}
	

	@Test
	public void testUndoController12() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();

		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);
		
		tableaus.add(new Tableau());
		
		foundation.add(new Foundation(Suit.SPADES));
		
		undoController.addUndoCommand(commandHistory, "T 1 1 0");
		
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(3, result); 
	}
	
	@Test
	public void testUndoController13() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();

		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);
		
		tableaus.add(new Tableau());
		
		foundation.add(new Foundation(Suit.SPADES));
		
		undoController.addUndoCommand(commandHistory, "T 1 A 0");
		
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(-3, result); 
	}
	
	@Test
	public void testUndoController14() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);

		foundation.add(new Foundation(Suit.SPADES));
		foundation.get(0).push(foundation.get(0).getCardList(), card1);
		
		undoController.addUndoCommand(commandHistory, "W 0 0");
		
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(4, result); 
	}

	@Test
	public void testUndoController15() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();
		
		undoController.addUndoCommand(commandHistory, "W A 0");
		
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(-4, result); 
	}
	
	@Test
	public void testUndoController16() {
		undoController = UndoController.getInstance();
		CommandHistory commandHistory = new CommandHistory();
		Stock stock = new Stock();
		Waste waste = new Waste();
		List<Tableau> tableaus = new ArrayList();
		List<Foundation> foundation = new ArrayList();

		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);

		waste.push(waste.getCardList(), card2);
		
		tableaus.add(new Tableau());
		tableaus.get(0).push(tableaus.get(0).getCardList(), card1);
		
		undoController.addUndoCommand(commandHistory, "W 1 0");
		
		int result = undoController.execute(commandHistory, stock, waste, tableaus, foundation);

		assertEquals(5, result); 
	}
}
