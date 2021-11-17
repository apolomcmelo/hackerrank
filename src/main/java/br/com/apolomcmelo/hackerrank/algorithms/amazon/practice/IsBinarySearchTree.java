package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Node;
import br.com.apolomcmelo.hackerrank.utils.Printer;
import java.util.List;

/**
 * Given a Binary Tree, figure out whether it’s a Binary Search Tree.
 * In a binary search tree, each node’s key value is smaller than the key value of all nodes in the right subtree,
 * and is greater than the key values of all nodes in the left subtree.
 */
public class IsBinarySearchTree implements IChallenge {

  // Using inorder traversal
  public boolean solveChallenge(Node root) {
    return isBinarySearchTreeRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public boolean isBinarySearchTreeRecursive(Node node, int minValue, int maxValue) {
    if(node == null) {
      return true;
    }

    if(node.getValue() < minValue || node.getValue() > maxValue) {
      return false;
    }

    return isBinarySearchTreeRecursive(node.getLeft(), minValue, node.getValue()) &&
        isBinarySearchTreeRecursive(node.getRight(), node.getValue(), maxValue);
  }

  @Override
  public void execute(Input input) {
    Node rootTree = generateBinarySearchTree();
    System.out.println(solveChallenge(rootTree));
  }

  // Example with 100<50<25 - 75; 200<125 - 350;
  private Node generateBinarySearchTree() {
    Node root = new Node(100);
    root.setLeft(new Node(50));
    root.getLeft().setLeft(new Node(25));
    root.getLeft().setRight(new Node(75));

    root.setRight(new Node(200));
    root.getRight().setLeft(new Node(125));
    root.getRight().setRight(new Node(350));

    return root;
  }

  // Example with 100<50<25 - 75; 200<90 - 350;
  private Node generateBinaryNonSearchTree() {
    Node root = new Node(100);
    root.setLeft(new Node(50));
    root.getLeft().setLeft(new Node(25));
    root.getLeft().setRight(new Node(75));

    root.setRight(new Node(200));
    root.getRight().setLeft(new Node(90));
    root.getRight().setRight(new Node(350));

    return root;
  }

}
