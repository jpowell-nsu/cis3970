package driver;

import processors.PrimeCounter;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		PrimeCounter pc1 = new PrimeCounter(1, 50000000);
		PrimeCounter pc2 = new PrimeCounter(1, 50000000);
		PrimeCounter pc3 = new PrimeCounter(1, 50000000);
		PrimeCounter pc4 = new PrimeCounter(1, 50000000);
		
		pc1.setPriority(10);
		pc2.setPriority(10);
		pc3.setPriority(10);
		pc4.setPriority(1);
		
		pc1.start();
		pc2.start();
		pc3.start();
		pc4.start();
		
		System.out.println("Waiting for threads...");
		try {
			pc1.join(); // blocks until pc1 joins, even if the others finish first
			pc2.join();
			pc3.join();
			pc4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		System.out.println(pc1 + " " +  pc1.getTime());
		System.out.println(pc2 + " " +  pc2.getTime());
		System.out.println(pc3 + " " +  pc3.getTime());
		System.out.println(pc4 + " " +  pc4.getTime());
		
		System.out.println("Total=" + (pc1.getCount() 
									+ pc2.getCount() 
									+ pc3.getCount() 
									+ pc4.getCount()));
		System.out.println("Threads are done.");			

		PrimeCounter[] pool = new PrimeCounter[5];
		for (int i = 0; i < pool.length; i++) {
			pool[i] = new PrimeCounter(1, 50000000);
			pool[i].start();

			//(pool[i] = new PrimeCounter(1, 50000000)).start();
		}

		for (PrimeCounter pc : pool) {
			pc.join();
			System.out.println(pc + " " +  pc.getTime());
		}
	}

}
