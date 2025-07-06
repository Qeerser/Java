package Player;

import exception.NameBlankException;
import logic.Item;

public class Armour extends Item {

	protected Armour(String itemName, int price) throws NameBlankException {
		super(itemName, price);
	}

}
