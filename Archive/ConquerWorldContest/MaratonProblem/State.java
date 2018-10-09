import java.util.*;
import java.io.*;


/**
 * Write a description of class State here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class State
{
    // instance variables - replace the example below with your own
    private int minInc;
    private long baseCost;
    DoubleHeap savings;

    /**
     * Constructor for objects of class State
     */
    public State()
    {
        minInc = 0;
        baseCost = 0;
        savings = new DoubleHeap();
    }
    
    public void deleteState(){
        savings = null;
    }
    
    public int getminInc(){ return this.minInc;}
    public void setminInc(int newminInc){ this.minInc = newminInc;}
    
    
    public long getbaseCost(){ return this.baseCost;}
    public void setbaseCost(long newbaseCost){ this.baseCost = newbaseCost;}
    
    public DoubleHeap getHeap(){return this.savings;}
    public void setHeap(DoubleHeap newHeap){ this.savings = newHeap;}
}
