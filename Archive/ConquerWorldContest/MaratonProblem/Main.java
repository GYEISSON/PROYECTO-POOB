import java.util.*;
import java.io.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    // instance variables - replace the example below with your own
    private int numberNations;
    
    private Vector<Vector> adjList,adjCost;
    
    private Vector<Integer> armiesNation,armiesNeedNation;
    
    private int source,target, cost;
    private BufferedReader br;
    private Scanner sc;
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        sc  =  new Scanner(System.in);
        
        adjList = new Vector();
        adjCost = new Vector();
        armiesNation = new Vector();
        armiesNeedNation = new Vector();
    }
    
    public void init(int n){
        this.numberNations = n;
        int aux1;
        for(int k=0;k<=numberNations;k++){
            adjList.addElement(new Vector());
            adjCost.addElement(new Vector());
            armiesNation.addElement(0);
            armiesNeedNation.addElement(0);
        }
        for(int i = 0; i<numberNations-1;i++){
            source = sc.nextInt();
            target = sc.nextInt();
            cost = sc.nextInt();
            adjList.elementAt(source).addElement(target);
            adjList.elementAt(target).addElement(source);
            adjCost.elementAt(source).addElement(cost);
            adjCost.elementAt(target).addElement(cost);
        }
        for(int j =1 ;j<=numberNations;j++){
            aux1 = sc.nextInt();
            armiesNation.insertElementAt(aux1,j);
            aux1 = sc.nextInt();
            armiesNeedNation.insertElementAt(aux1,j);
        }
    }
}
