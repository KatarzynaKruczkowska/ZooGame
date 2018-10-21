package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Stork extends Animal {

    public Stork(final AnimalType animalType, final SexType sex, final int age, final float weight) {
        super(animalType, sex, age, weight);
    }

    @Override
    public String getSound() {
        return STORK_SOUND;
    }
}
