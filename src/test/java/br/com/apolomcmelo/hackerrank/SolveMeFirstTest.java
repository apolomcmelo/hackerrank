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

import br.com.apolomcmelo.hackerrank.algorithms.warmup.SolveMeFirst;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class SolveMeFirstTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;

    @Parameter(1)
    public int a;
    @Parameter(2)
    public int b;

    @Parameter(3)
    public long testResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
            {new Input(new Scanner("4\n5")), 4, 5, 9},
            {new Input(new Scanner("-4\n-5")), -4, -5, -9},
            {new Input(new Scanner("5\n-5")), 5, -5, 0},
            {new Input(new Scanner("4\n-5")), 4, -5, -1},
            {new Input(new Scanner("-4\n5")), -4, 5, 1}};

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
        int result = (int) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(SolveMeFirst.class), "solveChallenge", 2, a, b);

        Assert.assertEquals(testResult, result);
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(SolveMeFirst.class).execute(input);

        Assert.assertEquals(testResult, Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", "")));
    }
}
