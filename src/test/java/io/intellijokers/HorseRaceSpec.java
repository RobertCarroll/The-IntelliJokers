package io.intellijokers;

import static org.hamcrest.CoreMatchers.instanceOf;
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

    @Test
    public void adjustOddsTest(){
        horserace.loadHorses();
        horserace.adjustOdds();
        int expectedValue = 2;
        int actualValue = horserace.getHorseAtIndex(0).getOdds();
        assertEquals("The expected value is 2.", expectedValue, actualValue);
    }

    @Test
    public void getHorseAtIndexTest(){
        horserace.loadHorses();
        assertThat(horserace.getHorseAtIndex(0), instanceOf(Horse.class));
    }
}
