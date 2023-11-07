package main;

import java.util.Scanner;

import controller.Deal;
import controller.MoveTableau;
import controller.MoveToFoundation;
import controller.RecordedCommand;
import controller.WasteToFoundation;
import controller.WasteToTableau;

public class Main {
	
	public static void main(String[] args) {
		GameManager gameManager = GameManager.getInstance();
		//boolean contin = true;
		while(true) {
			gameManager.printboard();
			
			Scanner in = new Scanner(System.in);
			System.out.print("(U)ndo, (R)edo, (D)eal, Move from (T)ableau, Move from (W)aste, or (Q)uit: ");
			
			String cmd = in.nextLine();
			String[] cmdParts = cmd.split(" ");
			
			switch(cmdParts[0]) {	//testing: should be case insensitive
				case "U":
					RecordedCommand.undoOneCommand();
					gameManager.setPreviousAction(cmdParts[0]);
					gameManager.move();
					break;
				case "R":
					RecordedCommand.redoOneCommand();
					gameManager.setPreviousAction(cmdParts[0]);
					gameManager.move();
					break;
				case "T":
					System.out.print("Move From? ");
					String moveFrom = in.nextLine();
					System.out.print("Move To(0 for foundation)? ");
					String moveTo = in.nextLine();
					String[] parts = (moveFrom + " " + moveTo).split(" ");
					if(moveTo.equals("0")) {
						(new MoveToFoundation()).execute(parts);
						
						if(gameManager.isWin()) {
							//refactoring: call other print function/print board
							gameManager.setScore(1000000*1/gameManager.getMove());
							System.out.printf("You win.\n");
						}
						
					}
					else {
						//refactoring: game manager contain all controller to control
						//controller can be static
						(new MoveTableau()).execute(parts);
					}
					gameManager.setPreviousAction(cmdParts[0]);
					gameManager.move();
					break;
				case "W":
					System.out.print("Move to (0 for foundation)? ");
					String from = in.nextLine();
					String[] fromParts = from.split(" ");
					if(from.equals("0"))
						(new WasteToFoundation()).execute(fromParts);
					else
						(new WasteToTableau()).execute(fromParts);
					gameManager.setPreviousAction(cmdParts[0]);
					gameManager.move();
					break;
				case "D":
					(new Deal()).execute(null);
					gameManager.setPreviousAction(cmdParts[0]);
					gameManager.move();
					break;
				case "Q":
					System.out.print("Quited. Thank you for playing.\n");
					gameManager.setPreviousAction(cmdParts[0]);
					gameManager.move();
					break;
				default:
					System.out.print("Please input a valid command.\n\n");
			}
			
			gameManager.tabAutoFlip();
		}
		

	}

}
