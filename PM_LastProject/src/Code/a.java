package Code;

public class a {

	public static void main(String[] args) {
		Thread d = new Thread(()-> {
			for(int i = 1;i <= 5 ; i++) {
				System.out.println(i +" from ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}); 
		muti a = new muti("a");
		muti b = new muti("b");
		muti c = new muti("c");
		d.start();
		c.start();
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.start();
		b.start();
		
		
	}

}

