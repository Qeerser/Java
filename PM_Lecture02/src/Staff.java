public class Staff implements Cloneable {
	//properties
	int id;
	String name;
	
	//constructor
	public Staff(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Staff(Staff other) {
		this(other.id, other.name)
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
		}
		return null;
	}
}
