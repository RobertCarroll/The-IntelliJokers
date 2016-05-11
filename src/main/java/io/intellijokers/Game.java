package io.intellijokers;

import java.util.ArrayList;

public class Game {

    //Change String in ArrayList to Player
    public ArrayList<String> currentPlayers = new ArrayList<String>();
    
    private int stage = 0;

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setCurrentPlayers(String name) {
        currentPlayers.add(name);
    }

    public int bet(int wager) {
        return wager;
    }

    public double payout(int odds, User player) {
        return 0;
    }

    public double payout(User player) {
        return 0;
    }

    //Add abstract when you get the chance
    public void determineWinner() {
    }
}
