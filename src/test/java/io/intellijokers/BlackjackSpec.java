package io.intellijokers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class BlackjackSpec {

    @Test
    public void hitTest(){
        Blackjack blackjack = new Blackjack();
        boolean expected = true;
        boolean actual = blackjack.hit();
        assertEquals("Should return true if the user hits",expected,actual);
    }

    @Test
    public void standTest(){
        Blackjack blackjack = new Blackjack();
        boolean expected = true;
        boolean actual = blackjack.stand();
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
    public void aceCheckTest(){
        Blackjack blackjack = new Blackjack();
        boolean expected = true;
        boolean actual = blackjack.aceCheck();
        assertEquals("Should return true if hand + 10 is not over 21",expected,actual);
    }
}
