package controller;

import java.util.List;

import main.GameManager;
import stackManager.Foundation;
import stackManager.Tableau;

public class DisplayController {
	static GameManager gameManager = GameManager.getInstance();  
	private static final DisplayController instance = new DisplayController();  
	
	public static DisplayController getInstance() {
		return instance;
	}
	
	public void printboard(int stockCount, String wasteCard, int score, int move, List<Foundation> foundations, List<Tableau> tableaus) {

		System.out.printf("Card Remaining: %d,  Waste: %s, Socre: %d, Move: %d\n",
					stockCount, wasteCard, score, move);
		
		System.out.print("Foundations: ");
		for(int i = 0; i < 4; i++) {
			System.out.printf("[%s] ", foundations.get(i).print());
		}
		System.out.print("\n\n");
		
		for(int i=0; i<7 ;i++) {
			System.out.printf("Tableau %d: [%s]\n", i+1, tableaus.get(i).print());
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
	
	public void printValidMove() {
		System.out.printf("Move successful.\n\n");
	}
	
	public void printInvalidMove() {
		System.out.print("Invalid move.\n\n");
	}
	
	public void printInvalidUndo() {
		System.out.print("Invalid undo.\n\n");
	}
	
	public void printInvalidRedo() {
		System.out.print("Nothing redo can execute.\n\n");
	}
	
	public void printInputReminder1() {
		System.out.print("Please input a valid command.\n\n");
	}
	
	public void printInputReminder2() {
		System.out.print("Please input a valid range 0-7.\n\n");
	}
	
	public void printAddCardToWaste() {
		System.out.print("A card added to Waste. \n\n");
	}
	
	public void printNoCardDeal() {
		System.out.print("There is no card can be deal. \n\n");
	}
}
