package processes;

public class Processor implements Runnable {
	
	private int ID;
	
	public Processor(int ID) {
		this.ID = ID;
	}
	
	@Override
	public void run() {
		System.out.printf("%s ID=%d started, State=%s\n", 
				Thread.currentThread().toString(),
				ID, 
				Thread.currentThread().getState());
		try {
			looper();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void looper() throws InterruptedException {
		while (true) {	// infinite loop -- BAD PROGRAMMING!!! lol
			System.out.printf("%s ID=%d printing, State=%s\n", 
					Thread.currentThread().toString(), 
					ID, 
					Thread.currentThread().getState());
			Thread.sleep(1000);	// sleep thread for 1 second
		}
	}

}
