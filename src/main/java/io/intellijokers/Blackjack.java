//package io.intellijokers;

import java.util.ArrayList;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class Blackjack extends CardGame{

    private boolean ace;
    private int aceValue;
    private boolean bust;


    public boolean hit(ArrayList<Card> whoHits){

        whoHits.add(nextCard);
        return true;
    }

    public boolean stand(){

        return true;
    }

    public boolean doubleDown(){

        return false;
    }

    public boolean split(){

        return false;
    }

    public boolean bustCheck(){

        return false;
    }

    public boolean insurance(){

        return false;
    }

    public boolean aceCheck(){

        return false;
    }
}


