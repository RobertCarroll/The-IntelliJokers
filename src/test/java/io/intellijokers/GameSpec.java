package io.intellijokers;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameSpec {

    Game game;
    Player player;
    String name;
    int money;
    @Before public void setupInitializer() {
        game = new Game();
        name = "Ricky bobby";
        money = 100;
        player = new Player(name, money);
    }


    @Test
    public void getStagesTest() {
        int expectedValue = 0;
        int actualValue = game.getStage();
        assertEquals("Should output 9", expectedValue, actualValue);
    }

    @Test
    public void setStagesTest() {
        game.setStage(5);
        assertTrue("Stages should be set to 5", game.getStage() == 5);
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
        int actualValue= game.payout(player);
        assertEquals("Should output 100", expectedValue, actualValue);
    }
}
