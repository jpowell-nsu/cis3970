package driver;

import processes.Processor;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		
		Processor p1 = new Processor(1);
		Processor p2 = new Processor(2);
		
		System.out.println(p1);
		System.out.println(p2);
		//System.out.println(p1.getState());
	
		//p1.start();
		//p2.start();
	
		Thread thread1 = new Thread(p1);
		Thread thread2 = new Thread(p2);
		thread1.start();
		thread2.start();
		System.out.println(thread1);
		System.out.println(thread2);

		Thread thread6 = new Thread(new Processor(3));
		thread6.start();
		
		new Thread(new Processor(4)).start();

		int ID = 5;
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
		
		// notice that main is finished, but the threads keep going

	}

}
