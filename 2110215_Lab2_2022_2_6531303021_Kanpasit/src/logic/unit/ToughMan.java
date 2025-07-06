package logic.unit;

public class ToughMan extends BaseCompetitor {
	private int maxHp;

	public ToughMan(String name) {
		super(name);
		this.setHp(8);
		this.setPower(4);
		this.setMaxHp(8);
	}

	public ToughMan(String name, int hp, int power) {
		super(name, hp, power);
		this.setMaxHp(hp);
	}

	public void heal(int healHp) {
		if (healHp > 0)
			this.setHp(this.getHp() + healHp);
		if (this.getHp() > this.maxHp)
			this.setHp(maxHp);
	}

	public void attack(BaseCompetitor enemy) {
		int a;
		if (enemy.getType().equals("Sorcerer"))
			a = 1;
		else if (enemy.getType().equals("ToughMan") || enemy.getType().equals("BaseCompetitor") )
			a = 2;
		else
			a = 3;
		enemy.setHp(enemy.getHp() - (a * this.getPower() / 2));
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		if (maxHp < 0) {
			this.maxHp = 0;
			this.setHp(0);
		}
		else {this.maxHp = maxHp;}
		if (this.getHp() > this.maxHp)
			this.setHp(maxHp);
		;
	}

}
