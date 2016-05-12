package io.intellijokers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class BlackjackSpec {

    Blackjack blackjack;
    Dealer dealer;
    Player player;

    @Before
    public void initiate() {
        blackjack = new Blackjack();
        dealer = new Dealer();
        player = new Player("Chester Tester", 500);
    }


    @Test
    public void hitTest(){
        blackjack.hit(dealer);
        int expected = 2;
        int actual = dealer.getHand().get(0).rank;
        assertEquals("Should return true if the user hits",expected,actual);
    }

    @Test
    public void standTest(){
        Blackjack blackjack = new Blackjack();
        boolean expected = true;
        boolean actual = blackjack.stand(dealer);
        assertEquals("Should return true if the user stands",expected,actual);
    }

    @Test
    public void doubleDownTest(){
        Blackjack blackjack = new Blackjack();
        boolean expected = true;
        boolean actual = blackjack.doubleDown();
        assertEquals("Should return true if the user doubles down",expected,actual);
    }

    @Test
    public void splitTest(){
        Blackjack blackjack = new Blackjack();
        boolean expected = true;
        boolean actual = blackjack.split();
        assertEquals("Should return true if the user splits",expected,actual);
    }

    @Test
    public void bustCheck(){
        Blackjack blackjack = new Blackjack();
        boolean expected = true;
        boolean actual = blackjack.bustCheck();
        assertEquals("Should return true if the user busts",expected,actual);
    }

    @Test
    public void insuranceTest(){
        Blackjack blackjack = new Blackjack();
        boolean expected = true;
        boolean actual = blackjack.insurance();
        assertEquals("Should return true if the user takes insurance",expected,actual);
    }

    @Test
    public void isAceInHandTest(){
        player.getHand().add(dealer.dealCard());
        player.getHand().add(dealer.dealCard());
        boolean expected = false;
        boolean actual = blackjack.isAceInHand(player);
        assertEquals("Should return false if no ace is in hand",expected,actual);
    }

    @Test
    public void evaluateHandTest(){
        player.getHand().add(dealer.dealCard());
        player.getHand().add(dealer.dealCard());
        int expected = 5;
        int actual = blackjack.evaluateHand(player);
        assertEquals("Hand total should be 5",expected,actual);
    }
}
