package coderstorm.datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree {
    Node root;

    static public class Node {
        String value;
        ArrayList<Node> leaves = new ArrayList<Node>();

        public Node(String value) {
            this.value = value;
        }

        public Node addLeaf(String leafValue) {
            Node newLeaf = new Node(leafValue);
            this.leaves.add(newLeaf);
            return newLeaf;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            if (leaves != null) {
                for (Node n : leaves) {

                }
            }
            return sb.toString();
        }

    }

    public List<String> traverseIterativePostOrderBFT() {
        List<String> ret = new ArrayList<String>();
        Deque<Node> parentStack = new ArrayDeque<Node>();
        Node top = root;
        parentStack.push(top);
        while (!parentStack.isEmpty()) {
            ret.add(top.value);
            for (Node n : top.leaves) {
                parentStack.push(n);
            }
            top = parentStack.pop();
        }
        return ret;
    }

    public List<String> traverseIterativeInOrderBFT() {
        List<String> ret = new ArrayList<String>();
        Deque<Node> parentStack = new ArrayDeque<Node>();
        Node top = root;
        do {
            ret.add(top.value);
            for (Node n : top.leaves) {
                parentStack.push(n);
            }
            top = parentStack.pollLast();
        } while (!parentStack.isEmpty());
        ret.add(top.value);
        return ret;
    }
}


