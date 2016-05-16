package io.intellijokers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HorseRaceSpec {
    HorseRace horserace;
    @Before public void setUp(){
        horserace = new HorseRace();
    }



    @Test
    public void getMaxSpeedTest(){
        int actualValue = horserace.getMaxSpeed();
        assertTrue("The expected value is true", actualValue <= 20 && actualValue >= 1);
    }
}
