package logic.unit;

public class Sorcerer extends BaseCompetitor {

	public Sorcerer(String name) {
		super(name);
		this.setPower(2);
		this.setHp(4);
	}

	public Sorcerer(String name, int hp, int power) {
		super(name, hp, power);
	}

	public void lowerPower(BaseCompetitor enemy, int powerDown) {
		if (powerDown > 0)
			enemy.setPower(enemy.getPower() - powerDown);
	}

	public void attack(BaseCompetitor enemy) {
		int a;
		if (enemy.getType().equals("Tiger"))
			a = 1;
		else if (enemy.getType().equals("Sorcerer") || enemy.getType().equals("BaseCompetitor"))
			a = 2;
		else
			a = 3;
		enemy.setHp(enemy.getHp() - (a * this.getPower() / 2));
	}
}
