package main;

import java.util.Scanner;

import controller.ControlHandler;
import controller.DisplayController;

public class Main {
	
	public static void main(String[] args) {
		ControlHandler controlHandler = ControlHandler.getInstance();
		DisplayController displayController = DisplayController.getInstance();
		while(true) {
			displayController.printLevel();
			Scanner sc = new Scanner(System.in);
			
			String cmd = sc.nextLine();
			//-2 (Q)
			if(controlHandler.execute(cmd) == -2) {
				break;
			}else if(controlHandler.execute(cmd) == 4) {
				displayController.printMoveFromQ();
				String moveFrom = sc.nextLine();
				displayController.printMoveToQ();
				String moveTo = sc.nextLine();
				controlHandler.execute("TNext" + " " + moveFrom + " " + moveTo);
			}else if(controlHandler.execute(cmd) == 5) {
				displayController.printMoveToQ();
				String moveFrom = sc.nextLine();
				controlHandler.execute("WNext" + " " + moveFrom);
			}
			controlHandler.tabAutoFlip();
		}
		

	}

}
