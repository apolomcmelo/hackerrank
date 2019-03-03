package br.com.apolomcmelo.hackerrank;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.com.apolomcmelo.hackerrank.algorithms.implementation.AppleAndOrange;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class AppleAndOrangeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;

    @Parameter(1)
    public int[] arr;

    @Parameter(3)
    public String executeResult;
    
    @Parameter(4)
    public int[] solveResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {{new Input(new Scanner("7\n11\n5\n15\n3\n2\n-2\n2\n1\n5\n-6")), 7, 11, 5, 15, 3, 2, new int[] {-2, 2, 1}, new int[] {5, -6}, "1\n1\n"}};

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
        int[] result = (int[]) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(AppleAndOrange.class), "solveChallenge", 8, 7, 11, 5, 15, 3, 2, new int[] {-2, 2, 1}, new int[] {5, -6});

        Assert.assertEquals(solveResult[0], result[0]);
        Assert.assertEquals(solveResult[1], result[1]);
    }

    @Test
    @Ignore
    public void executeTest() {
        ChallengeFactory.startChallenge(AppleAndOrange.class).execute(input);

        Assert.assertEquals(executeResult, Long.parseLong(outContent.toString().replace("\n", "")));
    }
}
