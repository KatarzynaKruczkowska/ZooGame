package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Fish extends Animal {

    public Fish(final AnimalType animalType, final SexType sex, final int age, final float weight) {
        super(animalType, sex, age, weight);

    }

    @Override
    public String getSound() {
        return FISH_SOUND;
    }
}
