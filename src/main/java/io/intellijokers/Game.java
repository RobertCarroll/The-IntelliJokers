package io.intellijokers;

import java.util.ArrayList;

public class Game {

    //Change String in ArrayList to Player
    ArrayList<String> currentPlayers = new ArrayList<String>();

    private int cpu = 0;

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    private int stages = 0;

    public int getStages() {
        return stages;
    }

    public void setStages(int stages) {
        this.stages = stages;
    }

    public void setCurrentPlayers(String name) {
        currentPlayers.add(name);
    }

    public int bet(int wager) {
        return wager;
    }

    public int payout(int pot) {
        return pot;
    }

    //Add abstract when you get the chance
    public void determineWinner() {
    }
}
