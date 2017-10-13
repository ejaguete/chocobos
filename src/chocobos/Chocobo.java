package chocobos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Chocobo extends GenericObject {
	
	private ChocoboStats stats = new ChocoboStats();
		
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
