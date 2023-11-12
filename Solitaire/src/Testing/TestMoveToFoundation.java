package Testing;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.MoveToFoundation;
import controller.RecordedCommand;
import main.GameManager;
import main.ScoreManager;

public class TestMoveToFoundation {

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
        String[] parts = ("0" + " " + "0").split(" ");
        (new MoveToFoundation()).execute(parts);
        String expectedOutput = "Move invalid.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    @Test
    public void T02() {
        String[] parts = ("8" + " " + "0").split(" ");
        (new MoveToFoundation()).execute(parts);
        String expectedOutput = "Move invalid.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
    @Test
    public void T03() {
        String[] parts = ("N" + " " + "0").split(" ");
        (new MoveToFoundation()).execute(parts);
        String expectedOutput = "Invalid input.";
		assertEquals(expectedOutput, getConsoleOutput());
    }
    
	@Test
	public void T04() {
		String[] parts = ("5" + " " + "0").split(" ");
		(new MoveToFoundation()).execute(parts);
	    String expectedOutput = "Move invalid.";
		assertEquals(expectedOutput, getConsoleOutput());
	}
    
    @Test
    public void T05() {
        String[] parts = ("2" + " " + "0").split(" ");
        (new MoveToFoundation()).execute(parts);
        assertEquals(1, gameManager.getFoundate().get(1).getCardList().size());
        assertEquals(50, scoreManager.getScore());
    }
    
    @Test
    public void T06() {
    	RecordedCommand.undoOneCommand();
        assertEquals(0, gameManager.getFoundate().get(1).getCardList().size());
    }
    
    @Test
	public void T07(){
		RecordedCommand.undoOneCommand();
		String expectedOutput = "Nothing to undo.";
		assertEquals(expectedOutput, getConsoleOutput());
	}
    
    @Test
    public void T08() {
    	RecordedCommand.redoOneCommand();
        assertEquals(1, gameManager.getFoundate().get(1).getCardList().size());
    }
    
    @Test
	public void T09(){
		RecordedCommand.redoOneCommand();
		String expectedOutput = "Nothing to redo.";
		assertEquals(expectedOutput, getConsoleOutput());
	}
   
}
