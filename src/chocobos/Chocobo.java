package chocobos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Chocobo extends GenericObject {
	
	private ChocoboStats stats;
		
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
		int[] params = {stamina, new Random().nextInt(11), type, 0, 0, 0};
		stats = new ChocoboStats(params);
	}
	
	public void rename(String newName) {
		_name = newName;
	}
	
	public ChocoboStats stats() {
		return stats;
	}
	
}
