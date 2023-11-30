package Testing;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import main.GameManager;
import stackManager.Foundation;
import stackManager.Tableau;

public class TestGameManager {

    private GameManager gameManager;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
    public void testCardAllocation() {
    	gameManager = GameManager.getInstance();
        gameManager.start();
        assertEquals(0,gameManager.getDeck().getCards().size());
        assertEquals(1,gameManager.getTableaus().get(0).getCardList().size());
        assertEquals(2,gameManager.getTableaus().get(1).getCardList().size());
        assertEquals(3,gameManager.getTableaus().get(2).getCardList().size());
        assertEquals(4,gameManager.getTableaus().get(3).getCardList().size());
        assertEquals(5,gameManager.getTableaus().get(4).getCardList().size());
        assertEquals(6,gameManager.getTableaus().get(5).getCardList().size());
        assertEquals(7,gameManager.getTableaus().get(6).getCardList().size());
        assertEquals(24,gameManager.getStock().getCardList().size());
    }
    
    @Before
    public void setup() {
    	GameManager.resetInstance();
    	gameManager = GameManager.getInstance();
        System.setOut(new PrintStream(outputStream));
    }

	@Test
	public void testStartCommand() {
		assertEquals(1,gameManager.commandExecute("S"));
	}
	
	@Test
	public void testDealCommand1() {
		gameManager.start();
		assertEquals(8,gameManager.commandExecute("D"));
	}
	    
    
    @Test
    public void testDealCommand2() {
    	gameManager.start();
    	gameManager.getStock().clear();
    	assertEquals(-14,gameManager.commandExecute("D"));
    }
    

	
	
	//check waste command
	//waste to foundation
	@Test
	public void testToWasteCommand1() {
		gameManager.start();
		assertEquals(-9,gameManager.commandExecute("W 0"));
	}
  
	@Test
	public void testToWasteCommand2() {
		gameManager.start();
		gameManager.commandExecute("D");
		assertEquals(-10,gameManager.commandExecute("W -1"));
	}
  
	@Test
	public void testToWasteCommand3() {
		gameManager.start();
		gameManager.commandExecute("D");
		assertEquals(-10,gameManager.commandExecute("W 8"));
	}
    
	@Test
	public void testToWasteCommand4() {
		gameManager.start();
		gameManager.commandExecute("D");
		assertEquals(-11,gameManager.commandExecute("W 0"));
	}
  
	@Test
	public void testToWasteCommand5() {
		gameManager.start();
		gameManager.commandExecute("D");
		gameManager.commandExecute("D");
			
		assertEquals(6,gameManager.commandExecute("W 0"));
	}
  
	@Test
	public void testToWasteCommand6() {
		gameManager.start();
			
		for(int i =0; i <2; i++) {
			gameManager.commandExecute("D");
		}
			gameManager.commandExecute("W 0");
		for(int i =0; i <15; i++) {
			gameManager.commandExecute("D");
		}
			assertEquals(6,gameManager.commandExecute("W 0"));
	}
  
	// waste to tableau
	@Test
	public void testToWasteCommand7() {
		gameManager.start();
			
		for(int i =0; i <4; i++) {
			gameManager.commandExecute("D");
		}
		assertEquals(7,gameManager.commandExecute("W 1"));
	}
  
	@Test
	public void testToWasteCommand8() {
		gameManager.start();
		gameManager.commandExecute("D");
		assertEquals(-12,gameManager.commandExecute("W 6"));
	}
  
	//Invalid waste input
	@Test
	public void testToWasteCommand9() {
		gameManager.start();
		gameManager.commandExecute("D");
		assertEquals(-13,gameManager.commandExecute("W W"));
	}
	
	@Test
	public void testToWasteCommand10() {
		gameManager.start();
		Tableau t1 = gameManager.getTableaus().get(0);
		t1.push(new Card(Suit.HEARTS, Rank._2));
		gameManager.getWaste().push(new Card(Suit.CLUBS, Rank.A));
		gameManager.commandExecute("W 1");
		assertEquals("XX", gameManager.getWaste().print());
	}
	

	//check tableau command
	//check tableau to tableau
	@Test
	public void testToTableauCommand1() {
		gameManager.start();
		assertEquals(-3,gameManager.commandExecute("T 0 6"));
	}
	
	@Test
	public void testToTableauCommand2() {
		gameManager.start();
		assertEquals(-3,gameManager.commandExecute("T 8 8"));
	}
	
