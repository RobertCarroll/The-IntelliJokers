package io.intellijokers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by alejandrolondono on 5/11/16.
 */
public class DealerSpec {

    Dealer dealer;
    Deck deck;
    Player player;
//    AI ai;
    String name;
    int ammount;
    @Before
    public void Sandbox(){
        name = "Dandy Randy";
        dealer = new Dealer();
        deck = new Deck();
        player = new Player(name, ammount);
//        ai = new AI();
    }

    @Test
    public void setGetDeck(){
        dealer.setDeck(deck);
        Deck actualDeck = dealer.getDeck();
        assertEquals("deck should have been passed and returned", deck, actualDeck);
    }

//    @Test
//    public void drawFromDeckToPlayerTest(){
//
//
//
//    }
//
//    @Test
//    public void drawFromDeckToSelfTest(){
//
//    }
//
//    @Test
//    public void drawFromDeckToAITest(){
//
//    }
}
