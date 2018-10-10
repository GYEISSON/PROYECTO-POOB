package Archive.conquer_world_astah.conquerWorld;



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
public class simulate
{
    private int solution;
    private Solve agente;
    private ConquerWorld cw;
    /**
     * Default constructor for test class simulate
     */
    public simulate(int n)
    {
        solution = 0;
        agente  = new Solve( n);
        cw = new ConquerWorld(1000,1000);
    }

    
    public void jugar(int[][] routes,int[][] armies, boolean slow){
        agente.init(routes,armies);
        cw.addNation("pentagon",2500,"blue",new int[] {200,200},armies[0]);
        cw.addNation("triangle",2000,"yellow",new int[] {450,350},armies[1]);
        cw.addNation("rectangle",2000,"red",new int[] {500,150},armies[2]);
        cw.addRoute(new String[] {"blue","yellow"},routes[0][2]);
        cw.addRoute(new String[] {"red","blue"},routes[1][2]);
        cw.makeVisible();
        cw.moveArmy("blue","red");
    }
}
