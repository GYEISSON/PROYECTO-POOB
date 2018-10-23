package preParcial;
import java.util.*;
public class MaterTraining {
	public int UNDEFINED;
	private ArrayList<Trainer> trainers;
	private ArrayList<Plan> planes;
	private ArrayList<Cyclist> cyclist;
	
	public MaterTraining() {
		UNDEFINED =  -1;
		trainers  = new ArrayList<Trainer>();
		planes =  new ArrayList<Plan>();
		cyclist = new ArrayList<Cyclist>();
	}
	
	public void evaluatePlan(long number) {
		for(Plan p: planes) {
			if(p instanceof Easy) {
				
			}
		}
	}
}
