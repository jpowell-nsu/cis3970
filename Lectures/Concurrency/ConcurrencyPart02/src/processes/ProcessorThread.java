package processes;

public class ProcessorThread extends Thread {
	
	private int ID;
	
	public ProcessorThread(int ID) {
		this.ID = ID;
	}
	
	@Override
	public void run() {	// note: you cannot throw anything outside of run
		System.out.printf("ID=%d started, State=%s\n", ID, getState());
		try {
			looper();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void looper() throws InterruptedException {
		while (true) {		// infinite loop -- BAD PROGRAMMING!!! lol
			System.out.printf("ID=%d printing, State=%s\n", ID, getState());
			sleep(1000); 	// sleep thread for 1 second
		}
	}

}
