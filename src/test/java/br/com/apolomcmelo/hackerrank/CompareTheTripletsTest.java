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

import br.com.apolomcmelo.hackerrank.algorithms.warmup.CompareTheTriplets;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class CompareTheTripletsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;

    @Parameter(1)
    public int a1;
    @Parameter(2)
    public int a2;
    @Parameter(3)
    public int a3;

    @Parameter(4)
    public int b1;
    @Parameter(5)
    public int b2;
    @Parameter(6)
    public int b3;

    @Parameter(7)
    public String executeResult;
    @Parameter(8)
    public int[] solveResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                        {new Input(new Scanner("5\n6\n7\n3\n4\n5\n")), 5, 6, 7, 3, 4, 5, "3 0 ",new int[] {3, 0}},
                        {new Input(new Scanner("2\n2\n2\n2\n2\n2\n")), 2, 2, 2, 2, 2, 2, "0 0 ",new int[] {0, 0}},
                        {new Input(new Scanner("3\n4\n5\n5\n6\n7\n")), 3, 4, 5, 5, 6, 7, "0 3 ",new int[] {0, 3}},
                        {new Input(new Scanner("5\n6\n7\n3\n6\n10\n")), 5, 6, 7, 3, 6, 10, "1 1 ",new int[] {1, 1}}};
                        
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
        int[] result = (int[]) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(CompareTheTriplets.class), "solveChallenge", 6, a1, a2, a3, b1, b2, b3);

        Assert.assertEquals(solveResult[0], result[0]);
        Assert.assertEquals(solveResult[1], result[1]);
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(CompareTheTriplets.class).execute(input);

        Assert.assertEquals(executeResult, outContent.toString().replace("\n", ""));
    }
}