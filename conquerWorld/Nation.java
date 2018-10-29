package conquerWorld;
import shapes.*;
import java.lang.*;
import java.awt.*;
import java.util.*;
/**
 * A nation that contains a determined shape and a determined color.
 * 
 * @author  Yeisson Gualdron and Santiago Rubiano
 * @version 4.3  (30 August 2018)
 */
public class Nation
{
    // instance variables - replace the example below with your own
    private String nationShape;
    private shapes.Canvas mundo;
    private int area;
    private String color;
    private int[] position;
    private Army army;
<<<<<<< HEAD:Archive/conquer_world_astah/conquerWorld/Nation.java
  
=======
>>>>>>> 39c281156b311876016322698dc5899394ae9d13:conquerWorld/Nation.java
    private int puntos;
    public static double PI=3.1416;
    private Figure figure;
    private int height;
    private int width;
    
    private ArrayList<Figure> figures = new ArrayList<Figure>();
    /**
     * Constructor for objects of class nation
     */
    public Nation(String shape,int area,String color,int[] pos,int[] armies,shapes.Canvas mundo)
    {
        // initialise instance variables
        this.color = color;
        this.position=pos;
        this.nationShape = shape;
        this.mundo = mundo;
        if (shape.equals("square"))
        {
            figure = new Square();
            figure.changeColor(color);
            figure.changeSize(((int)Math.sqrt(area)),((int)Math.sqrt(area)));
            figure.changePos(position[0],position[1]);
            this.width=((int)Math.sqrt(area));
            this.height=((int)Math.sqrt(area));
            figures.add(figure);

        }
        else if(shape.equals("circle"))
        {
            figure = new Circle();
            figure.changeColor(color);
            figure.changeSize(((int)(Math.sqrt(area/PI)))*2,0);
            figure.changePos(position[0],position[1]);
            this.width=((int)(Math.sqrt(area/PI)))*2;
            this.height=((int)(Math.sqrt(area/PI)))*2;
            figures.add(figure);

        }
        
        else if(shape.equals("triangle"))
        {
            figure = new Triangle();
            figure.changeColor(color);
            figure.resize(area);
            figure.changePos(position[0],position[1]);
            this.width=(int)Math.sqrt(2*area);
            this.height = (int)Math.sqrt(2*area);
            figures.add(figure);
        }
        
        else if(shape.equals("pentagon"))
        {
            figure = new Pentagon();
            figure.changeColor(color);
            figure.resize(area);
            figure.changePos(position[0],position[1]);
            this.width=(int)Math.sqrt(2*area);
            this.height = (int)Math.sqrt(2*area);
            figures.add(figure);
            army = new Army(armies,pos,this.width,this.height,mundo);
        }
        else if(shape.equals("rectangle"))
        {
            figure = new Recta();
            figure.changeColor(color);
            figure.resize(area);
            figure.changePos(position[0],position[1]);
            this.width=(int)(Math.sqrt(2*area))/2;
            this.height = (int)Math.sqrt(2*area);
            figures.add(figure);
            
        }
        //funciona el army si no es un pentagono
        if(!shape.equals("pentagon")){
            army = new Army(armies,pos,mundo);
        }
        
    }
    /**
     * Make all the corresponding shapes of a nation, invisible. 
     * If it was already invisible, do nothing.
     *
     */
    public void makeInvisible(){     
        for (Figure o:figures)
        {
            o.makeInvisible();
        }

        army.makeInvisible();
    }      
    /**
     * Make all the corresponding shapes of a nation, invisible. 
     * If it was already invisible, do nothing.
     *
     */
    public void makeVisible()
<<<<<<< HEAD:Archive/conquer_world_astah/conquerWorld/Nation.java
    {          
        for (Rectangle r:rec)
        {
            r.makeVisible();
            army.makeVisible();
        }
        for (Triangle t:tri)
=======
    {        // put your code her       
        for (Figure o:figures)
>>>>>>> 39c281156b311876016322698dc5899394ae9d13:conquerWorld/Nation.java
        {
            o.makeVisible();
            if (o instanceof Pentagon){
                army.makeVisible(1);
            }
        }
        
    }       
    /**
     *Delete all the corresponding shapes of a nation.
     *
     * @param  color of the nation to be removed
     */
    public void removeNationF(String color){ 
        for (Figure o:figures)
        {
            if (o.color == color) o.delete();
        }
    }
    /**
     * Return the color of the current nation
     *
     * @return    color of current nation
     */
    public String getColor(){
    
        return this.color;
    }
    /**
     * Return the position of the current nation
     *
     * @return    Return the position of the current nation
     */
    public int[] getPosition()
    {
        // put your code here
        return this.position;
    }
    /**
     * Add armies to the ones, the nation already has
     *
     * @param  y, the number of armies to be added
     */
    public void setArmy(int y)
    {
        // put your code here
        army.setArmy(y);
    }    
    /**
     * Set the armies of the nation to 0
     * 
     */
    public void setArmy()
    {
        // put your code here
        army.setArmy();
    }    
    /**
     * Return the number of armies, the nation has
     *
     */
    public int getArmyN()
    {
        // put your code here
        return army.getArmyN();
    }
    /**
     * Return the number of armies, the nation has
     *
     */
    public int getArmyH()
    {
        // put your code here
        return army.getArmyH();
    }
    /**
     * Return the shape of the current nation
     *
     ** @return    Return String shape
     */
    public String getShape()
    {
        // put your code here
        return this.nationShape;
    }    
     /**
     * Return the width of the current nation
     *
     ** @return    Return int width
     */
    public int getWidth(){
        return width;
    }    
    /**
     * Return the height of the current nation
     *
     ** @return    Return int height
     */
    public int getHeight(){
        return height;
    }
}