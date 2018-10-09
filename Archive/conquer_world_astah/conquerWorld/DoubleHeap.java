package Archive.conquer_world_astah.conquerWorld;

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
    private HashMap<Long,Integer> hashSet1,hashSet2;
    
    /**
     * Constructor for objects of class DoubleHeap
     */
    public DoubleHeap
    ()
    {
        set1 = new TreeSet<Long>();
        set2 = new TreeSet<Long>();
        hashSet1 = new HashMap<Long,Integer>();
        hashSet2 =  new HashMap<Long,Integer>();
    }        
    // Make sure set 1 contains exactly "part" elements, padding with 0 if needed.
    public void shiftPartition(int part){
        long aux,aux2;
        while( sizeSet1() < part){            
            if(sizeSet2() > 0){
                aux2 = set2.last() + set2Base + set1Base;
                if(set1.contains(aux2)){
                    hashSet1.put(aux2,hashSet1.get(aux2)+1);                  
                }
                else{
                    set1.add(aux2);
                    hashSet1.put(aux2,1);
                }                                
                
                if(hashSet2.get(set2.last())==1){
                    hashSet2.remove(set2.last());
                    set2.remove(set2.last());
                }
                else{
                    hashSet2.put(set2.last(),hashSet2.get(set2.last())-1);
                }
            } else {
                if(set1.contains(-set1Base)){
                    hashSet1.put(-set1Base,hashSet1.get(-set1Base)+1);                
                }
                else{
                    set1.add(-(set1Base));
                    hashSet1.put(-set1Base,1);
                }
            }            
        }
        while(set1.size() > part){
            aux = set1.first() + set1Base - set2Base;
            if(set2.contains(aux)){
                hashSet2.put(aux,hashSet2.get(aux)+1);
            }
            else{
                set2.add(aux);
                hashSet2.put(aux,1);
            }
            if(hashSet1.get(set1.first())==1){
                hashSet1.remove(set1.first());
                set1.remove(set1.first());
            }
            else{
                hashSet1.put(set1.first(),hashSet1.get(set1.first())-1);
            }
            
        }
    }
    private long sizeSet1(){
        long realSize;
        realSize= 0;
        for(long element: set1){
            realSize += hashSet1.get(element);
        }
        return realSize;
    }
    private long sizeSet2(){
        long realSize;
        realSize= 0;
        for(long element: set2){
            realSize += hashSet2.get(element);
        }
        return realSize;
    }
    public long size(){
        long realSize;
        realSize= 0;
        for(long element: set1){
            realSize += hashSet1.get(element);
        }
        for(long e: set2){
            realSize += hashSet2.get(e);
        }
        
        return realSize;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void push(long  v)
    {
        long aux;
        if(!(set2.size()>0) || (v - set2Base) > set2.last()){
            aux = v - set1Base;
            if(set1.contains(aux)){
                hashSet1.put(aux,hashSet1.get(aux)+1);
            }
            else{
                set1.add(aux);
                hashSet1.put(aux,1);
            }
        }
        else{
            aux = v - set2Base;
            if(set2.contains(aux)){
                hashSet2.put(aux,hashSet2.get(aux)+1);
            }
            else{
                set2.add(aux);
                hashSet2.put(v - set2Base,1);        
            }
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
            if(hashSet1.get(set1.last())==1){                
                hashSet1.remove(set1.last());
                set1.remove(set1.last());
            }
            else{
                hashSet1.put(set1.last(),hashSet1.get(set1.last())-1);
            }            
        }else{            
            if(hashSet2.get(set2.last())==1){                
                hashSet2.remove(set2.last());
                set2.remove(set2.last());
            }
            else{
                hashSet2.put(set2.last(),hashSet2.get(set2.last())-1);
            }            
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
            if(hashSet2.get(set2.first())==1){
                hashSet2.remove(set2.first());
                set2.remove(set2.first());
            }
            else{
                hashSet2.put(set2.first(),hashSet2.get(set2.first())-1);
            }
        }
        while(set1.size() > 0 && (set1.first()+set1Base) < 0){
            if(hashSet2.get(set2.first())==1){
                hashSet2.remove(set2.first());
                set2.remove(set2.first());
            }
            else{
                hashSet2.put(set2.first(),hashSet2.get(set2.first())-1);
            }
        }
    }
    
    public long getset1Base(){ return this.set1Base;}
    public long getset2Base(){ return this.set2Base;}
    
    public void setset1Base(long newNum){ this.set1Base = newNum;}
    public void setset2Base(long newNum){ this.set2Base  =  newNum;}
}
