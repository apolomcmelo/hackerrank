package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class FruitPromotion implements IChallenge {

  private int solveChallenge(List<String> codeList, List<String> shoppingCart) {
    Deque<String> codeQueue = new ArrayDeque<>();

    for(String code: codeList) {
      String[] fruitList = code.split(" ");

      for(String fruit: fruitList) {
        codeQueue.push(fruit);
      }
    }

    for(String fruit: shoppingCart) {
      if(fruit.equalsIgnoreCase(codeQueue.peekFirst()) || codeQueue.peekFirst().equalsIgnoreCase("anything")) {
        codeQueue.poll();
      }
    }

    return codeQueue.isEmpty() ? 1: 0;
  }
  @Override
  public void execute(Input input) {
    List<String> codeList = Arrays.asList("apple apple", "banana anything orange");
    List<String> shoppingCart = Arrays.asList("apple", "banana", "apple", "apple", "banana", "kiwi", "orange", "banana");

    System.out.println(solveChallenge(codeList, shoppingCart));
  }

}
