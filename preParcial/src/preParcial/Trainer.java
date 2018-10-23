package preParcial;
import java.util.*;

public class Trainer {
	private String email;
	private ArrayList<Plan> planes;
	
	public Trainer() {
		email = "yeisson.gualdron@mail.com";
		planes = new ArrayList<Plan>();
	}
	public void suspend() {
		for(Plan p: planes) {
			p.inactive();
		}
		System.out.println("Trainer suspended");
	}
}
