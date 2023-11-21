package Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import controller.ScoreController;

public class TestScoreController {
	private ScoreController scoreController;
	
	@Test
	public void testGetScore() {
		scoreController = ScoreController.getInstance();
	    scoreController.setScore(9876);
	    assertEquals(9876, scoreController.getScore());
	}
	
	@Before
	public void setup() {
		ScoreController.resetInstance();
		scoreController = ScoreController.getInstance();
	}
	
	@Test
	public void testAddScore() {
		scoreController.setScore(2250);
		scoreController.addScore(500);
		assertEquals(2750, scoreController.getScore());
	}
	
	@Test
	public void testGetComboCount() {
		scoreController.setComboCount(11);
		assertEquals(11, scoreController.getComboCount());
	}
	
	@Test
	public void testCombo1() {
		scoreController.checkCombo("D 0 0");
		assertEquals(0, scoreController.getScore());
	}
	
	@Test
	public void testCombo2() {
		scoreController.setScore(3000);
		scoreController.setComboCount(20);
		scoreController.checkCombo("W 1");
		assertEquals(3000, scoreController.getScore());
	}
	
	@Test
	public void testCombo3() {
		scoreController.setScore(1500);
		scoreController.setComboCount(2);
		scoreController.checkCombo("W 0");
		assertEquals(1550, scoreController.getScore());
	}
	
	@Test
	public void testCombo4() {	
		scoreController.setScore(350);
		scoreController.setComboCount(3);
		scoreController.checkCombo("T 1 2");
		assertEquals(350, scoreController.getScore());
	}
	
	@Test
	public void testCombo5() {	
		scoreController.setScore(600);
		scoreController.setComboCount(3);
		scoreController.checkCombo("T 1 0");
		assertEquals(800, scoreController.getScore());
	}
	
	@Test
	public void testCombo6() {	
		scoreController.setScore(600);
		scoreController.setComboCount(7);
		scoreController.checkCombo("T 1 0");
		assertEquals(1000, scoreController.getScore());
	}
	
	@Test
	public void testCombo7() {	
		scoreController.setScore(600);
		scoreController.setComboCount(10);
		scoreController.checkCombo("T 5 0");
		assertEquals(1400, scoreController.getScore());
	}
	
	@Test
	public void testCombo8() {	
		scoreController.setScore(600);
		scoreController.setComboCount(20);
		scoreController.checkCombo("W 0");
		assertEquals(2200, scoreController.getScore());
	}
	
//	@Test
//	public void testCombo3() {
//		scoreController.checkCombo("W 0");
//		assertEquals(0, scoreController.getComboCount());
//		
//		scoreController.setScore(500);
//		scoreController.setComboCount(2);
//		scoreController.checkCombo("W 0");
//		assertEquals(550, scoreController.getComboCount());
//	}
	
//	@Test
//	public void testCombo2() {
//		ScoreController scoreManager = new ScoreController();
//		scoreManager.setScore(100);
//		scoreManager.setPreviousAction("T");
//		scoreManager.setComboCount(2);
//		scoreManager.checkCombo();
//		assertEquals(150, scoreManager.getScore());
//	}
	
//	
//	
//	@Test
//	public void testCombo3() {
//		ScoreManager scoreManager = new ScoreManager();
//		scoreManager.setScore(150);
//		scoreManager.setPreviousAction("T");
//		scoreManager.setComboCount(3);
//		scoreManager.checkCombo();
//		assertEquals(250, scoreManager.getScore());
//	}
//	
//	@Test
//	public void testCombo4() {
//		ScoreManager scoreManager = new ScoreManager();
//		scoreManager.setScore(150);
//		scoreManager.setPreviousAction("T");
//		scoreManager.setComboCount(3);
//		scoreManager.checkCombo();
//		assertEquals(250, scoreManager.getScore());
//	}
//	
//	@Test
//	public void testCombo5() {
//		ScoreManager scoreManager = new ScoreManager();
//		scoreManager.setScore(450);
//		scoreManager.setPreviousAction("T");
//		scoreManager.setComboCount(6);
//		scoreManager.checkCombo();
//		assertEquals(550, scoreManager.getScore());
//	}
//	
//	@Test
//	public void testCombo6() {
//		ScoreManager scoreManager = new ScoreManager();
//		scoreManager.setScore(550);
//		scoreManager.setPreviousAction("T");
//		scoreManager.setComboCount(7);
//		scoreManager.checkCombo();
//		assertEquals(700, scoreManager.getScore());
//	}
//	
//	@Test
//	public void testCombo7() {
//		ScoreManager scoreManager = new ScoreManager();
//		scoreManager.setScore(850);
//		scoreManager.setPreviousAction("T");
//		scoreManager.setComboCount(9);
//		scoreManager.checkCombo();
//		assertEquals(1000, scoreManager.getScore());
//	}
//	
//	@Test
//	public void testCombo8() {
//		ScoreManager scoreManager = new ScoreManager();
//		scoreManager.setScore(1000);
//		scoreManager.setPreviousAction("T");
//		scoreManager.setComboCount(10);
//		scoreManager.checkCombo();
//		assertEquals(1250, scoreManager.getScore());
//	}
//	
//	@Test
//	public void testCombo9() {
//		ScoreManager scoreManager = new ScoreManager();
//		scoreManager.setScore(3500);
//		scoreManager.setPreviousAction("T");
//		scoreManager.setComboCount(20);
//		scoreManager.checkCombo();
//		assertEquals(4000, scoreManager.getScore());
//	}
//	
//	@Test
//	public void testCombo10() {
//		ScoreManager scoreManager = new ScoreManager();
//		scoreManager.setScore(19500);
//		scoreManager.setPreviousAction("T");
//		scoreManager.setComboCount(52);
//		scoreManager.checkCombo();
//		assertEquals(20000, scoreManager.getScore());
//	}
//	
//	//check score by each card adding
//	@Test
//	public void testCombo11() {
//		
//	}
//		
//		
//	//Not fulfil combo requirement
//	@Test
//	public void testNoCombo() {
//		ScoreManager scoreManager = new ScoreManager();
//		scoreManager.setPreviousAction("D");
//		scoreManager.checkCombo();
//		assertEquals(0, scoreManager.getComboCount());
//	}
//	
//	
}
