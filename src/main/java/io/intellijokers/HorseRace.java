package io.intellijokers;

import java.util.Arrays;

public class HorseRace {
    private Horse[] horses = new Horse[10];
    private int raceLength = 120;
    private Horse leadHorse;

    public void checkLead(){
        getPositions();
        leadHorse = horses[9];
    }

    public void loadHorses(){
        for(int i = 0; i < 10; i++){
            horses[i] = new Horse((int)(Math.random()*20+10));
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
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void firstTurn(){
        while(leadHorse.getDistanceCovered() < 100){
            for(Horse horse:horses){
                horse.ride();
                checkLead();
            }
        }

        displayCurrentLeaders("first turn");
        delayProgram();
    }

    public void enterBackstretch(){
        while(leadHorse.getDistanceCovered() < 125){
            for(Horse horse:horses){
                horse.ride();
                checkLead();
            }
        }

        displayCurrentLeaders("backstretch");
        delayProgram();
    }

    public void secondTurn(){
        while(leadHorse.getDistanceCovered() < 225){
            for(Horse horse:horses){
                horse.ride();
                checkLead();
            }
        }

        displayCurrentLeaders("second turn");
        delayProgram();
    }

    public void enterHomestretch(){
        while(leadHorse.getDistanceCovered() < 275){
            for(Horse horse:horses){
                horse.ride();
                checkLead();
            }
        }

        displayCurrentLeaders("homestretch");
        delayProgram();
    }

    public void finish(){
        while(horses[7].getDistanceCovered() < 350){
            for(Horse horse:horses){
                horse.ride();
                checkLead();
            }
        }

        displayWinningHorses();
    }

    public void startRace(){
        loadHorses();

        firstTurn();
        enterBackstretch();
        secondTurn();
        enterHomestretch();
        finish();
    }

    public static void main(String[] args) {
        HorseRace race = new HorseRace();
        race.startRace();
    }
}
