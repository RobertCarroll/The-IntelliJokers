package io.intellijokers;

public class HorseNameGenerator {

    public static String nameGenerator() {
        String[] horseNames = {"Stinky Pete","Daddy's Bank Account","Galloping Sue","My Lucky Stars",
                "Fellowship Of Froilan","Dave Class Warfare","My Pants Are On Fire","Old Levis","cabbage",
                "I Love Unit Testing","Nurudeen Stop Looking Over My Shoulder","Rubber Band","Macy Gray Never Left",
                "#gettingPunchedInTheFace","Kanye West's Self-Esteem","I Left The Toaster On","Blawr! Blawr!",
                "Tyrannosaurus Rex With A Monocle","Mountain Man","Boom Goes The Dynamite","Blue Sky","This Horse Never Wins",
                "Runs Like A Dream","Last Horse Name I 'm Writing","I'm The Juggernaut","Sky Wizard", "Sleeper Cell"};
        int randomNum =  (int)(Math.random() * horseNames.length);
        return horseNames[randomNum];
    }
}
