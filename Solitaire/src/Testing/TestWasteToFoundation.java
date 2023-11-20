package Testing;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import card.Card;
import card.Rank;
import card.Suit;
import main.GameManager;

public class TestWasteToFoundation {
	private GameManager gameManager;
//	private ScoreManager scoreManager;
//    private ByteArrayOutputStream outputStream;
//
//    @BeforeEach
//    public void setup() {
//        gameManager = GameManager.getInstance();
//        outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//    }
//
//    @AfterEach
//    public void tearDown() {
//        System.setOut(System.out);
//    }
//	
//    public String getConsoleOutput() {
//        return outputStream.toString().trim();
//    }
//    
//    @Test
//    public void testWTF1() {
//    	String[] parts = new String[0];
//    	(new WasteToFoundation()).execute(parts);
//    	String expectedOutput = "Move invalid.\n\n";
//    	assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void testWTF2() {
//    	String[] parts = null;
//    	(new WasteToFoundation()).execute(parts);
//    	String expectedOutput = "Move invalid.";
//    	assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void testWTF3() {
//    	String[] parts = null;
//    	(new WasteToFoundation()).execute(parts);
//    	String expectedOutput = "Move invalid.";
//    	assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
////    @Test
////	  public void testWTF1() {
////	  	Card card = new Card(Suit.SPADES, Rank._10);
////	  	
////	  }

	
}
