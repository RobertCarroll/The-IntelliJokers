package io.intellijokers;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

    /**
     * Doubles the bet and deals one card.*****************
     * @return
     */
    public boolean doubleDown(){
        wager = wager*2;
        hit(player);
        return true;
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
    public void reduceAceValue(User whosAce){
        for(Card card : whosAce.getHand()) {
            if (card.blackjackValue == 11) {
                card.blackjackValue = 1;
            }
        }
    }

    /**
     * Inserts a 2 second delay.
     */
    public void delay(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the user's hand.
     * @param whosHand
     * @return
     */
    public String displayHand(User whosHand){
        String hand = "";
        for(Card c : whosHand.getHand()){
            hand += c.display;
        }
        hand += "  " + evaluateHand(whosHand) + "\n";
        return hand;
    }

    /**
     * Displays the scoreboard with both hands and totals.
     * @return
     */
    public String displayScoreBoard(){
        String scoreboard = "";
        scoreboard += "Dealer : " + displayHand(dealer) + "\n" +
                "Player : " + displayHand(player);
        return scoreboard;
    }

    /**
     * Confirms user wants to continue playing.
     * @return
     */
    public boolean wantToPlay() {
        boolean wantToPlay = false;
        int again = prompt.promptTheUserForAnInteger("Continue playing? " +
                "\n1 : Yes\n2 : No");
        switch (again) {
            case 1:
                wantToPlay = true;
                break;
            case 2:
                wantToPlay = false;
                prompt.promptUser("Goodbye");
                break;
        }
        return wantToPlay;
    }





    public void run(){

        boolean wantToPlay = true;
        while(wantToPlay) {

            player.getHand().clear();
            dealer.getHand().clear();
            /**
             * Deal initial cards to start the game.
             */
            player.getHand().add(dealer.dealCard()); //Face Up
            dealer.getHand().add(dealer.dealCard()); //Face UP
            player.getHand().add(dealer.dealCard()); //Face Up
            dealer.getHand().add(dealer.dealCard()); //Face Down

            prompt.promptUser("Dealing...\n");
            delay();
            prompt.promptUser("Hands: \n\n" + displayScoreBoard());

            /**
             * Check to see if any of the player has blackjack.
             */
            if (evaluateHand(dealer) == 21 && evaluateHand(player) != 21) {
                prompt.promptUser("Dealer has blackjack. You lose.");
            }

            if (evaluateHand(player) == 21 && evaluateHand(dealer) != 21) {
                prompt.promptUser("Player has blackjack. You win.");
                payout(3, player);
            }

            /**
             * If no one has blackjack, continue with the game. Player can hit, stay, or double.
             */

            int choice = prompt.promptTheUserForAnInteger("Choose an option: \n" +
                    "1 : Hit\n" +
                    "2 : Stay\n" +
                    "3 : Double Down");

            switch (choice) {
                case 1:
                    hit(player);
                    while (evaluateHand(player) < 21) {
                        int nextMove = prompt.promptTheUserForAnInteger(displayScoreBoard()
                                + "\nChoose an option: \n" +
                                "1 : Hit\n" +
                                "2 : Stay");
                        switch (nextMove) {
                            case 1:
                                hit(player);
                                break;
                            case 2:
                                stand(player);
                                break;
                        }
                        if (bustCheck(player)) {
                            prompt.promptUser("You busted.");
                            break;
                        }
                        if (nextMove == 2) {
                            break;
                        }
                    }
                    break;

                case 2:
                    stand(player);
                    break;

                case 3:
                    doubleDown();
                    break;

            }

            /**
             * Dealer draws until hand is at least 17.
             */
            while (evaluateHand(dealer) < 17) {
                prompt.promptUser("Dealer hits!");
                delay();
                hit(dealer);
                prompt.promptUser(displayScoreBoard());
                delay();

            }

            /**
             * If dealer busts, player wins.  If dealer stays continue with game.
             */
            if(evaluateHand(dealer) > 21){
                prompt.promptUser("Dealer busted, you win!");
                payout(2,player);
                delay();
                wantToPlay = wantToPlay();
            } else {
                prompt.promptUser("Dealer stays with: " + evaluateHand(dealer));
            }

            /**
             * If dealer doesn't bust, compare hands to determine the winner.
             */
            if(evaluateHand(dealer) <= 21){
                if(evaluateHand(player) > evaluateHand(dealer)){
                    delay();
                    prompt.promptUser("You win.");
                    payout(2,player);
                    delay();
                    wantToPlay = wantToPlay();
                }
                if(evaluateHand(player) < evaluateHand(dealer)){
                    delay();
                    prompt.promptUser("You lose.");
                    delay();
                    wantToPlay = wantToPlay();
                }
                if(evaluateHand(player) == evaluateHand(dealer)){
                    delay();
                    prompt.promptUser("Push");
                    payout(1,player);
                    delay();
                    wantToPlay = wantToPlay();
                }
            }
        }

    }

}


