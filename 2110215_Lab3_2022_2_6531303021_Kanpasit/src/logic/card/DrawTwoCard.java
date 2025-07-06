package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;

//You CAN modify the first line
public class DrawTwoCard extends EffectCard {

	public DrawTwoCard(CardColor color) {
		super(color, CardSymbol.DRAW_TWO);
	}

	@Override
	public String performEffect() {

		Boolean nowDraw = true;
		BaseCard nowCard = null;

		gameInstance.incrementDrawAmount(2);
		gameInstance.goToNextPlayer();

		while (gameInstance.getCurrentPlayerHand().size() == 0)
			gameInstance.goToNextPlayer();

		for (BaseCard onHand : gameInstance.getCurrentPlayerHand()) {
			nowCard = onHand;
			if (nowCard.getSymbol() == CardSymbol.DRAW_TWO || nowCard.getSymbol() == CardSymbol.DRAW_FOUR) {
				nowDraw = false;
				break;
			}

		}

		String message = "Player " + gameInstance.getCurrentPlayer() + " played " + nowCard.toString() + ". "
				+ (gameInstance.getCurrentPlayerHand().size() - 1) + " cards remaining.\n";

		if (!nowDraw) {
			return message + nowCard.play();
		} else {
			int drawAmount = gameInstance.getDrawAmount();
			gameInstance.getCurrentPlayerHand().addAll(gameInstance.draw(drawAmount));
			gameInstance.setDrawAmount(0);
			return "Player " + gameInstance.getCurrentPlayer() + " drew " + drawAmount + " cards. "
					+ gameInstance.getCurrentPlayerHand().size() + " cards remaining.";
		}

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
