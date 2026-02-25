package race;

import java.util.ArrayList;

public class RaceTrack {
	
	public enum Flag { WAIT, GO };

	public static long length;
	public static Flag flag;
	public static ArrayList<Racer> winners;
	
	public RaceTrack(long length) {
		RaceTrack.winners = new ArrayList<>();
		RaceTrack.length = length;
		RaceTrack.flag = Flag.WAIT;
	}
	
	public void reset() {
		RaceTrack.flag = Flag.WAIT;
		RaceTrack.winners.clear();
	}
}
