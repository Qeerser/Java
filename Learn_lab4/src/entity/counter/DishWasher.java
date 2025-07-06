package entity.counter;


import entity.base.Updatable;
import entity.container.Dish;
import logic.Player;

public class DishWasher extends Counter implements Updatable {

	public DishWasher() {
		super("Dish Washer");
		
	}
	public void interact(Player p) {
		if(!this.isPlacedContentEmpty()||((p.getHoldingItem() instanceof Dish) && ((Dish)p.getHoldingItem()).isDirty() ) )super.interact(p);

		}

	@Override
	public void update() {
		if(this.getPlacedContent() instanceof Dish)((Dish)this.getPlacedContent()).clean(15);

	}

}

