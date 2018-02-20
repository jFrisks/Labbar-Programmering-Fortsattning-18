package bst;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class BinarySearchTreeTest {
    BinarySearchTree<Integer> treeInt;
    BinarySearchTree<String> treeString;

    @Before
    public void setUp() throws Exception {
        treeInt = new BinarySearchTree<Integer>();
        treeString = new BinarySearchTree<String>();
    }

    @After
    public void tearDown() throws Exception {
        treeInt = null;
        treeString = null;
    }

    @Test
    void add() {
        assertTrue();
    }

    @Test
    void height() {
    }

    @Test
    void size() {
    }

    @Test
    void printTree() {
    }

}