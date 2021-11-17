package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of ‘n’ elements, find their Kth permutation. Consider the following set of elements:
 * [1, 2, 3] All permutations of the above elements are (with ordering): [1, 2, 3] [1, 3, 2] [2, 1,
 * 3] [2, 3, 1] [3, 1, 2] [3, 2, 1] Here we need to find the Kth permutation.
 */
public class KthPermutation implements IChallenge {

  // Used to count how many permutations are possible given n
  private int factorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }

  private String solveChallenge(int n, int k) {
    List<Character> v = new ArrayList<Character>();
    char c = '1';

    // Generate array of possible values
    for (int i = 1; i <= n; ++i) {
      v.add(c);
      c++;
    }
    System.out.println(v.toString());
    StringBuilder result = new StringBuilder();

    findKthPermutation(v, k, result);

    return result.toString();
  }

  private void findKthPermutation(List<Character> v, int k, StringBuilder result) {
    // No chars possible to permute
    if (v.isEmpty()) {
      return;
    }

    int n = v.size();
    // count is number of permutations starting with first digit
    int count = factorial(n - 1);
    int selected = (k - 1) / count;

    result.append(v.get(selected));
    v.remove(selected);

    k = k - (count * selected);
    findKthPermutation(v, k, result);
  }

  @Override
  public void execute(Input input) {
    System.out.println(solveChallenge(4,8));
  }
}
