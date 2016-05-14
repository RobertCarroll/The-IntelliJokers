package io.intellijokers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by alejandrolondono on 5/11/16.
 */
public class PlayerSpec {

    Player player;
    String name;
    int amount;
    double err;
    ArrayList<Integer> bets;



    @Before
    public void Sandbox(){
        amount = 500;
        err = .01;
        player = new Player(name, amount);
        bets = new ArrayList();
        bets.add(1);
        bets.add(2);
        bets.add(3);
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

    @Test
    public void storeBetListTest(){
        player.placeBet(50, bets);
        int expectedBet = player.getBets().get(1);
        int actualBet = 2;
        assertEquals("bet int should be the same",expectedBet,actualBet);
    }

    @Test
    public void placeBetTestReturn(){
        int money = player.placeBet(50,bets);
        int expectedMoney = 50;
        assertEquals("the bet should return the money", expectedMoney, money);
    }

}
