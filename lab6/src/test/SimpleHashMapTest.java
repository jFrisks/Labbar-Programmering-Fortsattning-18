package test;

import map.Map;
import map.SimpleHashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleHashMapTest {
    Map<Integer, Integer> m;
    Map<Integer, Integer> m16;
    Map<String, Integer> s;

    @Before
    public void setUp() throws Exception {
        m = new SimpleHashMap<Integer, Integer>(10);
        m16 = new SimpleHashMap<Integer, Integer>();
        s = new SimpleHashMap<String, Integer>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void put() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void show() throws Exception {
    }

    @Test
    public void size() throws Exception {
    }

}