package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;

//You CAN modify the first line
public class ChangeColorCard extends EffectCard {
	public ChangeColorCard() {
		super(null, CardSymbol.CHANGE_COLOR);
	}

	@Override
	public String performEffect() {
			this.setColor(CardColor.RED);
		if (!gameInstance.getCurrentPlayerHand().isEmpty()
				&& gameInstance.getCurrentPlayerHand().get(0).getColor() != null) {
			this.setColor(gameInstance.getCurrentPlayerHand().get(0).getColor());
		}
		return "Set color to " + this.getColor().toString();
	}

	@Override
	public String toString() {
		if (this.getColor() != null) {
			return "CHANGE COLOR (" + this.getColor().toString() + " color selected)";
		}
		return "CHANGE COLOR";
	}

	@Override
	public boolean canPlay() {
		return true;
	}

}
