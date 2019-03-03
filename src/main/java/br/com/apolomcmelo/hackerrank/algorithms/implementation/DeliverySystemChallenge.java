package br.com.apolomcmelo.hackerrank.algorithms.implementation;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class DeliverySystemChallenge implements IChallenge {

    private int solveChallenge(int tripMaxWeight, int[] packagesWeight) {
        int trips = 0;
        int j = (packagesWeight.length - 1);
        
        for (int i = 0; i < j; i++, j--) {
            if (packagesWeight[i] + packagesWeight[j] <= tripMaxWeight) {
                trips++;
            } else {
                i--;
            }
        }

        return trips + packagesWeight.length - j - 1;
    }

    @Override
    public void execute(Input input) {
        int tripMaxWeight = input.getData().nextInt();
        int numberOfPackages = input.getData().nextInt();

        int[] packagesWeight = new int[numberOfPackages];

        for (int i = 0; i < numberOfPackages; i++) {
            packagesWeight[i] = input.getData().nextInt();
        }

        Printer.printNumberOutput(solveChallenge(tripMaxWeight, packagesWeight));
    }
}