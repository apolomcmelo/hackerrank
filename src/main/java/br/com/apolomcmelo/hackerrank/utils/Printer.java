package br.com.apolomcmelo.hackerrank.utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Printer {
    public static void printNumberOutput(Number data) {
        System.out.println(data);
    }
    
    public static void printListOutput(List<?> data) {
        for (int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i) + (i < data.size() ? " " : ""));
        }
    }
    
    public static void printIntArrayOutput(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + (i < data.length ? " " : ""));
        }
    }
    
    public static void printLongArrayOutput(long[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + (i < data.length ? " " : ""));
        }
    }
    
    public static void printStringOutput(String data) {
        System.out.println(data);
    }
    
    public static void printFormattedDoubleArrayOutput(double[] data, String format) {
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.format(format, data[i]));
        }
    }
    
    public static void printStringArrayOutput(String[] data) {
        Arrays.stream(data).forEach(System.out::println);
    }
    
    public static void printBigIntegerArrayOutput(BigInteger[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + (i < data.length ? " " : ""));
        }
    }

    public static void printMatrixOutput(int n, int mat[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}