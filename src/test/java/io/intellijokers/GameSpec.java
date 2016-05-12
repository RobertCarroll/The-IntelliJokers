package io.intellijokers;

/**
 * Created by michaelcane on 5/11/16.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameSpec {

    Game game;
    @Before public void setupInitializer() {
        //game = new Game();
    }


    @Test
    public void getAmountBetTest() {
        int expectedValue = 9;
        int actualValue = game.getAmountBet();
        assertEquals("Should output 0", expectedValue, actualValue);
    }

    @Test
    public void getRound() {
        int expectedValue = 9;
        int actualValue = game.getRound();
        assertEquals("Should output 0", expectedValue, actualValue);
    }


}
