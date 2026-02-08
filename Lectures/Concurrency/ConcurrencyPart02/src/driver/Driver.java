package driver;

import processes.ProcessorThread;
import processes.ProcessorRunnable;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		int cpus = Runtime.getRuntime().availableProcessors();
		System.out.printf("Number of Processors = %d\n", cpus);
		System.out.printf("MIN  Priority = %d\n", Thread.MIN_PRIORITY);
		System.out.printf("NORM Priority = %d\n", Thread.NORM_PRIORITY);
		System.out.printf("MAX  Priority = %d\n", Thread.MAX_PRIORITY);
		
		ProcessorThread p1 = new ProcessorThread(1);
		ProcessorThread p2 = new ProcessorThread(2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.getState());
	/*	
		p1.start();
		p2.start();
		
		ProcessorRunnable p3 = new ProcessorRunnable(3);
		ProcessorRunnable p4 = new ProcessorRunnable(4);
		Thread thread3 = new Thread(p3);
		Thread thread4 = new Thread(p4);
		thread3.start();
		thread4.start();
		System.out.println(thread3);
		System.out.println(thread4);
		
		new ProcessorThread(5).run();
		
		Thread thread6 = new Thread(new ProcessorRunnable(6));
		thread6.start();
		new Thread(new ProcessorRunnable(7)).start();

		int ID = 8;
		new Thread() {
			@Override
			public void run() {
				System.out.printf("ID=%d started\n", ID);
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
		}.start();
*/		
		while (true) {
			System.out.printf("ID=%d printing\n", 0);
			Thread.sleep(1000);
		}

	}

}
