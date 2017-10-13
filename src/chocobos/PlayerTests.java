package chocobos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTests {
	
	@Test
	public void testPlayerStatementRegChocobo() {
		Player noctis = new Player("Noctis");
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("coco", 30, 0));
		noctis.addRental(stable.getChocobo("coco"), 1);
		
		noctis.statement();
		assertEquals(815, noctis.rent().rentalCost());
		assertEquals(1, noctis.points());
		
		stable.clear();
	}
	
	@Test
	public void testPlayerStatementFlyingChocobo() {
		Player noctis = new Player("noctis");
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("coco", 30, 1));
		noctis.addRental(stable.getChocobo("coco"), 1);
		
		noctis.statement();
		assertEquals(1020, noctis.rent().rentalCost());
		assertEquals(1, noctis.points());
		
		stable.clear();
	}
	
	@Test
	public void testPlayerStatementWeeklongRentRegChocobo() {
		Player noctis = new Player("noctis");
		Stable stable = Stable.get();
		stable.addChocobo(new Chocobo("coco", 30, 0));
		noctis.addRental(stable.getChocobo("coco"), 7);
		
		noctis.statement();
		assertEquals(875, noctis.rent().rentalCost());
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
		assertEquals(1080, noctis.rent().rentalCost());
		assertEquals(3, noctis.points());
		
		stable.clear();
	}
	

}
