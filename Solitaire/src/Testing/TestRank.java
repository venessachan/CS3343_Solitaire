package Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import card.Rank;

public class TestRank {
	
	@Test
	public void testRankgetSign1() {
		assertEquals("A", Rank.A.getSign());
	}
	
	@Test
	public void testRankgetSign2() {
		assertEquals("J", Rank.J.getSign());
	}
	
	@Test
	public void testRankgetSign3() {
		assertEquals("Q", Rank.Q.getSign());
	}
	
	@Test
	public void testRankgetSign4() {
		assertEquals("K", Rank.K.getSign());
	}
	
	@Test
	public void testRankgetSign5() {
		assertEquals("10", Rank._10.getSign());
	}
	
	@Test
	public void testRankgetNum1() {
		Integer ans = 1;
		assertEquals(ans, Rank.A.getNum());
	}
	
	@Test
	public void testRankgetNum2() {
		Integer ans = 11;
		assertEquals(ans, Rank.J.getNum());
	}
	
	@Test
	public void testRankgetNum3() {
		Integer ans = 12;
		assertEquals(ans, Rank.Q.getNum());
	}
	
	@Test
	public void testRankgetNum4() {
		Integer ans = 13;
		assertEquals(ans, Rank.K.getNum());
	}
	
	@Test
	public void testRankgetNum5() {
		Integer ans = 10;
		assertEquals(ans, Rank._10.getNum());
	}

}
