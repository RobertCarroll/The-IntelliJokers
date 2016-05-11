package io.intellijokers;

import java.util.ArrayList;
import java.util.Arrays;

public class HorseNameGenerator {

    public static String generateName(){
        String pickedName = "";
        ArrayList<String> horseNames = new ArrayList<>();
        String[] names = {"Stinky Pete","Daddy's Bank Account","Galloping Sue","My Lucky Stars",
                "Fellowship Of Froilan","Dave Class Warfare","My Pants Are On Fire","Old Levis","Cabbage",
                "I Love Unit Testing","Nurudeen Stop Looking Over My Shoulder","Rubber Band","Macy Gray Never Left",
                "#gettingPunchedInTheFace","Kanye West's Self-Esteem","I Left The Toaster On","Blawr! Blawr!",
                "Tyrannosaurus Rex With A Monocle","Mountain Man","Boom Goes The Dynamite","Blue Sky","This Horse Never Wins",
                "Runs Like A Dream","Last Horse Name I'm Writing","I'm The Juggernaut","Sky Wizard", "Sleeper Cell"};
        horseNames.addAll(Arrays.asList(names));

        for(int i = 0; i < 10; i++){
            int randomNumber =  (int)(Math.random() * horseNames.size());
            pickedName = horseNames.get(randomNumber);
            horseNames.remove(randomNumber);
        }

        return pickedName;
    }
}
