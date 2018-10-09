package Archive.conquer_world_astah.conquerWorld;

import java.awt.*;

/**
 * A pentagon that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Yeisson Gualdron and Santiago Rubiano
 * @version 1.3  (30 August 2018)
 */

public class Pentagon{
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    public String color;
    private boolean isVisible;

    /**
     * Create a new pentagon at default position with default color.
     */
    public Pentagon(){
        height = 30;
        width = 40;
        xPosition = 140;
        yPosition = 150;
        color = "green";
        isVisible = false;
    }

    /**
     * Make this pentagon visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this pentagon invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    

    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidht must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
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
     * Change the old position to a new position
     */
    public void changePos(int newX, int newY) {
        erase();
        xPosition = newX;
        yPosition = newY;
        draw();
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
     * Draw the pentagon with current specifications on screen.
     */
    private void draw(){
        if(isVisible) {

            
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { xPosition-width, xPosition, xPosition + width,xPosition + (width/2),xPosition-(width/2) };
            int[] ypoints = { yPosition, yPosition + height, yPosition,yPosition-height,yPosition-height};
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 5));
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
