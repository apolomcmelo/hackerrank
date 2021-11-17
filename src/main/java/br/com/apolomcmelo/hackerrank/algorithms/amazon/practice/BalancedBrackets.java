package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class BalancedBrackets implements IChallenge {

  private boolean solveChallenge(String expression) {
    if(expression == null || expression.isEmpty()) {
      return true;
    }

    List<Character> openingBrackets = Arrays.asList('{', '[', '(');
    List<Character> closingBrackets = Arrays.asList('}', ']', ')');

    Deque<Character> bracketsStack = new ArrayDeque<>();
    char[] expressionChars = expression.toCharArray();

    for(char bracket: expressionChars) {
      if(openingBrackets.contains(bracket)) {
        bracketsStack.push(bracket);
      } else if (closingBrackets.contains(bracket)){

        if(bracketsStack.isEmpty()) {
          return false;
        }
        char bracketInStack = bracketsStack.pop();

        if (openingBrackets.indexOf(bracketInStack) != closingBrackets.indexOf(bracket)) {
          return false;
        }
      }
    }
    return bracketsStack.isEmpty();
  }

  @Override
  public void execute(Input input) {
    //String expression = "[()]{}{[()()]()}"; // balanced
    //String expression = "[(])"; // not balanced
    String expression = "[(a, b)]{x}{[()()]()}"; // balanced
    //String expression = ""; // balanced
    //String expression = null; // balanced
    //String expression = "null"; // balanced
    //String expression = "[a])"; // not balanced


    System.out.println(solveChallenge(expression));
  }

}
