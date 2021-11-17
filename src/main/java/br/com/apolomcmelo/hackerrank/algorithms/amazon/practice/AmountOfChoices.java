package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmountOfChoices implements IChallenge {

  // O(a * b * c * d)
  private static int solveChallenge(List<Integer> pricesA, List<Integer> pricesB, List<Integer> pricesC, List<Integer> pricesD, int budget) {
    int amount = 0;
    int total = 0;
    int counter = 0;

    for (int i = 0; i < pricesA.size(); i++) {

      total += pricesA.get(i);

      for (int j = 0; j < pricesB.size(); j++) {

        total += pricesB.get(j);

        for (int k = 0; k < pricesC.size(); k++) {

          total += pricesC.get(k);

          for (int l = 0; l < pricesD.size(); l++) {

            total += pricesD.get(l);

            if(total <= budget) {
              amount++;
            }
            counter++;
            total -= pricesD.get(l);
          }

          total -= pricesC.get(k);
        }

        total -= pricesB.get(j);
      }

      total = 0;
    }

    System.out.println("Counter " + counter);
    return amount;
  }

  // Constraint to avoid calculate number already invalid
  private static int solveChallenge2(List<Integer> pricesA, List<Integer> pricesB, List<Integer> pricesC, List<Integer> pricesD, int limit) {
    int amount = 0;
    int total = 0;
    int counter = 0;

    for (int i = 0; i < pricesA.size(); i++) {

      total += pricesA.get(i);

      if(total <= limit) {

        for (int j = 0; j < pricesB.size(); j++) {

          total += pricesB.get(j);

          if(total <= limit) {
            for (int k = 0; k < pricesC.size(); k++) {

              total += pricesC.get(k);

              if(total <= limit) {
                for (int l = 0; l < pricesD.size(); l++) {

                  total += pricesD.get(l);

                  if (total <= limit) {
                    amount++;
                  }
                  counter++;
                  total -= pricesD.get(l);
                }
              }

              total -= pricesC.get(k);
            }
          }

          total -= pricesB.get(j);
        }
      }

      total -= pricesA.get(i);
    }

    System.out.println("Counter " + counter);
    return amount;
  }

  // Recursion
  private static int solveChallenge3(List<List<Integer>> listOfPrices, int currentArrayIndex, int limit, int total, int amount) {

    if(total <= limit) {
      if(currentArrayIndex == listOfPrices.size()) {
        amount++;
      } else {
        for (int i = 0; i < listOfPrices.get(currentArrayIndex).size(); i++) {
          amount = solveChallenge3(listOfPrices, currentArrayIndex + 1, limit, total + listOfPrices.get(currentArrayIndex).get(i), amount);
        }
      }
    }

    return amount;
  }

  // Dynamic Programming - NOT WORKING YET
  private static int solveChallenge4(List<Integer> pricesA, List<Integer> pricesB, List<Integer> pricesC, List<Integer> pricesD, int limit) {
    int amount = 0;
    int counter = 0;
    List<Integer> listOfSums = new ArrayList<>();
    listOfSums.addAll(pricesA);

    int currentSize = listOfSums.size();

    for (int i = (listOfSums.size() - pricesA.size()); i < currentSize; i++) {
      for(int j = 0; j< pricesB.size(); j++) {
        listOfSums.add(pricesB.get(j) + listOfSums.get(i));
      }
    }
    currentSize = listOfSums.size();

    for (int i = (pricesA.size() * pricesB.size()); i < currentSize; i++) {
      for(int j = 0; j< pricesC.size(); j++) {
        listOfSums.add(pricesC.get(j) + listOfSums.get(i));
      }
    }

    currentSize = listOfSums.size();

    for (int i = (pricesA.size() * pricesB.size() * pricesC.size()); i < currentSize; i++) {
      for(int j = 0; j< pricesD.size(); j++) {
        int sum = pricesD.get(j) + listOfSums.get(i);

        if(sum <= limit) {
          amount++;
        }
      }
    }

    System.out.println("Counter " + counter);
    return amount;
  }

  @Override
  public void execute(Input input) {
    List<List<Integer>> listOfPrices = scenario1();

    int budget = 10;
    List<Integer> counter = new ArrayList<>();
    listOfPrices.sort(Comparator.comparing(List::size));

    //int amount = solveChallenge2(listOfPrices.get(0), listOfPrices.get(1), listOfPrices.get(2), listOfPrices.get(3), budget);
    int amount = solveChallenge3(listOfPrices, 0, budget, 0 , 0);

    System.out.println("The amount is: " + amount);
    System.out.println("The counter is: " + counter.size());
  }

  // 2, 4, 2, 1 = 9
  // 2, 4, 2, 3 = 11
  // 2, 4, 2, 5 = 13
  // 2, 4, 3, 1 = 10
  // 2, 4, 3, 3 = 12
  // 2, 4, 3, 5 = 14
  // 3, 4, 2, 1 = 10
  // 3, 4, 2, 3 = 12
  // 3, 4, 2, 5 = 14
  // 3, 4, 3, 1 = 11
  // 3, 4, 3, 3 = 13
  // 3, 4, 3, 5 = 15
  // Expect amount 3, counter 12
  // Expect amount 3, counter 12

  // 2 3 - 6 7 - 8 9 9 10 - 9 10 10 11 11 12 12 13 13 14 14 15
  private List<List<Integer>> scenario1() {
    List<Integer> pricesA = Arrays.asList(2, 3);
    List<Integer> pricesB = Arrays.asList(4);
    List<Integer> pricesC = Arrays.asList(2, 3);
    List<Integer> pricesD = Arrays.asList(1, 3, 5);

    return new ArrayList<List<Integer>>(Arrays.asList(pricesA, pricesB, pricesC, pricesD));
  }

  // 5, 6, 2, 1 = 14
  // 5, 6, 2, 3 = 16
  // 5, 6, 2, 5 = 18
  // 5, 6, 3, 1 = 15
  // 5, 6, 3, 3 = 17
  // 5, 6, 3, 5 = 19
  // 5, 2, 2, 1 = 10
  // 5, 2, 2, 3 = 12
  // 5, 2, 2, 5 = 14
  // 5, 2, 3, 1 = 11
  // 5, 2, 3, 3 = 13
  // 5, 2, 3, 5 = 15
  // 3, 6, 2, 1 = 12
  // 3, 6, 2, 3 = 14
  // 3, 6, 2, 5 = 16
  // 3, 6, 3, 1 = 13
  // 3, 6, 3, 3 = 15
  // 3, 6, 3, 5 = 17
  // 3, 2, 2, 1 = 8
  // 3, 2, 2, 3 = 10
  // 3, 2, 2, 5 = 12
  // 3, 2, 3, 1 = 9
  // 3, 2, 3, 3 = 11
  // 3, 2, 3, 5 = 13
  // 1, 6, 2, 1 = 10
  // 1, 6, 2, 3 = 12
  // 1, 6, 2, 5 = 14
  // 1, 6, 3, 1 = 11
  // 1, 6, 3, 3 = 13
  // 1, 6, 3, 5 = 15
  // 1, 2, 2, 1 = 6
  // 1, 2, 2, 3 = 8
  // 1, 2, 2, 5 = 10
  // 1, 2, 3, 1 = 7
  // 1, 2, 3, 3 = 9
  // 1, 2, 3, 5 = 11
  // Expect amount 10, counter 36 - Solution 1
  // Expect amount 10, counter 24 - Solution 2
  private List<List<Integer>> scenario2() {
    List<Integer> pricesA = Arrays.asList(5, 3, 1);
    List<Integer> pricesB = Arrays.asList(6, 2);
    List<Integer> pricesC = Arrays.asList(2, 3);
    List<Integer> pricesD = Arrays.asList(1, 3, 5);

    return new ArrayList<List<Integer>>(Arrays.asList(pricesA, pricesB, pricesC, pricesD));
  }
}
