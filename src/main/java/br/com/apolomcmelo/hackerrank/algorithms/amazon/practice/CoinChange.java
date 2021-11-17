package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import java.util.Arrays;

/**
 * Suppose we have coin denominations of [1, 2, 5] and the total amount is 7.
 * We can make changes in the following 6 ways
 * 1, 1, 1, 1, 1, 1, 1
 * 1, 1, 1, 1, 1, 2
 * 1, 1, 1, 2, 2
 * 1, 2, 2, 2
 * 1, 1, 5
 * 2, 5
 */
public class CoinChange implements IChallenge {

  private int solveChallenge(int[] denominations, int amount) {
    int[] solutionArray = new int[amount + 1];
    solutionArray[0] = 1;

    for (int den: denominations) {
      for (int i = den; i < (amount + 1); ++i) {
        solutionArray[i] += solutionArray[i - den];
      }
    }
    return solutionArray[solutionArray.length - 1];
  }

  @Override
  public void execute(Input input) {
    int[] denominations = {1,2,5};
    int amount = 7;

    System.out.println(solveChallenge(denominations, amount));
  }

}
