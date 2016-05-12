package io.intellijokers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by stevejaminson on 5/11/16.
 */
public class CardSpec {

    Card card;
    int rank;
    Card.Suits suit;
    @Before
    public void Sandbox(){

        rank = 4;
        suit = Card.Suits.CLUBS;
        card = new Card(rank, suit);

    }

    @Test
    public void setGetRankTest(){
        int arg = 10;
        card.setRank(arg);
        int newRank = card.getRank();
        assertEquals("the integer passed should be returned",arg, newRank);
    }

    @Test
    public void setGetSuitTest(){
        Card.Suits hearts = Card.Suits.HEARTS;
        card.setSuit(hearts);
        Card.Suits newSuit = card.getSuit();
        assertEquals("the suit passed should be set and returned", hearts,newSuit);
    }

    @Test
    public void setGetorientationTest(){
        Card.Orientation expectedOrientation = Card.Orientation.FACEUP;
        card.setOrientation(expectedOrientation);
        Card.Orientation newOrientation = card.getOrientation();
        assertEquals("orientation should have switched to "+expectedOrientation, expectedOrientation, newOrientation);
    }

    @Test
    public void turnFaceUpTest(){
        Card.Orientation expectedOrientation = Card.Orientation.FACEUP;
        Card.Orientation actualOrientation= card.turnFaceUP();
        assertEquals("orientation should be face up", expectedOrientation, actualOrientation);
    }

    @Test
    public void getFace(){
        String expectedFace = card.getRank()+" "+Card.Suits.CLUBS.getUnicode();
        String actualFace = card.getFace();
        assertEquals("The face of the card is "+expectedFace, expectedFace, actualFace);
    }

    @Test
    public void getBlackJackValue(){
        rank = 12;
        int expectedValue = 10;
        card.setRank(rank);
        int actualValue = card.getBlackJackValue();
        assertEquals("The black jack value should be flattened at 10 for face cards", expectedValue, actualValue);
    }

    @Test
    public void switchAceTest(){
        rank = 11;
        int expectedRank = 1;
        card.switchAce();
        int newRank = card.getRank();
        assertEquals("the rank should be 1",expectedRank,newRank);
    }



}
