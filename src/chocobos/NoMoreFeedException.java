package chocobos;

@SuppressWarnings("serial")
public class NoMoreFeedException extends Exception {
	
	public NoMoreFeedException(int feed) {
		super("Stable does not have this type of feed anymore: " + feed);
	}
}
