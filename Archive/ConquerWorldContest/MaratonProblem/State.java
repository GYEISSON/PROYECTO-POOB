import java.util.*;
import java.io.*;


/**
 * Write a description of class State here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class State
{
    // instance variables - replace the example below with your own
    private int minInc;
    private long baseCost;
    DoubleHeap savings;

    /**
     * Constructor for objects of class State
     */
    public State()
    {
        minInc = 0;
        baseCost = 0;
        savings = new DoubleHeap();
    }


}
