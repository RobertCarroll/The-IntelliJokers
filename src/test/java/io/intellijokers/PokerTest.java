package io.intellijokers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by michaelcane on 5/11/16.
 */
public class PokerTest {

    Poker poker;
    @Before public void setupInitializer() {
        poker = new Poker();
    }

    @Test
    public void getPotTest() {
        int expectedValue = 9;
        int actualValue = poker.getPot();
        assertEquals("Should output 9", expectedValue, actualValue);
    }
}
