package Archive.conquer_world_astah.conquerWorld;


/**
 * Write a description of class Army here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Army
{
    // instance variables - replace the example below with your own
    private int armiesNeeded;
    private int armyHave;

    /**
     * Constructor for objects of class Army
     */
    public Army()
    {
        // initialise instance variables
        armiesNeeded = armyHave = 0;
    }

    /**
     * Add armies to the ones, the nation already has
     *
     * @param  y, the number of armies to be added
     */
    public void setArmy(int y)
    {
        // put your code here
        armyHave += y;
    }    
    /**
     * Set the armies of the nation to 0
     * 
     */
    public void setArmy()
    {
        // put your code here
        armyHave=0;
    }    
    /**
     * Return the number of armies, the nation has
     *
     */
    public int getArmy()
    {
        // put your code here
        return armyHave;
    }
}
