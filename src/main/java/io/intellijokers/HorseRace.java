package io.intellijokers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HorseRace extends Game{
    private Horse[] horses = new Horse[10];
    private ArrayList<Horse> winningHorses;
    private Horse leadHorse;

    public void checkLead(){
        adjustPositions();
        leadHorse = horses[9];
    }

    public Horse getHorseAtIndex(int index){
        return horses[index];
    }

    public int getMaxSpeed(){
        return (int)(Math.random()*(15-13) + 13);
    }

    public void loadHorses(){
        for(int i = 0; i < 10; i++){
            horses[i] = new Horse(getMaxSpeed());
        }

        leadHorse = horses[0];
    }

    /**
     * order is last to first
     * and highest odds to lowest odds for adjust odds
     */
    public void adjustPositions(){
        Arrays.sort(horses, (o1, o2) -> o1.getDistanceCovered() - o2.getDistanceCovered());
    }

    public void adjustOdds(){
        Arrays.sort(horses, (o1, o2) -> o1.getOdds() - o2.getOdds());

        int oddsDifference = horses[0].getOdds() - 2;
        for (int i = 0; i < horses.length; i++) {
            horses[i].setOdds(horses[i].getOdds() - oddsDifference);
        }
    }

    public void displayHorsesToBetOn(){
        for (Horse horse:horses) {
            System.out.println(horse.getName() + " odds: " + horse.getOdds());
        }
    }

    public String getHorseName(){
        return prompt.promptTheUserForAString("What horse do you think will win? Enter help for description of payouts.");
    }

    public boolean approveHorseName(String horseName){
        for(Horse horse : horses){
            if(horseName.equals(horse.getName())){
                return true;
            }
        }
        if(horseName.equals("help") | horseName.equals("Help")){
            System.out.println("With the odds of 2, you double your money.\nWith the odds of 3, your bet triples and so on...\n");
        }else{
            System.out.println("We could not match that horse name.\n");
        }
        return false;
    }

    public boolean checkForWinningBet(String horseName){
        return horseName.equals(horses[9].getName());
    }

    public int getBet(){
        int betAmount = prompt.promptTheUserForAnInteger("How much would you like to bet? Your current balance is $" + currentPlayer.getCash());
        currentPlayer.placeBet(betAmount);
        return betAmount;
    }

    public void displayCurrentLeaders(String trackPosition){
        adjustPositions();
        System.out.println(horses[9].getName() + " is leading going into the "+ trackPosition +", followed by " + horses[8].getName() + " and " + horses[7].getName() + "!");
    }

    public void displayWinningHorses(){
        adjustPositions();
        System.out.println("1st: " + winningHorses.get(0).getName() + "\n2nd: " + winningHorses.get(1).getName() + "\n3rd: " + winningHorses.get(2).getName() +"\n");
    }

    public void delayProgram(){
        try {
            Thread.sleep(500);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean checkArrayForInteger(Integer[] array, Integer horseIndex){
        List<Integer> list = Arrays.asList(array);
        return list.contains(horseIndex);
    }


    public void completeRaceLeg(){
        winningHorses = new ArrayList<>();
        Integer[] finishedHorseIndex = new Integer[3];
        int currentIndex = 0;
        while(winningHorses.size() < 3){
            for(int i = 0; i < horses.length; i++){
                horses[i].ride();
                if(horses[i].getDistanceCovered() > 500 && !checkArrayForInteger(finishedHorseIndex, i)){
                    winningHorses.add(horses[i]);
                    finishedHorseIndex[currentIndex] = i;
                    if(currentIndex == 2){
                        break;
                    }else{
                        currentIndex++;
                    }
                }
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

    public void startRace(Player player){
        currentPlayer = player;
        loadHorses();
        adjustOdds();

        displayHorsesToBetOn();
        String horseName = getHorseName();
        while( !approveHorseName(horseName) ) {
            horseName = getHorseName();
        }

        setAmountBet(getBet());

        completeRaceLeg(100, "first turn");
        completeRaceLeg(150, "backstretch");
        completeRaceLeg(350, "second turn");
        completeRaceLeg(400, "homestretch");
        completeRaceLeg();

        if(checkForWinningBet(horseName)){
            currentPlayer.setCash(player.getCash() + payOut(horses[9].getOdds()));
            System.out.println("Congratulations! You now have: " + player.getCash() + "\n");
        }else{
            System.out.println("Thank you for your money. You now have $" + currentPlayer.getCash() + "\n");
        }
    }
}
