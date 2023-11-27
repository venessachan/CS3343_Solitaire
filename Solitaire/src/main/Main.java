package main;

import java.util.Scanner;

import controller.ControlHandler;
import controller.DisplayController;

public class Main {
	
	public static void main(String[] args) {
		ControlHandler controlHandler = ControlHandler.getInstance();
		DisplayController displayController = DisplayController.getInstance();
		
		while(true) {
			System.out.println("Start Game?");
			System.out.println("(Y)es, (N)o, (Q)uit");
			Scanner sc = new Scanner(System.in);
			String isStart = sc.nextLine();
			isStart.split(" ");
			if(isStart.equals("Y")) {
				controlHandler.execute("S");
				while(true) {
					//displayController.printLevel();
					//print start? if-else
					System.out.println("Please input a letter for your action:");
					System.out.println("(D)eal, (W)aste, (T)ableau, (U)ndo, (Q)uit");
					String cmd = sc.nextLine();
					System.out.println();
					//-2 (Q)
					
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
					else if(controlHandler.execute(cmd) == -15) {
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
