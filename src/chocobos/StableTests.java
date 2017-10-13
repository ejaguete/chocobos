package chocobos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

public class StableTests {
		
		@Test
		public void test_StableCreation() {
			Stable stable = Stable.get();
			assertTrue(stable.isEmpty());
			
			stable.clear();
		}
		
		@Test
		public void test_StableAddChocobo() {
			Stable stable = Stable.get();
			Chocobo coco = new Chocobo("coco", 30, 0);
			stable.addChocobo(coco);
			assertEquals(1, stable.size());
			
			stable.clear();
		}
		
		@Test
		public void test_StableRemoveChocobo() {
			Stable stable = Stable.get();
			Chocobo coco = new Chocobo("coco", 30, 0);
			stable.addChocobo(coco);
			stable.removeChocobo("coco");
			assertTrue(stable.isEmpty());
			
			stable.clear();
		}
		
		@Test
		public void test_StableAddThreeChocobosRemoveOne() {
			Stable stable = Stable.get();
			stable.addChocobo(new Chocobo("coco", 30, 0));
			stable.addChocobo(new Chocobo("mimi", 20, 1));
			stable.addChocobo(new Chocobo("prom", 66, 0));
			
			stable.removeChocobo("coco");
			assertNull(stable.getChocobo("coco"));
			
			stable.clear();
		}
		
		@Test
		public void test_StableRenameChocobo() {
			Stable stable = Stable.get();
			stable.addChocobo(new Chocobo("coco", 30, 0));
			stable.rename("coco", "sunny");
			
			assertNull(stable.getChocobo("coco"));
			assertNotNull(stable.getChocobo("sunny"));
			
			stable.clear();
		}
		

		@Test
		public void test_StableFeedChocobo() throws NoMoreFeedException {
			Stable stable = Stable.get();
			stable.addChocobo(new Chocobo("coco", 30, 0));
			stable.feed().updateFeed(StableFoodStores.GHYSAHL, 10);
			
			stable.feedChocobo("coco", StableFoodStores.GHYSAHL);
			assertEquals(9, stable.feed().getFeedAmount(StableFoodStores.GHYSAHL));
			assertEquals(35, stable.getChocobo("coco").stats().get(ChocoboStats.ST));
			
			stable.clear();
		}
		
		@Test
		public void test_StableFeedChocoboTwice() throws NoMoreFeedException {
			Stable stable = Stable.get();
			stable.addChocobo(new Chocobo("coco", 30, 0));
			stable.feed().updateFeed(StableFoodStores.GHYSAHL, 10);
			
			stable.feedChocobo("coco", StableFoodStores.GHYSAHL);
			stable.feedChocobo("coco", StableFoodStores.GHYSAHL);
			
			assertEquals(8, stable.feed().getFeedAmount(StableFoodStores.GHYSAHL));
			assertEquals(40, stable.getChocobo("coco").stats().get(ChocoboStats.ST));
			
			stable.clear();
		}
		
		@Test
		public void test_StableFeedChocoboDifferentFeed() throws NoMoreFeedException {
			Stable stable = Stable.get();
			stable.addChocobo(new Chocobo("coco", 30, 0));
			stable.feed().updateFeed(StableFoodStores.GHYSAHL, 10);
			stable.feed().updateFeed(StableFoodStores.CURIEL, 10);
			
			stable.feedChocobo("coco", StableFoodStores.GHYSAHL);
			stable.feedChocobo("coco", StableFoodStores.CURIEL);
			
			assertEquals(9, stable.feed().getFeedAmount(StableFoodStores.GHYSAHL));
			assertEquals(9, stable.feed().getFeedAmount(StableFoodStores.CURIEL));
			assertEquals(35, stable.getChocobo("coco").stats().get(ChocoboStats.ST));
			assertEquals(5, stable.getChocobo("coco").stats().get(ChocoboStats.HEAL));
			
			stable.clear();
		}
		
		@Test(expected=NoMoreFeedException.class)
		public void test_StableNoMoreFeed() throws NoMoreFeedException {
			Stable stable = Stable.get();
			stable.addChocobo(new Chocobo("coco", 30, 0));
			stable.feed().updateFeed(StableFoodStores.GHYSAHL, 1);
			
			stable.feedChocobo("coco", StableFoodStores.GHYSAHL);
			stable.feedChocobo("coco", StableFoodStores.GHYSAHL);
			
			stable.clear();
		}
}
