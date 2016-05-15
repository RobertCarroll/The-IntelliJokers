package io.intellijokers;

abstract class Game {
    public Player currentPlayer;
    private int round = 0;
    private int amountBet = 0;

    UserInputHandler prompt = new UserInputHandler();

    /**
     * Resets the bet back to zero.
     */
    public void resetBet(){
        this.amountBet = 0;
    }

    /**
     * Returns the current amount bet, used by the payout methods
     * @return
     */
    public int getAmountBet() {
        return amountBet;
    }

    /**
     * Sets the amount the player bet.
     * @param amountBet
     */
    public void setAmountBet(int amountBet) {
        this.amountBet = amountBet;
    }

    public int payOut(int odds) {
        return odds*getAmountBet();
    }

    public int payOut(){
        return payOut(2);
    }


    public void payout(int odds, Player player) {
        int earnings = getAmountBet() * odds;
        resetBet();
        player.setCash( player.getCash() + earnings);
    }


    public void increaseBet(int amountBet) {
        this.amountBet += amountBet;
    }
    /**
     * Returns the current round, used primarily by Poker
     * @return
     */
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
    /**
     * Sets the current round, used to reset the count of the round.
     */
    public void resetRound() {
        this.round = 0;
    }
}
