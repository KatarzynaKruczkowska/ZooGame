package com.company.zoo;

import static com.company.zoo.Texts.OCTOPUS_SOUND;

public class Octopus extends Animal {

    private int tentaclesAmount = 8;

    public Octopus(final AnimalType animalType) {
        super(animalType);
    }

    public Octopus(final AnimalType animalType, final int tentaclesAmount) {
        super(animalType);
        this.tentaclesAmount = tentaclesAmount;
    }

    @Override
    public String getSound() {
        return OCTOPUS_SOUND;
    }

    public int getTentaclesAmount() {
        return tentaclesAmount;
    }
}
