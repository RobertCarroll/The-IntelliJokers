package io.intellijokers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HorseSpec {
    Horse horse;
    @Before public void setUp(){
        horse = new Horse(5);
    }

    @Test
    public void setAndGetDistanceCoveredTest(){
        int expectedValue = 5;
        horse.setDistanceCovered(5);
        int actualValue = horse.getDistanceCovered();
        assertEquals("The expected value is 5", expectedValue, actualValue);
    }

    @Test
    public void getOddsTest() {
        int expectedValue = 8;
        horse.setOdds(8);
        int actualValue = horse.getOdds();
        assertEquals("Should output a value of 5", expectedValue, actualValue);
    }
}
