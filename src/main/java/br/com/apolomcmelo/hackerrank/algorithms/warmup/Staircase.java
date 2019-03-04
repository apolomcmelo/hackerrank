package br.com.apolomcmelo.hackerrank.algorithms.warmup;

import java.util.Arrays;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class Staircase implements IChallenge {

    private String solveChallenge(int n) {
        char character = '#', space = ' ';
        String breakline = "\n";
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            char[] spaces = new char[n - i];
            Arrays.fill(spaces, space);

            char[] characteres = new char[i];
            Arrays.fill(characteres, character);

            sb.append(new String(spaces));
            sb.append(new String(characteres));
            
            if(i < n) {
            	sb.append(breakline);            	
            }
        }

        return sb.toString();
    }

    @Override
    public void execute(Input input) {
        int n = input.getData().nextInt();

        Printer.printStringOutput(solveChallenge(n));
    }
}