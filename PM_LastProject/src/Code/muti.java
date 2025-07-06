package Code;

public class muti extends Thread {
	private String t;
	
	public muti(String t) {
		this.t = t;
	}

	public void run() {
		for(int i = 1;i <= 5 ; i++) {
			System.out.println(i +" from "+ t);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
