package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;
import java.util.Arrays;

/**
 * Find the missing number in the array
 * You are given an array of positive numbers from 1 to n,
 * such that all numbers from 1 to n are present except one number x.
 * You have to find x. The input array is not sorted.
 */
public class MissingNumber implements IChallenge {

  private int solveChallenge(int[] input) {
    if(input == null || input.length == 0) {
      return -1;
    }

    int n = input.length + 1;
    int expectedSum = ((n + 1) * n) / 2;
    int currentSum = Arrays.stream(input).sum();

    return expectedSum - currentSum;
  }

  @Override
  public void execute(Input input) {
    //int[] arr = {3, 7, 1, 2, 8, 4, 5}; // Missing 6
    int[] arr = {3, 2, 4, 5}; // Missing 1

    Printer.printNumberOutput(solveChallenge(arr));
  }
}
