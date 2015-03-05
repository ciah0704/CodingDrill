package coderstorm.datastructures;

import org.junit.Test;
import org.junit.Before;

import java.util.List;

public class TreeTest {

    /*
    Testing trees
                     root
                      |
             +--------+--------+--------+
             |                 |        |
            A1                 B1       23
             |
         +---+---
         |       |
        A21      33

                         root
                          |
              +-----------+---+------+----+
              |               |      |    |
             A1               B1     23   /
              |               |
         +----+-----+      +------+
         |    |     |      |      |
        A21   33   A22    B21   1 2 +


     */
    Tree[] trees;

    String[][] expectedInOrderBFT = {
            {"root", "A1", "B1", "23", "A21", "33"},
            {"root", "A1", "B1", "23", "/", "A21", "33", "A22", "B21", "1 2 +"}
    };
    String[][] expectedPostOrderBFT = {
            {"root", "23", "B1", "A1", "33", "A21"},
            {"root", "/", "23", "B1", "A1", "1 2 +", "B21", "A22", "33", "A21"}
    };
    
    
    @Before
    public void setup () {
        trees = new Tree[2];

        trees[0] = new Tree();
        Tree.Node root0  = trees[0].root = new Tree.Node("root");
        Tree.Node a01  = root0.addLeaf("A1");
        Tree.Node b01  = root0.addLeaf("B1");
        Tree.Node n01  = root0.addLeaf("23");
        Tree.Node a021 = a01.addLeaf("A21");
        Tree.Node n033 = a01.addLeaf("33");

        trees[1] = new Tree();
        Tree.Node root1  = trees[1].root = new Tree.Node("root");
        Tree.Node a11  = root1.addLeaf("A1");
        Tree.Node b11  = root1.addLeaf("B1");
        root1.addLeaf("23");
        root1.addLeaf("/");
        Tree.Node a121 = a11.addLeaf("A21");
        a11.addLeaf("33");
        Tree.Node a122 = a11.addLeaf("a22");
        b11.addLeaf("b21");
        b11.addLeaf("1 2 +");
    }

    @Test
    public void testTraverse() throws Exception {
        List<String> actualValue = trees[0].traverseIterativeInOrderBFT();
        for(String s:actualValue)
            System.out.print(s + ", ");
        System.out.println("\n-----");

        actualValue = trees[0].traverseIterativePostOrderBFT();
        for(String s:actualValue)
            System.out.print(s + ", ");
        System.out.println("\n-----");

        actualValue = trees[1].traverseIterativeInOrderBFT();
        for(String s:actualValue)
            System.out.print(s + ", ");
        System.out.println("\n-----");

        actualValue = trees[1].traverseIterativePostOrderBFT();
        for(String s:actualValue)
            System.out.print(s + ", ");
        System.out.println("\n-----");
    }

}