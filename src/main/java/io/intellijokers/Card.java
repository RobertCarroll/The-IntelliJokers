package io.intellijokers;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class Card {

    int rank;
    Deck.Suits suit; //what does this dot notation mean?
    int blackjackValue;
    String display;

    public Card(){}; //is there ever a point where we would need a blank card object other than testing?
    public Card(int thisRank, Deck.Suits thisSuit, int thisBlackjackValue, String thisDisplay){
        this.rank = thisRank;
        this.suit = thisSuit;
        this.blackjackValue = thisBlackjackValue;
        this.display = thisDisplay;
    }
}
