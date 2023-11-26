package main;

import java.util.Scanner;

import controller.ControlHandler;
import controller.DisplayController;

public class Main {
	
	public static void main(String[] args) {
		ControlHandler controlHandler = ControlHandler.getInstance();
		DisplayController displayController = DisplayController.getInstance();
		System.out.println("Start Game?");
		System.out.println("(Y)es, (N)o");
		Scanner sc = new Scanner(System.in);
		String isStart = sc.nextLine();
		isStart.split(" ");
		if(isStart.equals("Y")) {
			controlHandler.execute("S");
			while(true) {
				//displayController.printLevel();
				//print start? if-else
				
				
				System.out.println("(D)eal, (W)aste, (T)ableau, (Q)uit");
				String cmd = sc.nextLine();
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
		}
		
		
		
		

	}

}
