package logic;

import exception.NameBlankException;

public class Item extends Slot {

	private String itemName;
	private int price;

	// constructor
	protected Item(String itemName, int price) throws NameBlankException {
		this.setItemName(itemName);
		this.setPrice(price);
	}

	// methods
	public boolean equals(Item other) {
		return this.itemName.equals(other.itemName);

	}

	public String toString() {
		return this.itemName;
	}

	// getter & setter
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) throws NameBlankException {
		if (itemName.isBlank())
			throw new NameBlankException();
		else
			this.itemName = itemName;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = Math.max(0, price);
	}

}
