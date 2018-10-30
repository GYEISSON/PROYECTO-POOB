package conquerWorld;
import shapes.*;
import java.util.*;

/**
 * Write a description of class Wanderer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wanderer
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Wanderer
     */
    public Wanderer()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void movingArmy(long cash, String nation,ArrayList<Route> routes,ConquerWorld cw)
    {   
        if(cash>0){
            for(Route r: routes){
                if(r.getFrom().equals(nation)){
                    cw.moveArmy(nation,r.getTo());
                    movingArmy(cash,r.getTo(),routes,cw);
                }
            }
        }
    }
}
