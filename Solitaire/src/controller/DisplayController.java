package controller;

import main.GameManager;

public class DisplayController {
	static GameManager gameManager = GameManager.getInstance();  
	private static final DisplayController instance = new DisplayController();  
	
	public static DisplayController getInstance() {
		return instance;
	}
	
	public void printboard() {

		System.out.printf("Card Remaining: %d,  Waste: %s, Socre: %d, Move: %d\n",
					stock.count(), waste.print(), scoreManager.getScore(), getMove());
		System.out.printf("Foundations: [%s] [%s] [%s] [%s]\n\n", foundate.get(0).print(), foundate.get(1).print(), foundate.get(2).print(), foundate.get(3).print());
		for(int i=0; i<7 ;i++) {
			System.out.printf("Tableau %d: [%s]\n", i+1, tab.get(i).print());
		}
		System.out.print("\n");
	}

	public void printLevel() {
		System.out.println("Please input the number to select the level:");
		System.out.println("1-Level 1");
		System.out.println("2-Level 2");
		System.out.println("3-Level 3");
	}
	
	public void printMoveFromQ() {
		System.out.print("Move From? ");
	}
	
	public void printMoveToQ() {
		System.out.print("Move To(0 for foundation)? ");
	}
	public void printQuitMessage() {
		System.out.println("Quited. Thank you for playing.");
	}
}
