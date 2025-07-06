package logic;

public class ItemCounter extends Slot {
	
	private Stackable item;
	private int amount;
	
	public ItemCounter(Item item){
		setItem(item);
		setCount(1);
	}
	
	public ItemCounter(Item item,int count) {
		setItem(item);
		if(count < 1) setCount(1);
		else setCount(count);
	}
	
	public String toString() {
		if (this.item instanceof Stackable) 
			return this.getItem() + " x" + this.getCount();
		else
			return this.getItem().toString();
	}
		// getter & setter
	public Item getItem() {
		return (Item) this.item;
	}

	public void setItem(Item item){
		this.item = (Stackable) item;
	}

	public int getCount() {
		return this.amount;
	}

	public void setCount(int count) {
		if(count >= 0)this.amount = count;
		else this.amount = 0;
	}
}
