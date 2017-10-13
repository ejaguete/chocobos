package chocobos;

/**
 * @author EJ
 *
 */

public class GenericObject {
	
	protected String _name = "none";
	
	public GenericObject() {}
	
	public GenericObject (String name) {
		_name = name.toLowerCase();
	}
	
	public String name() {
		return _name;
	}
	
	public String toString() {
		return "Name="+ _name;
	}

}
