package io.intellijokers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by alejandrolondono on 5/11/16.
 */
public class DeckSpec {

    Deck deck;
    Player player;
    Card card;
    Card.Suits suit;
    ArrayList<Card> newDeck;
    @Before
    public void Sandbox(){
        deck = new Deck();
        suit = Card.Suits.DIAMONDS;
        card = new Card(6, suit);
        player = new Player("Stevie Wonder", 200);
    }

    @Test
    public void setGetDeck(){
        newDeck.add(card);
        String actualCard = newDeck.get(0).getFace();
        String expectedCard =card.getFace();
        assertEquals("faceCards should be the same and from deck", expectedCard, actualCard);
    }

//    @Test
//    public void drawTest(){
//        deck.draw(player);
//        expectedCard = ""
//        String faceValue = player.getHand().get(0).getFace();
//        assertEquals("player should have a card in his hand", );
//    }
}
