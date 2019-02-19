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

import br.com.apolomcmelo.hackerrank.algorithms.warmup.DiagonalDifference;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class DiagonalDifferenceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;

    @Parameter(1)
    public int[][] mat;

    @Parameter(2)
    public int testResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
            {new Input(new Scanner("3\n11\n2\n4\n4\n5\n6\n10\n8\n-12")), new int[][] {{11, 2, 4}, {4, 5, 6}, {10, 8, -12}}, 15},
            {new Input(new Scanner("3\n5\n3\n6\n0\n0\n0\n-5\n-3\n-6")), new int[][] {{5, 3, 6}, {0, 0, 0}, {-5, -3, -6}}, 2},
            {new Input(new Scanner("3\n2\n4\n6\n1\n3\n5\n0\n2\n4")), new int[][] {{2, 4, 6}, {1, 3, 5}, {0, 2, 4}}, 0}};

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
        int n = 3;
        
        int result = (int) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(DiagonalDifference.class), "solveChallenge", 2, n, mat);

        Assert.assertEquals(testResult, result);
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(DiagonalDifference.class).execute(input);

        Assert.assertEquals(testResult, Integer.parseInt(outContent.toString().replace("\n", "")));
    }
}
