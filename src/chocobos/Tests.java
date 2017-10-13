package chocobos;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author EJ
 *
 */
public class Tests {

// ChocoboStats.java tests
	
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
// Chocobo.java tests

	@Test
	public void test_ChocoboCreation() {
		Chocobo coco = new Chocobo("Coco", 50, 0);
		assertEquals("coco", coco.name());
		
		String expected = "[50, 0, 0, 0, 0, 0]";
		
		assertEquals(expected, coco.stats().toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_IllegalChocoboKind() {
		Chocobo coco = new Chocobo("Coco", 30, -1);
		Chocobo mimi = new Chocobo("Mimi", 30, 11);
	}
	
// Rental.java tests
	
	@Test
	public void test_RentalCreationOneDayRent() {
		Chocobo coco = new Chocobo("Coco", 30, 0);
		Rental rent = new Rental(coco, 1);
		assertEquals(rent.chocobo(),coco);
		assertEquals(1, rent.daysRented());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_RentalCreationIllegalDayRent() {
		Chocobo coco = new Chocobo("Coco", 30, 0);
		Rental rent = new Rental(coco, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_RentalCreationTooManyDaysRent() {
		Chocobo coco = new Chocobo("Coco", 30, 0);
		Rental rent = new Rental(coco, 31);
	}
	
// Stable.java tests
	
	@Test
	public void test_StableCreation() {
		Stable stable = Stable.get();
		assertTrue(stable.isEmpty());
		
		stable.clear();
	}
	
	@Test
	public void test_StableAddChocobo() {
		Stable stable = Stable.get();
		Chocobo coco = new Chocobo("Coco", 30, 0);
		stable.addChocobo(coco);
		assertEquals(1, stable.size());
		
		stable.clear();
	}
	
	@Test
	public void test_StableRemoveChocobo() {
		Stable stable = Stable.get();
		Chocobo coco = new Chocobo("Coco", 30, 0);
		stable.addChocobo(coco);
		stable.removeChocobo("coco");
		assertTrue(stable.isEmpty());
		
		stable.clear();
	}
	
	@Test
	public void test_StableAddThreeChocobosRemoveOne() {
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("Coco", 30, 0));
		stable.addChocobo(new Chocobo("Mimi", 20, 1));
		stable.addChocobo(new Chocobo("Prom", 66, 0));
		
		stable.removeChocobo("coco");
		assertNull(stable.getChocobo("coco"));
		
		stable.clear();
	}
	
	@Test
	public void test_StableRenameChocobo() {
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("Coco", 30, 0));
		stable.rename("coco", "Sunny");
		
		assertNull(stable.getChocobo("coco"));
		assertNotNull(stable.getChocobo("sunny"));
		
		stable.clear();
	}
	
	@Test
	public void test_AddNewFeed() {
		Stable stable = Stable.get();
		stable.addFeed(Stable.CURIEL, 11);
		assertEquals(11, stable.getFeedAmount(Stable.CURIEL));
		
		stable.clear();
	}
	
	@Test
	public void test_AddExistingFeed() {
		Stable stable = Stable.get();
		stable.addFeed(Stable.CURIEL, 11);
		assertEquals(11, stable.getFeedAmount(Stable.CURIEL));
		
		stable.addFeed(Stable.CURIEL, 4);
		assertEquals(15, stable.getFeedAmount(Stable.CURIEL));
		
		stable.clear();
	}
	
	@Test
	public void test_StableFeedChocobo() throws NoMoreFeedException {
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("Coco", 30, 0));
		stable.addFeed(Stable.GHYSAHL, 10);
		
		stable.feed("coco", Stable.GHYSAHL);
		assertEquals(9, stable.getFeedAmount(Stable.GHYSAHL));
		assertEquals(35, stable.getChocobo("coco").stats().get(ChocoboStats.ST));
		
		stable.clear();
	}
	
	@Test
	public void test_StableFeedChocoboTwice() throws NoMoreFeedException {
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("Coco", 30, 0));
		stable.addFeed(Stable.GHYSAHL, 10);
		
		stable.feed("coco", Stable.GHYSAHL);
		stable.feed("coco", Stable.GHYSAHL);
		
		assertEquals(8, stable.getFeedAmount(Stable.GHYSAHL));
		assertEquals(40, stable.getChocobo("coco").stats().get(ChocoboStats.ST));
		
		stable.clear();
	}
	
	@Test(expected=NoMoreFeedException.class)
	public void test_StableNoMoreFeed() throws NoMoreFeedException {
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("Coco", 30, 0));
		stable.addFeed(Stable.GHYSAHL, 1);
		
		stable.feed("coco", Stable.GHYSAHL);
		stable.feed("coco", Stable.GHYSAHL);
		
		stable.clear();
	}
	
	@Test
	public void test_StableFeedChocoboDifferentFeed() throws NoMoreFeedException {
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("Coco", 30, 0));
		stable.addFeed(Stable.GHYSAHL, 10);
		stable.addFeed(Stable.CURIEL, 10);
		
		stable.feed("coco", Stable.GHYSAHL);
		stable.feed("coco", Stable.CURIEL);
		
		assertEquals(9, stable.getFeedAmount(Stable.GHYSAHL));
		assertEquals(9, stable.getFeedAmount(Stable.CURIEL));
		assertEquals(35, stable.getChocobo("coco").stats().get(ChocoboStats.ST));
		assertEquals(5, stable.getChocobo("coco").stats().get(ChocoboStats.HEAL));
		
		stable.clear();
	}
	
// Player.java tests
	
	@Test
	public void testPlayerStatementRegChocobo() {
		Player noctis = new Player("Noctis");
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("Coco", 30, 0));
		noctis.addRental(stable.getChocobo("Coco"), 1);
		
		noctis.statement();
		assertEquals(815, noctis.rentCost());
		assertEquals(1, noctis.points());
		
		stable.clear();
	}
	
	@Test
	public void testPlayerStatementFlyingChocobo() {
		Player noctis = new Player("Noctis");
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("Coco", 30, 1));
		noctis.addRental(stable.getChocobo("Coco"), 1);
		
		noctis.statement();
		assertEquals(1020, noctis.rentCost());
		assertEquals(1, noctis.points());
		
		stable.clear();
	}
	
	@Test
	public void testPlayerStatementWeeklongRentRegChocobo() {
		Player noctis = new Player("Noctis");
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("Coco", 30, 0));
		noctis.addRental(stable.getChocobo("Coco"), 7);
		
		noctis.statement();
		assertEquals(875, noctis.rentCost());
		assertEquals(3, noctis.points());
		
		stable.clear();
	}
	
	@Test
	public void testPlayerStatementWeeklongRentFlyingChocobo() {
		Player noctis = new Player("Noctis");
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("Coco", 30, 1));
		noctis.addRental(stable.getChocobo("Coco"), 7);
		
		noctis.statement();
		assertEquals(1080, noctis.rentCost());
		assertEquals(3, noctis.points());
		
		stable.clear();
	}
	
}
