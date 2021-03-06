package conquerWorld;


/**
 * A nation that contains a determined shape and a determined color.
 * 
 *
 * @author  (Yeisson Gualdron y Santiago Rubiano)
 * @version (9.3)
 */
public class SteadyN extends Nation
{
    /**
     * Constructor for objects of class Normal
     */
    public SteadyN(String shape,int area,String color,int[] pos,int[] armies,shapes.Canvas mundo)
    {
        // initialise instance variables
        super(shape,area,color,pos,armies,mundo);
    }
    /**
     * @return si es posible que la nacion realice ese comportamiento
     */
    public boolean canRemoveN(){
        return false;
    } 
    /**
     * @return si es posible que la nacion realice ese comportamiento
     */
    public boolean canRemoveR(){
        return false;
    }
}
