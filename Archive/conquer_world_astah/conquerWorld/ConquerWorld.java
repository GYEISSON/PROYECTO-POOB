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
    private ArrayList<String> colorNations;
    private HashMap<String,Integer> visited; //tabla de hash para saber si un una nacion esta visitado
    private Map<String,ArrayList<String>> adjList; //lista de adyacencia para los nodos del grafo       
    private ArrayList<Route> routes;
    private Nation nation;
    private boolean isVisible;
    private boolean aCicle;
    private int maxX;
    private Cash cash;
    private Route elimina;
    private boolean okR;
    private Route route;
    private int nNations;
    
    /**
    /**
     * Constructor de objetos de la clase conquerWorld
     */
    public ConquerWorld(int maxX,int maxY){
        this.maxX = maxX;
        mundo = mundo.getCanvas(maxX,maxY);
        arrayNations = new ArrayList<Nation>();
        colorNations = new ArrayList<String>();
        routes = new ArrayList<Route>();
        isVisible = false;
        fondoCash f = new fondoCash(maxX);
        cash = new Cash(0,maxX);
        colorNations = new ArrayList<String>();
        visited = new HashMap<String,Integer>();
        adjList = new HashMap<>();
    }   
    /**     * Anadir efectivo al presupuesto de batalla
     *
     * @param  dinero a adicionar
     */
    public void addCash(int c){
        int bCash=cash.getCash();
        cash.addCash(c);
        if(cash.getCash()==(bCash+c)) okR=true;
        else okR=false;
        
    }
    /**
     * Anade una nueva nacion a la batalla
     *
     * @param  La forma,el color, el area, la posicion y las unidades necesarias para esta nueva nacion
     */
    public void addNation(String shape, int area,String color,int[] position, int armiesNeeded){
        boolean put=true;
        int side;
        int xPos=position[0],yPos=position[1];
        nNations=colorNations.size();
        int[] aux= new int[2];
        
        if(nNations>0){
            if(shape=="pentagon"){
                side = (int)Math.sqrt(2*area);
                put = put && canPut(position); //1
                position[0]+=side;
                put = put && canPut(position); //2
                position[1]-=side;
                put = put && canPut(position); //3
                position[0]-=side*2;
                put= put&&canPut(position);  //4
                position[1] +=side;
                put = put && canPut(position); //5
                position[0]+=side;
                position[1]+=side;
                put = put&&canPut(position); //6
                position[1]-=side;
            }
            else if(shape == "triangle"){
                side = (int)Math.sqrt(2*area);
                put = put&&canPut(position);
                position[0]+=(int)side/2;position[1]+=side;
                put = put&&canPut(position);
                position[0]-=side;
                put = put&&canPut(position);
                position[0]+=(int)side/2;position[1]-=side;
            }
            else if(shape == "circle"){
                side = (int)(Math.sqrt(area/Nation.PI))*2;
                put = put && canPut(position);
                position[0]+=side;
                put = put && canPut(position);
                position[1]+=side;
                put = put && canPut(position);
                position[0]-=side;
                put = put && canPut(position);
                position[1]-=side;
            }
            else if(shape=="square"){
                side = (int)Math.sqrt(area);
                put = put && canPut(position);
                position[0]+=side;
                put = put && canPut(position);
                position[1]+=side;
                put = canPut(position);
                position[0]-=side;
                put = put && canPut(position);
            }
            else{
                side = (int)Math.sqrt(2*area);
                put = put && canPut(position);
                position[0]+=(int)side/2;
                put = put && canPut(position);
                position[1]+=side;
                put = put && canPut(position);
                position[0]-=(int)side/2;
                put = put && canPut(position);
                position[1]-=side;
            }
        }
        if(put &&  !(colorNations.contains(color))){
            aux[0]=xPos;aux[1]=yPos;
            nation = new Nation(shape,area,color,aux);
            arrayNations.add(nation);
            colorNations.add(color);
            adjList.put(color,new ArrayList<String>());
           
            okR=true;
        }
        else{
            //JOptionPane.showMessageDialog(null,"El lugar esta ocupado por otra nacion o nacion existente");
            okR=false;
        }
    }        
    /**
     * Remueve una nacion de la batalla
     *
     * @param  Nombre/Color de la nacion
     * 
     */
    public void removeNation(String removeColor)
    {        
        String colorob;
        // System.out.println(colorNations.toString());
        if(colorNations.contains(removeColor)){ 
        for(int i=0;i<arrayNations.size();i++){
            colorob= arrayNations.get(i).getColor();
            if(arrayNations.get(i).getColor()==removeColor){
                arrayNations.get(i).removeNationF(removeColor);
                arrayNations.remove(i);
                okR = true;
            }                    
        }
        okR = true;
      }
    }
    /**
     * Anade una nueva ruta entre dos naciones a la batalla.
     *
     * @param  Las naciones con ruta y su costo
     */
    public void addRoute(String[] nations,int cost){
        int[] aPosition={0,0},bPosition={0,0};        
        for(Nation ob : arrayNations){            
            if(ob.getColor()== nations[0]){
                aPosition = ob.getPosition();                
            }
            else if( ob.getColor()==nations[1]){
                bPosition = ob.getPosition();
            }
        }                       
        if (colorNations.contains(nations[0]) && colorNations.contains(nations[1]) ){
            if(okRoute(nations)){
                Route route = new Route(aPosition,bPosition,cost,nations[0],nations[1]); 
                route.makeVisible();
                routes.add(route);    
                adjList.get(nations[0]).add(nations[1]);
                adjList.get(nations[1]).add(nations[0]);
                okR=true;
            }else okR=false;
        }
        else{
            okR=false;
        }
    }       
    /**
     * Remueve una ruta entre dos naciones de la batalla
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void removeRoute(String[] nations)
    {
        int[] aPosition={0,0},bPosition={0,0};
        int posRouteToRemove = 0;
        okR=false;
        for(Route r : routes){
            if((r.getFrom()==nations[0] && r.getTo()==nations[1]) ||( 
            r.getFrom()==nations[1] && r.getTo()==nations[0])){
                elimina = r;
                for(Nation obNation : arrayNations){
                    if(obNation.getColor()== nations[0]){
                        aPosition = obNation.getPosition();
                        for(int k =0;k<adjList.get(nations[0]).size();k++){
                            if(adjList.get(nations[0]).get(k).equals(nations[1])){
                                adjList.get(nations[0]).remove(k);
                            }
                        }
                    }
                    else if( obNation.getColor()==nations[1]){
                        bPosition = obNation.getPosition();
                        for(int l =0;l<adjList.get(nations[1]).size();l++){
                            if(adjList.get(nations[1]).get(l).equals(nations[0])){
                                adjList.get(nations[1]).remove(l);
                            }
                        }
                    }
                }
                r.removeR(aPosition,bPosition);
                r.makeInvisible();
                okR=true;
                //System.out.println("true");
            }
            //else{okR=false;System.out.println("false");}
            if(!okR) posRouteToRemove++;
        }
        if(okR){
            routes.remove(posRouteToRemove);
        }
    }    
    /**
     * Limpia todo el tablero
     */
    public void erase(){
        mundo.erase();
    }                 
    /**
     * Hace visible todas las naciones y rutas
     */
    public void makeVisible(){
        for (Nation c:arrayNations)
        {
            c.makeVisible();
            okR=true;
        }
        for (Route r:routes){
            r.makeVisible();
            okR=true;
        }
    }      
     /**
     * Hace invisible todas las naciones y rutas
     */
    public void makeInvisible(){
        for (Nation c:arrayNations)
        {
            c.makeInvisible();
            okR=true;
        }
        for (Route r:routes){
            r.makeInvisible();
            okR=true;
        }
    }
     /**
     * Anade armamento a una nacion
     * 
     * @param  Nacion a agregar armamento
     */
    public void addArmy(String nation){
        
        for(Nation n : arrayNations){
            if(n.getColor() == nation ){
                n.setArmy(10);
                okR=true;
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
    /**
     * Quita armamento a una nacion
     *
     * @param  Nacion a quitar armamento
     */
    public void removeArmies(String nation){
        for(Nation n : arrayNations){
            if(n.getColor() == nation ){
                n.setArmy();
                okR=true;
            }
        }
    }    
    /**
     * Mover armamento entre naciones
     *
     * @param  Nacion origen y nacion destino
     */
    public void moveArmy(String fromNation,String toNation)
    {
        // put your code here
        Nation object1 = getNation(fromNation),object2=getNation(toNation);
        if(object1.getArmy()>0){
            object2.setArmy(object1.getArmy());
            object1.setArmy();
            okR=true;
        }
    }
    /**
     * Obtiene la nacion a partir del Nombre/Color
     *
     * @param  Nombre/Color de nacion
     * @return     Nacion
     */
    private Nation getNation(String nationName){
        int[] pos={1,1};
        Nation x= new Nation("triangle",1,"blue",pos);
        
        for(Nation n: arrayNations){    
            if(n.getColor() == nationName){ 
                okR=true;
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
        boolean aux=true;
        for(Nation nation: arrayNations){
            aux = isFigure(positions[0],positions[1],nation);
            if(aux) return false;
        }
        return true;
    }
   /**
     * Revisa si una figura esta sobre otra
     * 
     * @return    int xPoint,int yPoint,Nation toNation
     */
    private boolean isFigure(int xPoint,int yPoint,Nation toNation){
        int[] natPosition = toNation.getPosition();
        int xPosNation=natPosition[0],yPosNation= natPosition[1];
        int wNation = toNation.getWidth(),hNation= toNation.getHeight();
        String shapeNation =toNation.getShape(); 
        // // // System.out.println("Posiciones de otros objetos: "+xPosNation+" "+yPosNation);
        if(shapeNation=="triangle"){
            if( xPoint<=xPosNation+(wNation/2) && xPoint>= xPosNation-(wNation/2) 
               && (yPoint>=yPosNation && yPoint<= yPosNation+hNation)){
                return true;
            }
        }
        else if(shapeNation == "pentagon"){           
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
            
            if((xPoint >= xPosNation && xPoint <= (int)(xPosNation+wNation)) && (yPoint >= yPosNation && yPoint <= (int)(yPosNation+hNation))){
                return true;
            }
            else return false;
        }
        return false;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void  finish()
    {
        // put your code here
        System.exit(0);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean okRoute(String[] nations )
    {
        // put your code here
        //visited.put(nations[0],1);
        depthFirstSearch(nations[0],nations[1]);
<<<<<<< HEAD
        if(visited.containsKey(nations[1])){ 
            visited.clear();
            return false;}
        else{ 
            //System.out.println("yes");
            visited.clear();
=======
        if(visited.get(nations[1])==1){ 
            System.out.println("no");
            return false;
        }
        else{ 
            System.out.println("yes");
>>>>>>> 0f5a1e262e627ebc65af5b5ac0664b82b1575582
            return true;}
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public boolean ok()  
    { 
        //boolean auxBool=okR;
        //okR=false;
        return okR;
    }
    
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean okRoutes()
    {
        aCicle=true;
        for(Nation nat: arrayNations){
            dFS(nat.getColor(),aCicle);
        }
        visited.clear();
        return aCicle;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void depthFirstSearch(String uNation,String toFound)
    {
        // put your code here
        for(String vNation: adjList.get(uNation)){
            if(!visited.containsKey(vNation)){
                visited.put(vNation,1);
                depthFirstSearch( vNation, toFound);
            }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void dFS(String uNation,boolean aCicle)
    {
        // put your code here
        
        for(String vNation: adjList.get(uNation)){
            if(visited.containsKey(vNation)){
                visited.put(vNation,1);
                dFS( vNation,aCicle);
            }
            else aCicle=false;
        }
    }
}