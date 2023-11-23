package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import controller.MoveToTableauController;
import stackManager.Tableau;

public class TestMoveToTableauController {
	private MoveToTableauController moveToTableauController;
	
	@Test
	public void testMoveToTableau1(){
		moveToTableauController = MoveToTableauController.getInstance();
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));
		
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));
		
		moveToTableauController.execute(moveFromT, moveToT, 5);
		assertEquals(false,moveToT.getCardList().equals(moveFromT.getCardList()));
	}
	
	@Before
	public void setup() {
		MoveToTableauController.resetInstance();
		moveToTableauController = MoveToTableauController.getInstance();
	}
	
	@Test
	public void testMoveToTableau2() {
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));
		
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));
		
		moveToTableauController.execute(moveFromT, moveToT, 5);
		moveToT.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♦2, ♦8, ♣7, ♦6, ♠5, ♥4, ♣3]",moveToT.getCardList().toString());
	}
	
	@Test
	public void testMoveToTableau3(){
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));
		
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));
		
		moveToTableauController.execute(moveFromT, moveToT, 5);
		moveFromT.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♣K, ♥2]",moveFromT.getCardList().toString());
	}
	
	@Test
	public void testMoveToTableau4(){
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));
		
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));
		
		moveToTableauController.execute(moveFromT, moveToT, 1);
		moveToT.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♦2, ♦8, ♣7]",moveToT.getCardList().toString());
	}
	
	@Test
	public void testMoveToTableau5(){
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));
		
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));
		
		moveToTableauController.execute(moveFromT, moveToT, 1);
		moveFromT.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3]",moveFromT.getCardList().toString());
	}
	
	@Test
	public void testMoveToTableau6(){
		Tableau moveFromT = new Tableau();
		Tableau moveToT = new Tableau();
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));
		
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));
		
		moveToTableauController.execute(moveFromT, moveToT, 1);
		moveFromT.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3]",moveFromT.getCardList().toString());
	}
//    private ScoreManager scoreManager;
//    private ByteArrayOutputStream outputStream;
//    
//    @BeforeEach
//    public void setup() {
//        gameManager = GameManager.getInstance();
//        scoreManager = scoreManager.getInstance();
//        outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//    }
//    
//    @AfterEach
//    public void tearDown() {
//        System.setOut(System.out);
//    }
//    
//    private String getConsoleOutput() {
//        return outputStream.toString().trim();
//    }
//    
//    @Test
//    public void T01() {
//        String[] parts = ("0" + " " + "5").split(" ");
//        (new MoveTableau()).execute(parts);
//        String expectedOutput = "Move invalid.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void T02() {
//        String[] parts = ("10" + " " + "5").split(" ");
//        (new MoveTableau()).execute(parts);
//        String expectedOutput = "Move invalid.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void T03() {
//        String[] parts = ("1" + " " + "0").split(" ");
//        (new MoveTableau()).execute(parts);
//        String expectedOutput = "Move invalid.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void T04() {
//        String[] parts = ("1" + " " + "9").split(" ");
//        (new MoveTableau()).execute(parts);
//        String expectedOutput = "Move invalid.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void T05() {
//        String[] parts = ("1" + " " + "5").split(" ");
//        (new MoveTableau()).execute(parts);
//        String expectedOutput = "Move invalid.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void T06() {
//        String[] parts = ("N" + " " + "5").split(" ");
//        (new MoveTableau()).execute(parts);
//        String expectedOutput = "Invalid input.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void T07() {
//        String[] parts = ("1" + " " + "N").split(" ");
//        (new MoveTableau()).execute(parts);
//        String expectedOutput = "Invalid input.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void T08() {
//        String[] parts = ("6" + " " + "1").split(" ");
//        (new MoveTableau()).execute(parts);
//        String expectedOutput = "Move successful.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void T09() {
//		assertEquals(2, gameManager.getTab().get(0).getCardList().size());
//		assertEquals(5, gameManager.getTab().get(5).getCardList().size());
//    }
//    
//    @Test
//    public void T10() {
//    	ControlHandler.undoOneCommand();
//    	assertEquals(1, gameManager.getTab().get(0).getCardList().size());
//		assertEquals(6, gameManager.getTab().get(5).getCardList().size());
//    }
//    
//    @Test
//    public void T11() {
//    	ControlHandler.redoOneCommand();
//    	assertEquals(2, gameManager.getTab().get(0).getCardList().size());
//		assertEquals(5, gameManager.getTab().get(5).getCardList().size());
//    }
//    
//    @Test
//    public void T12() {
//    	String[] parts = ("1" + " " + "1").split(" ");
//        (new MoveTableau()).execute(parts);
//        String expectedOutput = "Move invalid.";
// 		assertEquals(expectedOutput, getConsoleOutput());
//    	parts = ("2" + " " + "0").split(" ");
//        (new MoveToFoundation()).execute(parts);
//        parts = ("2" + " " + "0").split(" ");
//        (new MoveToFoundation()).execute(parts);
//    }
//    
//    @Test
//    public void T13() {
//    	String parts[] = ("2" + " " + "1").split(" ");
//        (new MoveTableau()).execute(parts);
//        String expectedOutput = "Move invalid";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    
    
}
