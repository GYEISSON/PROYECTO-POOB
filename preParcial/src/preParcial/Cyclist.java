package preParcial;
import java.util.*;

public class Cyclist {
	private boolean  estaEnfermo;
	private ArrayList<Plan> planes;
	public Cyclist() {
		estaEnfermo=false; 
		planes = new ArrayList<Plan>();
	}
	
	public void suspend() {
		for(Plan p: planes) {
			p.inactive();
		}
		System.out.println("Suspended");
	}

}
