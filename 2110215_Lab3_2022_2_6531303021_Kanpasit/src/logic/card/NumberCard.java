package logic.card;

import logic.game.CardSymbol;
import logic.game.CardColor;

//You CAN modify the first line
public class NumberCard extends BaseCard {
	public NumberCard(CardColor color, CardSymbol symbol) {
		super(color, symbol);
	}

	@Override
	public String toString() {
		return this.getColor().toString() + " " + this.getSymbol().toString();
	}

	@Override
	public boolean canPlay() {
		return gameInstance.getTopCard().getColor().equals(this.getColor())
				|| gameInstance.getTopCard().getSymbol().equals(this.getSymbol());
	}

	@Override
	public String play() {
		gameInstance.setTopCard(this);
		gameInstance.getCurrentPlayerHand().remove(this);
		return null;
	}

}
