package stackManager;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory{
	private static List<String> history;
    
    public CommandHistory() {
    	history = new ArrayList<>();
    	history.clear();
    }
    
    public List<String> getUndoCommandList() {
        return history;
    }
    public void push(String previousCmd) {
		history.add(previousCmd);
	}
	
	public String pop() {
		if(!history.isEmpty()) {
			return history.remove(history.size()-1);
		}
		return null;
	}
	
	public String peek() {
		if(!history.isEmpty()) {
			return history.get(history.size()-1);
		}
		return null;
	}
	
	public boolean isEmpty() {
		return history.isEmpty();
	}
	
	public void clear() {
		history.clear();
	}
    
}
