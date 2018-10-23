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
    
    private Vector<Vector<Integer>> adjList,adjCost;
    
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
        //Llenando las estructuras con los datos (creando el grafo(uno de adyacencias y otro de costos))
        
        this.numberNations = n;
        int aux1;
        for(int k=0;k<=numberNations;k++){
            adjList.addElement(new Vector());
            adjCost.addElement(new Vector());
            armiesNation.addElement(0);
            armiesNeedNation.addElement(0);
        }
        System.out.println(armiesNation.size()+" size initial");
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
        //revisamo si las adyacencias esten bien// paso
        //revisamo si los costos de las madyacencias esten bien//paso
        //revisamos si el armies este bien de cada nacion //maso cuidado con el tamaño de armies
        //solucionando el problema 
        State st = doit(1,-1);
        
        long ret = st.getbaseCost();
        //System.out.println(ret+" iniciamos");
        for(int i = 0; i< -(st.getminInc()); i++ ){
            ret -= st.getHeap().top();
            //System.out.println(ret);
            st.getHeap().pop();
        }
        System.out.println(ret);
    }
    
    private State doit(int nd , int prev){
        State st =  new State();

        for(int i = 0;i< adjList.get(nd).size(); i++){
            if(adjList.get(nd).get(i) != prev){
                State st2 = doit(adjList.get(nd).get(i), nd);
                st.setminInc(st.getminInc() + st2.getminInc());
                //System.out.println(st2.getbaseCost() + " + "+ adjCost.get(nd).get(i)+ " * "+  java.lang.Math.abs(st2.getminInc()) + " check 1004");
                st.setbaseCost(st.getbaseCost() + st2.getbaseCost() + (long)(adjCost.get(nd).get(i) * java.lang.Math.abs(st2.getminInc())));


                st2.getHeap().setset1Base(st2.getHeap().getset1Base() + (long)(adjCost.get(nd).get(i)));
                
                st2.getHeap().setset2Base(st2.getHeap().getset2Base() +
                (long)adjCost.get(nd).get(i));
                
                st2.getHeap().pruneNeg();
                DoubleHeap auxHeap;
                
                if(st2.getHeap().size() > st.getHeap().size()){
                    auxHeap = st.getHeap();
                    st.setHeap(st2.getHeap());
                    st2.setHeap(auxHeap);
                }
                while(st2.getHeap().size()>0){
                    long v = st2.getHeap().top();
                    if(v <= 0) break;
                    st2.getHeap().pop();
                    st.getHeap().push(v);
                }
            }
        }
        
        st.setminInc(st.getminInc() + armiesNeedNation.get(nd) - armiesNation.get(nd));
        
        //ERROR
        st.getHeap().shiftPartition(java.lang.Math.max(0,-(st.getminInc())));
        
        return st;
    }
}