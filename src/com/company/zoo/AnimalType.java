package com.company.zoo;

public enum AnimalType {
    słoń("Słoń afrykański", 4000),
    wąż("Wąż Boa", 15),
    pies("Pies", 10),
    ryba("Ryba Gupik", 0.10),
    ośmiornica("Ośmiornica olbrzymia", 15),
    bocian("Bocian Biały", 4),
    struś("Struś czerwonoskóry", 120),
    tygrys("Tygrys azjatycki", 90);

    public final String printableType;
    public final double maxWeight;

    AnimalType(final String printableType, final double maxWeight) {
        this.printableType = printableType;
        this.maxWeight = maxWeight;
    }
}
