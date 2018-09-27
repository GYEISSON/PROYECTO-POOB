import java.util.*;
import java.io.*;

/**
 * Write a description of class DoubleHeap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DoubleHeap
{
    // instance variables - replace the example below with your own
    private long set1Base, set2Base;
    private TreeSet<Long> set1, set2;
    
    /**
     * Constructor for objects of class DoubleHeap
     */
    public DoubleHeap()
    {
        set1 = new TreeSet<Long>();
        set2 = new TreeSet<Long>();
    }        
    // Make sure set 1 contains exactly "part" elements, padding with 0 if needed.
    public void shiftPartition(int part){
        System.out.println(set1.size()+ " " + part );
        while(set1.size() < part){
            System.out.println("ok while set1 < part" +" " +set1.size() +" "+ part  );
            if(set2.size()>0){
                //System.out.println("ok66666");
                set1.add(set2.last() + set2Base + set1Base);
                set2.remove(set2.last()-1);
            } else {
                 System.out.println("add");
                set1.add(-(set1Base));
            }            
        }
        //System.out.println("ok5");
        while(set1.size() > part){
            //System.out.println("ok6");
            set2.add(set1.first() + set1Base - set2Base);
            //System.out.println("ok7");
            set1.remove(set1.first());
        }
        //System.out.println("ok8");
    }
     
    public int size(){
        return set1.size()+set2.size();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void push(long  v)
    {
        if(!(set2.size()>0) || v - set2Base > set2.last()){
            set1.add(v - set1Base);
        }
        else{
            set2.add( v - set2Base);
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void pop()
    {
        if(set1.size() >0 ){
            set1.remove(set1.last()-1);
        }else{
            set2.remove(set2.last()-1);
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public long top()
    {
        if(set1.size()>0){
            return set1.last() + set1Base;
        }
        return set2.last()+set2Base;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void pruneNeg()
    {
        while(set2.size()>0  && (set2.first() + set2Base) < 0 ){
            set2.remove(set2.first());
        }
        while(set1.size() > 0 && (set1.first()+set1Base) < 0){
            set1.remove(set1.first());
        }
    }
    
    public long getset1Base(){ return this.set1Base;}
    public long getset2Base(){ return this.set2Base;}
    
    public void setset1Base(long newNum){ this.set1Base = newNum;}
    public void setset2Base(long newNum){ this.set2Base  =  newNum;}
}
