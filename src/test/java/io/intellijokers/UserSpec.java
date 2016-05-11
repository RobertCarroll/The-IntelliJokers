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

    @Before
    public void Sandbox(){
        user = new User();
    }
    @Test
    public void getHandTest(){

        ArrayList<card> expectedHand =;//hand will go here

        ArrayList<card> actualHand = ;  //hand will go here
        assertEquals("the two hands should be the same", expectedHand, actualHand);
    }

    @Test
    public void setHand(){
        ArrayList<card> expectedHand = ; //hand will go here
        user.setHand();
        ArrayList>card> actualHand = user.getHand();
    }
}
