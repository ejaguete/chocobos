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
		int amt = 0;
		int points = 0;
		String res = "Rental Record for " + name() + "\n";

		switch(rent.chocobo().getStat(Chocobo.TYPE)) {

			case Chocobo.REGULAR: {
				amt+=800;
				if (rent.daysRented() > 6)
					amt += (rent.daysRented()-2) * 15;
				else
					amt += rent.daysRented() * 15;
		
				if (rent.chocobo().getStat(Chocobo.ST) > 50)
					amt += 2 * (rent.chocobo().getStat(Chocobo.ST)-50);
				break;
			}
	
			case Chocobo.FLYING: {
				amt+=1000;
				if(rent.daysRented() > 6)
					amt += (rent.daysRented()-3) * 20;
				else
					amt += rent.daysRented() * 20;
	
				if (rent.chocobo().getStat(Chocobo.ST) > 50)
					amt += 3 * (rent.chocobo().getStat(Chocobo.ST)-50);
				break;
			}
		}
		
		points++;
		if (rent.daysRented() > 6) points+=2;
		
		_points += points;
		_cost = amt;
		
		
		res += "\t" + "Name: " + rent.chocobo().name() + "\n";
		res += "\t" + "Cost: " + String.valueOf(amt) + "\n";
		res += "\t" + "You earned " + points + " renter points.";
		return res; 
	}

}
