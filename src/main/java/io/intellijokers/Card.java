package io.intellijokers;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class Card {

    private int rank;
    private Suits suit; //what does this dot notation mean?
    private Orientation orientation = Orientation.FACEDOWN;
    public enum Orientation{FACEUP,FACEDOWN;}
    public enum Suits{
        SPADES("\u2660"),
        HEARTS("\u2764"),
        DIAMONDS("\u2666"),
        CLUBS("\u2663");
        String unicode;
        //        constructor which is private access
        Suits(String unicode){
            this.unicode = unicode;
        }

        public String getUnicode(){ return unicode}
    }

    public Card(int thisRank, Suits suit){
        this.rank = thisRank;
        this.suit = suit;
    }

    public String getFace(){  //return royalty cards
        return "";
    }

    public Orientation turnFaceUP(){
        return null;
    }


    public

}
