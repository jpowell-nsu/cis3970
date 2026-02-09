package driver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import processors.PrimeCounter;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		// for asynchronous concurrent tasks
		
		PrimeCounter[] pcs = new PrimeCounter[5];
		for (int i = 0; i < pcs.length; i++) {
			pcs[i] = new PrimeCounter(1, 10000000);
		}

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < pcs.length; i++) {
			executorService.execute(pcs[i]);
		}
		
		// stops the executor server from accepting any new tasks
		executorService.shutdown();
		// waits for all threads to finish, or times out at 30 seconds
		executorService.awaitTermination(30, TimeUnit.SECONDS);
		// forces it to stop if needed
		executorService.shutdownNow();
		
		long count = 0;
		for (int i = 0; i < pcs.length; i++) {
			System.out.println(pcs[i].getTime());
			count += pcs[i].getCount();
		}
		System.out.println(count);
		
	
		// creates some new object
		for (int i = 0; i < pcs.length; i++) {
			pcs[i] = new PrimeCounter(1, 10000000);
		}
		// virtual threads
		executorService = Executors.newVirtualThreadPerTaskExecutor();
		for (int i = 0; i < pcs.length; i++) {
			executorService.execute(pcs[i]);
		}
		
		executorService.shutdown();
		executorService.awaitTermination(30, TimeUnit.SECONDS);
		executorService.shutdownNow();
		
		count = 0;
		for (int i = 0; i < pcs.length; i++) {
			System.out.println(pcs[i].getTime());
			count += pcs[i].getCount();
		}
		System.out.println(count);
		
		// Be careful, the executor service appears to reuse tasks objects,
		// but it actually causes the thread to share the object
		executorService = Executors.newVirtualThreadPerTaskExecutor();
		for (int i = 0; i < pcs.length; i++) {
			executorService.execute(pcs[i]);	// notice that I did not create new objects
		}	
		
		for (int i = 0; i < pcs.length; i++) {
			executorService.execute(pcs[i]);	// notice that I did not create new objects
		}	
		
		executorService.shutdown();
		executorService.awaitTermination(30, TimeUnit.SECONDS);
		executorService.shutdownNow();
		
		count = 0;
		for (int i = 0; i < pcs.length; i++) {
			System.out.println(pcs[i].getTime());
			count += pcs[i].getCount();
		}
		System.out.println(count);
	}

}
