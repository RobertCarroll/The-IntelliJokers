package io.intellijokers;

import java.util.ArrayList;

public class Game {

    //Change String in ArrayList to Player
    public ArrayList<String> currentPlayers = new ArrayList<String>();
    
    private int stage = 0;
    private int betStore = 0;

    public int getBetStore() {
        return betStore;
    }

    public void setBetStore(int betStore) {
        this.betStore = betStore;
    }


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

    public int payOut(int odds) {
        return odds*getBetStore();
    }

    public int payOut(){
       return payOut(2);
    }

    //Add abstract when you get the chance
    public void determineWinner() {
    }
}
