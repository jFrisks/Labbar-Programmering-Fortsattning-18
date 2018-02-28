package map;

public class Test {
    static Map<Integer, Integer> m;

    public static void main(String[] args) {
        m = new SimpleHashMap<Integer, Integer>(10);
        m.put(3, 5);
        m.put(4,5);
        m.remove(3);
        //SimpleHashMap.show();
        //System.out.println(m.get(3));

    }
}
