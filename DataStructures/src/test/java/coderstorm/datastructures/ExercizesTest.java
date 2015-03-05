package coderstorm.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExercizesTest {

    @Test
    public void testIsUnBalanced() throws Exception {

        /*
        Unbalanced
                     50
             17               76
        9       23         54
           14                72
        12                 67
         */
        BinaryTreeNode<Integer> tree = new BinaryTreeNode();
        tree.root.key = 50;
        tree.root.addLeaves(17, 72);
        BinaryTreeNode<Integer>.Node n17 = tree.root.left;
        BinaryTreeNode<Integer>.Node n72 = tree.root.right;
        n17.addLeaves(12,23);
        n72.addLeaves(54,76);

        BinaryTreeNode<Integer>.Node n12 = n17.left;
        BinaryTreeNode<Integer>.Node n23 = n17.right;
        n12.addLeaves(9,14);
        n23.addLeaves(19,null);

        BinaryTreeNode<Integer>.Node n54 = n72.left;
        n54.addLeaves(null, 67);

        assertFalse( tree.isBalanced() );


    }
    @Test
    public void testIsBalanced() throws Exception {

        /*
        Balanced tree
                       50
               17              72
          12       23     54       76
        9    14  19         67
         */
        BinaryTreeNode<Integer> tree = new BinaryTreeNode();
        tree.root.key = 50;
        tree.root.addLeaves(17, 72);
        BinaryTreeNode<Integer>.Node n17 = tree.root.left;
        BinaryTreeNode<Integer>.Node n72 = tree.root.right;
        n17.addLeaves(12,23);
        n72.addLeaves(54,76);

        BinaryTreeNode<Integer>.Node n12 = n17.left;
        BinaryTreeNode<Integer>.Node n23 = n17.right;
        n12.addLeaves(9,14);
        n23.addLeaves(19,null);

        BinaryTreeNode<Integer>.Node n54 = n72.left;
        n54.addLeaves(null, 67);

        assertTrue( tree.isBalanced() );
    }
}