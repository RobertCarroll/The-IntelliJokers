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
}
