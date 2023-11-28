package Testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import stackManager.CommandHistory;

public class TestCommandHistory {
	@Test
	public void testPushCmd1() {
		CommandHistory history = new CommandHistory();
		history.push("D");
		history.push("W 0");
		history.push("T 1 3");
		assertEquals("[D, W 0, T 1 3]",history.getUndoCommandList().toString());
		
	}
	
	@Test
	public void testPopCmd1() {
		CommandHistory history = new CommandHistory();
		history.push("D");
		history.push("W 0");
		history.push("T 1 3");
		assertEquals("T 1 3", history.pop());
		assertEquals("[D, W 0]",history.getUndoCommandList().toString());
	}
	
	@Test
	public void testPopCmd2() {
		CommandHistory history = new CommandHistory();
		assertEquals(null,history.pop());
	}
	
	@Test
	public void testPeekCmd1() {
		CommandHistory history = new CommandHistory();
		history.push("D");
		history.push("W 0");
		history.push("T 1 3");
		assertEquals("T 1 3",history.peek());
	}
	
	@Test
	public void testPeekCmd2() {
		CommandHistory history = new CommandHistory();
		assertEquals(null,history.peek());
	}
	
	@Test
	public void testIsEmptyCmd1() {
		CommandHistory history = new CommandHistory();
		history.push("D");
		history.push("W 0");
		history.push("T 1 3");
		history.clear();
		assertEquals(true,history.isEmpty());
	}
	
	@Test
	public void testIsEmptyCmd2() {
		CommandHistory history = new CommandHistory();
		history.push("D");
		history.push("W 0");
		history.push("T 1 3");
		assertEquals(false,history.isEmpty());
	}
	
}
