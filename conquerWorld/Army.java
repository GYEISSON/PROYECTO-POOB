package conquerWorld;

import shapes.*;
/**
 * Write a description of class Army here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Army
{
    // instance variables - replace the example below with your own
    private int armiesNeeded;
    private int armyHave,width,height;
    private int[] pos; 
    private boolean isVisible;
    Canvas mundo;

    /**
     * Constructor for objects of class Army
     */
    public Army(int[] armies,int[] positions,Canvas mundo)
    {
        // initialise instance variables
        armiesNeeded =  armies[1];
        armyHave = armies[0];
        this.pos = positions;
        this.isVisible =false;
        this.mundo = mundo;
    }

    
    /**
     * Constructor for objects of class Army
     */
    public Army(int[] armies,int[] positions,int width,int height,Canvas mundo)
    {
        // initialise instance variables
        armiesNeeded =  armies[1];
        armyHave = armies[0];
        this.pos = positions;
        this.isVisible =false;
        this.width = width;
        this.height = height;
        this.mundo = mundo;
    }
    
    /**
     * Add armies to the ones, the nation already has
     *
     * @param  y, the number of armies to be added
     */
    public void setArmy(int y)
    {
        // put your code here
        makeInvisible();
        armyHave += y;
        makeVisible();
    }    
    /**
     * Set the armies of the nation to 0
     * 
     */
    public void setArmy()
    {
        // put your code here
        makeInvisible();
        armyHave=0;
        makeVisible();
    }    
    /**
     * Return the number of armies, the nation has
     *
     */
    public int getArmyH()
    {
        // put your code here
        return armyHave;
    }
    /**
     * Return the number of armies, the nation need
     *
     */
    public int getArmyN()
    {
        // put your code here
        return armiesNeeded;
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
        //System.out.println("makeinvis_army");
        erase();
        isVisible = false;
    }

    
    /**
     * Erase the army on screen.
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

    private void draw(){

        if(isVisible) {
            
            mundo.drawString(Integer.toString(armyHave),pos[0]-5,pos[1]-5);
            mundo.drawString(Integer.toString(armiesNeeded),pos[0]+30,pos[1]-5);
        }
    }
    private void draw(int x) {
        
        if(isVisible) {
            
            mundo.drawString(Integer.toString(armyHave),pos[0]-(width-30),pos[1]-(height+5));
            mundo.drawString(Integer.toString(armiesNeeded),pos[0]-(width-100),pos[1]-(height+5));
        }
    }
        /**
     * @return si es posible que la nacion realice ese comportamiento
     */
    public boolean canRemoveA(){
        return true;
    } 
}
