package chocobos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StableFoodStoresTests {
	
	@Test
	public void test_FoodStoresCreation() {
		StableFoodStores f = new StableFoodStores();
		
		for(int i=0;i<4;++i)
			assertTrue(!f.hasFeed(i));
	}
	
	@Test
	public void test_FoodStoresParams() {
		int[] params = {1,5,2,3};
		StableFoodStores f = new StableFoodStores(params);
		
		for (int i=0;i<4;++i) {
			assertEquals(params[i], f.getFeedAmount(i));
		}
	}
	@Test
	public void test_AddNewFeed() {
		StableFoodStores f = new StableFoodStores();
		f.updateFeed(StableFoodStores.CURIEL, 11);
		assertEquals(11, f.getFeedAmount(StableFoodStores.CURIEL));
	}
	
	@Test
	public void test_AddExistingFeed() {
		StableFoodStores f = new StableFoodStores();
		f.updateFeed(StableFoodStores.CURIEL, 11);
		assertEquals(11, f.getFeedAmount(StableFoodStores.CURIEL));
		
		f.updateFeed(StableFoodStores.CURIEL, 4);
		assertEquals(15, f.getFeedAmount(StableFoodStores.CURIEL));
	}
}
