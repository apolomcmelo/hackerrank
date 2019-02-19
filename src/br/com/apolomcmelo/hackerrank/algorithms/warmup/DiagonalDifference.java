package br.com.apolomcmelo.hackerrank.algorithms.warmup;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class DiagonalDifference implements IChallenge {

    private int solveChallenge(int n, int[][] a) {
        int pD = 0, sD = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    pD += a[i][j];
                    sD += a[n - i - 1][j];
                }
            }
        }

        return Math.abs(pD - sD);
    }

    @Override
    public void execute(Input input) {
        int n = input.getData().nextInt();
        int a[][] = new int[n][n];

        for (int a_i = 0; a_i < n; a_i++) {
            for (int a_j = 0; a_j < n; a_j++) {
                a[a_i][a_j] = input.getData().nextInt();
            }
        }

        Printer.printNumberOutput(solveChallenge(n, a));
    }
}