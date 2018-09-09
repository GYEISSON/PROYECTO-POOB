import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;

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
    private boolean isVisible = true;
    private String color = "black";

     /**
     // * Constructor for objects of class Ruta
     // */
     public Route(int[] aPos,int[] bPos,int cost)
     {
        // initialise instance variables
        int x1,y1,x2,y2;
        this.cost=cost;
        x1=aPos[0];
        y1=aPos[1];
        x2=bPos[0];
        y2=bPos[1];
        
        System.out.println(x1);
        System.out.println(y1);
        System.out.println(x2);
        System.out.println(y2);

        Canvas canvas = Canvas.getCanvas();
        canvas.drawLine(x1, y1, x2, y2);
        
        // Canvas canvas = Canvas.getCanvas();
        // int[] xpoints = { x1, x2, x2,x1 };
        // int[] ypoints = { y1, y2, y2+20,y1+20};
        // canvas.draw(this, color, new Polygon(xpoints, ypoints, 4));
    }        
    
}