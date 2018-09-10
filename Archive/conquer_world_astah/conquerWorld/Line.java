import java.awt.*;
import java.awt.geom.*;

/**
 * A pentagon that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Yeisson Gualdron and Santiago Rubiano
 * @version 1.3  (30 August 2018)
 */

public class Line{
    private int diameter;
    private int xPosition;
    private int yPosition;
    public String color;
    private boolean isVisible;
    private double area;
    private double radius;
    private int x1,y1,x2,y2;
    private Line2D.Double line;

    /**
     * Create a new pentagon at default position with default color.
     */
    public Line(){
        x1=y1=0;
        x2=y2=100;
        color = "yellow";
        isVisible = false;
    }
 
    /**
     * Make this line visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this line invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }

    /**
     * Draw the line with current specifications on screen.
     */
    private void draw(){
        if(isVisible) {
            line =new Line2D.Double(); 
            line.setLine(50,50,100,100);
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, line);
            canvas.wait(10);
            System.out.println(line.getY1());
            
        }
    }
    /**
     * Erase the pentagon on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
}
