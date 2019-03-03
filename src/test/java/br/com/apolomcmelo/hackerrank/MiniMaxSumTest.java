package br.com.apolomcmelo.hackerrank;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
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

import br.com.apolomcmelo.hackerrank.algorithms.warmup.MiniMaxSum;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class MiniMaxSumTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;

    @Parameter(1)
    public int[] arr;

    @Parameter(2)
    public String executeResult;
    @Parameter(3)
    public BigInteger[] solveResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                        {new Input(new Scanner("1\n2\n3\n4\n5")), new int[] {1, 2, 3, 4, 5}, "10 14 ",new BigInteger[] {new BigInteger("10"), new BigInteger("14")}},
                        {new Input(new Scanner("0\n1\n2\n0\n2")), new int[] {0, 1, 2, 0, 2}, "3 5 ",new BigInteger[] {new BigInteger("3"), new BigInteger("5")}},
                        {new Input(new Scanner("1\n1\n1\n1\n1")), new int[] {1, 1, 1, 1, 1}, "4 4 ",new BigInteger[] {new BigInteger("4"), new BigInteger("4")}}};

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
        BigInteger[] result = (BigInteger[]) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(MiniMaxSum.class), "solveChallenge", 1, arr);

        Assert.assertEquals(solveResult[0], result[0]);
        Assert.assertEquals(solveResult[1], result[1]);
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(MiniMaxSum.class).execute(input);

        Assert.assertEquals(executeResult, outContent.toString().replace("\n", ""));
    }
}
