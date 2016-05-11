package io.intellijokers;

/**
 * Created by michaelcane on 5/11/16.
 */
import static io.intellijokers.Player.*;
import java.util.ArrayList;

abstract class Game {

    public ArrayList<Player> currentPlayers = new ArrayList<Player>();
    
    private int stage = 0;

    private int amountBet;

    public int getAmountBet() {
        return amountBet;
    }

    public void setAmountBet(int amountBet) {
        this.amountBet = amountBet;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setCurrentPlayers(Player player) {
        currentPlayers.add(player);
    }

    public abstract void takeBet(int wager);

    /**
     * This method is used by Black Jack, Horse Racing, and Roulette.
     * It will have a slightly different int odds for each but the action
     * is the same for each.
     * @param odds
     * @param player
     */
    public void payout(int odds, Player player) {
        int earnings = getAmountBet() * odds;
        int currentCash = player.getCash();
        player.setCash(currentCash + earnings);
    }

    /**
     * Used primarily by Poker to move the contents of the Pot to the
     * winner's cash field.
     * @param player
     * @return
     */
    public void payout(Player player) {
        //int currentPot= pot;
        //resetPot();
        //player.setCash(currentPot);
    }

    public abstract void determineWinner();
}
