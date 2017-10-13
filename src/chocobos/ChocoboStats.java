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
		stats.put("healing", 0);
		stats.put("defense", 0);
		stats.put("attack", 0);
	}

}
