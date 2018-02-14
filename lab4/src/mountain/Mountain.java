package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

import java.util.ArrayList;
import java.util.HashMap;

public class Mountain extends Fractal{
    private int length;
    private HashMap<Side, Point> hmap = new HashMap();
    public Mountain(int length) {
        super();
        this.length = length;
       
    
    }

    @Override
    public String getTitle() {
        return "Mountain";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        int length = 300;
        int dev = 20;

        int startX = (int) Math.round(turtle.getWidth() / 2.0 - length / 2.0);
        int startY = (int) Math.round(turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0);

        Point pointA = new Point(20, 20);
        Point pointC = new Point(60, 500);
        Point pointB = new Point(500, 250);

        //TODO:
        mountainTriangle(turtle, order, pointA, pointB, pointC, dev);
    }

    private void mountainTriangle(TurtleGraphics turtle, int order, Point pointA, Point pointB, Point pointC, int dev){
        Point pointD;
        Point pointE;
        Point pointF;

        pointD = middlepoint(pointA,pointB,dev);
        pointE = middlepoint(pointB,pointC,dev);
        pointF = middlepoint(pointC,pointA,dev);
        
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
            mountainTriangle(turtle, order-1, pointD, pointB, pointE, dev/2);
            //vänster
            mountainTriangle(turtle, order-1, pointA, pointD, pointF, dev/2);
            //höger
            mountainTriangle(turtle, order-1, pointE, pointC, pointF, dev/2);
            //mitt - obs annorlunda skruvad
            mountainTriangle(turtle, order-1, pointD, pointE, pointF, dev/2);

        }
        
        
        

    }
    
    private Point middlepoint(Point p, Point ps, double dev) {
		Side temp = new Side(p, ps);
		Point mp;
		if (hmap.containsKey(temp)) {
			mp = hmap.remove(temp);
			return mp;
		} 
		else {
			int x = (p.getX() + ps.getX()) / 2;
			int y = (p.getY() + ps.getY()) / 2;
			mp = new Point(x + (int) Math.round(RandomUtilities.randFunc(dev)),
			y + (int) Math.round(RandomUtilities.randFunc(dev)));
			hmap.put(temp, mp);
			return mp;
		}

	}
}

