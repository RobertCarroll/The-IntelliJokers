package io.intellijokers;

/**
 * Created by alejandrolondono on 5/11/16.
 */
abstract public class Users {

    private ArrayList<card> hand;

    public ArrayList<card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<card> hand) {
        this.hand = hand;
    }

    public User(){}
}
