package main;

import java.util.Scanner;

import controller.ControlHandler;
import controller.DisplayController;

public class Main {
	
	public static void main(String[] args) {
		ControlHandler controlHandler = ControlHandler.getInstance();
		DisplayController displayController = DisplayController.getInstance();
		while(true) {
			//displayController.printLevel();
			//print start? if-else
			Scanner sc = new Scanner(System.in);
			
			String cmd = sc.nextLine();
			//-2 (Q)
			if(controlHandler.execute(cmd) == -2) {
				break;
			}
			String[] cmdParts = cmd.split(" ");
			if(cmdParts[0].equals("T")) {
				displayController.printMoveFromQ();
				String moveFrom = sc.nextLine();
				displayController.printMoveToQ();
				String moveTo = sc.nextLine();
				controlHandler.execute("T" + " " + moveFrom + " " + moveTo);
			}else if(cmdParts[0].equals("W")) {
				displayController.printMoveToQ();
				String moveTo = sc.nextLine();
				controlHandler.execute("W" + " " + moveTo);
			}
			controlHandler.tabAutoFlip();
		}
		

	}

}
