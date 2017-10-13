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
	
	public Chocobo chocobo() {
		return _chocobo;
	}
	
	public int daysRented() {
		return _days;
	}
	
	public String toString() {
		String res = _chocobo.name();
		res += " daysRented=" + _days;
		return res;
	}

}
