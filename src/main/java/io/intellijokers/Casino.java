package io.intellijokers;

import java.util.Scanner;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class Casino {
    HorseRace horseRace = new HorseRace();
    Blackjack blackjack = new Blackjack();
    Roulette roulette = new Roulette();
    Player player;
    Scanner scanner = new Scanner(System.in);

    public enum Game{ HORSERACE, BLACKJACK, ROULETTE, DEFAULT }
    public void CLI(Player player, String input){
        Game comm = Game.DEFAULT;
        try{
            int i = Game.valueOf(input.toUpperCase()).ordinal();
            comm = Game.values()[i];
        }catch (Exception e){
            System.out.println("that game does not seem to be available \n maybe you did not spell it right");
        }
        switch(comm){
            case BLACKJACK:
                blackjack.run();
                break;
            case ROULETTE:
                roulette.engine(player);
                break;
            case HORSERACE:
                horseRace.startRace(player);
                break;
            default:
                System.out.println("that is not a game that is available");
                break;
        }
    }
    public void enterCasino(){
        boolean keepRunning = true;

        System.out.printf("Welcome to the the IntelliJoker Casino! \n Enter a name:");
        String name = scanner.next();
        player = new Player(name);

        while(keepRunning){
           System.out.println("which game would you like to play");
           String input = scanner.nextLine();
           CLI(player, input);
           System.out.println("would you like to play another game? y/n");
           if(scanner.nextLine().equalsIgnoreCase("n")) keepRunning = false;
        }
    }


}
