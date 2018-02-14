package mountain;

import java.util.HashMap;

public class Side {
    Point p1;
    Point p2;


    public Side(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public int hashCode(){
        return p1.hashCode() + p2.hashCode();
    }
}
