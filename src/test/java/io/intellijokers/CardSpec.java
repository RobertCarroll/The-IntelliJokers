package io.intellijokers;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by stevejaminson on 5/11/16.
 */
public class CardSpec {

    String cardDisplay;

    Card card;
    @Before public void setupInitializer() {
        //card = new Card();
        cardDisplay = "Faceup";
    }

    @Test
    public void setCardDisplayTest() {
        card.setCardDisplay(cardDisplay);
        //String actualValue = card.setCardDisplay();
    }
}
