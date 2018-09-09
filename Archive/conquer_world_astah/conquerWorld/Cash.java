import java.awt.*;

/**
 * Manage the cash of the game.
 * 
 * 
 * @author  Yeisson Gualdron and Santiago Rubiano
 * @version 1.2  (30 August 2018)
 */
public class Cash
{
    // instance variables - replace the example below with your own
    private int cash;
    private long cont;
    private int height;
    private long width;
    private long maxweight;
    private long xPosition;
    private long yPosition;
    private boolean isVisible;
    private String color;
    private Graphics g;
    private ConquerWorld c;
    

    /**
     * Constructor for objects of class Presupuesto
     */
    public Cash(int cash,int maxweight)
    {
        // initialise instance variables
        height = 40;
        width = maxweight;
        cont = 0;
        xPosition = 0;
        yPosition = 0;
        isVisible = true;
        color = "blue";
        draw();
    }
    private void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,(new java.awt.Rectangle(0, 0,cash,height)));
        }
    }
    /*
     * Erase the rectangle on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void addCash(long newWidth) {
        erase();
        cont+=newWidth;
        System.out.println(cont);
        System.out.println(width);
        double x = (width*cont)/1000000000;
        System.out.println(x);
        cash = (int)x;
        draw();
    }

}
