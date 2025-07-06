package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;

//You CAN modify the first line
public class SkipCard extends EffectCard {

	public SkipCard(CardColor color) {
		super(color, CardSymbol.SKIP);
	}

	@Override
	public String performEffect() {
		gameInstance.goToNextPlayer();
		while (gameInstance.getCurrentPlayerHand().size() == 0) {
			gameInstance.goToNextPlayer();
		}
		return "Skipped player " + gameInstance.getCurrentPlayer();
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
