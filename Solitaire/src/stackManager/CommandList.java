package stackManager;

import java.util.List;

public class CommandList {
	public void push(List<String> history, String previousCmd) {
		history.add(previousCmd);
	}
	
	public String pop(List<String> history) {
		if(!history.isEmpty()) {
			return history.remove(history.size()-1);
		}
		return null;
	}
	
	public String peek(List<String> history) {
		if(!history.isEmpty()) {
			return history.get(history.size()-1);
		}
		return null;
	}
	
	public boolean isEmpty(List<String> history) {
		return history.isEmpty();
	}
	
	public void clear(List<String> history) {
		history.clear();
	}
	
}
