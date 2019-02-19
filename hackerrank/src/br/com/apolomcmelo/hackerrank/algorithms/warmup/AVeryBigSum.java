package br.com.apolomcmelo.hackerrank.algorithms.warmup;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class AVeryBigSum implements IChallenge {

    private long solveChallenge(int n, long[] ar) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += ar[i];
        }

        return sum;
    }

    @Override
    public void execute(Input input) {
        int n = input.getData().nextInt();
        long[] ar = new long[n];

        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = input.getData().nextLong();
        }

        Printer.printNumberOutput(solveChallenge(n, ar));
    }
}