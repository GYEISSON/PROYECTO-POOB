import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.*;

/**
 * A route connects two nations with a cost to move armies between them.
 * 
 * @author  Yeisson Gualdron and Santiago Rubiano
 * @version 2.3  (30 August 2018)
 */

public class Route
{
    // instance variables - replace the example below with your own
    private int[] aPosition, bPosition;
    private int cost;
    private boolean isVisible = false;
    private String color;
    private String nationA,nationB;
    private double x1,y1,x2,y2;

     /**
     // * Constructor for objects of class Ruta
     // */
     public Route(int[] aPos,int[] bPos,int cost,String from,String to)
     {
        // initialise instance variables
        this.nationA=from;
        this.nationB=to;
        this.cost=cost;
        color = "black";
        
        x1=aPos[0];
        y1=aPos[1];
        x2=bPos[0];
        y2=bPos[1];

        Canvas canvas = Canvas.getCanvas();
        // mundo.drawLine(x1, y1, x2, y2);
        int r = (int)(Math.random()*((256-0)+1))+0;
        int g = (int)(Math.random()*((256-0)+1))+0;
        int b = (int)(Math.random()*((256-0)+1))+0;
        
        // canvas.draw(this, "black",new Line2D.Double(x1,y1,x2,y2));
        // canvas.wait(10);
        isVisible = true;
        draw();
    }        
    
    /**
     * Draw the pentagon with current specifications on screen.
     */
    private void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,new Line2D.Double(x1,y1,x2,y2));
            canvas.wait(10);
            
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void removeR(int[] aPos,int[] bPos)
    {
        // put your code here
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public String getFrom()
    {
        // put your code here
        return nationA;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public String getTo()
    {
        // put your code here
        return nationB;
    }

}