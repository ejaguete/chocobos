package chocobos;

public class Rental extends GenericObject {

	private Chocobo _chocobo;
	private int _days;
	private int _cost;
	
	private final int MINDAYS = 1;
	private final int MAXDAYS = 30;
	
	public Rental(Chocobo choco, int daysRented) {
		super();
		_chocobo = choco;
		
		if(daysRented>=MINDAYS && daysRented<=MAXDAYS)
			_days = daysRented;
		else
			throw new IllegalArgumentException("Rent days value out of range: " + daysRented);
	}
	
	public Chocobo chocobo() {
		return _chocobo;
	}
	
	public int daysRented() {
		return _days;
	}
	
	public int rentalCost() {
		int amt = 0;
		int stam = _chocobo.stats().get(ChocoboStats.ST);
		int chocoType = _chocobo.stats().get(ChocoboStats.TYPE);
		
		switch(chocoType) {

		case ChocoboStats.REGULAR: 
		{
			amt+=800;
			if (_days>6)
				amt += (_days-2) * 15;
			else
				amt += (_days) * 15;

			if (stam > 50)
				amt += 2 * (stam-50);
			break;
		}

		case ChocoboStats.FLYING:
		{
			amt+=1000;
			if(_days>6)
				amt += (_days-3) * 20;
			else
				amt += _days * 20;

			if (stam > 50)
				amt += 3 * (stam-50);
			break;
		}
		}
		return amt;
	}
	
	public String toString() {
		String res = _chocobo.name();
		res += " daysRented=" + _days;
		return res;
	}
	

}
