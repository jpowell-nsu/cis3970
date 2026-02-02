package processes;

public class PrimeCounter implements Runnable {
	
	private long start;
	private long end;
	private long count;
	
	public PrimeCounter(long start, long end) {
		this.start = start;
		this.end = end;
		this.count = 0;
	}
	
	public long getCount() { return count; }
	
	@Override
	public void run() {
		System.out.printf("%s checking %d to %d with priority %d\n", Thread.currentThread().getName(), start, end, Thread.currentThread().getPriority());
		long startTime = System.currentTimeMillis();
		long count = counter();
		long elapseTime = System.currentTimeMillis() - startTime;
		System.out.printf("%s counted %d in %d milliseconds\n", Thread.currentThread().getName(), count, elapseTime);
	}

	private long counter() {
		for(long i = start; i <= end; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		return count;
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
