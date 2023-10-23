package main;

import java.util.ArrayList;
import java.util.List;

import card.Card;
import card.Deck;
import card.Suit;
import stackManager.Foundation;
import stackManager.Stock;
import stackManager.Tableau;
import stackManager.Waste;

public class GameManager {
	
	private Deck deck;
	private List<Tableau> tab;
	private Stock stock;
	private Waste waste;
	private List<Foundation> foundate;
	
	public GameManager(){
		start();
	}
	
	private void start() {
		long seed = System.currentTimeMillis();		//every games have different see
		
		//Deck
		deck = new Deck();
		deck.shuffle(0);//seed
		
		//Foundation
		foundate = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			foundate.add(new Foundation (suit));
		}
		
		//Stock
		stock = new Stock();
		stock.setStock(deck.getCards());
		
		//Tableau
		tab = new ArrayList<>();
		for(int i=1;i<=7;i++) {
			Tableau t = new Tableau();
			List<Card> temp= new ArrayList<>();
			for(int j=1; j<=i;j++) {
				temp.add(stock.pop());
			}
			t.put(temp);
			tab.add(t);
		}
		
		//Waste
		waste = new Waste();
		tabAutoFlip();
	}
	
	public void tabAutoFlip(){
		for(Tableau t: tab) {
			if(!t.empty() && !(t.peek().getShow())) 
				t.peek().setShow(true);
		}
	}
	
	public void dealFromStock() {
		
		if(stock.empty()) {
			for(Card wastedCard: waste.getCardList()) {
				stock.push(wastedCard);
				wastedCard.setShow(false);
			}
			waste.getCardList().clear();
		}
		
		Card c = stock.pop();
		c.setShow(true);
		waste.push(c);
		
	}
	
	public boolean isWin() {
		if(foundate.get(0).full() 
			&& foundate.get(1).full()
			&& foundate.get(2).full()
			&& foundate.get(3).full()) {
			return true;
		}
		return false;
	}
	
	public void moveToFoundation(int moveFrom) {
		//Check from waste or not
		Card c;
		if(moveFrom != 0) {
			c= tab.get(moveFrom-1).peek();
		}else {
			c= waste.peak();
		}
		
		boolean isPut =false;
		if(foundate.get(0).checkValidAction(c)) {
			foundate.get(0).push(c);
			isPut = true;
		}
		else if(foundate.get(1).checkValidAction(c)) {
			foundate.get(1).push(c);
			isPut = true;
		}
		else if(foundate.get(2).checkValidAction(c)) {
			foundate.get(2).push(c);
			isPut = true;
		}
		else if(foundate.get(3).checkValidAction(c)) {
			foundate.get(3).push(c);
			isPut = true;
		}
		else
			isPut = false;
			
		
		if(isPut) {
			if(moveFrom != 0) 
				tab.get(moveFrom-1).pop();
			else
				waste.pop();
			System.out.printf("Move successful\n");
		}else {
			System.out.printf("Move invalid\n");
		}
	}
	
	public void moveTableau(int moveFrom, int moveTo) {
		
		Tableau tabFrom = tab.get(moveFrom-1);
		Tableau tabTo = tab.get(moveTo-1);
		
		if(tabFrom.empty()) {
			System.out.printf("Move invalid\n");
			return;
		}
	
		int tabIndex=0;
		for(Card c: tabFrom.getCardList()) {
			if(c.getShow())
				break;
			tabIndex++;
		}
		
		boolean isPut = false;
		while(tabIndex < tabFrom.getCardList().size()) {
			Card cardFrom = tabFrom.getCardList().get(tabIndex);
			if(tabTo.checkValidAction(cardFrom)) {
				isPut = true;
				break;
			}
			tabIndex ++;
		}
		
		if(isPut) {
			
			List<Card> range = tabFrom.getCardList().subList(tabIndex, tabFrom.getCardList().size());
			tabTo.put(range);
			
			int times = range.size();
			
			for(int i=0; i<times;i++) {
				tabFrom.pop();
			}
			
			System.out.printf("Move successful\n");
			
		}else {
			System.out.printf("Move invalid\n");
		}
	
	}
	
	public void wasteToTableau(int moveTo){
		
		Tableau tabTo = tab.get(moveTo-1);
		if(waste.empty()) {
			System.out.printf("Move invalid\n");
			return;
		}
		
		boolean isPut = false;
		if(tabTo.checkValidAction(waste.peak())) 
			isPut = true;
		
		if(isPut) {
			
			List<Card> range = new ArrayList<>();
			range.add(waste.peak());
			tabTo.put(range);
			
			waste.pop();
			
			System.out.printf("Move successful\n");
			
		}else {
			System.out.printf("Move invalid\n");
		}
	
		
	}
	
	public void printboard() {
		System.out.printf("Card Remaining: %d,  Waste: %s\n", stock.count(), waste.print());
		System.out.printf("Foundations: [%s] [%s] [%s] [%s]\n\n", foundate.get(0).print(), foundate.get(1).print(), foundate.get(2).print(), foundate.get(3).print());
		for(int i=0; i<7 ;i++) {
			System.out.printf("Tableau %d: [%s]\n", i+1, tab.get(i).print());
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		GameManager g = new GameManager();
//		while(g.isWin()) {
//			g.printboard();
//			System.out.print("(U)ndo, (D)eal, Move from (T)ableau, Move from (W)aste, or (Q)uit:");
//		}
	}
	
}
