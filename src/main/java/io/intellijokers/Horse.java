package io.intellijokers;

public class Horse {
    private String name;
    private int maxSpeed;
    private int distanceCovered;

    public Horse(int number){
        name = HorseNameGenerator.generateName();
        maxSpeed = (int)( Math.random() * number + 1 );
    }

    public void setDistanceCovered(int distanceCovered){
        this.distanceCovered = distanceCovered;
    }

    public int getDistanceCovered(){
        return distanceCovered;
    }

    public String getName(){
        return name;
    }

    /**
     * Unit testing random number generator?
     */
    public void ride(){
        distanceCovered += (int) (Math.random()*maxSpeed+5);
    }
}
