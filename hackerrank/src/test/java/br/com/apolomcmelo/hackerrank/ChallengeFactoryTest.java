package test.java.br.com.apolomcmelo.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import br.com.apolomcmelo.hackerrank.algorithms.warmup.TimeConversion;
import br.com.apolomcmelo.hackerrank.factories.ChallengeFactory;
import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;

public class ChallengeFactoryTest {

    @Test
    public void startChallengeTest() {
        TimeConversion tc = (TimeConversion) ChallengeFactory.startChallenge(TimeConversion.class);
        
        Assert.assertTrue(tc instanceof IChallenge);
    }
}