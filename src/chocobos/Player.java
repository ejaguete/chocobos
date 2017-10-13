package chocobos;

public class Player extends GenericObject {
	
	private Rental rent;
	private int _points = 0;
	private int _cost = 0;

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
	
	public int rentCost() {
		return _cost;
	}

	public String statement() {
		int points = 0;
		String res = "Rental Record for " + name() + "\n";

		
		
		points++;
		if (rent.daysRented() > 6) points+=2;
		
		_points += points;
		_cost = rent.rentalCost();
		
		
		res += "\t" + "Name: " + rent.chocobo().name() + "\n";
		res += "\t" + "Cost: " + String.valueOf(_cost) + "\n";
		res += "\t" + "You earned " + points + " renter points.";
		return res; 
	}

}
