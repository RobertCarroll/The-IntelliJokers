package io.intellijokers;

public class Blackjack extends Game{

    UserInputHandler userInputHandler = new UserInputHandler();
    private int currentBet;

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
    public void doubleDown(Player player){
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

    public void resetAceValue(){
        for(Card card : dealer.getDeck().getCards()) {
            if (card.getBlackjackValue() == 1) {
                card.setBlackjackValue(11);
            }
        }
    }

    /**
     * Inserts a 2 second delay.
     */
    private void delay(){
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
    public String displayScoreBoard(Player player){
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
        int again = userInputHandler.promptTheUserForAnInteger("Continue playing? " +
                "\n1 : Yes\n2 : No");
        switch (again) {
            case 1:
                wantToPlay = true;
                break;
            case 2:
                wantToPlay = false;
                userInputHandler.promptUser("Goodbye");
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
     */
    public int payOut(int odds, Player player) {
        player.setCash(player.getCash() + getCurrentBet()*odds + getCurrentBet());
        int win = getCurrentBet()*odds + getCurrentBet();
        userInputHandler.promptUser("\nYou won $" + win + "!\n");
        return win;
    }


    public void run(Player player){

        boolean wantToPlay = true;
        while(wantToPlay) {

            resetAceValue();
            dealer.shuffleDeck();
            boolean busted = false;
            boolean blackjack = false;
            player.getHand().clear();
            dealer.getHand().clear();


            setCurrentBet(player.placeBet(userInputHandler.promptTheUserForAnInteger("How much would you like to bet?     Total Cash: $" + player.getCash())));

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


            userInputHandler.promptUser("Dealing...\n");
            delay();
            userInputHandler.promptUser(displayScoreBoard(player));
            /**
             * Check to see if the player has blackjack.
             */

            if (evaluateHand(player) == 21 && evaluateHand(dealer) != 21) {
                payOut(2, player);
                blackjack = true;
            }

            /**
             * If no one has blackjack, continue with the game. Player can hit, stay, or double.
             */
            if(!blackjack) {
                int choice = userInputHandler.promptTheUserForAnInteger("Choose an option: \n" +
                        "1 : Hit\n" +
                        "2 : Stay\n" +
                        "3 : Double Down");

                switch (choice) {
                    case 1:
                        hit(player);
                        if (evaluateHand(player) > 21) {
                            reduceAceValue(player);
                        }
                        while (evaluateHand(player) < 21) {
                            int nextMove = userInputHandler.promptTheUserForAnInteger(displayScoreBoard(player)
                                    + "\nChoose an option: \n" +
                                    "1 : Hit\n" +
                                    "2 : Stay");
                            switch (nextMove) {
                                case 1:
                                    hit(player);
                                    if (evaluateHand(player) > 21) {
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
                        userInputHandler.promptUser("You doubled-down!");
                        doubleDown(player);
                        if (evaluateHand(player) > 21) {
                            reduceAceValue(player);
                        }
                        displayScoreBoard(player);
                        break;

                }

                if (bustCheck(player)) {
                    userInputHandler.promptUser(displayScoreBoard(player) + "\nYou busted.\n");
                    delay();
                    dealer.getHand().get(1).setCardDisplay(downCard);
                    dealer.getHand().get(1).setBlackjackValue(downNum);
                    userInputHandler.promptUser("Dealer had : \n\n" + displayScoreBoard(player) +
                            "\nYou busted and lost $" + getCurrentBet() + "\n");
                    busted = true;
                }

                while (!busted) {

                    /**
                     * Dealer flips down card.
                     */
                    userInputHandler.promptUser("Dealer has : \n");
                    dealer.getHand().get(1).setCardDisplay(downCard);
                    dealer.getHand().get(1).setBlackjackValue(downNum);
                    userInputHandler.promptUser(displayScoreBoard(player));
                    delay();
                    delay();

                    /**
                     * Dealer draws until hand is at least 17.
                     */
                    while (evaluateHand(dealer) < 17) {
                        userInputHandler.promptUser("Dealer hits!\n");
                        delay();
                        hit(dealer);
                        if (evaluateHand(dealer) > 21) {
                            reduceAceValue(dealer);
                        }
                        userInputHandler.promptUser(displayScoreBoard(player));
                        delay();

                    }

                    /**
                     * If dealer busts, player wins.  If dealer stays continue with game.
                     */
                    if (evaluateHand(dealer) > 21) {
                        userInputHandler.promptUser("Dealer busted!");
                        payOut(1, player);
                        delay();
                        busted = true;
                    } else {
                        userInputHandler.promptUser("Dealer stays with: " + evaluateHand(dealer));
                    }

                    /**
                     * If dealer doesn't bust, compare hands to determine the winner.
                     */
                    if (evaluateHand(dealer) <= 21) {
                        if (evaluateHand(player) > evaluateHand(dealer)) {
                            delay();
                            payOut(1, player);
                            delay();
                            busted = true;
                        }
                        if (evaluateHand(player) < evaluateHand(dealer)) {
                            delay();
                            userInputHandler.promptUser("\nYou lost $" + getCurrentBet() + ".\n");
                            delay();
                            busted = true;
                        }
                        if (evaluateHand(player) == evaluateHand(dealer)) {
                            delay();
                            userInputHandler.promptUser("\nPush.\n");
                            payOut(0, player);
                            delay();
                            busted = true;
                        }
                    }
                }
            }

                wantToPlay = wantToPlay();
            }
        }

}


