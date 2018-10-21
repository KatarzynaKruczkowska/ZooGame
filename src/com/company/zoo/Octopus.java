package com.company.zoo;

import static com.company.zoo.Texts.OCTOPUS_SOUND;

public class Octopus extends Animal {

    private int tentaclesAmount = 8;

    public Octopus(final AnimalType animalType, final SexType sex, final int age, final float weight) {
        super(animalType, sex, age, weight);
    }

    public Octopus(final AnimalType animalType, final SexType sex, final int age, final float weight, final int tentaclesAmount) {
        super(animalType, sex, age, weight);
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
