package main;

import java.util.Scanner;

import controller.ControlHandler;
import controller.DisplayController;


public class Main {
	
	public static void main(String[] args) {
		ControlHandler controlHandler = ControlHandler.getInstance();
		DisplayController displayController = DisplayController.getInstance();

		while(true) {
			displayController.printStartGame();
			Scanner sc = new Scanner(System.in);
			String isStart = sc.nextLine();
			isStart.split(" ");
			if(isStart.equals("Y")) {
				controlHandler.execute("S");
				while(true) {
					displayController.printInstruction();
					String cmd = sc.nextLine();
					System.out.println();
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
					else if(controlHandler.execute(cmd) == -15) {	//Q -15
						break;
					}
					controlHandler.tabAutoFlip();
				}
			}else if(isStart.equals("Q")) {
				System.exit(0);
			}
		}
		
		
		

	}

}
