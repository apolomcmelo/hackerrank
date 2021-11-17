package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two sorted linked lists, merge them so that the resulting linked list is also sorted.
 */
public class MergeSortedLists implements IChallenge {

  private List solveChallenge(List<Integer> list1, List<Integer> list2) {
    List mergedList = new ArrayList();

    if(list1 == null) {
      mergedList = list2;
    } else if(list2 == null) {
      mergedList = list1;
    }

    int list1Index = 0;
    int list2Index = 0;


    while (list1Index < list1.size() && list2Index < list2.size()) {
      Integer element = null;

      if (list1.get(list1Index) <= list2.get(list2Index)) {
        element = list1.get(list1Index);
        list1Index++;
      } else {
        element = list2.get(list2Index);
        list2Index++;
      }

      mergedList.add(element);
    }

    if (list1Index < list1.size()) {
      mergedList.addAll(list1.subList(list1Index, list1.size()));
    } else if (list2Index < list2.size()) {
      mergedList.addAll(list2.subList(list2Index, list2.size()));
    }

    return mergedList;
  }

  @Override
  public void execute(Input input) {
    Integer[] arr1 = {1, 3, 5, 6};
    Integer[] arr2 = {2, 4, 6, 20, 34};

    List<Integer> mergedList = solveChallenge(Arrays.asList(arr1), Arrays.asList(arr2));
    Printer.printListOutput(mergedList);
  }
}
