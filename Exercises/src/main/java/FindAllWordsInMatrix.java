import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * Let's play a game of Boggle! Given a grid with characters (e.g. the following),
 * <p/>
 * EECA
 * ALEP
 * HNBO
 * QTTY
 * <p/>
 * Find all the words that can be formed using the letters in the grid. For instance, you can perform the words elan, celeb, cape, peace, etc....
 * The grid of letters can be used in every direction (see PEACE)
 * No position can be used twice within the same word. (e.g. POPE is not a valid word on this board)
 */
public class FindAllWordsInMatrix {

    Set<String> findWords(char[][] grid, Set<String> dictionary) {

        Deque<Node> stack = new ArrayDeque<Node>();
        int x = 0;
        int y = 0;
        stack.push(new Node(grid[x][y]));
        while (stack.size()>0) {
            Node n = stack.pop();
            // iterate through the row

            //

        }

        return null;

    }

    class Node {
        char letter;

        Node root;
        Node[] n = new Node[7];

        public Node(char c) {
            letter = c;
        }
    }

 /*
 1 2 3
 4 n 5
 6 7 8
 */

}
