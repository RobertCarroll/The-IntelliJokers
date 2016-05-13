package io.intellijokers;

/**
 * Created by alejandrolondono on 5/11/16.
 */
public class Player extends User{

    int cash = 0;

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void placeBet(int amount){
//        take from cash and return
        this.setCash(this.getCash()-amount);
    }



    public Player(String name, int money){
        super(name);
        this.setCash(money);
    }

}
