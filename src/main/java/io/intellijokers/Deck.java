package io.intellijokers;

import java.util.ArrayList;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class Deck {
    private ArrayList<Card> deck;

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }



    private ArrayList populateDeck(){
        return null;
    }

    public void draw(User user){
        Card drawnCard = deck.get(deck.size());
        deck.remove(deck.size());
        user.hand.add(drawnCard);
    }

    public void shuffle(){

    }

}
