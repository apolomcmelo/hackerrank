package br.com.apolomcmelo.hackerrank;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.com.apolomcmelo.hackerrank.algorithms.implementation.GradingStudents;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class GradingStudentsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;
    
    @Parameter(1)
    public int n;
    
    @Parameter(2)
    public int[] arr;

    @Parameter(3)
    public String executeResult;
    @Parameter(4)
    public int[] solveResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                        {new Input(new Scanner("4\n73\n67\n38\n33")), 4, new int[] {73, 67, 38, 33}, "75 67 40 33 ", new int[] {75, 67, 40, 33}}};
                        
        return Arrays.asList(data);
    }

    @Before
    public void setUpOutput() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpOutput() {
        System.setOut(null);
    }

    @Test
    public void solveChallengeTest() {
        int[] result = (int[]) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(GradingStudents.class), "solveChallenge", 1, arr);

        for(int i=0; i<result.length; i++) {
            Assert.assertEquals(solveResult[i], result[i]);
        }
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(GradingStudents.class).execute(input);

        Assert.assertEquals(executeResult, outContent.toString().replace("\n", ""));
    }
}