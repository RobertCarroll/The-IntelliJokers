package io.intellijokers;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Before;
import org.junit.Test;

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
        player = new Player("Chester Tester");
    }


    @Test
    public void hitTest(){
        blackjack.hit(dealer);
        int expected = 2;
        int actual = dealer.getHand().get(0).getBlackjackValue();
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
        blackjack.doubleDown(player);
        int expected = 0;
        int actual = blackjack.getCurrentBet();
        assertEquals("Should return double the original wager",expected,actual);
    }

    @Test
    public void bustCheckFalse(){
        boolean expected = false;
        boolean actual = blackjack.bustCheck(player);
        assertEquals("Should return true if the user busts",expected,actual);
    }

    @Test
    public void bustCheckTrue(){
        player.getHand().add(dealer.dealCard());
        player.getHand().get(0).setBlackjackValue(25);
        boolean expected = true;
        boolean actual = blackjack.bustCheck(player);
        assertEquals("Should return true if the user busts",expected,actual);
    }

    @Test
    public void evaluateHandTest(){
        player.getHand().add(dealer.dealCard());
        player.getHand().add(dealer.dealCard());
        int expected = 4;
        int actual = blackjack.evaluateHand(player);
        assertEquals("Hand total should be 5",expected,actual);
    }

    @Test
    public void reduceAceValueTest(){
        Player shaunJawn = new Player("Sean Jawn");
        Card ace = new Card(Card.Suits.SPADES.suitIcon, 14,11, Card.Suits.SPADES);
        shaunJawn.getHand().add(ace);
        blackjack.reduceAceValue(shaunJawn);
        int expected = 1;
        int actual = blackjack.evaluateHand(shaunJawn);
        assertEquals("Hand total should be 85 after ace is reduced", expected, actual);
    }

    @Test
    public void displayHandTest(){
        player.getHand().add(dealer.dealCard());
        player.getHand().add(dealer.dealCard());
        String expected = "[2\u2660][2\u2764]  4\n";
        String actual = blackjack.displayHand(player);
        assertEquals(expected,actual);
    }

    @Test
    public void displayScoreBoardTest(){
        String expected = "Current Bet : $0   Total Cash : $500\n\nDealer :   0\n\nChester Tester :   0\n";
        String actual = blackjack.displayScoreBoard(player);
        assertEquals("The expected return is true.", expected, actual);
    }

    @Test
    public void faceDownTest(){
        String expected = "[?]";
        String actual = blackjack.faceDown();
        assertEquals("Should return the card-face-down symbol",expected,actual);
    }

    @Test
    public void setGetCurrentBetTest(){
        blackjack.setCurrentBet(50);
        int expected = 50;
        int actual = blackjack.getCurrentBet();
        assertEquals("Getter should match setter", expected, actual);
    }

    @Test
    public void payoutTest(){
        blackjack.setCurrentBet(50);
        blackjack.payout(1,player);
        int expected = 50;
        int actual = blackjack.getCurrentBet();
        assertEquals("Total should be $50 after win", expected, actual);
    }

    @Test
    public void resetAceValueTest(){
        Dealer dealio = new Dealer();
        Player earl = new Player("Earl Pearl");
        Card ace = new Card(Card.Suits.SPADES.suitIcon, 14,11, Card.Suits.SPADES);
        dealio.getDeck().getCards().add(ace);
        earl.getHand().add(ace);
        blackjack.reduceAceValue(player);
        blackjack.resetAceValue();
        int expected = 11;
        int actual = dealio.getDeck().getCards().get(dealio.getDeck().getCards().indexOf(ace)).getBlackjackValue();
        assertEquals("Hand total should be 85 after ace is reduced", expected, actual);
    }
}
