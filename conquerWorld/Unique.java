package conquerWorld;
import shapes.*;
import java.util.*;


/**
 * Write a description of class Unique here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Unique extends Army
{

    /**
     * Constructor for objects of class NormalA
     */
    public Unique(int[] armies,int[] positions,Canvas mundo)
    {
        super(armies,positions,mundo);
    }
    /**
     * Constructor for objects of class NormalA
     */
    public Unique(int[] armies,int[] positions,int width,int height,Canvas mundo)
    {
        super(armies,positions,width,height,mundo);
    }
    /**
     * Add armies to the ones, the nation already has
     *
     * @param  y, the number of armies to be added
     */
    public void setArmy(int y)
    {
        // put your code here
        makeInvisible();
        armyHave = y;
        makeVisible();
    }  
}
