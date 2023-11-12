package Testing;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import card.Card;
import card.Rank;
import card.Suit;
import controller.Deal;
import controller.RecordedCommand;
import main.GameManager;
import main.ScoreManager;

public class TestDeal {
	
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
    
    private String getConsoleOutput() {
        return outputStream.toString().trim();
    }
	
	@Test
    public void T01() {
		(new Deal()).execute(null);
		String expectedOutput = "A card added to Waste.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
	
	@Test
	public void T02(){
		assertEquals(23, gameManager.getStock().getCardList().size());
		assertEquals(1, gameManager.getWaste().getCardList().size());
	}
	
	@Test
    public void T03() {
		Card c = gameManager.getWaste().peak();
		assertEquals(Suit.CLUBS, c.getSuit());
		assertEquals(Rank.J, c.getRank());
		assertEquals("♣J",c.toString());
    }
	
	@Test
	public void T04(){
		RecordedCommand.undoOneCommand();
		assertEquals(24, gameManager.getStock().getCardList().size());
		assertEquals(0, gameManager.getWaste().getCardList().size());
	}
	
	@Test
    public void T05() {
		Card c = gameManager.getStock().getCardList().get(0);
		assertEquals(Suit.CLUBS, c.getSuit());
		assertEquals(Rank.J, c.getRank());
		assertEquals("??",c.toString());
		assertEquals(-50, scoreManager.getScore());
    }
	
	@Test
	public void T06(){
		RecordedCommand.undoOneCommand();
		String expectedOutput = "Nothing to undo.";
		assertEquals(expectedOutput, getConsoleOutput());
	}
	
	@Test
	public void T07(){
		RecordedCommand.redoOneCommand();
		assertEquals(23, gameManager.getStock().getCardList().size());
		assertEquals(1, gameManager.getWaste().getCardList().size());
	}
	
	@Test
	public void T08(){
		Card c = gameManager.getWaste().peak();
		assertEquals(Suit.CLUBS, c.getSuit());
		assertEquals(Rank.J, c.getRank());
		assertEquals("♣J",c.toString());
	}
	
	@Test
	public void T09(){
		RecordedCommand.redoOneCommand();
		String expectedOutput = "Nothing to redo.";
		assertEquals(expectedOutput, getConsoleOutput());
	}
	
	@Test
	public void T10(){
		for(int i=0; i <24; i++) {
			(new Deal()).execute(null);
		}
		assertEquals(23, gameManager.getStock().getCardList().size());
		assertEquals(1, gameManager.getWaste().getCardList().size());
	}
	
	@Test
	public void T11(){
		Card c = gameManager.getWaste().peak();
		assertEquals(Suit.CLUBS, c.getSuit());
		assertEquals(Rank.J, c.getRank());
		assertEquals("♣J",c.toString());
	}

}
