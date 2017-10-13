package chocobos;

public class Player extends GenericObject {
	
	private Rental rent;
	private int _points = 0;

	public Player (String name) {
		super(name);
	}
	
	public void addRental(Rental rental) {
		rent = rental;
	}
	
	public void addRental(Chocobo choco, int daysRented) {
		rent = new Rental(choco, daysRented);
	}
	
	public Rental rent() {
		return rent;
	}
	
	public int points() {
		return _points;
	}

	public String statement() {
		String res = "Rental Record for " + name() + "\n";
		
		res += "\t" + "Name: " + rent.chocobo().name() + "\n";
		res += "\t" + "Cost: " + String.valueOf(rent.rentalCost()) + "\n";
		res += "\t" + "You earned " + rentPoints() + " renter points.";
		return res; 
	}
	
	public int rentPoints() {
		int points = 1;
		if (rent.daysRented() > 6) points+=2;
		_points += points;
		return points;
	}

}
