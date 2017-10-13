package chocobos;

import java.util.HashMap;
import java.util.Map;

public class ChocoboStats {
	//  stats
	private Map<Integer,Integer> stats = new HashMap<Integer,Integer>();
	
	public static final int ST = 0; // ST > 50 increases price
	public static final int TMP = 1; // TMP > 5 harder to manage, more likely to buck
	public static final int TYPE = 2; 
	public static final int HEAL = 3;
	public static final int DEF = 4; 
	public static final int ATK = 5;
	
	public ChocoboStats() {	
		// initialize battle stats
		for (int i=0;i<stats.size();++i)
			set(i, 0);
	}
	
	public ChocoboStats(int[] newStats) {
		if(newStats.length!=stats.size())
			throw new IllegalArgumentException("Wrong number of arguments, requires " + stats.size());
		
		for(int i=0;i<stats.size();++i) {
			set(i,newStats[i]);
		}
		
	}
	
	public int set(int stat, int value) {
		stats.put(stat, value);
		return value;
	}
	
	public int get(int stat) {
		return stats.get(stat);
	}

}
