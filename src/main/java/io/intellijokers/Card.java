package io.intellijokers;

public class Card {
    private String cardDisplay;
    private int pokerRank;
    private int blackjackValue;
    private Suits suit;

    public enum Suits{
        SPADES("\u2660"), HEARTS("\u2764"), DIAMONDS("\u2666"), CLUBS("\u2663");

        String suitIcon;
        Suits(String string){
            suitIcon = string;
        }
    }

    public Card(String display, int pokerRank, int blackjackValue, Suits suit){
        cardDisplay = display;
        this.pokerRank = pokerRank;
        this.blackjackValue = blackjackValue;
        this.suit = suit;
    }

}
