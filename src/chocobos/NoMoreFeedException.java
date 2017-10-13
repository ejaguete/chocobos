package chocobos;

@SuppressWarnings("serial")
public class NoMoreFeedException extends Exception {
	
	public NoMoreFeedException(String feed) {
		super("Stable does not have this type of feed anymore: " + feed);
	}
}
