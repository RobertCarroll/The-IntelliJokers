package io.intellijokers;
import io.intellijokers.Player;
import io.intellijokers.Roulette;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dimitrivaughn on 5/11/16.
 */
public class RouletteSpec {


    Player player;
    Roulette roly;


    @Before

    public void Sandbox() {
        player = new Player("Sephiroth", 1500) {
        };
        roly = new Roulette();

    }

    @Test

    public void betStraightTest() {
        roly.betStraight(24);
        boolean actualValue = roly.getBets().contains(24);
        assertTrue("Expected value = true", actualValue);

    }

    @Test

    public void betEvenTest() {
        boolean bool = false;
        roly.betEven();

        for (Integer betNum : roly.getBets()) {

            if (betNum % 2 == 0) {
                bool = true;
            } else {
                bool = false;
            }
        }

        assertTrue("Every value should be even: Expected value = true", bool);

    }

    @Test

    public void betOddTest() {
        boolean bool = false;
        roly.betOdd();

        for (Integer betNum : roly.getBets()) {

            if (betNum % 2 != 0) {
                bool = true;
            } else {
                bool = false;
            }
        }

        assertTrue("Every value should be odd: Expected value = true", bool);

    }

    @Test

    public void betColorTest() {
        roly.betColor(player, "RED");
        String expectedValue = "RED";
        String actualValue = player.getBetColor();
        assertEquals("The color stored should be the same: Expected value = RED", expectedValue, actualValue);
    }

    @Test

    public void setWinningNumberTest() {
        roly.setWinningNumber();
        boolean bool = false;
        if (roly.getWinningNumber() >= 0 && roly.getWinningNumber() <= 36) {
            bool = true;

        }
        assertTrue("Number should be between 0 and 36 Expected value = true", bool);
    }

    @Test

    public void determineWinnerNumberTest(){
        roly.setWinningNumber();
        int winNum = roly.getWinningNumber();
        player.getBets().add(winNum);
        boolean bool = roly.determineWinner(player);
        assertTrue("the winner should return true because they have the winning number: "+winNum, bool);

    }

    @Test

    public void determineWinnerColorTest(){
        roly.setWinningNumber();
        int winNum = roly.getWinningNumber();
        String winColor = roly.hashMap.get(winNum);
        player.setBetColor(winColor);
        player.setBetType(Player.Choice.COLOR);
        boolean bool = roly.determineWinner(player);
        assertTrue("the winner should return true because they have the winning number: "+winColor, bool);

    }
}



