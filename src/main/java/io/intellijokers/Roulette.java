package io.intellijokers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dimitrivaughn on 5/11/16.
 */
public class Roulette {


    static {
        HashMap<Integer, String> rouletteMap = new HashMap<Integer, String>();

        rouletteMap.put(0, "GREEN");
        rouletteMap.put(1, "RED");
        rouletteMap.put(2, "BLACK");
        rouletteMap.put(3, "RED");
        rouletteMap.put(4, "BLACK");
        rouletteMap.put(5, "RED");
        rouletteMap.put(6, "BLACK");
        rouletteMap.put(7, "RED");
        rouletteMap.put(8, "BLACK");
        rouletteMap.put(9, "RED");
        rouletteMap.put(10, "BLACK");
        rouletteMap.put(11, "BLACK");
        rouletteMap.put(12, "RED");
        rouletteMap.put(13, "BLACK");
        rouletteMap.put(14, "RED");
        rouletteMap.put(15, "BLACK");
        rouletteMap.put(16, "RED");
        rouletteMap.put(17, "BLACK");
        rouletteMap.put(18, "RED");
        rouletteMap.put(19, "RED");
        rouletteMap.put(20, "BLACK");
        rouletteMap.put(21, "RED");
        rouletteMap.put(22, "BLACK");
        rouletteMap.put(23, "RED");
        rouletteMap.put(24, "BLACK");
        rouletteMap.put(25, "RED");
        rouletteMap.put(26, "BLACK");
        rouletteMap.put(27, "RED");
        rouletteMap.put(28, "BLACK");
        rouletteMap.put(29, "BLACK");
        rouletteMap.put(30, "RED");
        rouletteMap.put(31, "BLACK");
        rouletteMap.put(32, "RED");
        rouletteMap.put(33, "BLACK");
        rouletteMap.put(34, "RED");
        rouletteMap.put(35, "BLACK");
        rouletteMap.put(36, "RED");

    }


// Initializing fields

    private int winningNumber;
    private String winningColor;
    ArrayList<Integer> bets = new ArrayList<>();

// Sets a randomly generated winning number (0-36)


    public void setWinningNumber(){
        winningNumber = (int) (Math.random()*36);
    }

// Returns the winning number

    public int getWinningNumber(){
        return winningNumber;
    }

// Returns the bets array lists

    public ArrayList getBets(){
        return bets;
    }


// Stores a straight bet (single number)

    public void betStraight(int number){
        bets.add(number);
    }

// Stores an even bet

    public void betEven(){
        for(int i=2; i <= 36; i= i+2){
            betStraight(i);
        }
    }




    public void determineWinner(){}






    public void greetPlayer(){}

    public void printBettingOptions(){}

    public void giveHistory1(){}

    public void runHistoryLoop(){}

    public void printGameManual(){}

    public void rouletteEngine(){}


    public static void main(String[] args) {



    }

}
