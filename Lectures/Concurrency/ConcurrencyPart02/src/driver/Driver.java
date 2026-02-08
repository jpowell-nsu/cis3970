package driver;

import processes.Processor;

public class Driver {

	public static void main(String[] args) throws InterruptedException {

		//Runtime.getRuntime().
		int cpus = Runtime.getRuntime().availableProcessors();
		System.out.printf("Number of Processors = %d\n", cpus);

		//Thread.
		System.out.printf("MIN  Priority = %d\n", Thread.MIN_PRIORITY);
		System.out.printf("NORM Priority = %d\n", Thread.NORM_PRIORITY);
		System.out.printf("MAX  Priority = %d\n", Thread.MAX_PRIORITY);
		
		Processor p1 = new Processor(1);
		Processor p2 = new Processor(2);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.getState());
	
		//p1.run();
		p1.start();
		p2.start();

		while (true) {
			System.out.printf("ID=main printing\n");
			Thread.sleep(1000);
		}
		
/*
		// as an anonymous object
		new Processor(3).start(); 

		// as an anonymous class
		int ID = 4;
		new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.printf("%s ID=%d printing, State=%s\n", this, ID, getState());
						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
*/
	}
	
}
