package io.intellijokers;


/**
 * Created by stevejaminson on 5/11/16.
 */
public class Card {

    int rank;
    Deck.Suits suit;
    int blackjackValue;
    String display;

    public Card() {
    }

    public Card(int thisRank, Deck.Suits thisSuit, int thisBlackjackValue, String thisDisplay) {
        this.rank = thisRank;
        this.suit = thisSuit;
        this.blackjackValue = thisBlackjackValue;
        this.display = thisDisplay;
    }

}