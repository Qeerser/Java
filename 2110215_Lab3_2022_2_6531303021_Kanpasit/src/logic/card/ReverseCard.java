package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.PlayDirection;

//You CAN modify the first line
public class ReverseCard extends EffectCard {

	public ReverseCard(CardColor color) {
		super(color, CardSymbol.REVERSE);
	}

	@Override
	public String performEffect() {
		PlayDirection newDirection = gameInstance.getPlayDirection().getOpposite();
		gameInstance.setPlayDirection(newDirection);
		return "Set direction to " + newDirection.toString();
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

}
