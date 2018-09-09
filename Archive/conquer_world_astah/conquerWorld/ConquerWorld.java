import java.util.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Manage all the nations and also ConquerWorld the canvas .
 * 
 * @author (Yeisson Gualdron y Santiago Rubiano)
 * @version 2.4.  (21 August 2018)
 */
public class ConquerWorld
{
    // instance variables - replace the example below with your own
    private Canvas mundo;
    private ArrayList<Nation> arrayNations;
    private ArrayList<Route> routes;
    private Nation nation;
    private boolean isVisible;
    private int maxX;
    private Cash cash;
    /**
     * Constructor for objects of class conquerWorld
     */
    public ConquerWorld(int maxX,int maxY){
        // initialise instance variables
        this.maxX = maxX;
        mundo = mundo.getCanvas(maxX,maxY);
        arrayNations = new ArrayList<Nation>();
        routes = new ArrayList<Route>();
        isVisible = false;
        fondoCash f = new fondoCash(maxX);
        cash = new Cash(0,maxX);
    }   
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void addCash(int c){
        cash.addCash(c);
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addNation(String shape, int area,String color,int[] position, int armiesNeeded){
        if(canPut(position)){
            nation = new Nation(shape,area,color,position);
            arrayNations.add(nation);
        }
        else{
            JOptionPane.showMessageDialog(null,"El lugar esta ocupado por otra figura");
        }
    }    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void removeNation(String removeColor)
    {        
        String colorob;
        for(int i=0;i<arrayNations.size();i++){
            colorob= arrayNations.get(i).getColor();
            if(arrayNations.get(i).getColor()==removeColor){
                arrayNations.get(i).removeNationF(removeColor);
                arrayNations.remove(i);
                break;
            }                    
        }        
    }    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addRoute(String[] nations,int cost){
        int[] aPosition={0,0},bPosition={0,0};        
        for(Nation ob : arrayNations){
            System.out.println(ob.getColor());
            if(ob.getColor()== nations[0]){
                aPosition = ob.getPosition();
            }
            else if( ob.getColor()==nations[1]){
                bPosition = ob.getPosition();
            }
        }
        Route route = new Route(aPosition,bPosition,cost);        
        routes.add(route);        
    }    
    /**
     * 
     */
    public void erase(){
        mundo.erase();
    }                 
    /**
     * 
     */
    public void makeVisible(){
        for (Nation c:arrayNations)
        {
            c.makeVisible();
        }
    }      
     /**
     * 
     */
    public void makeInvisible(){
        for (Nation c:arrayNations)
        {
            c.makeInvisible();
        }
    }
        /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addArmy(String nation){
        // put your code here
        for(Nation n : arrayNations){
            if(n.getColor() == nation ){
                n.setArmy(10);
            }
        }
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addArmies(String[] nations){
        for(int j=0;j<nations.length;j++){
            addArmy(nations[j]);
        }
    }
    public void removeArmies(String nation){
        for(Nation n : arrayNations){
            if(n.getColor() == nation ){
                n.setArmy();
            }
        }
    }    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void moveArmy(String fromNation,String toNation)
    {
        // put your code here
        Nation object1 = getNation(fromNation),object2=getNation(toNation);
        object2.setArmy(object1.getArmy());
        object1.setArmy();
    }
    private Nation getNation(String nationName){
        int[] pos={1,1};
        Nation x= new Nation("triangle",1,"blue",pos);
        
        for(Nation n: arrayNations){    
            if(n.getColor() == nationName){ 
                return n;
            }
        }       
        return x;
    }    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private boolean canPut(int[] positions){
        for(Nation nation: arrayNations){
            if(isFigure(positions[0],positions[1],nation)) return false;
        }
        return true;
    }
   /**
     * Check if a figure is on top of another
     * 
     * @return    int xPoint,int yPoint,Nation toNation
     */
    private boolean isFigure(int xPoint,int yPoint,Nation toNation){
        int[] natPosition = toNation.getPosition();
        int xPosNation=natPosition[0],yPosNation= natPosition[1];
        int wNation = toNation.getWidth(),hNation= toNation.getHeight();
        String shapeNation =toNation.getShape(); 
        
        if(shapeNation=="triangle"){
            if( xPoint<=xPosNation+(wNation/2) && xPoint>= xPosNation-(wNation/2) 
               && (yPoint>=yPosNation && yPoint<= yPosNation+hNation)){
                return true;
            }
        }
        else if(shapeNation == "Pentagon"){
            if(xPoint<=xPosNation+wNation && xPoint>= xPosNation-wNation 
                && (yPoint >= yPosNation-hNation && yPoint<=yPosNation+hNation )){
                return true;
            }
        }
        else if(shapeNation == "circle"){
            if((xPoint>=xPosNation && xPoint <= xPosNation+wNation ) && (yPoint>=yPosNation && yPoint<=yPosNation+hNation)){
                return true;
            }
        
        }
        else if(shapeNation == "rectangle"){
            if((xPoint >= xPosNation && xPoint <= xPosNation+wNation) && (yPoint >= yPosNation && yPoint <= yPosNation+hNation)){
                return true;
            }
        }
        else{
            if((xPoint >= xPosNation && xPoint <= xPosNation+wNation) && (yPoint >= yPosNation && yPoint <= yPosNation+hNation)){
                return true;
            }
            else return false;
        }
        return false;
    }
}