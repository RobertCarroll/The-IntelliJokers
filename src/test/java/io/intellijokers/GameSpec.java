package io.intellijokers;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameSpec {

    Game game;
    @Before public void setupInitializer() {
        game = new Game();
    }

    @Test
    public void getCPUTest() {
        int expectedValue = 0;
        int actualValue = game.getCpu();
        assertEquals("Should output 9", expectedValue, actualValue);
    }

    @Test
    public void setCpuTest() {
        game.setCpu(3);
        assertTrue("CPU should be set to 3", game.getCpu() == 3);
    }

    @Test
    public void getStagesTest() {
        int expectedValue = 9;
        int actualValue = game.getStages();
        assertEquals("Should output 9", expectedValue, actualValue);
    }

    @Test
    public void setStagesTest() {
        game.setStages(5);
        assertTrue("Stages should be set to 5", game.getStages() == 5);
    }

    @Test
    public void betTest() {
        int expectedValue= 100;
        int actualValue = game.bet(100);
        assertEquals("Should output 100", expectedValue, actualValue);
    }

    @Test
    public void payoutTest() {
        int expectedValue = 100;
        int actualValue= game.payout(100);
        assertEquals("Should output 100", expectedValue, actualValue);
    }
}
