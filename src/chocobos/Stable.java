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
	
	public void clear() {
		stable.clear();
		feed.clear();
	}
	
	public StableFoodStores feed() { return feed; }

	public int size() { return stable.size(); }
	
	public boolean isEmpty() { return stable.isEmpty(); }
	
	public void addChocobo(Chocobo choco) { stable.put(choco.name(), choco); }

	public Chocobo getChocobo(String name) { return stable.get(name.toLowerCase()); }
	
	public Chocobo removeChocobo(String choco) { return stable.remove(choco.toLowerCase()); }
	
	public void rename(String oldName, String newName) {
		oldName = oldName.toLowerCase();
		newName = newName.toLowerCase();
		
		Chocobo choco = removeChocobo(oldName);
		choco.rename(newName);
		stable.put(newName, choco);
	}
	
	public int feedChocobo(String name, int food) throws NoMoreFeedException {
		name = name.toLowerCase();
		Chocobo choco = getChocobo(name);
	
		if (feed().hasFeed(food))
			feed().updateFeed(food, -1);
		else throw new NoMoreFeedException(food);
		
		updateChocoboStats(choco, food);

		return feed().updateFeed(food, 0);
	}
	
	private void updateChocoboStats(Chocobo choco, int food) {
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
