package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Driver {
	
	public static void main(String []args) throws InterruptedException, ExecutionException {
		int rangeSize = 200000;
		int count = 0;
		ExecutorService executor = Executors.newFixedThreadPool(24);
		List<Future<Integer>> futures = new ArrayList<>();
		
		for (int start = 1; start <= 1_000_000_000; start += rangeSize) {
			int end = start + rangeSize - 1;
			PrimeTask task = new PrimeTask(start, end);
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }
		
		for (Future<Integer> future : futures) {
			count += future.get();
		}
		
		System.out.println("Count: " + count);
		executor.shutdown();
	}
}
