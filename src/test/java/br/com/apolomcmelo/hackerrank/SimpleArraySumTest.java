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

import br.com.apolomcmelo.hackerrank.algorithms.warmup.SimpleArraySum;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class SimpleArraySumTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;

    @Parameter(1)
    public int[] arr;

    @Parameter(2)
    public int testResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                        {new Input(new Scanner("6\n1\n2\n3\n4\n10\n11")), new int[] {1, 2, 3, 4, 10, 11}, 31},
                        {new Input(new Scanner("6\n5\n-2\n3\n-4\n0\n-2")), new int[] {5, -2, 3, -4, 0, -2}, 0}};
                        
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
        int n = 6;
        int result = (int) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(SimpleArraySum.class), "solveChallenge", 2, n, arr);

        Assert.assertEquals(testResult, result);
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(SimpleArraySum.class).execute(input);

        Assert.assertEquals(testResult, Integer.parseInt(outContent.toString().replace("\n", "")));
    }
}
