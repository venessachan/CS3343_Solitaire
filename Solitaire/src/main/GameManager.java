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
	
	private static GameManager instance = new GameManager();

	private Deck deck;
	private List<Tableau> tab;
	private Stock stock;
	private Waste waste;
	private List<Foundation> foundate;
	
	private GameManager(){
		start();
	}
	
	private void start() {
		long seed = System.currentTimeMillis();		//every games have different see
		
		//Deck
		deck = new Deck();
		deck.shuffle(seed);//seed
		
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
	
	
	public boolean isWin() {
		if(foundate.get(0).full() 
			&& foundate.get(1).full()
			&& foundate.get(2).full()
			&& foundate.get(3).full()) {
			return true;
		}
		return false;
	}
	
	public void printboard() {

		System.out.printf("Card Remaining: %d,  Waste: %s\n", stock.count(), waste.print());
		System.out.printf("Foundations: [%s] [%s] [%s] [%s]\n\n", foundate.get(0).print(), foundate.get(1).print(), foundate.get(2).print(), foundate.get(3).print());
		for(int i=0; i<7 ;i++) {
			System.out.printf("Tableau %d: [%s]\n", i+1, tab.get(i).print());
		}
		System.out.print("\n");
	}
	

	public static GameManager getInstance() {
		return instance;
	}
	
	public Deck getDeck() {
		return deck;
	}

	public List<Tableau> getTab() {
		return tab;
	}

	public Stock getStock() {
		return stock;
	}

	public Waste getWaste() {
		return waste;
	}

	public List<Foundation> getFoundate() {
		return foundate;
	}
	

	
	
}
