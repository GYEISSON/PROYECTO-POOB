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
    private int area;
    private String color;
    private int[] position;
    private int armiesNeeded;
    private int armyHave;
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
    public Nation(String shape,int area,String color,int[] pos)
    {
        // initialise instance variables
        this.color = color;
        this.position=pos;
        this.nationShape = shape;
        armyHave=0;
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
        }
        else if(shape.equals("rectangle"))
        {
            rectangle = new Rectangle();
            int a = (int)Math.sqrt(2*area);
            int b = a/2;
            rectangle.changeColor(color);
            rectangle.changeSize(a,b);
            rectangle.changePos(position[0],position[1]);
            this.width=a;
            this.height = b;
            rec.add(rectangle);
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
        }
        for (Triangle t:tri)
        {
            t.makeVisible();
        }
        for (Circle c:cir)
        {
            c.makeVisible();
        }
        for (Pentagon p:pen)
        {
            p.makeVisible();
        }
        for (Square s:sqr)
        {
            s.makeVisible();
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
