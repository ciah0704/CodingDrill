package codility;

import java.util.ArrayDeque;
import java.util.Deque;

public class TraverseBinTreeFindVisibleNodes {
    class TreeExt {
        Tree node;
        int maxVal;
        int level;
        boolean visible;

        TreeExt(Tree node, TreeExt parent) {
            this.node = node;
            if(parent == null) {
                visible = true;
                maxVal = node.x;
                level = 1;
            }
            else {
                maxVal = Math.max(parent.data(),node.x);
                visible = maxVal > parent.maxVal;
                level = parent.level+1;
            }
        }

        TreeExt(Tree node, int level, int maxVal) {
            this.node = node;
            this.maxVal = maxVal;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "x=" + node.x + ", visible="+ visible + ", level="+level+", maxVal="+maxVal+"}";
        }

        public Tree right() {
            return node.right;
        }

        public Tree left() {
            return node.left;
        }

        public int data() {
            return node.x;
        }
    };

    public int solution(Tree root) {
        System.out.println("-- BF --");
        traverseBF(root);
        System.out.println("-- DF --");
        traverseDF(root);
        return 4;
    }


    int traverseBF(Tree root) {
        Deque<TreeExt> queue = new ArrayDeque<TreeExt>();
        TreeExt parent = new TreeExt(root, null);
        queue.addFirst(parent);
        while (queue.size() > 0) {

            TreeExt node = queue.pollLast();

            System.out.println(node);

            if (node.left() != null) {
                TreeExt t = new TreeExt(node.left(), node);
                queue.push(t);
            }
            if (node.right() != null) {
                TreeExt t = new TreeExt(node.right(), node);
                queue.push(t);
            }


        }
        return 4;
    }

    int traverseDF(Tree root) {
        TreeExt NULL = new TreeExt(null, 0, 0);
        Deque<TreeExt> parentStack = new ArrayDeque<TreeExt>();
        parentStack.push(NULL);
        TreeExt top = new TreeExt(root, 1, 1);
        TreeExt prev = top;
        int visCount = 0;
        while (top != null) {
            System.out.println(top);
            if(prev.data() <= top.data())
                visCount++;

            if (top.right() != null) {
                parentStack.push(new TreeExt(top.right(), top.level+1, 1));
            }
            if (top.left() != null)
                parentStack.push(new TreeExt(top.left(), top.level+1, 1));

            prev = top;
            top = parentStack.pop();

            if( top == NULL)
                top = null;
        }
        return visCount;
    }


    static public class Tree {
        public int x;
        public Tree left;
        public Tree right;

        public Tree(int x) {
            this.x = x;
        }


        @Override
        public String toString() {
            return "Tree{" +
                    "x=" + x + "}";
        }
    }

}
