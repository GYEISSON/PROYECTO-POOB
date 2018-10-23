package preParcial;

import java.util.*;



public class Solutions {
	
	private static Cyclist cyclist;
	private static Trainer trainer;
	
	public static void main(String[] args) {
		System.out.println("Pre-parcial");
		cyclist = new Cyclist();
		trainer = new Trainer();
		
		cyclist.suspend();
		trainer.suspend();
	}
}
