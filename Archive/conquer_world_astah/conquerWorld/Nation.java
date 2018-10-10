package Archive.conquer_world_astah.conquerWorld;

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
    Canvas mundo;
    private int area;
    private String color;
    private int[] position;
    private Army army;
    

    private int puntos;
    public static double PI=3.1416;
    private Square square;
    private Rectangle rectangle;
    private Triangle triangle;
    private Pentagon pentagon;
    private Circle circle;
    private int height;
    private int width;
    
    private ArrayList<Triangle> tri = new ArrayList<Triangle>();
    private ArrayList<Rectangle> rec = new ArrayList<Rectangle>();
    private ArrayList<Circle> cir = new ArrayList<Circle>();
    private ArrayList<Square> sqr = new ArrayList<Square>();
    private ArrayList<Pentagon> pen = new ArrayList<Pentagon>();   
    /**
     * Constructor for objects of class nation
     */
    public Nation(String shape,int area,String color,int[] pos,int[] armies,Canvas mundo)
    {
        // initialise instance variables
        this.color = color;
        this.position=pos;
        this.nationShape = shape;
        this.mundo = mundo;
        if (shape.equals("square"))
        {
            square = new Square();
            square.changeColor(color);
            square.changeSize(((int)Math.sqrt(area)),((int)Math.sqrt(area)));
            square.changePos(position[0],position[1]);
            this.width=((int)Math.sqrt(area));
            this.height=((int)Math.sqrt(area));
            sqr.add(square);

        }
        else if(shape.equals("circle"))
        {
            circle = new Circle();
            circle.changeColor(color);
            circle.changeSize(((int)(Math.sqrt(area/PI)))*2);
            circle.changePos(position[0],position[1]);
            this.width=((int)(Math.sqrt(area/PI)))*2;
            this.height=((int)(Math.sqrt(area/PI)))*2;
            cir.add(circle);

        }
        
        else if(shape.equals("triangle"))
        {
            triangle = new Triangle();
            triangle.changeColor(color);
            triangle.changeSize((int)Math.sqrt(2*area),(int)Math.sqrt(2*area));
            triangle.changePos(position[0],position[1]);
            this.width=(int)Math.sqrt(2*area);
            this.height = (int)Math.sqrt(2*area);
            tri.add(triangle);

        }
        
        else if(shape.equals("pentagon"))
        {
            pentagon = new Pentagon();
            pentagon.changeColor(color);
            pentagon.changeSize((int)Math.sqrt(2*area),(int)Math.sqrt(2*area));
            pentagon.changePos(position[0],position[1]);
            this.width=(int)Math.sqrt(2*area);
            this.height = (int)Math.sqrt(2*area);
            pen.add(pentagon);
            army = new Army(armies,pos,this.width,this.height,mundo);
        }
        else if(shape.equals("rectangle"))
        {
            rectangle = new Rectangle();
            int a = (int)Math.sqrt(2*area);
            int b = a/2;
            rectangle.changeColor(color);
            rectangle.changeSize(a,b);
            rectangle.changePos(position[0],position[1]);
            this.width=b;
            this.height = a;
            rec.add(rectangle);
            
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
        for (Rectangle r:rec)
        {
            r.makeInvisible();
        }
        for (Triangle t:tri)
        {
            t.makeInvisible();
        }
        for (Circle c:cir)
        {
            c.makeInvisible();
        }
        for (Pentagon p:pen)
        {
            p.makeInvisible();
        }
        for (Square s:sqr)
        {
            s.makeInvisible();
        }
        army.makeInvisible();
    }      
    /**
     * Make all the corresponding shapes of a nation, invisible. 
     * If it was already invisible, do nothing.
     *
     */
    public void makeVisible()
    {        // put your code her       
        for (Rectangle r:rec)
        {
            r.makeVisible();
            army.makeVisible();
        }
        for (Triangle t:tri)
        {
            System.out.println("ok2");
            t.makeVisible();
            army.makeVisible();
        }
        for (Circle c:cir)
        {
            c.makeVisible();
            army.makeVisible();
        }
        for (Pentagon p:pen)
        {
            System.out.println("ok_Nation_army");
            p.makeVisible();
            army.makeVisible(1);
        }
        for (Square s:sqr)
        {
            
            s.makeVisible();
            army.makeVisible();
        }
        
    }       
    /**
     *Delete all the corresponding shapes of a nation.
     *
     * @param  color of the nation to be removed
     */
    public void removeNationF(String color){        
        for (Rectangle r:rec)
        {
            if (r.color == color) r.delete();
        }
        for (Triangle t:tri)
        {
            if (t.color == color) t.delete();
        }
        for (Circle c:cir)
        {
            if (c.color == color) c.delete();
        }
        for (Pentagon p:pen)
        {
            if (p.color == color) p.delete();
        }
        for (Square s:sqr)
        {
            if (s.color == color) s.delete();
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
