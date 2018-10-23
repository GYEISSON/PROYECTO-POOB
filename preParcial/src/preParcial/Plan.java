package preParcial;
import java.util.*;


public class Plan {
	private long number;
	private boolean active;
	private String Typet;
	public Plan() {
		number = 0;
		Typet = "Intensive" ;
		active = true;
	}
	
	public void inactive() {}
	public String getType() { return Typet;}
	public long getNumber() {return number; }
}
