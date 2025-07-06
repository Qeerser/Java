package game;

public class SimpleDice {
	// 1) properties, fields

	public static final int MAX = 6;
	private int faceValue;
	String naam;

	// 2) actions, methods

	// 2.1) constructor
	public SimpleDice() {
		this.roll();
	}

	public SimpleDice(int faceValue) {
		this.faceValue = faceValue;
	}
	
	// 2.2) setter (modifier)
	public void setFaceValue(int faceValue) {
		if(faceValue > SimpleDice.MAX) this.faceValue = SimpleDice.MAX;
		else if (faceValue < 1) this.faceValue = 1;
		else this.faceValue = faceValue;
	}
	// 2.3) getter (accessor)
	public int getFaceValue() {
		return this.faceValue;
	}
	// 2.4) recommended methods
	public String toString() {
		return "My face value is "+this.faceValue;
	}
	// 2.5) general methods
	public int roll() {
		faceValue = (int) (Math.random() * MAX) + 1;
		return faceValue;
	}
}