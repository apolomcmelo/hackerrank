package test.java.br.com.apolomcmelo.hackerrank;

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

import br.com.apolomcmelo.hackerrank.algorithms.warmup.AVeryBigSum;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class AVeryBigSumTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;

    @Parameter(1)
    public long[] arr;

    @Parameter(2)
    public long testResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
            {new Input(new Scanner("5\n1000000001\n1000000002\n1000000003\n1000000004\n1000000005")), new long[] {1000000001l, 1000000002l, 1000000003l, 1000000004l, 1000000005l}, 5000000015l},
            {new Input(new Scanner("5\n9999999999\n9999999999\n9999999999\n9999999999\n9999999999")), new long[] {9999999999l, 9999999999l, 9999999999l, 9999999999l, 9999999999l}, 49999999995l}};

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
        int n = 5;
        long result = (long) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(AVeryBigSum.class), "solveChallenge", 2, n, arr);

        Assert.assertEquals(testResult, result);
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(AVeryBigSum.class).execute(input);

        Assert.assertEquals(testResult, Long.parseLong(outContent.toString().replace("\n", "")));
    }
}