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
		GameManager g = GameManager.getInstance();
		boolean contin = true;
		while((!g.isWin()) && contin) {
			g.printboard();
			
			Scanner in = new Scanner(System.in);
			System.out.print("(U)ndo, (R)edo, (D)eal, Move from (T)ableau, Move from (W)aste, or (Q)uit: ");
			
			String cmd = in.nextLine();
			String[] cmdParts = cmd.split(" ");
			
			switch(cmdParts[0]) {
				case "U":
					RecordedCommand.undoOneCommand();
					break;
				case "R":
					RecordedCommand.redoOneCommand();
					break;
				case "T":
					System.out.print("Move From? ");
					String f = in.nextLine();
					System.out.print("Move To(0 for foundation)? ");
					String t = in.nextLine();
					String[] parts = (f+" "+t).split(" ");
					if(t.equals("0")) 
						(new MoveToFoundation()).execute(parts);
					else
						(new MoveTableau()).execute(parts);
					break;
				case "W":
					System.out.print("Move to (0 for foundation)? ");
					String from = in.nextLine();
					String[] fromParts = from.split(" ");
					if(from.equals("0"))
						(new WasteToFoundation()).execute(fromParts);
					else
						(new WasteToTableau()).execute(fromParts);
					break;
				case "D":
					(new Deal()).execute(null);
					break;
				case "Q":
					contin = false;
					System.out.print("Quited. Thank you for playing.\n");
					break;
				default:
					System.out.print("Please input a valid command.\n\n");
			}
			g.tabAutoFlip();
		}
		
		if(!contin) {
			System.out.printf("You win.\n");
		}
	}

}
