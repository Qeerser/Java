package logic.card;

import logic.game.CardSymbol;
import logic.game.GameLogic;
import logic.game.CardColor;

public abstract class BaseCard {
	private CardColor color;
	private CardSymbol symbol;
	protected GameLogic gameInstance = GameLogic.getInstance();

	public BaseCard(CardColor color, CardSymbol symbol) {
		this.color = color;
		this.symbol = symbol;
	}

	@Override
	public abstract String toString();

	public abstract boolean canPlay();

	public abstract String play();

	public CardColor getColor() {
		return color;
	}

	public void setColor(CardColor color) {
		this.color = color;
	}

	public CardSymbol getSymbol() {
		return symbol;
	}

	public void setSymbol(CardSymbol symbol) {
		this.symbol = symbol;
	}

}
