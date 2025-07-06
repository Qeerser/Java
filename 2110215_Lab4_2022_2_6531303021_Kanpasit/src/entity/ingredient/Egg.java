package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;

public class Egg extends Ingredient implements Cookable{
	private int cookedPercentage;
	
	public Egg() {
		super("Egg");
		this.setCookedPercentage(0);
	}
	
	public void cook() {
		this.setCookedPercentage(this.getCookedPercentage() + 12);
		int cPT = this.getCookedPercentage();
		if (cPT<= 50) {this.setName("Raw Egg"); this.setEdible(false);}
		else if(cPT<= 80) {this.setName("Sunny Side Egg"); this.setEdible(true);}
		else if(cPT<= 100) {this.setName("Fried Egg"); this.setEdible(true);}
		else {this.setName("Burnt Egg"); this.setEdible(false);}
	}
	
	public boolean isBurnt() {
		return this.getCookedPercentage() > 100;
	}
	
	public String toString() {
		return this.getName() +" (" + this.getCookedPercentage() + "%)" ;
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}
}
