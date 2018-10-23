package preParcial;
import java.util.*;


public abstract class Plan {
	
	protected long number;
	protected boolean active;
	protected String Typet;
	
	public Plan() {
		number = 0;
		Typet = "Intensive" ;
		active = true;
	}

	public abstract  void inactive();
	
	public String getType(){ return Typet; }
	public long getNumber(){ return number; }
	public boolean state(){  return active; }
}
