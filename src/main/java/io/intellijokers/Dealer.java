package io.intellijokers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by alejandrolondono on 5/11/16.
 */
public class Dealer extends User {
    Deck deck = new Deck();
    private ArrayList<Card> newDeck = deck.populateDeck();
    String name = "Dealer";
    private int nextCard = -1;

    public Dealer(){
        super("dealer");
        ArrayList<Card> newDeck = deck.populateDeck();
    }

    /**
     * Gets a deck.
     * @return
     */
    public ArrayList<Card> getDeck() {
        return newDeck;
    }

    /**
     * Takes in an array list of cards(deck) and shuffles it.
     * @param deck
     */
    public void shuffleDeck(ArrayList<Card> deck){
        Collections.shuffle(deck);
    }

    /**
     * Returns(deals) next card in the deck.
     * @return
     */
    public Card dealCard(){
        nextCard++;
        return newDeck.get(nextCard);
    }
}
