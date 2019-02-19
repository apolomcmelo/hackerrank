package br.com.apolomcmelo.hackerrank.algorithms.warmup;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class TimeConversion implements IChallenge {

    private String solveChallenge(String date) {
        DateTimeFormatter inForm = DateTimeFormatter.ofPattern("hh:mm:ssa");
        DateTimeFormatter outForm = DateTimeFormatter.ofPattern("HH:mm:ss");

        return LocalTime.parse(date, inForm).format(outForm);
    }

    @Override
    public void execute(Input input) {
        String s = input.getData().next();

        Printer.printStringOutput(solveChallenge(s));
    }
}