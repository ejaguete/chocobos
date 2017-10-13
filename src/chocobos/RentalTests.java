package chocobos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RentalTests {
	@Test
	public void test_RentalCreationOneDayRent() {
		Chocobo coco = new Chocobo("coco", 30, 0);
		Rental rent = new Rental(coco, 1);
		assertEquals(rent.chocobo(),coco);
		assertEquals(1, rent.daysRented());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_RentalCreationNoDaysRent() {
		Chocobo coco = new Chocobo("coco", 30, 0);
		Rental rent = new Rental(coco, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_RentalCreationTooManyDaysRent() {
		Chocobo coco = new Chocobo("coco", 30, 0);
		Rental rent = new Rental(coco, 31);
	}

}
