package io.intellijokers;

/**
 * Created by alejandrolondono on 5/11/16.
 */
public class Player extends User{

    double cash;

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }



    public Player(String name, double money){
        super(name);
        this.setCash(money);
    }

}
