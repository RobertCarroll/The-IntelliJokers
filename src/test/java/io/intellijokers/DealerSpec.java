package io.intellijokers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 * Created by alejandrolondono on 5/11/16.
 */
public class DealerSpec {

    Dealer dealer;
    Deck deck;
    Player player;
//    AI ai;
    String name;
    double amount;
    ArrayList<Card> newDeck;

    @Before
    public void Sandbox(){
        name = "Dandy Randy";
        dealer = new Dealer();
        deck = new Deck();
        newDeck = deck.populateDeck();
        player = new Player(name, amount);
//        ai = new AI();
    }

    @Test
    public void getDeck(){
        int expected  = deck.populateDeck().get(33).blackjackValue;
        int actual = dealer.getDeck().get(33).blackjackValue;
        assertEquals("Decks should match", expected, actual);
    }

    @Test
    public void shuffleDeckTest(){
        dealer.shuffleDeck(newDeck);
        int expected = 2;
        int actual = newDeck.get(0).rank;
        assertThat("Cards should usually not be the same after shuffle",expected, not(actual));
    }

    @Test
    public void dealCardTest(){
        Card testCard = dealer.dealCard();
        String expected = "[2\u2663]";
        String actual = testCard.display;
        assertEquals(expected,actual);
    }

}
