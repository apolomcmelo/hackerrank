package br.com.apolomcmelo.hackerrank.factories;

import br.com.apolomcmelo.hackerrank.interfaces.IChallenge;

public class ChallengeFactory {
    public static IChallenge startChallenge(Class<? extends IChallenge> challenge) {

        try {
            return challenge.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
