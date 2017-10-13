package chocobos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChocoboTests {
	
	@Test
	public void test_ChocoboCreation() {
		Chocobo c = new Chocobo("cici", 50, 1);
		
		assertEquals("cici",c.name());
	}
	
	@Test 
	public void test_ChocoboParams() {
		int[] params = {20, 1, 0, 0, 0, 0};
		Chocobo c = new Chocobo("mimi",params);
		
		assertEquals(20, c.stats().get(0));
		assertEquals(1, c.stats().get(1));	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_ChocoboIllegalParams() {
		int[] params = {20, 1, 0, 0};
		Chocobo c = new Chocobo("mimi",params);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_ChocoboIllegalParams2() {
		int[] params = {-1, 1, 0, 0, 0, 0};
		Chocobo c = new Chocobo("mimi",params);
	}
	
}
