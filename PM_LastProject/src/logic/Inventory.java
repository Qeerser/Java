package logic;

import java.util.ArrayList;

public class Inventory {

	// fields
	private String playerName;
	private int money;
	private ArrayList<Slot> items;

	// constructors
	public Inventory(String playerName) {
		// FILL CODE
		setPlayerName(playerName);
		setMoney(0);
		setItems(new ArrayList<ItemCounter>());
	}

	public Inventory(String playerName, int money) {
		// FILL CODE
		setPlayerName(playerName);
		setMoney(money);
		setItems(new ArrayList<ItemCounter>());
	}

	public Inventory(String playerName, int money, ArrayList<ItemCounter> items) {
		// FILL CODE
		setPlayerName(playerName);
		setMoney(money);
		setItems(items);
	}

	// methods
	public String toString() {
		if (items.size() == 0) {
			return "EMPTY INVENTORY";
		}
		String out = "\n";
		for (int i = 0; i < items.size(); i++) {
			out += i + 1;
			out += ". ";
			out += items.get(i).toString();
			out += "\n";
		}
		return out;
	}

	public boolean existsInInventory(Item item) {
		// FILL CODE
		for (Slot ic : items) {
			if (ic.getItem().equals(item)) {
				// Remove the card equal to count.
				if (ic.getCount() > 0)
					return true;
			}
		}
		return false;
	}

	public void addItem(Item newItem, int count) {
		// FILL CODE
		if (this.existsInInventory(newItem))
			for (ItemCounter ic : items) {
				if (ic.getItem().equals(newItem)) {
					// Remove the card equal to count.
					ic.setCount(ic.getCount() + count);
				}
			}
		else
			this.items.add(new ItemCounter(newItem, count));
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

	// getters setters
	public void setItems(ArrayList<Slot> items) {
		this.items = items;
	}

	public void setPlayerName(String playerName) {
		if (playerName.isBlank())
			this.playerName = "Untitled Player";
		else
			this.playerName = playerName;
	}

	public void setMoney(int money) {
		this.money = Math.max(money, 0);
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public int getMoney() {
		return this.money;
	}

	public ArrayList<Slot> getItems() {
		return this.items;
	}
}
