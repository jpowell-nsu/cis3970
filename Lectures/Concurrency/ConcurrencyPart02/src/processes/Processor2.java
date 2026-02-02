package processes;

public class Processor2 implements Runnable {
	
	private int ID;
	
	public Processor2(int ID) {
		this.ID = ID;
	}
	
	@Override
	public void run() {	// note: you cannot throw anything outside of run
		System.out.printf("ID=%d started\n", ID);
		try {
			looper();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void looper() throws InterruptedException {
		while (true) {		// infinite loop -- BAD PROGRAMMING!!! lol
			System.out.printf("ID=%d printing\n", ID);
			Thread.sleep(1000); 	// sleep thread for 1 second
		}
	}

}
