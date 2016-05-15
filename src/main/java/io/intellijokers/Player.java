package io.intellijokers;

import java.util.ArrayList;

public class Player extends User{
    public int cash = 500;

    private ArrayList<Integer> bets= new ArrayList<>();
    private String betColor;
    public enum Choice{ COLOR, NUMBER}
    private Choice betType = Choice.NUMBER;

    /**
     * This will return the type (Number or Color) of te bet made by the player.
     * @return
     */
    public Choice getBetType() {
        return betType;
    }

    /**
     * Sets the type (Number or Color) of the bet made by the player.
     * @param betType
     */
    public void setBetType(Choice betType) {
        this.betType = betType;
    }

    /**
     * This will return the ArrayList called bets.
     * @return
     */
    public ArrayList<Integer> getBets() {
        return bets;
    }

    /**
     * This places bets into the ArrayList called bets.
     * @param bets
     */
    public void setBets(ArrayList<Integer> bets) {
        this.bets = bets;
    }

    /**
     * This will output the color that the player bet on.
     * @return
     */
    public String getBetColor() {
        return betColor;
    }

    /**
     * This will set the color the player bet on.
     * @param betColor
     */
    public void setBetColor(String betColor) {
        this.betColor = betColor;
    }

    /**
     * This should return the value of cash.
     * @return
     */
    public int getCash() {
        return cash;
    }

    /**
     * This will set the value of cash.
     * @param cash
     */
    public void setCash(int cash) {
        this.cash = cash;
    }

    /**
     * This will allow a player to place a bet.
     * @param amount
     * @return
     */
    public int placeBet(int amount){
        this.setCash(this.getCash()-amount);
        return amount;
    }

    /**
     * This is an overloaded version of the above method.
     * @param amount
     * @param bets
     * @return
     */
    public int placeBet(int amount, ArrayList<Integer> bets){
        this.bets = bets;
        return placeBet(amount);
    }

    public Player(String name) {
        super(name);
    }

}
