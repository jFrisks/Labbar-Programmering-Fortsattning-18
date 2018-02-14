package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

import java.util.ArrayList;
import java.util.HashMap;

public class Mountain extends Fractal{
    private int length;
    HashMap<Side, Point> sideMap;

    public Mountain(int length) {
        super();
        this.length = length;
        sideMap = new HashMap<>();
    }

    @Override
    public String getTitle() {
        return "Mountain";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        int length = 300;

        int startX = (int) Math.round(turtle.getWidth() / 2.0 - length / 2.0);
        int startY = (int) Math.round(turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0);

        Point pointA = new Point(startX, startY);
        Point pointC = new Point(startX+length, startY+100);
        Point pointB = new Point(startX+length/2, startY-length/2);

        //TODO:
        mountainTriangle(turtle, order, pointA, pointB, pointC);
        /**
        fractalLine(turtle, order,length,0);
        fractalLine(turtle, order,length,120);
        fractalLine(turtle, order,length,240);
         */
    }

    private Point getExistingPoint{

    }

    private void mountainTriangle(TurtleGraphics turtle, int order, Point pointA, Point pointB, Point pointC){
        Point pointD;
        Point pointE;
        Point pointF;

        ArrayList<Side> sidesToSearch = new HashMap<>();

        sidesToSearch.add(new Side(pointA, pointB));
        sidesToSearch.add(new Side(pointC, pointB));
        sidesToSearch.add(new Side(pointA, pointC));

        pointD = pointA.middlePoint(pointB, true);
        pointE = pointC.middlePoint(pointB, true);
        pointF = pointA.middlePoint(pointC, true);

        if(sideMap.containsKey(pointD.hashCode())){
            //hämta värde
            pointD = sideMap.get(pointD);
            //ta bort
        }else{

        }
        if(sideMap.containsKey(pointE.hashCode())){
            //hämta värde
            pointE = sideMap.get(pointE);
            //ta bort
        }else{

        }
        if(sideMap.containsKey(pointF.hashCode())){
            //hämta värde
            pointF = sideMap.get(pointF);
            //ta bort
        }else{

        }




        //basfallet
        if(order == 0){
            //Rita ut skiten
            turtle.moveTo(pointA.getX(), pointA.getY());
            turtle.penDown();
            turtle.forwardTo(pointB.getX(), pointB.getY());
            turtle.forwardTo(pointC.getX(), pointC.getY());
            turtle.forwardTo(pointA.getX(), pointA.getY());
            turtle.penUp();

        }else{
            //topp
            mountainTriangle(turtle, order-1, pointD, pointB, pointE);
            //vänster
            mountainTriangle(turtle, order-1, pointA, pointD, pointF);
            //höger
            mountainTriangle(turtle, order-1, pointE, pointC, pointF);
            //mitt - obs annorlunda skruvad
            mountainTriangle(turtle, order-1, pointD, pointE, pointF);

        }

    }
}
