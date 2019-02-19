package br.com.apolomcmelo.hackerrank.algorithms.warmup;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class SolveMeFirst implements IChallenge {
    private int solveChallenge(int a, int b) {
        return a + b;
    }

    public void execute(Input input) {
        Printer.printNumberOutput(solveChallenge(input.getData().nextInt(), input.getData().nextInt()));
    }
}