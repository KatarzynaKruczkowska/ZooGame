package com.company.zoo;

public enum AnimalType {
    słoń(1, "Słoń afrykański", 4000, 70, "trututu"),
    wąż(2, "Wąż Boa", 15, 40, "ssssssss"),
    pies(3, "Pies", 10, 13, "hau hau"),
    ryba(4, "Ryba Gupik", 0.10f, 3, "nie pogadasz z rybą"),
    ośmiornica(5, "Ośmiornica olbrzymia", 15, 5, "plusk co najwyżej"),
    bocian(6, "Bocian Biały", 4, 12, "kle kle"),
    struś(7, "Struś czerwonoskóry", 120, 75, "normalnie nie wydaje dźwięków"),
    tygrys(8, "Tygrys azjatycki", 90, 20, "groźny pomruk");

    public final int index;
    public final String typeName;
    public final float maxWeight;
    public final int maxAge;
    public final String sound;


    AnimalType(final int index, final String typeName, final float maxWeight, final int maxAge, final String sound) {
        this.index = index;
        this.typeName = typeName;
        this.maxWeight = maxWeight;
        this.maxAge = maxAge;
        this.sound = sound;
    }
}
