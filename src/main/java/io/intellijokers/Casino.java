package io.intellijokers;

import java.util.regex.Pattern;

public class Casino {
    UserInputHandler inputHandler = new UserInputHandler();
    HorseRace horseRace = new HorseRace();
    Blackjack blackjack = new Blackjack();
    Roulette roulette = new Roulette();
    Player player;
    boolean running = true;

    Pattern blackjackPattern = Pattern.compile("(?i)b(l|1)(a|@)ckj(a|@)ck");
    Pattern horseRacePattern = Pattern.compile("(?i)h(0|o)r($|s)(3|e)\\sr(@|a)c(i|1)ng");
    Pattern roulettePattern = Pattern.compile("(?i)r(0|o)u(l|1)(e|3)(t|7)(t|7)(e|3)");
    Pattern exitPattern = Pattern.compile("(?i)(e|3)(x|%)(1|i|!)(7|t)");

    private void inputChecker(String input){
        if(blackjackPattern.matcher(input).matches()){
            blackjack.run(player);
        }else if(horseRacePattern.matcher(input).matches()){
            horseRace.startRace(player);
        }else if(roulettePattern.matcher(input).matches()){
            roulette.engine(player);
        }else if(exitPattern.matcher(input).matches()) {
            running = false;
        }else{
            System.out.println("We were unable to determine the game you wish to play.");
        }
    }

    public void enterCasino(){
        String name = inputHandler.promptTheUserForAString("Welcome to the the IntelliJoker Casino!\nWhat is your name?");
        player = new Player(name);
        while(running) {
            String choice = inputHandler.promptTheUserForAString("You have been given $500 to bet with.\nWe have Blackjack, Horse Racing and Roulette.\nWhat would you like to play?");
            inputChecker(choice);
        }
    }


}
