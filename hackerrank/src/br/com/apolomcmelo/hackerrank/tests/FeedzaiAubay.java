package br.com.apolomcmelo.hackerrank.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class FeedzaiAubay implements IChallenge {

    Map<String, List<String>> mapFriendlyWords = new HashMap<>();

    private String[] solveChallenge(String[] input) {
        List<String> listFriendlyWords = new ArrayList<String>();

        Arrays.stream(input).forEach((word) -> {

            if (word != null && !"".equals(word)) {
                char[] charsFromWord = word.toCharArray();
                Arrays.sort(charsFromWord);

                String sortedChars = String.valueOf(charsFromWord);

                putWordIntoMap(sortedChars, word);
            }
        });

        Set<String> keys = mapFriendlyWords.keySet();

        keys.forEach(key -> {
            if (mapFriendlyWords.get(key).size() > 1) {
                final StringBuilder sb = new StringBuilder();

                mapFriendlyWords.get(key).stream().sorted().forEach((w) -> {
                    sb.append(w);
                    sb.append(" ");
                });

                listFriendlyWords.add(sb.toString());

                sb.setLength(0);
            }
        });

        Collections.sort(listFriendlyWords);

        return listFriendlyWords.toArray(new String[listFriendlyWords.size()]);
    }

    private void putWordIntoMap(String key, String word) {
        if (!mapFriendlyWords.containsKey(key)) {
            mapFriendlyWords.put(key, new ArrayList<String>());
        }

        mapFriendlyWords.get(key).add(word);
    }

    @Override
    public void execute(Input input) {
//        String[] arr = {"car", "cheating", "dale", "deal", "lead", "listen", "silent", "teaching"};
        String[] arr = {null, "alegan", "angela", "quieren" , "enrique", "ironicamente", "ecuador", "renacimiento", null, "enlodar" , "leandro", "imponderablemente", "imperdonablemente", "desamparador", "desparramado", "", "amor", "abobora", "zebra", "acuerdo", ""};

        Printer.printStringArrayOutput(solveChallenge(arr));
    }

}