package io.intellijokers;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class HorseRace {
    private Horse[] horses = new Horse[10];
    private Horse leadHorse;

    public void checkLead(){
        getPositions();
        leadHorse = horses[9];
    }

    public int getMaxSpeed(){
        return (int)(Math.random()*(20-10) + 10);
    }

    public void loadHorses(){
        for(int i = 0; i < 10; i++){
            horses[i] = new Horse(getMaxSpeed());
        }

        leadHorse = horses[0];
    }

    /**
     * order is last to first
     */
    public void getPositions(){
        Arrays.sort(horses, (o1, o2) -> o1.getDistanceCovered() - o2.getDistanceCovered());
    }

    public void displayCurrentLeaders(String trackPosition){
        getPositions();
        System.out.println(horses[9].getName() + " is leading going into the "+ trackPosition +", followed by " + horses[8].getName() + " and " + horses[7].getName() + "!");
    }

    public void displayWinningHorses(){
        getPositions();
        System.out.println("1st: " + horses[9].getName() + "\n2nd: " + horses[8].getName() + "\n3rd: " + horses[7].getName());
    }

    public void delayProgram(){
        try {
            Thread.sleep(6000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    public void completeRaceLeg(){
        while(horses[7].getDistanceCovered() < 525){
            for(Horse horse:horses){
                horse.ride();
                checkLead();
            }
        }

        displayWinningHorses();
    }

    public void completeRaceLeg(int distance, String leg){
        while(leadHorse.getDistanceCovered() < distance){
            for(Horse horse : horses){
                horse.ride();
                checkLead();
            }
        }

        displayCurrentLeaders(leg);
        delayProgram();
    }

    public void playSong(){
        String audioFile = "";
        InputStream in = null;
        AudioStream audioStream = null;
        try {
            in = new FileInputStream(audioFile);
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AudioPlayer.player.start(audioStream);
    }

    public void startRace(){
        loadHorses();
        //playSong();

        completeRaceLeg(100, "first turn");
        completeRaceLeg(150, "backstretch");
        completeRaceLeg(350, "second turn");
        completeRaceLeg(400, "homestretch");
        completeRaceLeg();
    }

}
