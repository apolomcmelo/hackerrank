package br.com.apolomcmelo.hackerrank.algorithms.warmup;

import java.math.BigInteger;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class MiniMaxSum implements IChallenge {

    private BigInteger[] solveChallenge(int[] arr) {
        BigInteger[] miniMax = new BigInteger[2];
        BigInteger maxSum = new BigInteger("0");

        for (int i = 0; i < arr.length; i++) {
            maxSum = maxSum.add(new BigInteger(arr[i] + ""));
        }

        miniMax[0] = maxSum;
        miniMax[1] = BigInteger.ZERO;

        for (int i = 0; i < arr.length; i++) {
            BigInteger curr_sum = maxSum.subtract(new BigInteger(arr[i] + ""));

            if (curr_sum.compareTo(miniMax[0]) < 0) {
                miniMax[0] = curr_sum;
            }

            if (curr_sum.compareTo(miniMax[1]) > 0) {
                miniMax[1] = curr_sum;
            }
        }

        return miniMax;
    }

    @Override
    public void execute(Input input) {
        int[] arr = new int[5];

        for (int arr_i = 0; arr_i < 5; arr_i++) {
            arr[arr_i] = input.getData().nextInt();
        }

        Printer.printBigIntegerArrayOutput(solveChallenge(arr));
    }
}
