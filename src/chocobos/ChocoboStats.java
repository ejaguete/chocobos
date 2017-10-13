package chocobos;

import java.util.HashMap;
import java.util.Map;

public class ChocoboStats {
	//  stats
	private Map<Integer,Integer> stats = new HashMap<Integer,Integer>();
	
	private final int LEN = 6;
	
	public static final int ST = 0; // ST > 50 increases price
	public static final int TMP = 1; // TMP > 5 harder to manage, more likely to buck
	public static final int TYPE = 2; 
	public static final int HEAL = 3;
	public static final int DEF = 4; 
	public static final int ATK = 5;
	
	// type code
	public static final int REGULAR = 0;
	public static final int FLYING = 1;
	
	public ChocoboStats() {	
		// initialize battle stats
		for (int i=0;i<LEN;++i)
			set(i, 0);
	}
	
	/**
	 * constructor
	 * @param newStats : int[] containing [ST, TMP, TYPE, HEAL, DEF, ATK]
	 */
	public ChocoboStats(int[] newStats) {
		if(newStats.length!=LEN)
			throw new IllegalArgumentException("Only " + newStats.length + " arguments, requires " + LEN);
		
		for(int i=0;i<LEN;++i) {
			if(checkOK(i,newStats[i]))
				set(i,newStats[i]);
			else
				throw new IllegalArgumentException( "Element " + i + " of array invalid: " + newStats[i]);
		}
	}
	
	public int set(int stat, int value) {
		stats.put(stat, value);
		return value;
	}
	
	public int get(int stat) {
		return stats.get(stat);
	}
	
	private boolean checkOK(int stat, int value) {
		if(stat==ST)
			return value<101 && value>-1;
		else if(stat==TMP)
			return value<11 && value>-1;
		else if(stat==TYPE)
			return value<2 && value>-1;
		else
			return true;
	}
	
	public String toString() {
		String s = "[";
		for(int i=0;i<stats.size()-1;++i)
			s+= stats.get(i) + ", ";
		s += stats.get(stats.size()-1) + "]";
		return s;
	}

}
