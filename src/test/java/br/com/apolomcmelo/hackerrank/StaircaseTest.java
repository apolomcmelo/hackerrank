package br.com.apolomcmelo.hackerrank;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.com.apolomcmelo.hackerrank.algorithms.warmup.Staircase;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class StaircaseTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;

    @Parameter(1)
    public int n;

    @Parameter(2)
    public String testResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                        {new Input(new Scanner("4")), 4, "   #\n  ##\n ###\n####"},
                        {new Input(new Scanner("2")), 2, " #\n##"},
                        {new Input(new Scanner("1")), 1, "#"}};
                        
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
        String result = (String) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(Staircase.class), "solveChallenge", 1, n);
        Assert.assertEquals(testResult, result.replaceAll("[\\r]", ""));
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(Staircase.class).execute(input);
        Assert.assertEquals(testResult, StringUtils.chomp(outContent.toString().replaceAll("[\\r]", "")));
    }
}
