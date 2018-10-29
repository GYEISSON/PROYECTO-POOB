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
    	this.nations = n;
        solution = 0;
        cw = new ConquerWorld(1000,1000);
        path = new int[nations+1][nations+1];
        mat = new int[nations+1][nations+1];
        xI = new int[nations+1];
        yI = new int[nations+1];
        donantes = new Vector<Integer>();
        necesitados = new Vector<Integer>();
    }

    
    public void simulate(int[][] routes,int[][] armies, boolean slow){
        cw.addNation("pentagon",2500,"blue",new int[] {200,200},armies[0]);
        cw.addNation("triangle",2000,"yellow",new int[] {450,350},armies[1]);
        cw.addNation("rectangle",2000,"red",new int[] {500,150},armies[2]);
        cw.addRoute(new String[] {"blue","yellow"},routes[0][2]);
        cw.addRoute(new String[] {"red","blue"},routes[1][2]);
        cw.makeVisible();
        //llenamos la matriz de distancias de  infinitos
        for(int i=0;i<=nations;i++) {
            for(int j=0;j<=nations;j++) {
                if(i==j) { mat[i][j]=0;}
                else { mat[i][j]=max_int;}
                path[i][j]=i;
            }
        }
        for(int i=0 ; i< nations-1;i++){
        	mat[routes[i][0]][routes[i][1]] = routes[i][2]; mat[routes[i][1]][routes[i][0]] = routes[i][2];
        }
        for(int k=1;k<=nations;k++) {
            xI[k] = armies[k-1][0]; yI[k] = armies[k-1][1];
            if(x>y) donantes.add(k);
            else if(x < y) necesitados.add(k);
        }
        floyd_Warshall();
        System.out.println(solve());
    }
    public static void floyd_Warshall() {
        for(int k=0;k<=nations;k++) {
            for(int i=0;i<=nations;i++) {
                for(int j=0;j<=nations;j++) {
                    if(mat[i][j]>mat[i][k]+mat[k][j]) {
                        mat[i][j]=mat[i][k]+mat[k][j];
                        path[i][j]=path[k][j];
                    }

                }
            }
        }
    }
    private static int flowPath(int source, int target,int value) {
        int cost=mat[source][target];
        while(source != target) {
            xI[source]-=value;
            source = path[target][source];
            xI[source]+= value;
        }
        return cost;
    }
    private static long solve() {
        int xneed,ydon,ydonpos,value;
        long cost=0;
        while(necesitados.size()>0) {
            xneed=necesitados.get(0);
            ydon = donantes.get(0);
            ydonpos = 0;
            for(int i=0;i<donantes.size();i++) {
                if(mat[donantes.get(i)][xneed] < mat[ydon][xneed]) {
                    ydon = donantes.get(i);
                    ydonpos = i;
                }
            }
            if((xI[ydon]-yI[ydon]) <= (yI[xneed]-xI[xneed])) { value = xI[ydon]-yI[ydon]; }
            else { value = yI[xneed]-xI[xneed]; }
            cost += flowPath(ydon,xneed,value);
            if(xI[xneed]>=yI[xneed]) necesitados.remove(0);
            if(xI[ydon]==yI[ydon]) donantes.remove(ydonpos);
        }
        return cost;
    }

}
