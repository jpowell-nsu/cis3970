package processors;

public class PrimeCounter implements Runnable {
	
	private long start;
	private long end;
	private long count;
	private long time;
	
	public PrimeCounter(long start, long end) {
		this.start = start;
		this.end = end;
		this.count = 0;
		this.time = 0;
	}
	
	public long getCount() { return count; }
	public long getTime() { return time; }
	
	@Override
	public void run() {
		time = System.currentTimeMillis();
		counter();
		time = System.currentTimeMillis() - time;
	}

	private void counter() {
		for(long i = start; i <= end; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
	}
	
	private boolean isPrime(long n) {
		if (n <= 1) { return false; }

		if (n <= 3) { return true; }

		if (n % 2 == 0 || n % 3 == 0) { return false; }
	    
		for (long i = 5; i * i <= n; i += 6) {
	        if (n % i == 0 || n % (i + 2) == 0)
	            return false;
	    }

		return true;
	}
}
