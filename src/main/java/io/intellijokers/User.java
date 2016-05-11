package io.intellijokers;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/11/16.
 */
public class User {

    public ArrayList<Card> hand = new ArrayList<Card>();
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public User(String name){
        this.setName(name);
    }
}
