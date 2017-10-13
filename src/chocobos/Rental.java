package chocobos;

public class Rental extends GenericObject {

	private Chocobo _chocobo;
	private int _days;
	
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
	
	public Chocobo chocobo() { return _chocobo; }
	
	public int daysRented() { return _days; }
	
	public int rentalCost() {
		int stam = _chocobo.stats().get(ChocoboStats.ST);
		
		if(_chocobo.stats().get(ChocoboStats.TYPE)==ChocoboStats.REGULAR) 
			return regularChocoboCost(stam);
		else 
			return flyingChocoboCost(stam);
	}
	
	private int regularChocoboCost(int stam) {
		int amt = 800;
		if (_days>6)
			amt += (_days-2) * 15;
		else
			amt += (_days) * 15;
		
		if (stam > 50)
			amt += 2 * (stam-50);
		
		return amt;
	}
	
	private int flyingChocoboCost(int stam) {
		int amt=1000;
		if(_days>6)
			amt += (_days-3) * 20;
		else
			amt += _days * 20;

		if (stam > 50)
			amt += 3 * (stam-50);
		
		return amt;
	}
	
	public String toString() {
		String res = _chocobo.name();
		res += " daysRented=" + _days;
		return res;
	}
	

}
