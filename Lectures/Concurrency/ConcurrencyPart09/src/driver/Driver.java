package driver;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Driver {
	
	/*
	 * Runnable Interface – represents a task that does not return a result of throw an exception
	 * Callable Interface - represents a task that returns a result and may throw an exception
	 * Future Interface
	 * 	Represents the result of an asynchronous computation
	 * 	Holds the result and handles exceptions
	 * ExecutiveService submit() returns a Future object given a Callable or Runnable
	 * 	Future get() returns null for a Runnable
	 * 	Future get() returns the result for a Callable
	 */
	
	public static void main(String []args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
        
		//------------------------------------------------------
		Runnable runtask = () -> {
			int sum = 0;
			for (int i = 1; i <= 5; i++)
				sum += i;
			System.out.println("Result: " + sum);  // cannot return a result
		};
		// we can use submit, but the Future type must be set to ?
		Future<?> future = executor.submit(runtask);
		System.out.println(future.get());
        
		//------------------------------------------------------
		Callable<Integer> calltask = () -> {
			int sum = 0;
			for (int i = 1; i <= 5; i++)
				sum += i;
			return sum;  // can return a result
		};

		Future<Integer> future2 = executor.submit(calltask);
  
		try {
			Integer result = future2.get(); // waits but returns instantly
			System.out.println("Result: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}        
       
		//------------------------------------------------------       		
		future2 = executor.submit(() -> 30/0);
		try {
			Integer result = future2.get(); // waits but returns instantly
			System.out.println("Result: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		//------------------------------------------------------
		Future<String> future3 = executor.submit(new PingTask());
		System.out.println(future3.isDone());
		System.out.println(future3.isCancelled());
//		System.out.println(future3.cancel(true));
//		System.out.println(future3.isCancelled());
		System.out.println(future3.isDone());
		System.out.println(future3.get());
        
        executor.shutdown();				
	}
}
