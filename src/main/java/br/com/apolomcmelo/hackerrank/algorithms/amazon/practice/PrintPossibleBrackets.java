package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;
import java.util.ArrayList;

public class PrintPossibleBrackets implements IChallenge {

  private void printAllBacesRec(int n, int leftCount,
      int rightCount, ArrayList<Character> output,
      ArrayList<ArrayList<Character>> result) {

    if (leftCount >= n && rightCount >=n) {
      result.add((ArrayList)output.clone());
    }

    if (leftCount < n) {
      output.add('{');
      printAllBacesRec(n, leftCount + 1, rightCount, output, result);
      output.remove(output.size() - 1);
    }

    if (rightCount < leftCount) {
      output.add('}');
      printAllBacesRec(n, leftCount, rightCount + 1, output, result);
      output.remove(output.size() - 1);
    }
  }

  private ArrayList<ArrayList<Character>> solveChallenge(int n) {
    ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
    ArrayList<Character> output = new ArrayList<Character>();
    printAllBacesRec(n, 0, 0, output, result);
    return result;
  }

  @Override
  public void execute(Input input) {
    Printer.printListOutput(solveChallenge(3));
  }
}
