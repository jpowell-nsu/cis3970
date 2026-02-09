package driver;

import processors.PrimeCounter;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		
		PrimeCounter pc = new PrimeCounter(1, 50000000);
		Thread vt = Thread.ofVirtual().start(pc);
		vt.join();
		System.out.println(pc + " " +  pc.getTime());

		PrimeCounter[] pool = new PrimeCounter[5];
		Thread[] vtpool = new Thread[5];
		for (int i = 0; i < vtpool.length; i++) {
			pool[i] = new PrimeCounter(1, 50000000);
			vtpool[i] = Thread.ofVirtual().start(pool[i]);
			
//			vtpool[i] = Thread.ofVirtual().start(pool[i] = new PrimeCounter(1, 50000000));
		}
	
		for (int i = 0; i < vtpool.length; i++) {
			vtpool[i].join();
			System.out.println(pool[i] + " " +  pool[i].getTime());
		}

	}

}
