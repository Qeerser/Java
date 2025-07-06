package logic.unit;

public class Tiger extends BaseCompetitor {

	public Tiger(String name) {
		super(name);
		this.setPower(5);
		this.setHp(7);
	}

	public Tiger(String name, int hp, int power) {
		super(name, hp, power);

	}

	public void train(int addPower) {
		if (addPower > 0)
			this.setPower(this.getPower() + addPower);
	}

	public void attack(BaseCompetitor enemy) {
		int a;
		if (enemy.getType().equals("ToughMan"))
			a = 1;
		else if (enemy.getType().equals("Tiger") || enemy.getType().equals("BaseCompetitor"))
			a = 2;
		else
			a = 3;
		enemy.setHp(enemy.getHp() - (a * this.getPower() / 2));
	}

}
