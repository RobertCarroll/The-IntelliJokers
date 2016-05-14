package io.intellijokers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HorseRaceSpec {
    HorseRace race;
    @Before public void setUp(){
        race = new HorseRace();
    }

    @Test
    public void getMaxSpeedTest(){
        int actualValue = race.getMaxSpeed();
        assertTrue("The expected value is true", actualValue <= 20 && actualValue >= 1);
    }
}
