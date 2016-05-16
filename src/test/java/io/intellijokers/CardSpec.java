package io.intellijokers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by stevejaminson on 5/11/16.
 */
public class CardSpec {
    Card aceOfSpades;
    String display;
    int pokerRank;
    int blackJackValue;
    Card.Suits suit;


    @Before
    public void Sandbox(){
        display = "[A♠]";
        pokerRank = 14;
        blackJackValue = 11;
        suit = Card.Suits.SPADES;
        aceOfSpades = new Card(display, pokerRank, blackJackValue, suit);

    }

    @Test
    public void getCardDisplay(){
        String expectedDisplay = "[A♠]";
        String actualDisplay = aceOfSpades.getCardDisplay();
        assertEquals("the display should be equal", expectedDisplay,actualDisplay);
    }

    @Test
    public void getBlackJackValue(){
        int expectedValue = 11;
        int actualValue = aceOfSpades.getBlackjackValue();
        assertEquals("the blackJack value should be 11", expectedValue, actualValue);
    }

    @Test
    public void setBlackJackValueTest(){
        int newValue = 45;
        aceOfSpades.setBlackjackValue(newValue);
        int actualValue = aceOfSpades.getBlackjackValue();
        assertEquals("the blackJackValue should now be "+newValue, newValue, actualValue);
    }

    @Test
    public void SetCardDisplaytest(){
        String newDisplay = "\uF8FF";
        aceOfSpades.setCardDisplay(newDisplay);
        String actualCardDisplay = aceOfSpades.getCardDisplay();
        assertEquals("the card display should now be apple", newDisplay, actualCardDisplay);
    }
}
