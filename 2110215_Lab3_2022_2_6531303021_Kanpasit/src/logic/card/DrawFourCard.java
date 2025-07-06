package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;

//You CAN modify the first line
public class DrawFourCard extends EffectCard {

	public DrawFourCard() {
		super(null, CardSymbol.DRAW_FOUR);
	}

	@Override
	public String performEffect() {

		Boolean nowDraw = true;
		BaseCard nowCard = null;
		gameInstance.incrementDrawAmount(4);

		if (gameInstance.getCurrentPlayerHand().isEmpty()) {
			this.setColor(CardColor.RED);
		} else if (gameInstance.getCurrentPlayerHand().get(0).getColor() == null) {
			this.setColor(CardColor.RED);
		} else {
			this.setColor(gameInstance.getCurrentPlayerHand().get(0).getColor());
		}

		gameInstance.setTopCard(this);
		gameInstance.goToNextPlayer();

		while (gameInstance.getCurrentPlayerHand().size() == 0)
			gameInstance.goToNextPlayer();

		for (BaseCard onHand : gameInstance.getCurrentPlayerHand()) {
			nowCard = onHand;
			if (nowCard.getSymbol() == CardSymbol.DRAW_FOUR) {
				nowDraw = false;
				break;
			}

		}

		String setColor = "Set color to " + gameInstance.getTopCard().getColor() + "\n";
		String message = "Player " + gameInstance.getCurrentPlayer() + " played DRAW FOUR. "
				+ (gameInstance.getCurrentPlayerHand().size() - 1) + " cards remaining.\n";

		if (!nowDraw) {
			return setColor + message + nowCard.play();
		} else {
			int drawAmount = gameInstance.getDrawAmount();
			gameInstance.getCurrentPlayerHand().addAll(gameInstance.draw(drawAmount));
			gameInstance.setDrawAmount(0);
			return setColor + "Player " + gameInstance.getCurrentPlayer() + " drew " + drawAmount + " cards. "
					+ gameInstance.getCurrentPlayerHand().size() + " cards remaining.";
		}
	}

	@Override
	public String toString() {
		if (this.getColor() != null) {
			return "DRAW FOUR (" + this.getColor().toString() + " color selected)";
		}
		return "DRAW FOUR";
	}

	@Override
	public boolean canPlay() {
		return true;
	}

}
