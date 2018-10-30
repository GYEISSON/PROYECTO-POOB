package conquerWorld;
import shapes.*;

/**
 * Write a description of class Proactive here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Proactive extends Army
{
    private int move;
    /**
     * Constructor for objects of class NormalA
     */
    public Proactive(int[] armies,int[] positions,Canvas mundo)
    {
        super(armies,positions,mundo);
        move = 0;
    }
    /**
     * Constructor for objects of class NormalA
     */
    public Proactive(int[] armies,int[] positions,int width,int height,Canvas mundo)
    {
        super(armies,positions,width,height,mundo);
        move = 0;
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
        armyHave += y;
        makeVisible();
        move++;
    }    
    /**
     * Set the armies of the nation to 0
     * 
     */
    public void setArmy()
    {
        // put your code here
        makeInvisible();
        armyHave=0;
        makeVisible();
        move++;
    }  
    public boolean canRemoveA(){
        return (move<2)? true: false;
    }
}
