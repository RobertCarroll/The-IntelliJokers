package io.intellijokers;

import static org.hamcrest.CoreMatchers.instanceOf;
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

    @Test
    public void adjustOddsTest(){
        race.loadHorses();
        race.adjustOdds();
        int expectedValue = 2;
        int actualValue = race.getHorseAtIndex(0).getOdds();
        assertEquals("The expected value is 2.", expectedValue, actualValue);
    }

    @Test
    public void getHorseAtIndexTest(){
        race.loadHorses();
        assertThat(race.getHorseAtIndex(0), instanceOf(Horse.class));
    }
}
