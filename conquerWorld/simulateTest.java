package conquerWorld;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class simulateTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class simulateTest
{
    /**
     * Default constructor for test class simulateTest
     */
    public simulateTest()
    {
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    @Test
    public void testing()
    {
        int[][] routes={{1,2,5},{3,1,5}};
        int[][] armies = {{3,2},{5,0},{1,3}};
        boolean slow = true;
        Simulate simulador = new Simulate(3);
        simulador.simulate(new int[][] {{1,2,5},{3,1,5}}, new int[][]{{2,1},{5,0},{1,3}},true);
        
    }
    
    // @Test
    // public void yeisson(){
        // ConquerWorld cw = new ConquerWorld(800, 800);
        // cw.addNation("pentagon", 3000, "blue", new int[]{200, 200},new int[] {3,2});
        
        // cw.addNation("triangle", 3000, "yellow", new int[]{350, 350},new  int[] {5,0});
        
       // cw.addNation("square", 3000, "red", new int[]{400, 500},new  int[] {1,3});
        
        // //cw.addNation("square", 3000, "red", new int[]{100, 400},new  int[] {10,23});
       // cw.addRoute(new String[] { "blue","yellow"},56);
       // cw.addRoute(new String[] { "red","blue"},56);
       // cw.addCash(1000000);
       // cw.makeVisible();
    
       // cw.moveArmy("blue","red");
       
    // }
}
