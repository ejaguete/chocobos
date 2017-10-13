package chocobos;

import java.util.Map;
import java.util.HashMap;


public class Stable extends GenericObject{
	private static Stable self;
	
	Map<String,Chocobo> stable = new HashMap<String,Chocobo>();
	private StableFoodStores feed = new StableFoodStores();

	
	// singleton
	private Stable() {	}
	
	public static Stable get() {
		if (self==null)
			self = new Stable();
		return self;
	}
	
	/**
	 * clear()
	 * clear stable of all chocobos & greens
	 * used for debugging
	 */
	public void clear() {
		stable.clear();
	}
	
	public StableFoodStores feed() {
		return feed;
	}
	
	/**
	 * size()
	 * @return number of chocobos currently in stable
	 */
	public int size() {
		return stable.size();
	}
	
	/**
	 * isEmpty()
	 * @return true if stable has no chocobos, false otherwise
	 */
	public boolean isEmpty() {
		return stable.isEmpty();
	}
	
	/**
	 * addChocobo()
	 * @param choco : chocobo object to add
	 */
	public void addChocobo(Chocobo choco) {
		stable.put(choco.name(), choco);
	}

	/**
	 * getChocobo()
	 * get chocobo object with specific name
	 * @param name : name of chocobo to retrieve
	 * @return chocobo with corresponding name, null if no chocobo with that name
	 */
	public Chocobo getChocobo(String name) {
		return stable.get(name.toLowerCase());
	}
	
	/**
	 * removeChocobo()
	 * @param choco : name of chocobo to remove
	 * @return the removed chocobo
	 */
	public Chocobo removeChocobo(String choco) {
		return stable.remove(choco.toLowerCase());
	}
	
	/**
	 * rename()
	 * 
	 * @param oldName : current name of chocobo
	 * @param newName : desired name to give to chocobo
	 */
	public void rename(String oldName, String newName) {
		oldName = oldName.toLowerCase();
		newName = newName.toLowerCase();
		Chocobo choco = removeChocobo(oldName);
		choco.rename(newName.toLowerCase());
		stable.put(newName, choco);
	}
	
	
	public void feedChocobo(String name, int food) throws NoMoreFeedException {
		name = name.toLowerCase();
		Chocobo choco = getChocobo(name);
		
		int amt = feed().getFeedAmount(food);
		if (amt>0)
			feed().updateFeed(food, -1);
		else throw new NoMoreFeedException(food);
		
		switch(food) {
			case StableFoodStores.GHYSAHL:
				choco.stats().set(ChocoboStats.ST, choco.stats().get(ChocoboStats.ST)+5);
				break;
			case StableFoodStores.CURIEL:
				choco.stats().set(ChocoboStats.HEAL, choco.stats().get(ChocoboStats.HEAL)+5);
				break;
			case StableFoodStores.REAGAN:
				choco.stats().set(ChocoboStats.DEF, choco.stats().get(ChocoboStats.DEF)+5);
				break;
			case StableFoodStores.SYLKIS:
				choco.stats().set(ChocoboStats.ATK,  choco.stats().get(ChocoboStats.ATK)+5);
				break;
		}	
	}
}
