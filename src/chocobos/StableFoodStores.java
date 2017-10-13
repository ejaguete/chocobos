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
	
	public StableFoodStores(int[] feeds) {
		clear();
		if(feeds.length!=LEN)
			throw new IllegalArgumentException("Only " + feeds.length + " arguments, requires " + LEN);
		
		for(int i=0;i<LEN;++i) updateFeed(i,feeds[i]);
	}
	
	public void clear() {
		for(int i=0;i<LEN;++i)  feed.put(i, 0);
	}
	
	public int updateFeed(int type, int amt) { return feed.put(type, feed.get(type)+amt); }
	
	public int getFeedAmount(int type) { return feed.get(type);	}
	
	public boolean hasFeed(int type) { return feed.get(type)>0; }

}
