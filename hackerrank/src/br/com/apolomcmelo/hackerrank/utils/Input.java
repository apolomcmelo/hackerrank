package br.com.apolomcmelo.hackerrank.utils;

import java.util.Scanner;

public class Input {

    private Scanner data;

    public Input() {}

    public Input(Scanner data) {
        this.data = data;
    }

    public Scanner getData() {
        return data;
    }

    public void setData(Scanner data) {
        this.data = data;
    }
}
