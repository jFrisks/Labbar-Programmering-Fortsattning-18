package mountain;

import java.util.HashMap;

public class Side {
    Point p1;
    Point p2;
    Point m;


    public Side(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public int hashCode(){
        return p1.hashCode() + p2.hashCode();
    }
    
    public boolean equals(Object x) {
		if (x instanceof Side) {
			Side s = (Side) x; 
			if(p1 == null && p2 == null){
				return m.equals(s.m);				
			} else {
				return (p1.equals(s.p1) && p2.equals(s.p2)) || (p1.equals(s.p2) && p2.equals(s.p1)); 
			}
		}
		return false;
	}
    
    
 
}
