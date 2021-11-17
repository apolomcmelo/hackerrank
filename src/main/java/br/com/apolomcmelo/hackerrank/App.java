package br.com.apolomcmelo.hackerrank;

import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.AmountOfChoices;
import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.BalancedBrackets;
import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.CoinChange;
import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.FruitPromotion;
import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.IsBinarySearchTree;
import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.KthPermutation;
import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.LevelOrderTraversalBinaryTree;
import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.MergeSortedLists;
import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.PrintPossibleBrackets;
import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.ReverseWordsOfSentence;
import br.com.apolomcmelo.hackerrank.algorithms.amazon.practice.StringSegmentation;
import br.com.apolomcmelo.hackerrank.utils.Functions;
import br.com.apolomcmelo.hackerrank.utils.Printer;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Timer;

public class App {
    public static void main(String[] args) throws Exception {
        Timer.start();
        
        run();

        Timer.stop();
        Timer.printInMillis();

   }

    public static void run() {
        Scanner in = new Scanner(System.in);
        Input input = new Input(in);



      List<Integer> prices = Arrays.asList(1, 4, 8, 4);
      Set<Integer> test = prices.stream().sorted().collect(Collectors.toSet());


        ChallengeFactory.startChallenge(AmountOfChoices.class).execute(input);
    }


    
    
    
    
    
    
    
    
    public static List<String> romanizer(List<Integer> numbers) {
        List<String> numbersRomanized = new ArrayList<String>();
        
        numbers.forEach(n -> numbersRomanized.add(getRomanizedNumber(n)));

        return numbersRomanized;
    }
    
    public static String getRomanizedNumber(int number) {
        Map<Integer, String> romanMap = getRomanNumeralMap();
        
        final String romanizedNumber = "";
        
        romanMap.keySet().forEach(n -> {
            int quotient = number / n;
            int rest = number % n;
            do {
                
            } while (quotient == 1 && rest < n);
        });
        
        return romanizedNumber;
        
    }
    
    
    public static Map<Integer, String> getRomanNumeralMap() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        
        return map;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static List<String> getType(List<String> abc) {
        List<String> listTypes = new ArrayList<String>();

        for(int i=0; i<abc.size(); i++) {
            int[] triangleSides = getTriangleSidesFromString(abc.get(i));

            if(isValidTriangle(triangleSides)){
                if(isEquilateral(triangleSides)) {
                    listTypes.add("Equilateral");
                } else if(isIsosceles(triangleSides)) {
                    listTypes.add("Isosceles");
                } else {
                    listTypes.add("None of these");
                }
            } else {
                listTypes.add("None of these");
            }
        }

        return listTypes;
    }

    public static int[] getTriangleSidesFromString(String side) {
        List<String> listSides = Arrays.asList(side.split(" "));

        return listSides.stream().mapToInt(num -> Integer.parseInt(num)).sorted().toArray();
    }

    public static boolean isEquilateral(int[] sides) {
        return sides[2] == sides[1] && sides[1] == sides[0];
    }

    public static boolean isIsosceles(int[] sides) {
        return (sides[0] == sides[1] && sides[1] != sides[2]) || (sides[1] == sides[2] && sides[2] != sides[0]);
    }

    public static boolean isValidTriangle(int[] sides) {
        return (sides[0] + sides[1]) > sides[2];
    }
    
    public static int calcSquaredDistance(List<Integer> coordinates) {
        return (int)Point2D.distanceSq(coordinates.get(0), coordinates.get(1), coordinates.get(2), coordinates.get(3));
    }
 
    public static int solution(int[] A) {
        // Arrays em lista
        List<Integer> list = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());
        
        //Sequencia infinita... desde que eu não use o limit
        Stream<Integer> nums = Stream.iterate(1, i -> i + 1);
        
        // Último elemento
        Stream<String> stream = new ArrayList<String>().stream();
        stream.reduce((first, second) -> second).orElse(null);

        return 0;
    }

}