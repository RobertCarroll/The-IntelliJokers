package io.intellijokers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DealerSpec {

    Dealer dealer;
    Deck deck;
    Player player;
    String name;

    int amount;

    @Before
    public void Sandbox(){
        name = "Dandy Randy";
        dealer = new Dealer();
        deck = new Deck();
        player = new Player(name);
//        ai = new AI();
    }


    @Test
    public void dealCardTest(){
        Card testCard = dealer.dealCard();
        String expected = "[2"+Card.Suits.SPADES.suitIcon+"]";
        String actual = testCard.getCardDisplay();
        assertEquals(expected,actual);
    }

}
