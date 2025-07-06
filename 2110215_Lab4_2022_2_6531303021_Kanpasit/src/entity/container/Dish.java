package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {
	private int dirty;
	
	public Dish() {
		super("Dish", 4);
		this.setDirty(0);
	}
	
	public Dish(int dirty) {
		super("Dish", 4);
		this.setDirty(dirty);
	}
	
	public boolean isDirty() {
		return this.getDirty() > 0 ;
	}
	
	public boolean verifyContent(Ingredient i) {
		return !this.isDirty() && i.isEdible();
	}
	
	public void clean(int amount) {
		this.setDirty(this.getDirty()-amount);
	}
	
	public int getDirty() {
		return dirty;
	}

	public void setDirty(int dirty) {
		this.dirty = Math.max(dirty, 0);
		if(this.isDirty())this.setName("Dirty Dish");
		else this.setName("Dish");
	}
	
	public String toString(){
		if(this.isDirty()) return StringUtil.formatNamePercentage(this.getName(), this.getDirty());
		return super.toString();
	}

}
