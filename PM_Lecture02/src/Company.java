
public class Company {

	public static void main(String[] args) {
		Staff s1 = new Staff(1,"Lisa");
		
		Staff s2 = new Staff(s1.id,s1.name);
		
		Staff s3 = (Staff) s1.clone();
		
		Staff s4 = new Staff(s1);
	}

}
