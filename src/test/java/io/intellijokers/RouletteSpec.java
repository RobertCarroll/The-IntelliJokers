import io.intellijokers.Player;
import io.intellijokers.Roulette;

import org.junit.Test;

import java.util.ArrayList;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.assertEquals;

/**
 * Created by dimitrivaughn on 5/11/16.
 */
public class RouletteSpec {



Player player;
Roulette roly;
ArrayList array;


    @Before

    public void Sandbox() {
        Player player = new Player("Sephiroth", 1500){};
        Roulette roly = new Roulette();
        array = roly.getBets();

    }

    @Test

    public void betStraightTest(){
        roly.betStraight(24);
        boolean expectedValue = true;
        boolean actualValue = array.contains(24);
        assertEquals("Expected value = true",expectedValue, actualValue);





    }




}

//    @Test
//
//    public void spinWheelTest(){
//        Roulette roly = new Roulette();
//        roly.setWheelNumber();
//        boolean bool;
//        if (roly.getWheelNumber()>=0 && roly.getWheelNumber()<=36){
//            bool = true;
//        }
//        else {
//            bool = false;
//        }
//        boolean expectedValue = true;
//        boolean actualValue = bool;
//        assertEquals("Expected value = True",expectedValue, actualValue);
//
//    }