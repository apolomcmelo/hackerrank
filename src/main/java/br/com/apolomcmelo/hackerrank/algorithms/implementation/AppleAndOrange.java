package br.com.apolomcmelo.hackerrank.algorithms.implementation;

import java.util.Arrays;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class AppleAndOrange implements IChallenge {

    private int[] solveChallenge(int s, int t, int a, int b, int m, int n, int[] apples, int[] oranges) {
        int[] result = new int[2];
        
        for (int i = 0; i < apples.length; i++) {
            if(isInSamsHouse(s, t, a, apples[i])) {
                result[0]++;
            }
        }
        
        for (int i = 0; i < oranges.length; i++) {
            if(isInSamsHouse(s, t, b, oranges[i])) {
                result[1]++;
            }
        }
        
        return result;
    }
    
    private boolean isInSamsHouse(int x1House, int x2House, int tree, int fruit) {
        int fruitDistance = tree + fruit;
        return fruitDistance >= x1House && fruitDistance <= x2House;
    }
    
    @Override
    public void execute(Input input) {
        int s = input.getData().nextInt();
        int t = input.getData().nextInt();
        int a = input.getData().nextInt();
        int b = input.getData().nextInt();
        int m = input.getData().nextInt();
        int n = input.getData().nextInt();
        
        int[] apple = new int[m];
        
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = input.getData().nextInt();
        }
        
        int[] orange = new int[n];
        
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = input.getData().nextInt();
        }
        
        Arrays.stream(solveChallenge(s, t, a, b, m, n, apple, orange)).forEach(Printer::printNumberOutput);
    }
}
