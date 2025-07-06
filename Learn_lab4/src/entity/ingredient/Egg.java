package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;

public class Egg extends Ingredient implements Cookable {
	private int cookedPercentage;
	
	public Egg() {
		super("Egg");
		this.cookedPercentage = 0;
	}

	public void cook() {
		cookedPercentage += 12;
		
		if(0 < cookedPercentage && cookedPercentage <= 50) {this.setName("Raw Egg");this.setEdible(false);}
		else if(50 < cookedPercentage && cookedPercentage <= 80) {this.setName("Sunny Side Egg");this.setEdible(true);}
		else if(80 < cookedPercentage && cookedPercentage <= 100){this.setName("Fried Egg");this.setEdible(true);}
		else {this.setName("Burnt Egg");this.setEdible(false);}
	}

	public boolean isBurnt() {
		return this.cookedPercentage > 100;
	}

	public String toString() {
		return this.getName() +" (" + cookedPercentage + "%)";
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}
	
}
