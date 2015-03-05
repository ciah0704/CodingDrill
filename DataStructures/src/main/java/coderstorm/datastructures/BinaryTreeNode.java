package coderstorm.datastructures;

/**
 *
 */
public class BinaryTreeNode<Data extends Comparable<Data>> {

  Data value;
  BinaryTreeNode left, right;

  public BinaryTreeNode(Data value, BinaryTreeNode left, BinaryTreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}
