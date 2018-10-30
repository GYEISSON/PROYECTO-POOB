package conquerWorld;

import shapes.*;
/**
 * Write a description of class SteadyA here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SteadyA extends Army
{
    /**
     * Constructor for objects of class NormalA
     */
    public SteadyA(int[] armies,int[] positions,Canvas mundo)
    {
        super(armies,positions,mundo);
    }
    /**
     * Constructor for objects of class NormalA
     */
    public SteadyA(int[] armies,int[] positions,int width,int height,Canvas mundo)
    {
        super(armies,positions,width,height,mundo);
    }
    /**
     * @return si es posible que la nacion realice ese comportamiento
     */
    public boolean canRemoveN(){
        return false;
    } 
}
