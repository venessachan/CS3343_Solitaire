package Testing;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.Deal;
import controller.MoveTableau;
import controller.MoveToFoundation;
import controller.RecordedCommand;
import controller.WasteToTableau;
import main.GameManager;
import main.ScoreManager;

public class TestMoveTableau {

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
        String[] parts = ("0" + " " + "5").split(" ");
        (new MoveTableau()).execute(parts);
        String expectedOutput = "Move invalid.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    @Test
    public void T02() {
        String[] parts = ("10" + " " + "5").split(" ");
        (new MoveTableau()).execute(parts);
        String expectedOutput = "Move invalid.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    @Test
    public void T03() {
        String[] parts = ("1" + " " + "0").split(" ");
        (new MoveTableau()).execute(parts);
        String expectedOutput = "Move invalid.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    @Test
    public void T04() {
        String[] parts = ("1" + " " + "9").split(" ");
        (new MoveTableau()).execute(parts);
        String expectedOutput = "Move invalid.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    @Test
    public void T05() {
        String[] parts = ("1" + " " + "5").split(" ");
        (new MoveTableau()).execute(parts);
        String expectedOutput = "Move invalid.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    @Test
    public void T06() {
        String[] parts = ("N" + " " + "5").split(" ");
        (new MoveTableau()).execute(parts);
        String expectedOutput = "Move invalid.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    @Test
    public void T07() {
        String[] parts = ("1" + " " + "N").split(" ");
        (new MoveTableau()).execute(parts);
        String expectedOutput = "Move invalid.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    @Test
    public void T08() {
        String[] parts = ("6" + " " + "1").split(" ");
        (new MoveTableau()).execute(parts);
        String expectedOutput = "Move successful.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    @Test
    public void T09() {
		assertEquals(2, gameManager.getTab().get(0).getCardList().size());
		assertEquals(5, gameManager.getTab().get(5).getCardList().size());
    }
    
    @Test
    public void T10() {
    	RecordedCommand.undoOneCommand();
    	assertEquals(1, gameManager.getTab().get(0).getCardList().size());
		assertEquals(6, gameManager.getTab().get(5).getCardList().size());
    }
    
    @Test
    public void T11() {
    	RecordedCommand.redoOneCommand();
    	assertEquals(2, gameManager.getTab().get(0).getCardList().size());
		assertEquals(5, gameManager.getTab().get(5).getCardList().size());
    }
    
    @Test
    public void T12() {
    	String[] parts = ("1" + " " + "1").split(" ");
        (new MoveTableau()).execute(parts);
        String expectedOutput = "Move invalid.";
 		assertEquals(expectedOutput, getConsoleOutput());
    	parts = ("2" + " " + "0").split(" ");
        (new MoveToFoundation()).execute(parts);
        parts = ("2" + " " + "0").split(" ");
        (new MoveToFoundation()).execute(parts);
    }
    
    @Test
    public void T13() {
    	String parts[] = ("2" + " " + "1").split(" ");
        (new MoveTableau()).execute(parts);
        String expectedOutput = "Move invalid";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    
    
}
