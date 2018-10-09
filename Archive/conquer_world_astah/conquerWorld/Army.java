package Archive.conquer_world_astah.conquerWorld;


/**
 * Write a description of class Army here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Army
{
    // instance variables - replace the example below with your own
    private int armiesNeeded;
    private int armyHave,width,height;
    private int[] pos; 
    private boolean isVisible;
   

    /**
     * Constructor for objects of class Army
     */
    public Army(int[] armies,int[] positions)
    {
        // initialise instance variables
        armiesNeeded =  armies[1];
        armyHave = armies[0];
        this.pos = positions;
        this.isVisible =false;
        
    }

    
    /**
     * Constructor for objects of class Army
     */
    public Army(int[] armies,int[] positions,int width,int height)
    {
        // initialise instance variables
        armiesNeeded =  armies[1];
        armyHave = armies[0];
        this.pos = positions;
        this.isVisible =false;
        this.width = width;
        this.height = height;
    }
    
    /**
     * Add armies to the ones, the nation already has
     *
     * @param  y, the number of armies to be added
     */
    public void setArmy(int y)
    {
        // put your code here
        armyHave += y;
    }    
    /**
     * Set the armies of the nation to 0
     * 
     */
    public void setArmy()
    {
        // put your code here
        armyHave=0;
    }    
    /**
     * Return the number of armies, the nation has
     *
     */
    public int getArmy()
    {
        // put your code here
        return armyHave;
    }
    
    /**
     * Make this visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    public void makeVisible(int x){
        isVisible = true;
        draw(x);
    }
    
    /**
     * Make this invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
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
        /*
     * Draw the square with current specifications on screen.
     */

    private void draw() {
        //System.out.println("okdraw");
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.drawString(Integer.toString(armyHave),pos[0]-5,pos[1]-5);
            canvas.drawString(Integer.toString(armiesNeeded),pos[0]+30,pos[1]-5);
        }
    }
    private void draw(int x) {
        //System.out.println("okdraw");
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.drawString(Integer.toString(armyHave),pos[0]-(width+5),pos[1]-(height+5));
            canvas.drawString(Integer.toString(armiesNeeded),pos[0]-(width-30),pos[1]-(height+5));
        }
    }
}
