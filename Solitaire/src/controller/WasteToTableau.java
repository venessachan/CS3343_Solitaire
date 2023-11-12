package controller;

import java.util.List;

import card.Card;
import main.GameManager;
import stackManager.Tableau;
import stackManager.Waste;

public class WasteToTableau extends RecordedCommand{
	
	private Card removedCard;
	private int tabIndex;

    @Override
    public void execute(String[] cmdParts){
    	
    	try {
			GameManager g = GameManager.getInstance();
			List<Tableau> tab = g.getTab();
			Waste waste = g.getWaste();
			
			int moveTo = Integer.parseInt(cmdParts[0]);
			
			if(moveTo -1 <0 || moveTo -1 > 6) {
				System.out.printf("Move invalid.\n\n");
				return;
			}
			
			Tableau tabTo = tab.get(moveTo-1);
			tabIndex = moveTo-1;
			if(waste.empty()) {
				System.out.printf("Move invalid\n\n");
				return;
			}
			
			boolean isPut = false;
			if(tabTo.checkValidAction(waste.peak())) 
				isPut = true;
			
			if(isPut) {
				
				tabTo.push(waste.peak());
				removedCard = waste.pop();
				
				addUndoCommand(this);
				clearRedoList();
				
				System.out.printf("Move successful.\n\n");
				
			}else {
				System.out.printf("Move invalid.\n\n");
			}
		} catch (NumberFormatException e) {
			System.out.printf("Invalid input.\n\n");
		}
		
		
	}

    @Override
	public void undoMe(){
    	GameManager g = GameManager.getInstance();
    	g.getWaste().push(removedCard);
    	g.getTab().get(tabIndex).pop();
    	addRedoCommand(this);
    }
	
	@Override
	public void redoMe(){
		GameManager g = GameManager.getInstance();
		g.getWaste().pop();
		g.getTab().get(tabIndex).push(removedCard);
		addUndoCommand(this);
	}


}
