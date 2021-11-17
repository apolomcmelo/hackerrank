package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array of integers and a value, determine
 * if there are any two integers in the array whose sum is equal to the given value.
 * Return true if the sum exists and return false if it does not.
 */
public class SumOfTwo implements IChallenge {

  private boolean solveChallenge(int[] arr, int val) {
    HashSet<Integer> setOfDifferences = new HashSet<>();

    if(arr == null || arr.length == 0) {
      return false;
    }

    for (int element : arr) {
      if(setOfDifferences.contains(element)) {
        return true;
      }

      setOfDifferences.add(val - element);
    }

    return false;
  }

  @Override
  public void execute(Input input) {
    int[] arr = {5, 7, 1, 2, 8, 4, 3};
    int val = 19;

    System.out.println(solveChallenge(arr, val));
  }

}
