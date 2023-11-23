package Testing;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import main.GameManager;

public class TestGameManager {

    private GameManager gameManager;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
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
//        scoreManager = scoreManager.getInstance();
//        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
//    
//    @AfterEach
//    public void tearDown() {
//        System.setOut(System.out);
//    }
//
//    
//    public static void fillFoundate(Suit s, Foundation f) {
//		for(Rank rank : Rank.values())
//			f.push(new Card(s, rank));
//    }
//    
//    public static void clearFoundate(Foundation f) {
//    	f.getCardList().clear();
//    }
//    
//    private String getConsoleOutput() {
//        return outputStream.toString().trim();
//    }
//
//    @Test
//    public void T01() {
//        Assertions.assertNotNull(gameManager.getDeck());
//    }
//    
//    @Test
//    public void T02() {
//        Assertions.assertNotNull(gameManager.getTab());
//    }
//    
//    @Test
//    public void T03() {
//        Assertions.assertNotNull(gameManager.getStock());
//    }
//    
//    @Test
//    public void T04() {
//        Assertions.assertNotNull(gameManager.getWaste());
//    }
//    
//    @Test
//    public void T05() {
//        Assertions.assertNotNull(gameManager.getFoundate());
//    }
//    
//    @Test
//    public void T06() {
//    	assertEquals(7, gameManager.getTab().size());
//    }
//    
//    @Test
//    public void T07() {
//    	assertEquals(4, gameManager.getFoundate().size());
//    }
//    
//    @Test
//    public void T08() {
//    	for (Tableau tableau : gameManager.getTab()) {
//            Assertions.assertFalse(tableau.empty());
//        }
//    }
//    
//    @Test
//    public void T09() {
//    	for (Foundation foundate : gameManager.getFoundate()) {
//            Assertions.assertTrue(foundate.empty());
//        }
//    }
//    
    @Test
    public void testStartCommand() {
    	assertEquals(1,gameManager.commandExecute("S"));
    }
    
    @Test
    public void testDealCommand1() {
    	gameManager.start();
    	assertEquals(6,gameManager.commandExecute("D"));
    }
    
    
    @Test
    public void testDealCommand2() {
    	gameManager.start();
    	gameManager.getStock().clear(gameManager.getStock().getCardList());
    	assertEquals(-14,gameManager.commandExecute("D"));
    }
    
    
//    @Test
//    public void testUndoCommand1() {
//    	assertEquals(-1,gameManager.commandExecute("U"));
//    }
//    
//    @Test
//    public void testUndoCommand2() {
//    	assertEquals(2,gameManager.commandExecute("U"));
//    }
//    @Test
//    public void testRedoCommand1() {
//    	assertEquals(-1,gameManager.commandExecute("R"));
//    }
//    
//    @Test
//    public void testRedoCommand2() {
//    	assertEquals(3,gameManager.commandExecute("R"));
//    }
    
//  @Test
//  public void testToTableauCommand1() {
//  	assertEquals(-1,gameManager.commandExecute("T"));
//  }
    
//  @Test
//  public void testToTableauCommand2() {
//  	assertEquals(-1,gameManager.commandExecute("T"));
//  }
    
//  @Test
//  public void testToTableauCommand3() {
//  	assertEquals(-1,gameManager.commandExecute("T"));
//  }
    
//  @Test
//  public void testToTableauCommand4() {
//  	assertEquals(-1,gameManager.commandExecute("T"));
//  }
    
//  @Test
//  public void testToTableauCommand5() {
//  	assertEquals(4,gameManager.commandExecute("T"));
//  }
    
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
    public void testPrintBoard1() {
        //gameManager.commandExecute("S");
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
        gameManager.commandExecute("S");
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
    
    
    
//    
//    
//    @Test
//    public void T11() {
//    	gameManager.tabAutoFlip();
//        for (Tableau tableau : gameManager.getTab()) {
//        	Assertions.assertTrue(tableau.peek().getShow());
//        }
//    }
//    
//	@Test
//	public void T12() {
//		assertEquals(0, gameManager.getMove());
//		gameManager.move();
//		assertEquals(1, gameManager.getMove());
//	}
//    
//    @Test
//    public void T13() {
//        assertEquals(false, gameManager.isWin());
//    }
//    
//    @Test
//    public void T14() {
//    	fillFoundate(Suit.SPADES, gameManager.getFoundate().get(0));
//        assertEquals(false, gameManager.isWin());
//        clearFoundate(gameManager.getFoundate().get(0));
//    }
//    
//    @Test
//    public void T15() {
//    	fillFoundate(Suit.SPADES, gameManager.getFoundate().get(0));
//    	fillFoundate(Suit.HEARTS, gameManager.getFoundate().get(1));
//    	fillFoundate(Suit.CLUBS, gameManager.getFoundate().get(2));
//    	fillFoundate(Suit.DIAMONDS, gameManager.getFoundate().get(3));
//        assertEquals(true, gameManager.isWin());
//        clearFoundate(gameManager.getFoundate().get(0));
//        clearFoundate(gameManager.getFoundate().get(1));
//        clearFoundate(gameManager.getFoundate().get(2));
//        clearFoundate(gameManager.getFoundate().get(3));
//    }
//    
//    @Test
//    public void T16() {
//    	gameManager.setPreviousAction("T");
//    	gameManager.setScore(0);
//    	gameManager.checkCombo();
//    	assertEquals(50, scoreManager.getScore());
//    }
//    
//	@Test
//    public void T17() {
//		assertEquals(24, gameManager.getStock().getCardList().size());
//    }
//	
//	@Test
//    public void T18() {
//		assertEquals(0, gameManager.getWaste().getCardList().size());
//    }
    
}
