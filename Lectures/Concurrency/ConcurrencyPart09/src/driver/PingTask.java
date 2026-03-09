package driver;

import java.util.concurrent.Callable;

public class PingTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 100; i++) {
			System.out.println("ping...");
			Thread.sleep(2000);
		}
		return "Done";
	}

}
