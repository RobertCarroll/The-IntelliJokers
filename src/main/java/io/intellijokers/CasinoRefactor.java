package io.intellijokers;

/**
 * Created by michaelcane on 5/15/16.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.intellijokers.UserInputHandler.*;
public class CasinoRefactor {

    HorseRace horseRace = new HorseRace();
    Blackjack blackjack = new Blackjack();
    Roulette roulette = new Roulette();
    Player player;

    private String theBlackjackRegex = "(?i)b(l|1)(a|@)ckj(a|@)ck";
    private String theHorseRacingRegex = "(?i)h(0|o)r($|s)(3|e)\\sr(@|a)c(i|1)ng";
    private String theRouletteRegex = "(?i)r(0|o)u(l|1)(e|3)(t|7)(t|7)(e|3)";


    private void blackjackRegexChecker (String theRegex, String strToCheck) {

        Pattern checkRegex = Pattern.compile(theRegex);

        Matcher regexMatcher = checkRegex.matcher(strToCheck);

        while(regexMatcher.find()) {
            if(regexMatcher.group().length() != 0) {
                System.out.println("Alright, let's play some Blackjack!");
                blackjack.run();
            } else {
                System.out.println("I'm sorry, you didn't enter any text. Please select a game to play.");
            }
        }
    }

    private void horseRacingRegexChecker (String theRegex, String strToCheck) {

        Pattern checkRegex = Pattern.compile(theRegex);

        Matcher regexMatcher = checkRegex.matcher(strToCheck);

        while(regexMatcher.find()) {
            if(regexMatcher.group().length() != 0) {
                System.out.println("Alright, let's watch those horses run!!");
                horseRace.startRace(player);
            }
        }
    }

    private void rouletteRegexChecker (String theRegex, String strToCheck) {

        Pattern checkRegex = Pattern.compile(theRegex);

        Matcher regexMatcher = checkRegex.matcher(strToCheck);

        while(regexMatcher.find()) {
            if(regexMatcher.group().length() != 0) {
                System.out.println("Alright, let's play some Roulette!!");
                roulette.engine(player);
            }
        }
    }

    public void casinoEntrance() {
        boolean flag = true;
        while(flag) {
            String choice = promptTheUserForAString("Welcome to the the IntelliJoker Casino! \n We have Blackjack, Horse Racing, and Roulette \nWhat game would you like to play?");
            blackjackRegexChecker(theBlackjackRegex, choice);
            horseRacingRegexChecker(theHorseRacingRegex, choice);
            rouletteRegexChecker(theRouletteRegex, choice);

        }
    }
}
