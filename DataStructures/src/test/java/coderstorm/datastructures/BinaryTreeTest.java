package coderstorm.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BinaryTreeTest {

    /*
    Testing tree
                 1
                / \
               /   \
              /     \
             2       3
            / \     /
           4   5   6
          /       / \
         7       8   9
     */
    Tree tree;

    @Before
    public void setup () {
        tree = new Tree();
        Tree.Node n0 = tree.root = new Tree.Node("1");
        Tree.Node n2 = n0.addLeaf("2");
        Tree.Node n3 = n0.addLeaf("3");
        Tree.Node n4 = n2.addLeaf("4");
        Tree.Node n5 = n2.addLeaf("5");
        Tree.Node n6 = n3.addLeaf("6");
        Tree.Node n7 = n4.addLeaf("7");
        Tree.Node n8 = n6.addLeaf("8");
        Tree.Node n9 = n6.addLeaf("9");

    }

    @Test
    public void testTraverseIterativeInOrder() throws Exception {
        List<String> value = tree.traverseIterativeInOrderBFT();
        System.out.println("-----");

    }

    @Test
    public void testTraversePostOrder() throws Exception {

    }

}