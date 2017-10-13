package chocobos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Chocobo extends GenericObject {
	
	private ChocoboStats stats = new ChocoboStats();
	
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
	}
	
	public void rename(String newName) {
		_name = newName;
	}
	
}
