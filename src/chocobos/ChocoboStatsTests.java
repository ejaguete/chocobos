package chocobos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChocoboStatsTests {
	
		@Test
		public void test_ChocoboStatsBlank() {
			ChocoboStats s = new ChocoboStats();
			
			String expected = "[0, 0, 0, 0, 0, 0]";
			assertEquals(expected, s.toString());
		}
		
		@Test
		public void test_ChocoboStatsParams() {
			int[] params = {100, 0, 1, 0, 0, 0};
			ChocoboStats s = new ChocoboStats(params);
			
			String expected = "[100, 0, 1, 0, 0, 0]";
			assertEquals(expected, s.toString());
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void test_ChocoboStatsIllegalParams() {
			int[] params = {1};
			ChocoboStats s = new ChocoboStats(params);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void test_ChocoboStatsIllegalParams2() {
			int[] params = {-1, 0, 0, 0, 0, 0};
			ChocoboStats s = new ChocoboStats(params);
		}

}
