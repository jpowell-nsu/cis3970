package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Driver {
		
	public static void main(String []args) throws InterruptedException, ExecutionException {
        List<String> websites = List.of(
                "https://www.google.com",
                "https://www.github.com",
                "https://www.stackoverflow.com",
                "https://www.wikipedia.org",
                "https://www.oracle.com",
                "https://www.nsula.edu",
                "https://my.nsula.edu",
                "https://moodle.nsula.edu"
        );
        ExecutorService executor = Executors.newFixedThreadPool(websites.size());
        List<Future<String>> futures = new ArrayList<>();

        for (String site : websites) {
            Callable<String> task = new WebsiteCheckTask(site);
            Future<String> future = executor.submit(task);
            futures.add(future);
        }
        
        System.out.println("Checking websites...\n");
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        
        executor.shutdown();
	}
}
