package Player;

import exception.NameBlankException;
import logic.Item;
import logic.Stackable;

public class Potions extends Item implements Stackable {

	protected Potions(String itemName, int price) throws NameBlankException {
		super(itemName, price);
		
	}

}
