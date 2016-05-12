package io.intellijokers;

import java.util.ArrayList;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class Blackjack extends CardGame{


    Dealer dealer = new Dealer();
    Player player = new Player("Chester Tester", 500);
    UserInputHandler prompt = new UserInputHandler();


    private int wager;
    private boolean ace;
    private int aceValue;
    private boolean bust;


    /**
     * Takes in a user who wants to hit and adds a card to that user's hand.
     * @param whoHits
     */
    public void hit(User whoHits){
        whoHits.getHand().add(dealer.dealCard());
    }

    /**
     * Takes in a user who stands and return true.
     * @param whoStands
     * @return
     */
    public boolean stand(User whoStands){
        return true;
    }

    public boolean doubleDown(){
        wager = wager*2;
        return true;
        //If DD, then deal one card and end turn.
    }

    public boolean split(){

        return false;
    }

    /**
     * Checks to see if current hand is over 21.
     * @param whosHand
     * @return
     */
    public boolean bustCheck(User whosHand){
        int total = 0;
        for(Card card : whosHand.getHand()){
            total += card.blackjackValue;
        }
        if(total > 21)
            return true;
        else
            return false;
    }

    public boolean insurance(){

        return false;
    }

    /**
     * Checks for an Ace in the users hand.
     * @param whosHand
     * @return
     */
    public boolean isAceInHand(User whosHand){
        for(Card card : whosHand.getHand()){
            if(card.blackjackValue == 1){
                boolean ace = true;
            } else {
                boolean ace = false;
            }
        }
       return ace;
    }

    /**
     * Returns blackjack hand total.
     * @param whosHand
     * @return
     */
    public int evaluateHand(User whosHand){
        int total = 0;
        for(Card card : whosHand.getHand()){
            total += card.blackjackValue;
        }
        return total;
    }

    /**
     * Changes the ace value.
     * @param whosAce
     */
    public void makeAceEleven(User whosAce){
        for(Card card : whosAce.getHand()) {
            if (card.blackjackValue == 1) {
                card.blackjackValue = 11;
            }
        }
    }



    public void run(){
        /**
         * Deal initial cards to start the game.
         */
        player.getHand().add(dealer.dealCard()); //Face Up
        dealer.getHand().add(dealer.dealCard()); //Face UP
        player.getHand().add(dealer.dealCard()); //Face Up
        dealer.getHand().add(dealer.dealCard()); //Face Down

        int choice = prompt.promptTheUserForAnInteger("Your hand total is: "
                + evaluateHand(player) + "\nChoose an option: \n" +
                "1 : Hit\n" +
                "2 : Stay\n" +
                "3 : Double Down\n" +
                "4 : Split");

        switch (choice){
            case 1 :
                hit(player);
                while(evaluateHand(player) < 21){
                    
                }
                return;

            case 2:
                stand(player);
                return;

            case 3:
                doubleDown();
                return;

            case 4:
                split();
                return;
        }

    }

}


