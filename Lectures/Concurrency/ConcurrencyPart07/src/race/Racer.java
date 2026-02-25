package race;

import race.RaceTrack.Flag;

public class Racer implements Runnable {
	private int ID;
	private long time;
	
	public Racer(int ID) {
		this.ID = ID;
	}
	
	@Override
	public void run() {
		Flag f = Flag.WAIT;
		long distance = RaceTrack.length;
		
		while(f == Flag.WAIT) {
			f = RaceTrack.flag;
			try {
				Thread.sleep(0, 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		time = System.currentTimeMillis();
		while(distance > 0) {
			distance--;
		}
		RaceTrack.winners.add(this);
		time = System.currentTimeMillis() - time;
	}

	@Override
	public String toString() {
		return "\nRacer [ID=" + ID + ", time=" + time + "]";
	}

}