	@Test
	public void testToTableauCommand3() {
		gameManager.start();
		assertEquals(-3,gameManager.commandExecute("T 7 7"));
	}
	
	@Test
	public void testToTableauCommand4() {
		gameManager.start();
		assertEquals(-3,gameManager.commandExecute("T 1 8"));
	}
	
	@Test
	public void testToTableauCommand5() {
		gameManager.start();
		assertEquals(-3,gameManager.commandExecute("T 1 -1"));
	}

	
	@Test
	public void testToTableauCommand6() {
		gameManager.start();
		gameManager.commandExecute("T 3 2");
		gameManager.commandExecute("T 3 0");
		gameManager.commandExecute("T 3 2");
		assertEquals(-4,gameManager.commandExecute("T 3 1"));
	}
	
	//No visible card in tableau
	@Test
	public void testToTableauCommand7() {
		gameManager.start();
		gameManager.getTableaus().get(0).peek().setShow(false);
		assertEquals(-6,gameManager.commandExecute("T 1 2"));
	}
		
	//No Valid card
	@Test
	public void testToTableauCommand8() {
		gameManager.start();
		gameManager.getTableaus().get(0).peek().setShow(false);
		assertEquals(-7,gameManager.commandExecute("T 3 4"));
	}
	
	//Invalid tableau instruction
	@Test
	public void testToTableauCommand9() {
		gameManager.start();
		assertEquals(-8,gameManager.commandExecute("T T 4"));
	}
	
	//tableau to foundation
	@Test
	//No available foundation found
	public void testToTableauCommand10() {
		gameManager.start();
		assertEquals(-5,gameManager.commandExecute("T 6 0"));
	}

	@Test
	public void testToTableauCommand11() {
		gameManager.start();
		gameManager.commandExecute("T 3 2");
		assertEquals(4,gameManager.commandExecute("T 3 0"));
	}
	
	
	//Quit Game
	@Test
	public void testQuitCommand1() {
		gameManager.start();
		assertEquals(-15,gameManager.commandExecute("Q"));
	}
	
	//Other commands
	@Test
	public void testOtherCommand1() {
		gameManager.start();
		assertEquals(0,gameManager.commandExecute("F"));
	}
	
	//win game
	@Test
	public void testIsWin1() {
		gameManager.start();
		Foundation f1 = gameManager.getFoundation().get(0);
		Foundation f2 = gameManager.getFoundation().get(1);
		Foundation f3 = gameManager.getFoundation().get(2);
		Foundation f4 = gameManager.getFoundation().get(3);
		
		for(int i = 0; i < 13; i++) {
			Rank rank = Rank.values()[i];
			f1.push(new Card(Suit.SPADES, rank));
			f2.push(new Card(Suit.HEARTS, rank));
			f3.push(new Card(Suit.CLUBS, rank));
			f4.push(new Card(Suit.DIAMONDS, rank));
		}
		assertEquals(true,gameManager.isWin());
	}
	
	//not win
	@Test
	public void testIsWin2() {
		gameManager.start();
		Foundation f1 = gameManager.getFoundation().get(0);
		Foundation f2 = gameManager.getFoundation().get(1);
		Foundation f3 = gameManager.getFoundation().get(2);
		Foundation f4 = gameManager.getFoundation().get(3);
		
		for(int i = 0; i < 12; i++) {
			Rank rank = Rank.values()[i];
			f1.push(new Card(Suit.SPADES, rank));
			f2.push(new Card(Suit.HEARTS, rank));
			f3.push(new Card(Suit.CLUBS, rank));
			f4.push(new Card(Suit.DIAMONDS, rank));
		}
		f1.push(new Card(Suit.SPADES, Rank.values()[12]));
		f2.push(new Card(Suit.HEARTS, Rank.values()[12]));
		f3.push(new Card(Suit.CLUBS, Rank.values()[12]));
		
		assertEquals(false,gameManager.isWin());
	}
	
	@Test
	public void testIsWin3() {
		gameManager.start();
		Foundation f1 = gameManager.getFoundation().get(0);
		Foundation f2 = gameManager.getFoundation().get(1);
		Foundation f3 = gameManager.getFoundation().get(2);
		Foundation f4 = gameManager.getFoundation().get(3);
		
		for(int i = 0; i < 12; i++) {
			Rank rank = Rank.values()[i];
			f1.push(new Card(Suit.SPADES, rank));
			f2.push(new Card(Suit.HEARTS, rank));
			f3.push(new Card(Suit.CLUBS, rank));
			f4.push(new Card(Suit.DIAMONDS, rank));
		}
		f1.push(new Card(Suit.SPADES, Rank.values()[12]));
		f2.push(new Card(Suit.HEARTS, Rank.values()[12]));
		f4.push(new Card(Suit.DIAMONDS, Rank.values()[12]));
		
		assertEquals(false,gameManager.isWin());
	}
	
