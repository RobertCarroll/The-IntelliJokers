package io.intellijokers;

import java.util.Collections;

public class Dealer extends User {
    private int nextCard = -1;
    private Deck deck;

    public Deck getDeck() {
        return deck;
    }

    public Dealer(){
        super("Dealer");
        deck = new Deck();
    }

    /**
     * Takes in an array list of cards(deck) and shuffles it.
     */
    public void shuffleDeck(){
        Collections.shuffle(deck.getCards());
    }

    /**
     * Returns(deals) next card in the deck.
     * @return
     */
    public Card dealCard(){
        nextCard++;
        if(nextCard >= 46){
            nextCard = 0;
        }
        return deck.getCards().get(nextCard);

    }


}
