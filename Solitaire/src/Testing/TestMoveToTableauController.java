package Testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import card.Card;
import card.Rank;
import card.Suit;
import controller.MoveToTableauController;
import stackManager.Foundation;
import stackManager.Tableau;
import stackManager.Waste;

public class TestMoveToTableauController {
	private MoveToTableauController moveToTableauController;

	@Test
	public void testMoveToTableau1() {
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
		assertEquals(false, moveToT.getCardList().equals(moveFromT.getCardList()));
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
		moveToT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♦2, ♦8, ♣7, ♦6, ♠5, ♥4, ♣3]", moveToT.getCardList().toString());
	}

	@Test
	public void testMoveToTableau3() {
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
		moveFromT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2]", moveFromT.getCardList().toString());
	}

	@Test
	public void testMoveToTableau4() {
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
		moveToT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♦2, ♦8, ♣7]", moveToT.getCardList().toString());
	}

	@Test
	public void testMoveToTableau5() {
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
		moveFromT.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3]", moveFromT.getCardList().toString());
	}

//	@Test
//	public void testMoveToTableau6(){
//		Tableau moveFromT = new Tableau();
//		Tableau moveToT = new Tableau();
//		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank.K));
//		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._2));
//		moveFromT.push(moveFromT.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
//		moveFromT.push(moveFromT.getCardList(), new Card(Suit.SPADES, Rank._5));
//		moveFromT.push(moveFromT.getCardList(), new Card(Suit.HEARTS, Rank._4));
//		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._3));
//		moveFromT.push(moveFromT.getCardList(), new Card(Suit.CLUBS, Rank._7));
//		
//		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._2));
//		moveToT.push(moveToT.getCardList(), new Card(Suit.DIAMONDS, Rank._8));
//		
//		moveToTableauController.execute(moveFromT, moveToT, 1);
//		moveFromT.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3]",moveFromT.getCardList().toString());
//	}

	@Test
	public void testMoveToTableau7() {
		Tableau moveTo = new Tableau();
		Waste moveFrom = new Waste();
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveTo.push(moveTo.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveTo.push(moveTo.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveTo.push(moveTo.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveTo.push(moveTo.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank._7));

		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._8));

		moveToTableauController.execute(moveFrom, moveTo, 1);
		moveTo.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3, ♣7, ♣8]", moveTo.getCardList().toString());

	}

	@Test
	public void testMoveToTableau8() {
		Tableau moveTo = new Tableau();
		Foundation moveFrom = new Foundation(Suit.CLUBS);
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveTo.push(moveTo.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveTo.push(moveTo.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveTo.push(moveTo.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveTo.push(moveTo.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank._7));

		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank.A));

		moveToTableauController.execute(moveFrom, moveTo, 1);
		moveTo.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3, ♣7, ♣A]", moveTo.getCardList().toString());
	}

	@Test
	public void testMoveToTableau9() {
		Tableau moveFrom = new Tableau();
		Foundation moveTo = new Foundation(Suit.CLUBS);
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank.K));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.HEARTS, Rank._2));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.SPADES, Rank._5));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.HEARTS, Rank._4));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._3));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._7));
		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank.A));

		moveToTableauController.execute(moveFrom, moveTo, 1);
		moveTo.getCardList().forEach((c) -> c.setShow(true));
		assertEquals("[♣A]", moveTo.getCardList().toString());
	}

	@Test
	public void testMoveToTableau10() {
		Tableau target = new Tableau();
		Card moveFrom = new Card(Suit.CLUBS, Rank._8);
		target.push(target.getCardList(), new Card(Suit.CLUBS, Rank.K));
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank._2));
		target.push(target.getCardList(), new Card(Suit.DIAMONDS, Rank._6));

		int testUnit = moveToTableauController.getMoveCardCount(moveFrom, target);
		assertEquals(-1, testUnit);
	}

	@Test
	public void testMoveToTableau11() {
		Tableau target = new Tableau();
		Card moveFrom = new Card(Suit.CLUBS, Rank._5);
		target.push(target.getCardList(), new Card(Suit.CLUBS, Rank.K));
		target.push(target.getCardList(), new Card(Suit.HEARTS, Rank._2));
		target.push(target.getCardList(), new Card(Suit.DIAMONDS, Rank._6));

		int testUnit = moveToTableauController.getMoveCardCount(moveFrom, target);
		assertEquals(1, testUnit);
	}
	
	@Test
	public void testMoveToTableau12() {
		Tableau target = new Tableau();


		List<Card> moveFromList = new ArrayList<Card>();
		
		Card cardK = new Card(Suit.CLUBS, Rank.K);
		cardK.setShow(true);
		Card cardQ = new Card(Suit.DIAMONDS, Rank.Q);
		cardQ.setShow(true);
		Card cardJ = new Card(Suit.CLUBS, Rank.J);
		cardJ.setShow(true);
		Card card10 = new Card(Suit.DIAMONDS, Rank._10);
		card10.setShow(true);
		Card cardA = new Card(Suit.DIAMONDS, Rank.A);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		Card card3 = new Card(Suit.DIAMONDS, Rank._3);

		moveFromList.add(card3);
		moveFromList.add(card2);
		moveFromList.add(cardA);
		moveFromList.add(card10);
		moveFromList.add(cardJ);
		moveFromList.add(cardQ);
		moveFromList.add(cardK);
		
		int moveCardCount = moveToTableauController.getMoveCardCount(moveFromList, target, 4);
		assertEquals(4, moveCardCount);
	}
	
	@Test
	public void testMoveToTableau13() {
		Tableau target = new Tableau();


		List<Card> moveFromList = new ArrayList<Card>();
		
		int moveCardCount = moveToTableauController.getMoveCardCount(moveFromList, target, 4);
		assertEquals(-1, moveCardCount);
	}
	
	@Test
	public void testMoveToTableau14() {
		Tableau target = new Tableau();

		List<Card> moveFromList = new ArrayList<Card>();
		
		Card cardK = new Card(Suit.CLUBS, Rank.K);
		cardK.setShow(true);

		moveFromList.add(cardK);
		
		int moveCardCount = moveToTableauController.getMoveCardCount(moveFromList, target, 4);
		assertEquals(1, moveCardCount);
	}

	@Test
	public void testMoveToTableau21() {
		Tableau target = new Tableau();

		List<Card> moveFromList = new ArrayList<Card>();
		
		System.out.println(moveFromList.size());
		
		int moveCardCount = moveToTableauController.getMoveCardCount(moveFromList, target, 4);
		assertEquals(-1, moveCardCount);
	}
	
	@Test
	public void testMoveToTableau15() {
		Tableau target = new Tableau();


		List<Card> moveFromList = new ArrayList<Card>();
		
		Card cardK = new Card(Suit.CLUBS, Rank.K);
		cardK.setShow(true);
		Card cardQ = new Card(Suit.CLUBS, Rank.Q);
		cardQ.setShow(true);
		Card cardJ = new Card(Suit.CLUBS, Rank.J);
		cardJ.setShow(true);
		moveFromList.add(cardJ);
		moveFromList.add(cardQ);
		moveFromList.add(cardK);
		
		int moveCardCount = moveToTableauController.getMoveCardCount(moveFromList, target, 4);
		assertEquals(1, moveCardCount);
	}
	
	@Test
	public void testMoveToTableau16() {
		Tableau target = new Tableau();

		List<Card> moveFromList = new ArrayList<Card>();
		
		Card cardK = new Card(Suit.CLUBS, Rank.K);
		cardK.setShow(true);
		Card card10 = new Card(Suit.DIAMONDS, Rank._10);
		card10.setShow(true);
		Card cardJ = new Card(Suit.CLUBS, Rank.J);
		cardJ.setShow(true);
		
		moveFromList.add(cardJ);
		moveFromList.add(card10);
		moveFromList.add(cardK);
		
		int moveCardCount = moveToTableauController.getMoveCardCount(moveFromList, target, 4);
		assertEquals(1, moveCardCount);
	}
	
	@Test
	public void testMoveToTableau17() {
		Tableau target = new Tableau();

		List<Card> moveFromList = new ArrayList<Card>();
		
		Card card10 = new Card(Suit.DIAMONDS, Rank._10);
		card10.setShow(true);
		Card cardJ = new Card(Suit.CLUBS, Rank.J);
		cardJ.setShow(true);
		
		moveFromList.add(cardJ);
		moveFromList.add(card10);
		
		int moveCardCount = moveToTableauController.getMoveCardCount(moveFromList, target, 4);
		assertEquals(-1, moveCardCount);
	}
	
	@Test
	public void testMoveToTableau18() {
		List<Card> moveFromList = new ArrayList<Card>();
		
		Card cardA = new Card(Suit.DIAMONDS, Rank.A);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		Card card3 = new Card(Suit.DIAMONDS, Rank._3);
		Card card10 = new Card(Suit.DIAMONDS, Rank._10);
		card10.setShow(true);
		
		moveFromList.add(cardA);
		moveFromList.add(card2);
		moveFromList.add(card3);
		moveFromList.add(card10);
		
		int moveCardCount = moveToTableauController.getShowCard(moveFromList);
		assertEquals(1, moveCardCount);
	}
	
	@Test
	public void testMoveToTableau19() {
		List<Card> moveFromList = new ArrayList<Card>();
		
		Card cardA = new Card(Suit.DIAMONDS, Rank.A);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		Card card3 = new Card(Suit.DIAMONDS, Rank._3);
		Card card10 = new Card(Suit.DIAMONDS, Rank._10);
		
		moveFromList.add(cardA);
		moveFromList.add(card2);
		moveFromList.add(card3);
		moveFromList.add(card10);
		
		int moveCardCount = moveToTableauController.getShowCard(moveFromList);
		assertEquals(0, moveCardCount);
	}

	@Test
	public void testMoveToTableau20() {
		List<Card> moveFromList = new ArrayList<Card>();
		
		Card cardA = new Card(Suit.DIAMONDS, Rank.A);
		cardA.setShow(true);
		Card card2 = new Card(Suit.DIAMONDS, Rank._2);
		card2.setShow(true);
		Card card3 = new Card(Suit.DIAMONDS, Rank._3);
		card3.setShow(true);
		Card card10 = new Card(Suit.DIAMONDS, Rank._10);
		card10.setShow(true);
		
		moveFromList.add(cardA);
		moveFromList.add(card2);
		moveFromList.add(card3);
		moveFromList.add(card10);
		
		int moveCardCount = moveToTableauController.getShowCard(moveFromList);
		assertEquals(4, moveCardCount);
	}

//	@Test
//	public void testMoveToTableau9(){
//		Tableau moveTo = new Tableau();
//		Foundation moveFrom = new Foundation(Suit.CLUBS);
//		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank.K));
//		moveTo.push(moveTo.getCardList(), new Card(Suit.HEARTS, Rank._2));
//		moveTo.push(moveTo.getCardList(), new Card(Suit.DIAMONDS, Rank._6));
//		moveTo.push(moveTo.getCardList(), new Card(Suit.SPADES, Rank._5));
//		moveTo.push(moveTo.getCardList(), new Card(Suit.HEARTS, Rank._4));
//		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank._3));
//		moveTo.push(moveTo.getCardList(), new Card(Suit.CLUBS, Rank._7));
//		
//		moveFrom.push(moveFrom.getCardList(), new Card(Suit.CLUBS, Rank._8));
//		
//		moveToTableauController.execute(moveFrom, moveTo, 1);
//		moveTo.getCardList().forEach((c)->c.setShow(true));
//		assertEquals("[♣K, ♥2, ♦6, ♠5, ♥4, ♣3, ♣7, ♣8]",moveTo.getCardList().toString());
//	}

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
