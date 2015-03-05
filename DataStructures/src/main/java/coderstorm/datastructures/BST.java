package coderstorm.datastructures;

/**
 * Binary serach tree
 *          Average     Worst
 * Space	O(n)    	O(n)
 * Search	O(log n)	O(n)
 * Insert	O(log n)	O(n)
 * Delete	O(log n)	O(n)
 */
public class BST<T> {

    Node<T> root;

    class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
    }

    public boolean isBalanced() {
        return false;
    }

}
