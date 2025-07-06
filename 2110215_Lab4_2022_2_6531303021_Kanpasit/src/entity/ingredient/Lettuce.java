package entity.ingredient;

import entity.base.Choppable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable {
	private boolean chopState;
	
	public Lettuce() {
		super("Lettuce");
		super.setEdible(true);
		chopState = false;
	}
	
	public void chop() {
		chopState = true;
		this.setName("Chopped Lettuce");
	}
	
	public boolean isChopped() {
		return chopState;
	}

}
