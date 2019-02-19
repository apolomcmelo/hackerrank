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

import br.com.apolomcmelo.hackerrank.algorithms.warmup.BirthdayCakeCandles;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class BirthdayCakeCandlesTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;

    @Parameter(1)
    public int n;

    @Parameter(2)
    public int[] arr;

    @Parameter(3)
    public long testResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
            {new Input(new Scanner("4\n3\n2\n1\n3")), 4, new int[] {3, 2, 1, 3}, 2},
            {new Input(new Scanner("2\n1\n1")), 2, new int[] {1, 1}, 2},
            {new Input(new Scanner("3\n1\n4\n3")), 3, new int[] {1, 4, 3}, 1}};

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
        long result = (long) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(BirthdayCakeCandles.class), "solveChallenge", 2, n, arr);

        Assert.assertEquals(testResult, result);
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(BirthdayCakeCandles.class).execute(input);

        Assert.assertEquals(testResult, Long.parseLong(outContent.toString().replace("\n", "")));
    }
}