	@Test
	public void testIsWin4() {
		gameManager.start();
		Foundation f1 = gameManager.getFoundation().get(0);
		Foundation f3 = gameManager.getFoundation().get(2);
		Foundation f4 = gameManager.getFoundation().get(3);
		
		for(int i = 0; i < 13; i++) {
			Rank rank = Rank.values()[i];
			f1.push(new Card(Suit.SPADES, rank));
			f3.push(new Card(Suit.CLUBS, rank));
			f4.push(new Card(Suit.DIAMONDS, rank));
		}
		
		assertEquals(false,gameManager.isWin());
	}
	
	@Test
	public void testIsWin5() {
		gameManager.start();
		Foundation f2 = gameManager.getFoundation().get(1);
		Foundation f3 = gameManager.getFoundation().get(2);
		Foundation f4 = gameManager.getFoundation().get(3);
		
		for(int i = 0; i < 13; i++) {
			Rank rank = Rank.values()[i];
			f2.push(new Card(Suit.HEARTS, rank));
			f3.push(new Card(Suit.CLUBS, rank));
			f4.push(new Card(Suit.DIAMONDS, rank));
		}
		assertEquals(false,gameManager.isWin());
	}
	
	//set final score after win
	@Test
	public void testIsWin6() {
		gameManager.start();
		gameManager.commandExecute("D");
		
		gameManager.commandExecute("D");
		gameManager.commandExecute("W 0");	//place Ace to foundation
		gameManager.commandExecute("D");
		gameManager.commandExecute("W 0");
		Foundation f1 = gameManager.getFoundation().get(0);
		Foundation f2 = gameManager.getFoundation().get(1);
		Foundation f3 = gameManager.getFoundation().get(2);
		Foundation f4 = gameManager.getFoundation().get(3);
		
		for(int i = 0; i < 13; i++) {
			Rank rank = Rank.values()[i];
			f1.push(new Card(Suit.SPADES, rank));
			f2.push(new Card(Suit.HEARTS, rank));
			f3.push(new Card(Suit.CLUBS, rank));
			f4.push(new Card(Suit.DIAMONDS, rank));
		}
		gameManager.isWin();
		assertEquals(200100,gameManager.getScore());
	}
	
	//check score without win
	@Test
	public void testIsWin7() {
		gameManager.start();
		gameManager.commandExecute("D");
		gameManager.commandExecute("D");
		gameManager.commandExecute("W 0");	//place Ace to foundation
		gameManager.commandExecute("D");
		gameManager.commandExecute("W 0");
		gameManager.isWin();
		assertEquals(100,gameManager.getScore());
	}
	
	@Test
	public void testInvalidCommand1() {
		gameManager.start();
		assertEquals(-23,gameManager.commandExecute("W" ));
	}
	
	@Test
	public void testInvalidCommand2() {
		gameManager.start();
		assertEquals(-18,gameManager.commandExecute("T"));
	}
	
	@Test
	public void testUndoCommand1() {
		gameManager.start();
		assertEquals(-1, gameManager.commandExecute("U"));
	}
	
	@Test
	public void testUndoCommand2() {
		gameManager.start();
		gameManager.commandExecute("D");
		gameManager.commandExecute("D");
		gameManager.commandExecute("W 0");
		int result = gameManager.commandExecute("U");
		assertEquals(4, gameManager.getMove());
		assertEquals(0, gameManager.getScore());
		assertEquals(2, result);
	}
	
	@Test
	public void testScore1() {
		gameManager.start();
		Card card1 = new Card(Suit.SPADES, Rank._2);
		Card card2 = new Card(Suit.SPADES, Rank.A);
		card1.setShow(true);
		card2.setShow(true);
		gameManager.getTableaus().get(0).push(card1);
		gameManager.getTableaus().get(0).push(card2);
		gameManager.commandExecute("T 1 0");
		gameManager.commandExecute("T 1 0");
		assertEquals(2, gameManager.getMove());
		assertEquals(2, gameManager.getCombo());
		assertEquals(100, gameManager.getScore());
	}
	
