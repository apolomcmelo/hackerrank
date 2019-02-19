package br.com.apolomcmelo.hackerrank.algorithms.warmup;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class PlusMinus implements IChallenge {

    private double[] solveChallenge(int n, int[] arr) {
        double pos = 0, neu = 0, neg = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                pos++;
            }

            if (arr[i] < 0) {
                neg++;
            }

            if (arr[i] == 0) {
                neu++;
            }
        }

        return new double[] {calculateFraction(pos, n), calculateFraction(neg, n), calculateFraction(neu, n)};
    }

    @Override
    public void execute(Input input) {
        int n = input.getData().nextInt();
        int arr[] = new int[n];

        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = input.getData().nextInt();
        }

        Printer.printFormattedDoubleArrayOutput(solveChallenge(n, arr), "%.6f");
    }

    private double calculateFraction(double value, int size) {
        return value / (double) size;
    }
}