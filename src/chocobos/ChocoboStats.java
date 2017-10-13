package chocobos;

import java.util.HashMap;
import java.util.Map;

public class ChocoboStats {
	//  stats
	private Map<String,Integer> stats = new HashMap<String,Integer>();
	
	public static final String ST = "stamina"; // ST > 50 increases price
	public static final String TMP = "temper"; // TMP > 5 harder to manage, more likely to buck
	public static final String TYPE = "type"; 
	public static final String HEAL = "healing";
	public static final String DEF = "defense"; 
	public static final String ATK = "attack";
	
	public ChocoboStats() {	
		// initialize battle stats
		stats.put(ST, 0);
		stats.put(TMP, 0);
		stats.put(TYPE, 0);
		stats.put(HEAL, 0);
		stats.put(DEF, 0);
		stats.put(ATK, 0);
	}
	
	public int set(String stat, int value) {
		stat = stat.toLowerCase();
		stats.put(stat, value);
		return value;
	}
	
	public int get(String stat) {
		stat = stat.toLowerCase();
		return stats.get(stat);
	}

}
