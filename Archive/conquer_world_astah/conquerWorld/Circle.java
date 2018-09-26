package Archive.conquer_world_astah.conquerWorld;

import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0.  (15 July 2000) 
 */

public class Circle{

    public static double PI=3.1416;
    
    private int diameter;
    private int xPosition;
    private int yPosition;
    public String color;
    private boolean isVisible;
    private double area;
    private double radius;
    
    /**
     * Create a new circle at default position with default color.
     */
    public Circle(){
        diameter = 30;
        xPosition = 20;
        yPosition = 15;
        color = "blue";
        isVisible = false;
    }
    /**
     * Deletes the current shape
     *
     */
    public void delete()
    {
        // put your code here
        erase();
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Change the size.
     * @param newDiameter the new size (in pixels). Size must be >=0.
     */
    public void changeSize(int newDiameter){
        erase();
        diameter = newDiameter;
        draw();
    }
    
    /**
     * Change the old position to a new position
     */
    public void changePos(int newX, int newY) {
        erase();
        xPosition = newX;
        yPosition = newY;
        draw();
    }
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }

    /**
     * Draw the circle with current specifications on screen.
     */
    private void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, 
                new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
            canvas.wait(10);
        }
    }

    /**
     * Erase the circle on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }

    /**
     * Change the size of the circle from the area
     */
    public void resize(double area){
        changeSize((int)(2* Math.pow(area/PI,0.5)));
    }
}
