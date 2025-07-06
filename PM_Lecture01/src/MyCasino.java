import game.SimpleDice;

// peerapon
public class MyCasino {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDice d1 = new SimpleDice();
		SimpleDice d2 = new SimpleDice(2);
		d1.setFaceValue(1000);
		System.out.println(d1);
		System.out.println(d2);
	}

}
