package logic;

import java.util.ArrayList;

public class Inventory {
	
	//fields
	private String playerName;
	private int money;
	private ArrayList<ItemCounter> items;
	
	//constructors
	public Inventory(String playerName) {
		//FILL CODE
	}
	
	public Inventory(String playerName, int money) {
		//FILL CODE
	}
	
	public Inventory(String playerName, int money, ArrayList<ItemCounter> items) {
		//FILL CODE
	}
	
	//methods
	public String toString() {
		if (items.size() == 0) {
			return "EMPTY INVENTORY";
		}
		String out = "\n";
		for (int i=0; i<items.size(); i++) {
			out += i+1;
			out += ". ";
			out += items.get(i).toString();
			out += "\n";
		}
		return out;
	}
	public boolean existsInInventory(Item item) {
		//FILL CODE
	}

	public void addItem(Item newItem, int count){
		//FILL CODE
	}

	public void removeItem(Item toRemove, int count) {

		// if the amount is zero or negative, just return. nothing is removed.
		if (count <= 0)
			return;

		ItemCounter removeIfNeg = null;

		for (ItemCounter ic : items) {
			if (ic.getItem().equals(toRemove)) {
				// Remove the card equal to count.
				ic.setCount(ic.getCount() - count);
				removeIfNeg = ic;
			}
		}

		// If removeIfNeg isn't null (meaning something got removed) then we need to
		// check if it is negative.
		if (removeIfNeg != null) {
			// If it goes into the negative, then remove this entry from the deck entirely.
			// You cannot modify a for loop while it's inside, so this has to be done
			// outside.
			if (removeIfNeg.getCount() <= 0) {
				items.remove(removeIfNeg);
			}
		}

	}
	

	//getters setters
	//FILL CODE
	// V
	// V
	
}
