package driver;

import java.util.concurrent.Callable;

public class PrimeTask implements Callable<Integer> {
	
	private int start;
	private int end;
	
	public PrimeTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

	@Override
	public Integer call() throws Exception {
		int count = 0;

		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		System.out.println("Finished range " + start + "-" + end +
                           " : " + count + " primes");

        return count;
	}

	private boolean isPrime(int n) {
    	if (n < 2) return false;

    	for (int i = 2; i <= Math.sqrt(n); i++) {
    		if (n % i == 0)
    			return false;
    	}

    	return true;
    }
}
