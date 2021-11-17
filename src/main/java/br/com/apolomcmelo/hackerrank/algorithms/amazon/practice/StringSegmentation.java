package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * You are given a dictionary of words and a large input string.
 * You have to find out whether the input string can be completely segmented into the words of a given dictionary.
 */
public class StringSegmentation implements IChallenge {

  private boolean solveChallenge(Set dictionary, String word) {
    if(word == null || word.isEmpty()) {
      return true;
    }

    for(int i=1; i<word.length(); i++) {
      String firstSegment = word.substring(0, i);
      if(dictionary.contains(firstSegment)) {
        String secondSegment = word.substring(i);
        if (secondSegment == null || secondSegment.isEmpty() || dictionary.contains(secondSegment) || solveChallenge(dictionary,secondSegment)) {
          return true;
        }
      }
    }

    return false;
  }

  @Override
  public void execute(Input input) {
    String[] dictionary = {"apple", "apple", "pear", "pie"};
    Set dictionarSet = Arrays.stream(dictionary).collect(Collectors.toSet());
    //String word = "applepeer";
    String word = "applepiepear";

    System.out.println(solveChallenge(dictionarSet, word));
  }
}
