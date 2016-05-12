package io.intellijokers;

/**
 * Created by alejandrolondono on 5/11/16.
 */
public class Player extends User{

    int cash;

    public double getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }



    public Player(String name, int money){
        super(name);
        this.setCash(money);
    }

}
