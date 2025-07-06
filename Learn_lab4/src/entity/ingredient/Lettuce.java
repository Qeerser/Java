package entity.ingredient;

import entity.base.Choppable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable {
	private boolean chopState;
	
	public Lettuce() {
		super("Lettuce");
		super.setEdible(true);
		this.chopState = false;
	}

	public void chop() {
		if(!this.chopState) {
		this.chopState = true;
		super.setName("Chopped Lettuce");
		}
	}

	public boolean isChopped() {
		return this.chopState;
	}
	
	
}
