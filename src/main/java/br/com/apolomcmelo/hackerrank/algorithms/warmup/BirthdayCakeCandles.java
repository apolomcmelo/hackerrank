package br.com.apolomcmelo.hackerrank.algorithms.warmup;

import java.util.Arrays;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class BirthdayCakeCandles implements IChallenge {

    private long solveChallenge(int n, int[] ar) {
        int max = Arrays.stream(ar).max().getAsInt();
        return Arrays.stream(ar).filter(x -> x == max).count();
    }

    @Override
    public void execute(Input input) {
        int n = input.getData().nextInt();
        int[] ar = new int[n];

        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = input.getData().nextInt();
        }

        Printer.printNumberOutput(solveChallenge(n, ar));
    }
}