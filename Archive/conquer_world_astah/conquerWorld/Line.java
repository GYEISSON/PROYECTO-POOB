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

    /**
     * Create a new pentagon at default position with default color.
     */
    public Line(int x1,int y1,int x2,int y2){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        
        color = "black";
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
            int[] xpoints = { x1, x2, x2, x1};
            int[] ypoints = { y1, y2, y2+5, y1+5};
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 4));
            canvas.wait(10);
            
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
