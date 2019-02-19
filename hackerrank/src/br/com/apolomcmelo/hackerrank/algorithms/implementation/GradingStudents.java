package br.com.apolomcmelo.hackerrank.algorithms.implementation;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Printer;

public class GradingStudents implements IChallenge {
    
    private int[] solveChallenge(int[] grades) {
        int[] roundedGrades = new int[grades.length];
        
        for (int i = 0; i < grades.length; i++) {
            roundedGrades[i] = roundGrade(grades[i]);
        }
        
        return roundedGrades;
    }

    @Override
    public void execute(Input input) {
        int n = input.getData().nextInt();
        int[] grades = new int[n];
        
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = input.getData().nextInt();
        }
        
        Printer.printIntArrayOutput(solveChallenge(grades));
    }
    
    private int roundGrade(int grade) {
        if(grade < 38) {
            return grade;
        }
        int closestMulitpleOfFive = (int) (5 * Math.ceil(Math.abs((double)grade/5)));
        
        return (closestMulitpleOfFive - grade) < 3 ? closestMulitpleOfFive : grade;
    }
}
