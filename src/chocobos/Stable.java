package chocobos;

import java.util.Map;
import java.util.HashMap;


public class Stable extends GenericObject{
	private static Stable self;
	
	Map<String,Chocobo> stable = new HashMap<String,Chocobo>();

	// singleton
	private Stable() {
		// initialize feed
		feed.put(GHYSAHL, 0);
		feed.put(CURIEL, 0);
		feed.put(REAGAN, 0);
		feed.put(SYLKIS, 0);
		
	}
	
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
		feed.put(GHYSAHL, 0);
		feed.put(CURIEL, 0);
		feed.put(REAGAN, 0);
		feed.put(SYLKIS, 0);
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
	
	/**
	 * addFeed()
	 * add a type of feed to greens list
	 * @param feed : name of feed
	 * @param amt : amount of feed to add
	 */
	public void addFeed(String type, int amt) {
		type = type.toLowerCase();
		feed.put(type, feed.get(type)+amt);
	}
	
	/**
	 * getFeedAmount()
	 * @param type : feed of interest
	 * @return amount of this feed
	 */
	public int getFeedAmount(String type) {
		return feed.get(type);
	}
	
	/**
	 * hasFeed()
	 * @param name : name of feed to check
	 * @return true if stable has this feed, false otherwise
	 */
	public boolean hasFeed(String type) {
		return feed.get(type)>0;
	}
	
	public void feed(String name, String food) throws NoMoreFeedException {
		name = name.toLowerCase();
		food = food.toLowerCase();
		Chocobo choco = getChocobo(name);
		
		int amt = feed.get(food);
		if (amt>0)
			feed.put(food, amt-1);
		else throw new NoMoreFeedException(food);
		
		switch(food) {
			case GHYSAHL:
				choco.stats().set(ChocoboStats.ST, choco.stats().get(ChocoboStats.ST)+5);
				break;
			case CURIEL:
				choco.stats().set(ChocoboStats.HEAL, choco.stats().get(ChocoboStats.HEAL)+5);
				break;
			case REAGAN:
				choco.stats().set(ChocoboStats.DEF, choco.stats().get(ChocoboStats.DEF)+5);
				break;
			case SYLKIS:
				choco.stats().set(ChocoboStats.ATK,  choco.stats().get(ChocoboStats.ATK)+5);
				break;
		}	
	}
}
