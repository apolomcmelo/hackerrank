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

import br.com.apolomcmelo.hackerrank.algorithms.warmup.PlusMinus;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class PlusMinusTest {
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
    public double[] solveResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                        {new Input(new Scanner("6\n-4\n3\n-9\n0\n4\n1")), 6, new int[] {-4, 3, -9, 0, 4, 1}, "0,500000\n0,333333\n0,166667\n", new double[] {0.500000, 0.333333, 0.166667}},
                        {new Input(new Scanner("5\n4\n3\n9\n5\n7")), 5, new int[] {4, 3, 9, 5, 7}, "1,000000\n0,000000\n0,000000\n", new double[] {1.000000, 0.000000, 0.000000}},
                        {new Input(new Scanner("3\n0\n0\n0")), 3, new int[] {0, 0, 0}, "0,000000\n0,000000\n1,000000\n", new double[] {0.000000, 0.000000, 1.000000}},
                        {new Input(new Scanner("4\n-1\n-2\n-4\n-5")), 4, new int[] {-1, -2, -4, -5}, "0,000000\n1,000000\n0,000000\n", new double[] {0.000000, 1.000000, 0.000000}}};
                        
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
        double[] result = (double[]) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(PlusMinus.class), "solveChallenge", 2, n, arr);

        Assert.assertEquals(solveResult[0], result[0], 0.00001);
        Assert.assertEquals(solveResult[1], result[1], 0.00001);
        Assert.assertEquals(solveResult[2], result[2], 0.00001);
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(PlusMinus.class).execute(input);

        Assert.assertEquals(executeResult, outContent.toString());
    }
}
