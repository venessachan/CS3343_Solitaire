package Testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import card.Card;
import card.Rank;
import card.Suit;
import main.GameManager;
import main.ScoreManager;
import stackManager.Foundation;
import stackManager.Tableau;

public class TestGameManager {

    private GameManager gameManager;
    private ScoreManager scoreManager;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setup() {
        gameManager = GameManager.getInstance();
        scoreManager = scoreManager.getInstance();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    
    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    
    public static void fillFoundate(Suit s, Foundation f) {
		for(Rank rank : Rank.values())
			f.push(new Card(s, rank));
    }
    
    public static void clearFoundate(Foundation f) {
    	f.getCardList().clear();
    }
    
    private String getConsoleOutput() {
        return outputStream.toString().trim();
    }

    @Test
    public void T01() {
        Assertions.assertNotNull(gameManager.getDeck());
    }
    
    @Test
    public void T02() {
        Assertions.assertNotNull(gameManager.getTab());
    }
    
    @Test
    public void T03() {
        Assertions.assertNotNull(gameManager.getStock());
    }
    
    @Test
    public void T04() {
        Assertions.assertNotNull(gameManager.getWaste());
    }
    
    @Test
    public void T05() {
        Assertions.assertNotNull(gameManager.getFoundate());
    }
    
    @Test
    public void T06() {
    	assertEquals(7, gameManager.getTab().size());
    }
    
    @Test
    public void T07() {
    	assertEquals(4, gameManager.getFoundate().size());
    }
    
    @Test
    public void T08() {
    	for (Tableau tableau : gameManager.getTab()) {
            Assertions.assertFalse(tableau.empty());
        }
    }
    
    @Test
    public void T09() {
    	for (Foundation foundate : gameManager.getFoundate()) {
            Assertions.assertTrue(foundate.empty());
        }
    }
    
    @Test
    public void T10() {
        gameManager.printboard();
        String expectedOutput = "Card Remaining: 24,  Waste: XX, Socre: 0, Move: 0\n"
        		+ "Foundations: [♠] [♥] [♣] [♦]\n"
        		+ "\n"
        		+ "Tableau 1: [ ♥3 ]\n"
        		+ "Tableau 2: [ ??  ♥A ]\n"
        		+ "Tableau 3: [ ??  ??  ♠10 ]\n"
        		+ "Tableau 4: [ ??  ??  ??  ♦4 ]\n"
        		+ "Tableau 5: [ ??  ??  ??  ??  ♦5 ]\n"
        		+ "Tableau 6: [ ??  ??  ??  ??  ??  ♣2 ]\n"
        		+ "Tableau 7: [ ??  ??  ??  ??  ??  ??  ♦Q ]";
        assertEquals(expectedOutput, getConsoleOutput());
    }
    
    
    @Test
    public void T11() {
    	gameManager.tabAutoFlip();
        for (Tableau tableau : gameManager.getTab()) {
        	Assertions.assertTrue(tableau.peek().getShow());
        }
    }
    
	@Test
	public void T12() {
		assertEquals(0, gameManager.getMove());
		gameManager.move();
		assertEquals(1, gameManager.getMove());
	}
    
    @Test
    public void T13() {
        assertEquals(false, gameManager.isWin());
    }
    
    @Test
    public void T14() {
    	fillFoundate(Suit.SPADES, gameManager.getFoundate().get(0));
        assertEquals(false, gameManager.isWin());
        clearFoundate(gameManager.getFoundate().get(0));
    }
    
    @Test
    public void T15() {
    	fillFoundate(Suit.SPADES, gameManager.getFoundate().get(0));
    	fillFoundate(Suit.HEARTS, gameManager.getFoundate().get(1));
    	fillFoundate(Suit.CLUBS, gameManager.getFoundate().get(2));
    	fillFoundate(Suit.DIAMONDS, gameManager.getFoundate().get(3));
        assertEquals(true, gameManager.isWin());
        clearFoundate(gameManager.getFoundate().get(0));
        clearFoundate(gameManager.getFoundate().get(1));
        clearFoundate(gameManager.getFoundate().get(2));
        clearFoundate(gameManager.getFoundate().get(3));
    }
    
    @Test
    public void T16() {
    	gameManager.setPreviousAction("T");
    	gameManager.setScore(0);
    	gameManager.checkCombo();
    	assertEquals(50, scoreManager.getScore());
    }
    
	@Test
    public void T17() {
		assertEquals(24, gameManager.getStock().getCardList().size());
    }
	
	@Test
    public void T18() {
		assertEquals(0, gameManager.getWaste().getCardList().size());
    }
    
}
