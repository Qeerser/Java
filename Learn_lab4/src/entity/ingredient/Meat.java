package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Cookable, Choppable {
	private boolean chopState;
	private int cookedPercentage;
	
	public Meat() {
		super("Meat");
		this.chopState = false;
		this.cookedPercentage = 0;
		
	}
	
	public void chop() {
		if(!this.chopState) {
		this.chopState = true;
		super.setName("Minced Meat");}
	}

	public boolean isChopped() {
		return this.chopState;
	}

	public void cook() {
		if(!this.chopState) {
		cookedPercentage += 10;
		
		if(0 < cookedPercentage && cookedPercentage <= 50) {this.setName("Raw Meat");this.setEdible(false);}
		else if(50 < cookedPercentage && cookedPercentage <= 80) {this.setName("Medium Rare Steak");this.setEdible(true);}
		else if(80 < cookedPercentage && cookedPercentage <= 100){this.setName("Well Done Steak");this.setEdible(true);}
		else {this.setName("Burnt Steak");this.setEdible(false);}
		}
		else {
			cookedPercentage += 15;
			
			if(0 < cookedPercentage && cookedPercentage <= 80) {this.setName("Raw Burger");this.setEdible(false);}
			else if(80 < cookedPercentage && cookedPercentage <= 100){this.setName("Cooked Burger");this.setEdible(true);}
			else {this.setName("Burnt Burger");this.setEdible(false);}
		}
	}

	public boolean isBurnt() {
		return this.cookedPercentage > 100;
	}

	public String toString() {
		
		return StringUtil.formatNamePercentage(getName(), cookedPercentage);
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}
	
	

}
