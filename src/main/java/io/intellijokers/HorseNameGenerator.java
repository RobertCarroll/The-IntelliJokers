package io.intellijokers;

import java.util.ArrayList;

public class HorseNameGenerator {

    public String nameGenerator() {
        String[] horseNames = {"stinkyPete","daddysBankAccount","gallopingSue","myLuckyStars",
                "theFellowshipOfFroila","daveClassWarfare","myPantsAreOnFire","oldLevis","cabbage",
                "iLoveUnitTesting","nurudeenStopLookingOverMyShoulder","rubberBand","macyGrayNeverLeft",
                "#gettingPunchedInTheFace","KanyeWest'sSelfEsteem","iLeftTheToasterOn","blawrBlawr!",
                "tyrannosaurusRexWithAMonocle","mountainMan","andBoomGoesTheDynamite","blueSky","thisHorseNeverWins",
                "runsLikeADream","theLastHorseNameI'mWriting","i'mTheJuggernaut"};
        int randomNum =  (int)(Math.random() * horseNames.length);
        return horseNames[randomNum];
    }
}
