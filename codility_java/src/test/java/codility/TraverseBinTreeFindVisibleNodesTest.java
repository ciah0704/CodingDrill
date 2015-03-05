package codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class TraverseBinTreeFindVisibleNodesTest {

    @Test
    public void testSolution() throws Exception {
        TraverseBinTreeFindVisibleNodes s = new TraverseBinTreeFindVisibleNodes();

        TraverseBinTreeFindVisibleNodes.Tree root = new TraverseBinTreeFindVisibleNodes.Tree(5);
        root.left = new TraverseBinTreeFindVisibleNodes.Tree(3);
        root.right = new TraverseBinTreeFindVisibleNodes.Tree(10);

        root.left.left = new TraverseBinTreeFindVisibleNodes.Tree(20);
        root.left.right = new TraverseBinTreeFindVisibleNodes.Tree(21);
        root.right.left = new TraverseBinTreeFindVisibleNodes.Tree(1);



        assertEquals(4, s.solution( root ));

    }
}