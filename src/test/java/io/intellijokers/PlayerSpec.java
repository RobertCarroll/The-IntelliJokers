package io.intellijokers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by alejandrolondono on 5/11/16.
 */
public class PlayerSpec {

    Player player;
    String name;
    int ammount;
    double err;
    @Before
    public void Sandbox(){
        ammount = 500;
        err = .01;
        player = new Player(name, ammount);
    }

    @Test
    public void setGetCashTest(){
        //player.setCash(ammount);
        double actualCash = player.getCash();
        assertEquals("the ammount passed should have been set and returned by a getter and setter", ammount,actualCash, err);
    }
}
