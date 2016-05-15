package io.intellijokers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class Deck {


    private ArrayList<Card> cards;
    private String[] cardFaces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private int[] blackJackValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
    private int[] pokerRanks = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    private void populateDeck(){
        for(int i = 0; i < cardFaces.length; i++){
            for(Card.Suits suitValue : Card.Suits.values()){
                int pokerRank = pokerRanks[i];
                int blackjackValue = blackJackValues[i];
                Card.Suits suit = suitValue;
                String display = "[" + cardFaces[i] + suitValue.suitIcon + "]";

                cards.add(new Card(display, pokerRank, blackjackValue, suit));
            }
        }
    }

    public Deck(){
        cards = new ArrayList<>();
        populateDeck();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}

