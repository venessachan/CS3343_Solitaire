package Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import card.Color;
import card.Suit;

public class TestSuit {
	
	@Test
	public void testGetSign1() {// ♠
		assertEquals("♠", Suit.SPADES.getSign());
	}
	
	@Test
	public void testGetSign2() {// ♥
		assertEquals("♥", Suit.HEARTS.getSign());
	}
	
	@Test
	public void testGetSign3() {// ♣
		assertEquals("♣", Suit.CLUBS.getSign());
	}
	
	@Test
	public void testGetSign4() {// ♦
		assertEquals("♦", Suit.DIAMONDS.getSign());
	}
	
	@Test
	public void testGetColor1() {// Black
		assertEquals(Color.BLACK, Suit.SPADES.getColor());
	}
	
	@Test
	public void testGetColor2() {// Black
		assertEquals(Color.BLACK, Suit.CLUBS.getColor());
	}
	
	@Test
	public void testGetColor3() {// Red
		assertEquals(Color.RED, Suit.HEARTS.getColor());
	}
	
	@Test
	public void testGetColor4() {// Red
		assertEquals(Color.RED, Suit.DIAMONDS.getColor());
	}
	
}
