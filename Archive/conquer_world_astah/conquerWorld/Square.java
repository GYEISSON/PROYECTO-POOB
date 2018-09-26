package Archive.conquer_world_astah.conquerWorld;

import java.awt.*;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes (Modified)
 * @version 1.0  (15 July 2000)()
 */


 
public class Square{

    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    public String color;
    private boolean isVisible;

    /**
     * Create a new square at default position with default color.
     */
    public Square(){
        height = 50;
        width = 50;
        xPosition = 10;
        yPosition = 10;
        color = "green";
        isVisible = false;
    }
       /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void delete()
    {
        // put your code here
        erase();
    }


    /**
     * Make this square visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this square invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidth must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
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

    /*
     * Draw the square with current specifications on screen.
     */

    private void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
        new java.awt.Rectangle(xPosition, yPosition, width, height));
            canvas.wait(10);
        }
    }

    /*
     * Erase the square on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}

