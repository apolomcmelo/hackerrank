package br.com.apolomcmelo.hackerrank.algorithms.warmup;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class CompareTheTriplets implements IChallenge {
    private int[] solveChallenge(int a0, int a1, int a2, int b0, int b1, int b2) {
        int[] result = {0, 0};

        if (a0 > b0) {
            result[0]++;
        }
        if (a0 < b0) {
            result[1]++;
        }

        if (a1 > b1) {
            result[0]++;
        }
        if (a1 < b1) {
            result[1]++;
        }

        if (a2 > b2) {
            result[0]++;
        }
        if (a2 < b2) {
            result[1]++;
        }

        return result;
    }

    @Override
    public void execute(Input input) {
        int a0 = input.getData().nextInt();
        int a1 = input.getData().nextInt();
        int a2 = input.getData().nextInt();
        int b0 = input.getData().nextInt();
        int b1 = input.getData().nextInt();
        int b2 = input.getData().nextInt();

        Printer.printIntArrayOutput(solveChallenge(a0, a1, a2, b0, b1, b2));
    }
}
