package logic;

public class ItemCounter {
	
	private Item item;
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
		//FILL CODE
		return this.getItem() + " x" + this.getCount();
	}
		// getter & setter
	public Item getItem() {
		//FILL CODE
		return this.item;
	}

	public void setItem(Item item){
		//FILL CODE
		this.item = item;
	}

	public int getCount() {
		//FILL CODE
		return this.amount;
	}

	public void setCount(int count) {
		//FILL CODE
		if(count >= 0)this.amount = count;
		else this.amount = 0;
	}
}
