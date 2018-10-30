package conquerWorld;


/**
 * Write a description of class Still here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Still extends Nation
{
    /**
     * Constructor for objects of class Normal
     */
    public Still(String shape,int area,String color,int[] pos,int[] armies,shapes.Canvas mundo)
    {
        // initialise instance variables
        super(shape,area,color,pos,armies,mundo);
    }
    /**
     * @return si es posible que la nacion realice ese comportamiento
     */
    public boolean canRemoveR(){
        return false;
    }
}
