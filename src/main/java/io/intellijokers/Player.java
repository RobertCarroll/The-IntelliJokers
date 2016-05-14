package io.intellijokers;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/11/16.
 */
public class Player extends User{

    int cash = 0;

    private ArrayList<Integer> bets= new ArrayList<>();
    private String betColor;
    public enum Choice{ COLOR, NUMBER}
    private Choice betType = Choice.NUMBER;

    public Choice getBetType() {
        return betType;
    }

    public void setBetType(Choice betType) {
        this.betType = betType;
    }


    public ArrayList<Integer> getBets() {
        return bets;
    }

    public void setBets(ArrayList<Integer> bets) {
        this.bets = bets;
    }

    public String getBetColor() {
        return betColor;
    }

    public void setBetColor(String betColor) {
        this.betColor = betColor;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int placeBet(int amount){
        this.setCash(this.getCash()-amount);
        return amount;
    }

    public int placeBet(int amount, ArrayList<Integer> bets){
        this.bets = bets;
        return placeBet(amount);
    }

    public Player(String name, int money){
        super(name);
        this.setCash(money);
    }

}
