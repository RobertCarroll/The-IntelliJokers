package io.intellijokers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by alejandrolondono on 5/11/16.
 */
public class PlayerSpec {

    Player player;
    String name;
    int amount;
    double err;
    @Before
    public void Sandbox(){
        amount = 500;
        err = .01;
        player = new Player(name, amount);
    }

    @Test
    public void setGetCashTest(){
        player.setCash(amount);
        int actualCash = player.getCash();
        assertEquals("the amount passed should have been set and returned by a getter and setter", amount,actualCash);
    }

    @Test
    public void placeBetTest(){
        player.placeBet(50);
        int actualCash = player.getCash();
        int expectedCash = 500-50;
        assertEquals("the cash of player should be "+ expectedCash, expectedCash, actualCash);
    }
}
