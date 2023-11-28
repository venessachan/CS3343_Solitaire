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
		assertEquals(1700, scoreController.getScore());
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
}
