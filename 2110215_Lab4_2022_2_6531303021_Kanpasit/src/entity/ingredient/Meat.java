package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;

public class Meat extends Ingredient implements Cookable,Choppable {
	
	private boolean chopState;
	private int cookedPercentage;
	
	public Meat() {
		super("Meat");
		this.setChopState(false);
		this.setCookedPercentage(0);
		
	}
	
	public void chop() {
		this.setChopState(true);
		this.setName("Minced Meat");
	}
	
	public boolean isChopped() {
		return this.chopState;
	}
	
	public void cook() {
		int cPT = this.getCookedPercentage();
		
		if (!this.isChopState()) {cPT += 10;
		if (cPT<= 50) {this.setName("Raw Meat"); this.setEdible(false);}
		else if(cPT<= 80) {this.setName("Medium Rare Steak"); this.setEdible(true);}
		else if(cPT<= 100) {this.setName("Well Done Steak"); this.setEdible(true);}
		else {this.setName("Burnt Steak"); this.setEdible(false);}
		
		}
		else {cPT += 15;
		if(cPT<= 80) {this.setName("Raw Burger"); this.setEdible(false);}
		else if(cPT<= 100) {this.setName("Cooked Burger"); this.setEdible(true);}
		else {this.setName("Burnt Burger"); this.setEdible(false);}}
		
		this.setCookedPercentage(cPT);
	}
	
	public boolean isBurnt() {
		return this.getCookedPercentage() > 100;
	}
	
	public String toString() {
		return this.getName() +" (" + this.getCookedPercentage() + "%)" ;
	}

	public boolean isChopState() {
		return chopState;
	}

	public void setChopState(boolean chopState) {
		this.chopState = chopState;
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}
	
	
	
}
