package io.intellijokers;

/**
 * Created by michaelcane on 5/11/16.
 */

public class Poker extends Game{

    /**
     * The sum of money that players wager during a single hand or game,
     * according to the betting rules of the variant being played.
     */
    private int pot = 0;

    /**
     * Returns the pot to show the player the current value of the pot.
     * @return
     */
    public int getPot() {
        return pot;
    }

    /**
     * Resets the pot back to zero.
     */
    public void resetPot() {
        this.pot = 0;
    }

    /**
     * Discard one's hand and forfeit interest in the current pot.
     * No further bets are required by the folding player, but the player cannot win.
     */
    public void fold() {

    }

    /**
     * Used for first bets and also raises, or we can overload the bet for a raise mechanic.
     * @param wager
     */
    public void takeBet(int wager) {
        this.pot += wager;

    }

    public void call() {

    }

    public void discard(int number, Card card) {

    }

    /**
     * Used primarily by Poker to move the contents of the Pot to the
     * winner's cash field.
     * @param player
     * @return
     */
    public void payout(Player player) {
        int currentPot= getPot();
        resetPot();
        player.setCash(currentPot);
    }

    public void determineWinner() {

    }
}
