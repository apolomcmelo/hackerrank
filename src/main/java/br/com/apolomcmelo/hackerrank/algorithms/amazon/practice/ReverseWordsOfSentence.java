package br.com.apolomcmelo.hackerrank.algorithms.amazon.practice;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;

public class ReverseWordsOfSentence implements IChallenge {

  private String solveChallenge(String sentence) {
    if (sentence == null || sentence.isEmpty()) {
      return sentence;
    }

    String[] wordsArray = sentence.split(" ");

    String reversedSentence = "";

    for (int i = wordsArray.length - 1; i >= 0; i--) {
      reversedSentence += wordsArray[i];

      if (i > 0) {
        reversedSentence += " ";
      }
    }

    return reversedSentence;
  }

  @Override
  public void execute(Input input) {
    String sentence = "Hello World";
    System.out.println(sentence);
    System.out.println(solveChallenge(sentence));
  }

}
