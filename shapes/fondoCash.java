package shapes;

/**
 * Write a description of class fondoCash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fondoCash
{
    
    public fondoCash(int maxX) {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, "red",(new java.awt.Rectangle(0, 0,maxX,10)));
    }
}
