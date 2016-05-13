package io.intellijokers;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class Blackjack extends CardGame{


    Player player = new Player("Chester Tester", 500);
    UserInputHandler prompt = new UserInputHandler();


    private int currentBet;
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
     * Doubles the bet and deals one card.
     * @return
     */
    public void doubleDown(){
        player.setCash(player.getCash()-currentBet);
        currentBet = currentBet *2;
        hit(player);
    }

    /**
     * Checks to see if current hand is over 21.
     * @param whosHand
     * @return
     */
    public boolean bustCheck(User whosHand){
        int total = 0;
        for(Card card : whosHand.getHand()){
            total += card.getBlackjackValue();
        }
        if(total > 21)
            return true;
        else
            return false;
    }

    /**
     * Returns blackjack hand total.
     * @param whosHand
     * @return
     */
    public int evaluateHand(User whosHand){
        int total = 0;
        for(Card card : whosHand.getHand()){
            total += card.getBlackjackValue();
        }
        return total;
    }

    /**
     * Changes the ace value.
     * @param whosAce
     */
    public void reduceAceValue(User whosAce){
        for(Card card : whosAce.getHand()) {
            if (card.getBlackjackValue() == 11) {
                card.setBlackjackValue(1);
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
            hand += c.getCardDisplay();
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
        String bet = "Current Bet : $" + getCurrentBet() + "   Total Cash : $" + player.getCash() +"\n";
        scoreboard += bet + "\n" + "Dealer : " + displayHand(dealer) + "\n" +
                player.getName() + " : " + displayHand(player);
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

    /**
     * Keeps card face down.
     * @return
     */
    public String faceDown(){
        return "[?]";
    }

    /**
     * Returns the current bet.
     * @return
     */
    public int getCurrentBet() {
        return currentBet;
    }

    /**
     * Sets the current bet.
     * @param currentBet
     */
    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    /**
     * Pays the player based on the bet won.
     * @param odds
     * @param person
     * @return
     */
    public double payout(double odds, User person) {
        player.setCash(player.getCash() + getCurrentBet()*odds + getCurrentBet());
        double win = getCurrentBet()*odds + getCurrentBet();
        prompt.promptUser("\nYou won $" + win + "!\n");
        return win;
    }


    public void run(){

        boolean wantToPlay = true;
        while(wantToPlay) {

            dealer.shuffleDeck();
            boolean busted = false;
            boolean dealerTurn = false;
            player.getHand().clear();
            dealer.getHand().clear();

            setCurrentBet(player.placeBet(prompt.promptTheUserForAnInteger("How much would you " +
                    "like to bet?     Total Cash: $" + player.getCash())));

            /**
             * Deal initial cards to start the game.
             */
            player.getHand().add(dealer.dealCard()); //Face Up
            dealer.getHand().add(dealer.dealCard()); //Face UP
            player.getHand().add(dealer.dealCard()); //Face Up
            dealer.getHand().add(dealer.dealCard()); //Face Down

            String downCard = dealer.getHand().get(1).getCardDisplay();
            int downNum = dealer.getHand().get(1).getBlackjackValue();
            dealer.getHand().get(1).setCardDisplay(faceDown());
            dealer.getHand().get(1).setBlackjackValue(0);


            prompt.promptUser("Dealing...\n");
            delay();
            prompt.promptUser(displayScoreBoard());
            /**
             * Check to see if the player has blackjack.
             */

            if (evaluateHand(player) == 21 && evaluateHand(dealer) != 21) {
                payout(1.5, player);
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
                    if(evaluateHand(player) > 21) {
                        reduceAceValue(player);
                    }
                    while (evaluateHand(player) < 21) {
                        int nextMove = prompt.promptTheUserForAnInteger(displayScoreBoard()
                                + "\nChoose an option: \n" +
                                "1 : Hit\n" +
                                "2 : Stay");
                        switch (nextMove) {
                            case 1:
                                hit(player);
                                if(evaluateHand(player) > 21){
                                    reduceAceValue(player);
                                }
                                break;
                            case 2:
                                stand(player);
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
                    prompt.promptUser("You doubled-down!");
                    doubleDown();
                    if(evaluateHand(player) > 21){
                        reduceAceValue(player);
                    }
                    displayScoreBoard();
                    break;

            }

            if (bustCheck(player)) {
                prompt.promptUser(displayScoreBoard() + "\nYou busted.\n");
                delay();
                dealer.getHand().get(1).setCardDisplay(downCard);
                dealer.getHand().get(1).setBlackjackValue(downNum);
                prompt.promptUser("Dealer had : \n\n" + displayScoreBoard() +
                        "\nYou busted and lost $" + getCurrentBet() + "\n");
                busted = true;
            }

                while (!busted) {

                    /**
                     * Dealer flips down card.
                     */
                    prompt.promptUser("Dealer has : \n");
                    dealer.getHand().get(1).setCardDisplay(downCard);
                    dealer.getHand().get(1).setBlackjackValue(downNum);
                    prompt.promptUser(displayScoreBoard());
                    delay();
                    delay();

                    /**
                     * Dealer draws until hand is at least 17.
                     */
                    while (evaluateHand(dealer) < 17) {
                        prompt.promptUser("Dealer hits!\n");
                        delay();
                        hit(dealer);
                        if(evaluateHand(dealer) > 21){
                            reduceAceValue(dealer);
                        }
                        prompt.promptUser(displayScoreBoard());
                        delay();

                    }

                    /**
                     * If dealer busts, player wins.  If dealer stays continue with game.
                     */
                    if (evaluateHand(dealer) > 21) {
                        prompt.promptUser("Dealer busted!");
                        payout(1,player);
                        delay();
                        busted = true;
                    } else {
                        prompt.promptUser("Dealer stays with: " + evaluateHand(dealer));
                    }

                    /**
                     * If dealer doesn't bust, compare hands to determine the winner.
                     */
                    if (evaluateHand(dealer) <= 21) {
                        if (evaluateHand(player) > evaluateHand(dealer)) {
                            delay();
                            payout(1, player);
                            delay();
                            busted = true;
                        }
                        if (evaluateHand(player) < evaluateHand(dealer)) {
                            delay();
                            prompt.promptUser("\nYou lost $" + getCurrentBet() + ".\n");
                            delay();
                            busted = true;
                        }
                        if (evaluateHand(player) == evaluateHand(dealer)) {
                            delay();
                            prompt.promptUser("\nPush.\n");
                            payout(0, player);
                            delay();
                            busted = true;
                        }
                    }
                }

                wantToPlay = wantToPlay();
            }
        }

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        blackjack.run();
    }
    
}


