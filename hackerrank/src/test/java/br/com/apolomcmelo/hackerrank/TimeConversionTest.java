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

import br.com.apolomcmelo.hackerrank.algorithms.warmup.TimeConversion;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.utils.Input;
import br.com.apolomcmelo.hackerrank.utils.Reflection;

@RunWith(Parameterized.class)
public class TimeConversionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Parameter(0)
    public Input input;

    @Parameter(1)
    public String date;

    @Parameter(2)
    public String testResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                        {new Input(new Scanner("07:05:45PM")), "07:05:45PM", "19:05:45"},
                        {new Input(new Scanner("07:05:45AM")), "07:05:45AM", "07:05:45"}};

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
        String result = (String) Reflection.genericInvokePrivateMethod(ChallengeFactory.startChallenge(TimeConversion.class), "solveChallenge", 1, date);

        Assert.assertEquals(testResult, result);
    }

    @Test
    public void executeTest() {
        ChallengeFactory.startChallenge(TimeConversion.class).execute(input);

        Assert.assertEquals(testResult, outContent.toString().replace("\n", ""));
    }
}
