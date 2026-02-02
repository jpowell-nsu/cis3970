package driver;

import processes.PrimeCounter;

public class Driver {

	public static void main(String[] args) {
		PrimeCounter pc1 = new PrimeCounter(1, 20000000);
		PrimeCounter pc2 = new PrimeCounter(20000001, 40000000);
		PrimeCounter pc3 = new PrimeCounter(40000001, 60000000);
		PrimeCounter pc4 = new PrimeCounter(60000001, 80000000);
		
		Thread t1 = new Thread(pc1);
		Thread t2 = new Thread(pc2);
		Thread t3 = new Thread(pc3);
		Thread t4 = new Thread(pc4);
		
		t1.setPriority(10);
		t2.setPriority(10);
		t3.setPriority(10);
		t4.setPriority(1);
				
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println("Waiting for threads...");
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Total=" + (pc1.getCount() 
				+ pc2.getCount() 
				+ pc3.getCount() 
				+ pc4.getCount()));
		System.out.println("Threads are done.");			

	}

}
