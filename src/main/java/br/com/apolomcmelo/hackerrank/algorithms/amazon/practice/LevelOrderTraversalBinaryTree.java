package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Node;
import br.com.apolomcmelo.hackerrank.utils.Printer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, display the node values at each level.
 * Node values for all levels should be displayed on separate lines.
 */
public class LevelOrderTraversalBinaryTree implements IChallenge {

  private List<String> solveChallenge(Node root) {

    if (root == null) {
      return Collections.emptyList();
    }

    Queue<Node> currentLevelQueue = new ArrayDeque<>();
    Queue<Node> nextLevelQueue = new ArrayDeque<>();
    List<String> listOfLevels = new ArrayList<>();

    String level = "";
    currentLevelQueue.add(root);

    while (!currentLevelQueue.isEmpty()) {
      Node temp = currentLevelQueue.poll();
      level += temp.getValue() + ",";

      if (temp.getLeft() != null) {
        nextLevelQueue.add(temp.getLeft());
      }

      if (temp.getRight() != null) {
        nextLevelQueue.add(temp.getRight());
      }

      if (currentLevelQueue.isEmpty()) {
        listOfLevels.add(level);
        level = "";
        currentLevelQueue = nextLevelQueue;
        nextLevelQueue = new ArrayDeque<>();
      }
    }

    return listOfLevels;
  }
  
  @Override
  public void execute(Input input) {
    Node rootTree = generateTree();
    List<String> treeElementsByLevel = solveChallenge(rootTree);
    Printer.printListOutput(treeElementsByLevel);
  }

  // Example with 100<50<25 - 75; 200<350;
  private Node generateTree() {
    Node root = new Node(100);
    root.setLeft(new Node(50));
    root.getLeft().setLeft(new Node(25));
    root.getLeft().setRight(new Node(75));

    root.setRight(new Node(200));
    root.getRight().setRight(new Node(350));

    return root;
  }

}
