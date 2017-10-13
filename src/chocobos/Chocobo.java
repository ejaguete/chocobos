package chocobos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Chocobo extends GenericObject {
	//  stats
	private Map<String,Integer> stats = new HashMap<String,Integer>();
	public static final String ST = "stamina"; // ST > 50 increases price
	public static final String TMP = "temper"; // TMP > 5 harder to manage, more likely to buck
	public static final String TYPE = "type"; 
	public static final String HEAL = "healing";
	public static final String DEF = "defense"; 
	public static final String ATK = "attack";
	
	// type code
	public static final int REGULAR = 0;
	public static final int FLYING = 1;
		
	/**
	 * constructor
	 * 
	 * @param name
	 * @param stamina
	 * @param temper
	 * @param kind
	 */
	public Chocobo(String name, int stamina, int type) {
		super(name);
		setStat(ST, stamina);
		
		// generate a random temper
		stats.put(TMP, new Random().nextInt(11));
		
		// set kind of chocobo
		if (type==0 || type ==1)
			setStat(TYPE, type);
		else
			throw new IllegalArgumentException("Kind value out of range [0,1]");
		
		// initialize battle stats
		stats.put("healing", 0);
		stats.put("defense", 0);
		stats.put("attack", 0);
	}
	
	public void rename(String newName) {
		_name = newName;
	}
	
	public int getStat(String stat) {
		return stats.get(stat.toLowerCase());
	}
	
	public void setStat(String stat, int value) {
		stats.put(stat, value);
	}
	
}
