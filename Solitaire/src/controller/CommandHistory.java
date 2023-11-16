package controller;

import java.util.ArrayList;
import java.util.List;

import stackManager.CommandList;

public class CommandHistory extends CommandList{
	private static List<String> undoList;
    private static List<String> redoList;
    
    public CommandHistory() {
    	undoList = new ArrayList<>();
    	redoList = new ArrayList<>();
    	undoList.clear();
    	redoList.clear();
    }
    
    public List<String> getUndoCommandList() {
        return undoList;
    }

    public List<String> getRedoCommandList() {
        return redoList;
    }
   
}
