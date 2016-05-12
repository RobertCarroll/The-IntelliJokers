package io.intellijokers;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class Card {

    private int rank;
    private Suits suit; //what does this dot notation mean?
    private Orientation orientation = Orientation.FACEDOWN;
    private boolean blackJackCards = false;
    public enum Orientation{FACEUP,FACEDOWN;}
    public enum Faces{
        JACK("11"),
        QUEEN("12"),
        KING("13"),
        ACE("14");
        String faceRank;

        Faces(String faceRank){this.faceRank = faceRank;}

        public int getFaceRank(){return Integer.parseInt(faceRank);}

    }
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

        public String getUnicode(){ return unicode;}
    }


    /*
    getters and setters
     */

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /*
    constructors
     */

    public Card(int thisRank, Suits suit){
        this.rank = thisRank;
        this.suit = suit;
    }

    /*
    assorted methods
     */

    public Orientation turnFaceUP(){
        setOrientation(Orientation.FACEUP);
        return getOrientation();
    }

    public String getFace(){  //return royalty cards
        String value="";
        if(!blackJackCards){
            switch(this.rank){
                case 11:
                case 12:
                case 13:
                case 14:
                    value = Faces.valueOf(Integer.toString(this.rank)).toString();
                    break;
                default:
                    value = this.rank.toString();
                    break;
            }

        }else {

            switch(this.rank) {
                case 11:
                case 12:
                case 13:
                case 14:
                    value = Faces.valueOf(Integer.toString(this.rank)).toString();
                    break;
            }

        }
        return value;
        }
//        if(rank == 1 || rank == 11){
//            value = "A";
//        }else{
//            value = Integer.toString(this.getRank());
//        }
//        return value+" "+getSuit().getUnicode();
    }

    public int getBlackJackValue(){
        int blackJackRank;
        if(rank > 10 && rank< 14) {
            blackJackRank = 10;
        }else {
            blackJackRank = rank;
        }
        return blackJackRank;
    }

    public int switchAce(){
        if(getRank() == 1){
            setRank(11);
        }else{
            setRank(1);
        }
        return rank;
    }

}
