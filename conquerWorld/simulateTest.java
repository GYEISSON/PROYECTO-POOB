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
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
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
        simulate board = new simulate(3);
        board.jugar(routes,armies,slow);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
}
