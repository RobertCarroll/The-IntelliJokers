package io.intellijokers;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/11/16.
 */
public class UserSpec {

    User user;
    String name;
    ArrayList<Card> hand;
    @Before
    public void Sandbox(){
        name = "Randy Dandy";
        user = new User(name);
        hand = new ArrayList<Card>();
    }
    @Test
    public void setGetHandTest(){
        user.setHand(hand);
        ArrayList<Card> actualHand = user.getHand();  //hand will go here
        assertEquals("the two hands should be the same", hand, actualHand);
    }

    @Test
    public void getName(){
        String expectedName = name;
        user.name = name;
        String actualName = user.getName();
        assertEquals("the name should be able to be retieved",expectedName,actualName);
    }

    @Test
    public void setName(){
        String expectedString = name;
        user.setName(expectedString);
        String actualName = user.name;
    }


}
