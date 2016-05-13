package io.intellijokers;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/11/16.
 */
public class Player extends User{

    double cash = 0;
    ArrayList<Integer> bets;

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
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
