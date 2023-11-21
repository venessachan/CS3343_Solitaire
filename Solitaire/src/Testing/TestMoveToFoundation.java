package Testing;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import controller.MoveToFoundationController;
import stackManager.Foundation;

public class TestMoveToFoundation {
	private MoveToFoundationController moveToFoundationController;
	
	@Test
	public void testPush1() {
		moveToFoundationController = MoveToFoundationController.getInstance();
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.SPADES, Rank._2);
		Card moveFromCard = new Card(Suit.SPADES, Rank._3);
		Foundation foundation = new Foundation(Suit.SPADES);
		foundation.push(foundation.getCardList(), card1);
		foundation.push(foundation.getCardList(), card2);
		
		moveToFoundationController.execute(moveFromCard, foundation);
		foundation.getCardList().forEach((c)->c.setShow(true));
		assertEquals("[♠A, ♠2, ♠3]", foundation.getCardList().toString());
	}
	
	@Before
	public void setup() {
		MoveToFoundationController.resetInstance();
		moveToFoundationController = MoveToFoundationController.getInstance();
	}
	
	
	@Test
	public void testGetListIndex1() {
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.SPADES, Rank._2);
		Card card3 = new Card(Suit.SPADES, Rank._3);
		Card card4 = new Card(Suit.SPADES, Rank._4);
		Card card5 = new Card(Suit.SPADES, Rank._5);
		
		List<Foundation> foundation = new ArrayList<Foundation>();
		foundation = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(0).push(foundation.get(0).getCardList(), card1);
		foundation.get(0).push(foundation.get(0).getCardList(), card2);
		foundation.get(0).push(foundation.get(0).getCardList(), card3);
		foundation.get(0).push(foundation.get(0).getCardList(), card4);
		foundation.get(0).push(foundation.get(0).getCardList(), card5);

		assertEquals(false, foundation.get(0).getCardList().equals(foundation.get(2).getCardList()));
	}
	
	@Test
	public void testGetListIndex2() {
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.SPADES, Rank._2);
		Card card3 = new Card(Suit.SPADES, Rank._3);
		Card card4 = new Card(Suit.SPADES, Rank._4);
		Card card5 = new Card(Suit.SPADES, Rank._5);
		
		List<Foundation> foundation = new ArrayList<Foundation>();
		foundation = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(0).push(foundation.get(0).getCardList(), card1);
		foundation.get(0).push(foundation.get(0).getCardList(), card2);
		foundation.get(0).push(foundation.get(0).getCardList(), card3);
		foundation.get(0).push(foundation.get(0).getCardList(), card4);
		foundation.get(0).push(foundation.get(0).getCardList(), card5);
		
		Card moveFromCard = new Card(Suit.SPADES, Rank._6);
		foundation.get(0).getCardList().forEach((c)->c.setShow(true));
		assertEquals(0, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}
	
	@Test
	public void testGetListIndex3() {
		Card card1 = new Card(Suit.HEARTS, Rank.A);
		Card card2 = new Card(Suit.HEARTS, Rank._2);
		Card card3 = new Card(Suit.HEARTS, Rank._3);
		Card card4 = new Card(Suit.HEARTS, Rank._4);
		
		List<Foundation> foundation = new ArrayList<Foundation>();
		foundation = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(1).push(foundation.get(1).getCardList(), card1);
		foundation.get(1).push(foundation.get(1).getCardList(), card2);
		foundation.get(1).push(foundation.get(1).getCardList(), card3);
		foundation.get(1).push(foundation.get(1).getCardList(), card4);
		
		Card moveFromCard = new Card(Suit.HEARTS, Rank._5);
		assertEquals(1, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}

	@Test
	public void testGetListIndex4() {
		Card card1 = new Card(Suit.CLUBS, Rank.A);
		Card card2 = new Card(Suit.CLUBS, Rank._2);
		Card card3 = new Card(Suit.CLUBS, Rank._3);
		Card card4 = new Card(Suit.CLUBS, Rank._4);
		
		List<Foundation> foundation = new ArrayList<Foundation>();
		foundation = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(2).push(foundation.get(2).getCardList(), card1);
		foundation.get(2).push(foundation.get(2).getCardList(), card2);
		foundation.get(2).push(foundation.get(2).getCardList(), card3);
		foundation.get(2).push(foundation.get(2).getCardList(), card4);
		
		Card moveFromCard = new Card(Suit.CLUBS, Rank._5);
		assertEquals(2, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}
	
	@Test
	public void testGetListIndex5() {
		Card card1 = new Card(Suit.DIAMONDS, Rank.A);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		Card card3 = new Card(Suit.DIAMONDS, Rank._3);
		Card card4 = new Card(Suit.DIAMONDS, Rank._4);
		
		List<Foundation> foundation = new ArrayList<Foundation>();
		foundation = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(3).push(foundation.get(3).getCardList(), card1);
		foundation.get(3).push(foundation.get(3).getCardList(), card2);
		foundation.get(3).push(foundation.get(3).getCardList(), card3);
		foundation.get(3).push(foundation.get(3).getCardList(), card4);
		
		Card moveFromCard = new Card(Suit.DIAMONDS, Rank._5);
		assertEquals(3, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}
	
	@Test
	public void testGetListIndex6() {
		Card card1 = new Card(Suit.SPADES, Rank.A);
		Card card2 = new Card(Suit.SPADES, Rank._2);
		Card card3 = new Card(Suit.SPADES, Rank._3);
		Card card4 = new Card(Suit.SPADES, Rank._4);
		Card card5 = new Card(Suit.SPADES, Rank._5);
		
		List<Foundation> foundation = new ArrayList<Foundation>();
		foundation = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(0).push(foundation.get(0).getCardList(), card1);
		foundation.get(0).push(foundation.get(0).getCardList(), card2);
		foundation.get(0).push(foundation.get(0).getCardList(), card3);
		foundation.get(0).push(foundation.get(0).getCardList(), card4);
		foundation.get(0).push(foundation.get(0).getCardList(), card5);
		
		Card moveFromCard = new Card(Suit.SPADES, Rank._7);
		assertEquals(-1, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}
	
	@Test
	public void testGetListIndex7() {
		Card card1 = new Card(Suit.DIAMONDS, Rank.A);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		Card card3 = new Card(Suit.DIAMONDS, Rank._3);
		Card card4 = new Card(Suit.DIAMONDS, Rank._4);
		
		List<Foundation> foundation = new ArrayList<Foundation>();
		foundation = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundation.add(new Foundation (suit));
		}
		
		foundation.get(3).push(foundation.get(3).getCardList(), card1);
		foundation.get(3).push(foundation.get(3).getCardList(), card2);
		foundation.get(3).push(foundation.get(3).getCardList(), card3);
		foundation.get(3).push(foundation.get(3).getCardList(), card4);
		
		Card moveFromCard = new Card(Suit.HEARTS, Rank._5);
		assertEquals(-1, moveToFoundationController.getListIndex(moveFromCard, foundation));
	}
	
	
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
//        String[] parts = ("0" + " " + "0").split(" ");
//        (new MoveToFoundation()).execute(parts);
//        String expectedOutput = "Move invalid.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void T02() {
//        String[] parts = ("8" + " " + "0").split(" ");
//        (new MoveToFoundation()).execute(parts);
//        String expectedOutput = "Move invalid.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//    @Test
//    public void T03() {
//        String[] parts = ("N" + " " + "0").split(" ");
//        (new MoveToFoundation()).execute(parts);
//        String expectedOutput = "Invalid input.";
//		assertEquals(expectedOutput, getConsoleOutput());
//    }
//    
//	@Test
//	public void T04() {
//		String[] parts = ("5" + " " + "0").split(" ");
//		(new MoveToFoundation()).execute(parts);
//	    String expectedOutput = "Move invalid.";
//		assertEquals(expectedOutput, getConsoleOutput());
//	}
//    
//    @Test
//    public void T05() {
//        String[] parts = ("2" + " " + "0").split(" ");
//        (new MoveToFoundation()).execute(parts);
//        assertEquals(1, gameManager.getFoundate().get(1).getCardList().size());
//        assertEquals(50, scoreManager.getScore());
//    }
//    
//    @Test
//    public void T06() {
//    	ControlHandler.undoOneCommand();
//        assertEquals(0, gameManager.getFoundate().get(1).getCardList().size());
//    }
//    
//    @Test
//	public void T07(){
//		ControlHandler.undoOneCommand();
//		String expectedOutput = "Nothing to undo.";
//		assertEquals(expectedOutput, getConsoleOutput());
//	}
//    
//    @Test
//    public void T08() {
//    	ControlHandler.redoOneCommand();
//        assertEquals(1, gameManager.getFoundate().get(1).getCardList().size());
//    }
//    
//    @Test
//	public void T09(){
//		ControlHandler.redoOneCommand();
//		String expectedOutput = "Nothing to redo.";
//		assertEquals(expectedOutput, getConsoleOutput());
//	}
//   
}
