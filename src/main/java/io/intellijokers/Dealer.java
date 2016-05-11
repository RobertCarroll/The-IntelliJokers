package io.intellijokers;

/**
 * Created by alejandrolondono on 5/11/16.
 */
public class Dealer extends User {

    private Deck deck;
    String name = "Dealer";


    public void drawFromDeck(User user){

    }

    public Dealer(){
        super("dealer");
        Deck deck = new Deck();
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
