package controller;

public class Template extends RecordedCommand{
//    private Employee e;
//	private int addAmount; 

    @Override
    public void execute(){
//		//Note: In Q1, e and addAmount were local variables.  But now they are the data in the object (instance fields).
//		Company company = Company.getInstance();
//		e = company.findEmployee(cmdParts[1]);
//		addAmount=Integer.parseInt(cmdParts[2]);
//
//		e.addSalary(addAmount);
//
//		addUndoCommand(this); //<====== store this command (addUndoCommand is implemented in RecordedCommand.java)
//		clearRedoList(); //<====== There maybe some commands stored in the redo list.  Clear them.
//
//		System.out.println("Done.");
	}

    @Override
	public void undoMe(){
//		e.addSalary(-addAmount);
//		addRedoCommand(this); //<====== upon undo, we should keep a copy in the redo list (addRedoCommand is implemented in RecordedCommand.java)
	}
	
	@Override
	public void redoMe(){
//		e.addSalary(addAmount);
//		addUndoCommand(this); //<====== upon redo, we should keep a copy in the undo list
	}


}
