package io.intellijokers;

import java.util.ArrayList;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class Deck {


    private ArrayList<Card> deck;
//    public String[] cardFace = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
//    public int[] cardBjValue = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1};
//    public int[] cardRank = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};


//    public ArrayList<Card> populateDeck() {
//        ArrayList<Card> deck = new ArrayList<>();
//        for (Suits suit : Suits.values()) {
//
//            String uniCode;
//            for (int i = 2; i <= 14; i++) {
//                String theSuit = suit.toString().toLowerCase();
//                switch (theSuit) {
//                    case "spades":
//                    case "hearts":
//                    case "diamonds":
//                    case "clubs":
//                        suit = Suits.valueOf(theSuit);
//                        uniCode = suit.getUnicode();
//                        break;
//                }
//
//
//            }
//            deck.add(new Card());
//
//        }
//        return deck;
//    }
//        for (int i = 0; i < Deck.Suits.values().length; i++) {
//            for(int j = 0; j < cardFace.length; j++){
//                switch(i){
//                    case 0:
//                        suit = Deck.Suits.CLUBS;
//                        break;
//                    case 1:
//                        suit = Deck.Suits.DIAMONDS;
//                        break;
//                    case 2:
//                        suit = Deck.Suits.HEARTS;
//                        break;
//                    case 3:
//                        suit = Deck.Suits.SPADES;
//                        break;
//                }
//                String sign = "";
//                switch (suit){
//                    case CLUBS:
//                        sign = "\u2663";
//                        break;
//                    case DIAMONDS:
//                        sign = "\u2666";
//                        break;
//                    case HEARTS:
//                        sign = "\u2764";
//                        break;
//                    case SPADES:
//                        sign = "\u2660";
//                        break;
//
//                }
////                deck.add(cardTotal, new Card(cardRank[j], suit, cardBjValue[j], "[" + cardFace[j] + sign + "]"));
//                cardTotal++;
//            }
//        }
//        return deck;
//    }


}
