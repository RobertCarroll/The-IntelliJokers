package io.intellijokers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerSpec {

    Player player;
    String name;
    int amount;
    double err;
    String betColor;
    ArrayList<Integer> bets;
    Player.Choice betType;


    @Before
    public void Sandbox(){

        amount = 500;
        err = .01;
        player = new Player(name);
        bets = new ArrayList(); //might need to add <>
        bets.add(1);
        bets.add(2);
        bets.add(3);
        betColor = "Black";
        betType = Player.Choice.NUMBER;
    }

    @Test
    public void setBetTypeTest() {
        player.setBetType(betType);
        Player.Choice actualValue = player.getBetType();
        assertEquals("Should output the type of bet set by the player", betType, actualValue);
    }

    @Test
    public void setBetColorTest() {
        player.setBetColor(betColor);
        String actualValue = player.getBetColor();
        assertEquals("Should output the color set by the player", betColor, actualValue);
    }

    @Test
    public void setGetCashTest(){
        player.setCash(amount);
        int actualCash = player.getCash();
        assertEquals("the amount passed should have been set and returned by a getter and setter", amount,actualCash);
    }

    @Test
    public void placeBetTest() {
        player.placeBet(50);
        double actualCash = player.getCash();
        int expectedCash = 500 - 50;
        assertEquals("the cash of player should be " + expectedCash, expectedCash, actualCash, 0);
    }


    @Test
    public void placeBetTestReturn(){
        int money = player.placeBet(50, bets);
        int expectedMoney = 50;
        assertEquals("the bet should return the money", expectedMoney, money);
    }

    @Test
    public void storeBetListTest(){
        player.placeBet(50, bets);
        int expectedBet = player.getBets().get(1);
        int actualBet = 2;
        assertEquals("bet int should be the same",expectedBet,actualBet);
    }

    @Test
    public void setGetBetTest(){
        player.setBets(bets);
        ArrayList<Integer> actualBets = player.getBets();
        assertEquals("the bets passed should be returned.", bets, actualBets);
    }

}

