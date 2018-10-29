package conquerWorld;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class simulate.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Simulate
{
    private int solution;
    private ConquerWorld cw;
    
    
    
    private static Scanner in;
    private static int nations,u,v,c,x,y;
    private static int[][] path,mat;
    private static int[] xI,yI;
    private static final int  max_int = 429496729;
    private static Vector<Integer> donantes,necesitados;
    /**
     * Default constructor for test class simulate
     */
    public Simulate(int n)
    {
        solution = 0;
        cw = new ConquerWorld(1000,1000);
    }

    
    public void simulate(int[][] routes,int[][] armies, boolean slow){
        cw.addNation("pentagon",2500,"blue",new int[] {200,200},armies[0]);
        cw.addNation("triangle",2000,"yellow",new int[] {450,350},armies[1]);
        cw.addNation("rectangle",2000,"red",new int[] {500,150},armies[2]);
        cw.addRoute(new String[] {"blue","yellow"},routes[0][2]);
        cw.addRoute(new String[] {"red","blue"},routes[1][2]);
        cw.makeVisible();
    }
    
    
    
}
