package chocobos;

import java.util.HashMap;
import java.util.Map;

public class StableFoodStores {
	
	// types of greens 
	public static final int GHYSAHL = 0; 	// increases stamina
	public static final int CURIEL = 1; 		// increases healing
	public static final int REAGAN = 2; 		// increases defense
	public static final int SYLKIS = 3; 		// increases attack

	private final int LEN = 4;
	Map<Integer,Integer> feed = new HashMap<Integer,Integer>();
	
	public StableFoodStores() {
		// initialize feed
		clear();
	}
	
	public void clear() {
		for(int i=0;i<LEN;++i)
			feed.put(i, 0);
	}
	
	/**
	 * addFeed()
	 * add a type of feed to greens list
	 * @param feed : name of feed
	 * @param amt : amount of feed to add
	 */
	public void updateFeed(int type, int amt) {
		feed.put(type, feed.get(type)+amt);
	}
	
	/**
	 * getFeedAmount()
	 * @param type : feed of interest
	 * @return amount of this feed
	 */
	public int getFeedAmount(int type) {
		return feed.get(type);
	}
	
	/**
	 * hasFeed()
	 * @param name : name of feed to check
	 * @return true if stable has this feed, false otherwise
	 */
	public boolean hasFeed(int type) {
		return feed.get(type)>0;
	}

}
