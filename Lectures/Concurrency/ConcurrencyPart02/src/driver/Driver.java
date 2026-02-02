package driver;

import processes.Processor1;
import processes.Processor2;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		int cpus = Runtime.getRuntime().availableProcessors();
		System.out.printf("Number of Processors = %d\n", cpus);
		System.out.printf("MIN  Priority = %d\n", Thread.MIN_PRIORITY);
		System.out.printf("NORM Priority = %d\n", Thread.NORM_PRIORITY);
		System.out.printf("MAX  Priority = %d\n", Thread.MAX_PRIORITY);
	/*	
		Processor1 p1 = new Processor1(1);
		Processor1 p2 = new Processor1(2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.getState());
		
		p1.start();
		p2.start();
		
		Processor2 p3 = new Processor2(3);
		Processor2 p4 = new Processor2(4);
		Thread thread3 = new Thread(p3);
		Thread thread4 = new Thread(p4);
		thread3.start();
		thread4.start();
		System.out.println(thread3);
		System.out.println(thread4);
		
		new Processor1(5).run();
		Thread thread6 = new Thread(new Processor2(6));
		thread6.start();
		new Thread(new Processor2(7)).start();
*/
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
		
		while (true) {
			System.out.printf("ID=%d printing\n", 0);
			Thread.sleep(1000);
		}

	}

}