	@Test
	public void testScore2() {
		gameManager.start();
		Card card1 = new Card(Suit.SPADES, Rank._3);
		Card card2 = new Card(Suit.SPADES, Rank._2);
		Card card3 = new Card(Suit.SPADES, Rank.A);
		card1.setShow(true);
		card2.setShow(true);
		card3.setShow(true);
		gameManager.getTableaus().get(0).push(card1);
		gameManager.getTableaus().get(0).push(card2);
		gameManager.getTableaus().get(0).push(card3);
		gameManager.commandExecute("T 1 0");
		gameManager.commandExecute("T 1 0");
		gameManager.commandExecute("T 1 0");
		assertEquals(3, gameManager.getMove());
		assertEquals(3, gameManager.getCombo());
		assertEquals(300, gameManager.getScore());
	}
	
	@Test
	public void testScore3() {
		gameManager.start();
		Tableau t1 = gameManager.getTableaus().get(0);
		for(int i = 7; i > 0; i--) {
			Rank rank = Rank.values()[i-1];
			t1.push(new Card(Suit.SPADES, rank));
			t1.peek().setShow(true);
		}
		for(int i = 0; i < 7; i++) {
			gameManager.commandExecute("T 1 0");
		}
		assertEquals(7, gameManager.getMove());
		assertEquals(7, gameManager.getCombo());
		assertEquals(1300, gameManager.getScore());
	}
	
	@Test
	public void testScore4() {
		gameManager.start();
		Tableau t1 = gameManager.getTableaus().get(0);
		for(int i = 10; i > 0; i--) {
			Rank rank = Rank.values()[i-1];
			t1.push(new Card(Suit.SPADES, rank));
			t1.peek().setShow(true);
		}
		for(int i = 0; i < 10; i++) {
			gameManager.commandExecute("T 1 0");
		}
		assertEquals(10, gameManager.getMove());
		assertEquals(10, gameManager.getCombo());
		assertEquals(2900, gameManager.getScore());
	}
	
	@Test
	public void testScore5() {
		gameManager.start();
		Tableau t1 = gameManager.getTableaus().get(0);
		Tableau t2 = gameManager.getTableaus().get(1);
		for(int i = 10; i > 0; i--) {
			Rank rank = Rank.values()[i-1];
			t1.push(new Card(Suit.SPADES, rank));
			t1.peek().setShow(true);
			t2.push(new Card(Suit.HEARTS, rank));
			t2.peek().setShow(true);
		}
		for(int i = 0; i < 10; i++) {
			gameManager.commandExecute("T 1 0");
		}
		for(int i = 0; i < 10; i++) {
			gameManager.commandExecute("T 2 0");
		}
		assertEquals(20, gameManager.getMove());
		assertEquals(20, gameManager.getCombo());
		assertEquals(11700, gameManager.getScore());
	}
	
	@Test
	public void testScore6() {
		gameManager.start();
		Tableau t1 = gameManager.getTableaus().get(0);
		for(int i = 10; i > 0; i--) {
			Rank rank = Rank.values()[i-1];
			t1.push(new Card(Suit.SPADES, rank));
			t1.peek().setShow(true);
		}
		for(int i = 0; i < 9; i++) {
			gameManager.commandExecute("T 1 0");
		}
		
		gameManager.commandExecute("D");
		gameManager.commandExecute("T 1 0");
		assertEquals(11, gameManager.getMove());
		assertEquals(1, gameManager.getCombo());
		assertEquals(2150, gameManager.getScore());
	}
	
    @Test
    public void testPrintBoard1() {
    	gameManager.start();
        String expectedOutput = "Card Remaining: 24,  Waste: XX, Socre: 0, Move: 0\n"
        		+ "Foundations: [♠] [♥] [♣] [♦] \n"
        		+ "\n"
        		+ "Tableau 1: [ ♦7 ]\n"
        		+ "Tableau 2: [ ??  ♠9 ]\n"
        		+ "Tableau 3: [ ??  ??  ♦8 ]\n"
        		+ "Tableau 4: [ ??  ??  ??  ♥6 ]\n"
        		+ "Tableau 5: [ ??  ??  ??  ??  ♦K ]\n"
        		+ "Tableau 6: [ ??  ??  ??  ??  ??  ♦2 ]\n"
        		+ "Tableau 7: [ ??  ??  ??  ??  ??  ??  ♥9 ]";
        
        assertEquals(expectedOutput, outputStream.toString().trim());
    }    
}
