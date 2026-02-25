package driver;

import race.RaceTrack;
import race.RaceTrack.Flag;
import race.Racer;

public class Driver {
	
	public static void main(String []args) {
		
		RaceTrack rt = new RaceTrack(1_000_000_000_000_000_000L);
		Racer[] racer = new Racer[10];
		Thread[] rthreads = new Thread[10];
		int races = 3;
		
		for(int r = 0; r < races; r++) {
			rt.reset();
			for(int i = 0; i < rthreads.length; i++) {
				racer[i] = new Racer(i);
				rthreads[i] = new Thread(racer[i]);
				rthreads[i].start();
			
				(rthreads[i] = new Thread(new Racer(i))).start();
			}
			countdown();
			
			for(int i = 0; i < rthreads.length; i++) {
				try {
					rthreads[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
			System.out.println("Race Done");
			System.out.println(RaceTrack.winners);
			
		}
	}
	
	public static void countdown() {
		try {
			System.out.print("3...");
			Thread.sleep(1000);
			System.out.print("2...");
			Thread.sleep(1000);
			System.out.println("1...");
			Thread.sleep(1000);
			RaceTrack.flag = Flag.GO;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
