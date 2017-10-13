package chocobos;

public class Chocobo extends GenericObject {
	
	private ChocoboStats stats;
		
	/**
	 * constructor
	 * all other stats except stamina and type are set to 0
	 * @param name
	 * @param stamina
	 * @param type : 0 = regular, 1 = flying
	 */
	public Chocobo(String name, int stamina, int type) {
		super(name);
		int[] params = {stamina, 0, type, 0, 0, 0};
		stats = new ChocoboStats(params);
	}
	
	/**
	 * constructor
	 * @param name
	 * @param newStats : int[] containing [ST, TMP, TYPE, HEAL, DEF, ATK]
	 */
	public Chocobo(String name, int[] params) {
		super(name);
		stats = new ChocoboStats(params);
	}
	
	public void rename(String newName) { _name = newName; }
	
	public ChocoboStats stats() { return stats; }
	
}
