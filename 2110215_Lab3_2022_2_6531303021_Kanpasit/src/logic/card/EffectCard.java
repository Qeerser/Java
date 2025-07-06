package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;

//You CAN modify the first line
public abstract class EffectCard extends BaseCard {

	public EffectCard(CardColor color, CardSymbol symbol) {
		super(color, symbol);
	}

	public abstract String performEffect();

	public String play() {
		gameInstance.setTopCard(this);
		gameInstance.getCurrentPlayerHand().remove(this);
		return this.performEffect();
	}

}
