package mountain;

public class Point {
	private int x, y;

	/** Constructs and initializes a point at the specified (x,y) location. */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/** 
	 * Returns the x coordinate. 
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/** 
	 * Returns the y coordinate. 
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * */
	public Point middlePoint(Point otherPoint, boolean isWarped){
        Point newPoint;
        //TODO: If deltay = 0 => ändra.
        int x= (int) Math.round(this.x + (otherPoint.x - this.x) / 2.0);
        double deltaY = (this.y - otherPoint.y) / 2.0;
        int y = (int) Math.round(this.y - deltaY);

        if (isWarped){
            double dev = 0.25;
            int warpedY = y+(int)Math.round(deltaY*(RandomUtilities.randFunc(dev)));
		    newPoint = new Point(x,warpedY);
        }
        else {
            newPoint = new Point(x,y);
        }
		return newPoint;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			return x == p.x && y == p.y;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
	    return  31 * x + y;
	}
	
}
