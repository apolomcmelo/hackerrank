package br.com.apolomcmelo.hackerrank.algorithms.warmup;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class SimpleArraySum implements IChallenge {
    private int solveChallenge(int n, int[] ar) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += ar[i];
        }
        
        // Java8
        //sum = Arrays.stream(ar).sum();

        return sum;
    }

    public void execute(Input input) {
        int n = input.getData().nextInt();
        int[] ar = new int[n];

        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = input.getData().nextInt();
        }

        Printer.printNumberOutput(solveChallenge(n, ar));
    }
}