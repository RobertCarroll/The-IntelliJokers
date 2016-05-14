package io.intellijokers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dimitrivaughn on 5/11/16.
 */
public class Roulette {

    // Initializing hashmap to create roulette table

    static HashMap<Integer, String> hashMap = new HashMap<>();


    static {

        hashMap.put(0, "GREEN");
        hashMap.put(1, "RED");
        hashMap.put(2, "BLACK");
        hashMap.put(3, "RED");
        hashMap.put(4, "BLACK");
        hashMap.put(5, "RED");
        hashMap.put(6, "BLACK");
        hashMap.put(7, "RED");
        hashMap.put(8, "BLACK");
        hashMap.put(9, "RED");
        hashMap.put(10, "BLACK");
        hashMap.put(11, "BLACK");
        hashMap.put(12, "RED");
        hashMap.put(13, "BLACK");
        hashMap.put(14, "RED");
        hashMap.put(15, "BLACK");
        hashMap.put(16, "RED");
        hashMap.put(17, "BLACK");
        hashMap.put(18, "RED");
        hashMap.put(19, "RED");
        hashMap.put(20, "BLACK");
        hashMap.put(21, "RED");
        hashMap.put(22, "BLACK");
        hashMap.put(23, "RED");
        hashMap.put(24, "BLACK");
        hashMap.put(25, "RED");
        hashMap.put(26, "BLACK");
        hashMap.put(27, "RED");
        hashMap.put(28, "BLACK");
        hashMap.put(29, "BLACK");
        hashMap.put(30, "RED");
        hashMap.put(31, "BLACK");
        hashMap.put(32, "RED");
        hashMap.put(33, "BLACK");
        hashMap.put(34, "RED");
        hashMap.put(35, "BLACK");
        hashMap.put(36, "RED");

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

// Returns the winning color

    public String getWinningColor() {
        return winningColor;
    }

// Sets the winning color

    public void setWinningColor(String winningColor) {
        this.winningColor = winningColor;
    }

// Returns the bets array lists

    public ArrayList<Integer> getBets(){
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

// Stores an odd bet

    public void betOdd(){
        for(int i=1; i <= 36; i= i+2){
            betStraight(i);
        }
    }

// Stores a color bet

    public void betColor(Player player, String color){
            player.setBetColor(color);
    }






    public boolean determineWinner(Player player){

        boolean playerWins = false;
        int winNum = getWinningNumber();


        if(player.getBets().size()!=0){

            playerWins = player.getBets().contains(winNum);
        }
        else{
            String winColor = hashMap.get(winNum);
            String betColor = player.getBetColor();
            playerWins = winColor.equalsIgnoreCase(betColor);

        }

        return playerWins;



    }








    public void rouletteEngine(


    ){}




}
