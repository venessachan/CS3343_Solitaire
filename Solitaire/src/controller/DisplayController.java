package controller;

import main.GameManager;

public class DisplayController {
	static GameManager gameManager = GameManager.getInstance();  
	private static final DisplayController instance = new DisplayController();  
	
	public static DisplayController getInstance() {
		return instance;
	}
	
	public void printboard(int stockCount, String wasteCard, int score, int move, String[] foundations, String[] tableaus) {

		System.out.printf("Card Remaining: %d,  Waste: %s, Socre: %d, Move: %d\n",
					stockCount, wasteCard, score, move);
		
		System.out.print("Foundations: ");
		for(int i = 0; i < 4; i++) {
			System.out.printf("[%s] ", foundations[i]);
		}
		System.out.print("\n\n");
		
		for(int i=0; i<7 ;i++) {
			System.out.printf("Tableau %d: [%s]\n", i+1, tableaus[i]);
		}
		System.out.print("\n");
	}

//	public void printLevel() {
//		System.out.println("Please input the number to select the level:");
//		System.out.println("1-Level 1");
//		System.out.println("2-Level 2");
//		System.out.println("3-Level 3");
//	}
	
	public void printMoveFromQ() {
		System.out.print("Move From? ");
	}
	
	public void printMoveToQ() {
		System.out.print("Move To(0 for foundation)? ");
	}
	
	public void printQuitMessage() {
		System.out.println("Quited. Thank you for playing.");
	}
	
	public void printInvalidMove() {
		System.out.print("Move invalid.\n\n");
	}
	
	public void printInputReminder1() {
		System.out.print("Please input a valid command.\n\n");
	}
	
	public void printInputReminder2() {
		System.out.print("Please input a valid range 0-6.\n\n");
	}
}
