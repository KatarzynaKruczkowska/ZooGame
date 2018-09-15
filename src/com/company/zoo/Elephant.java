package com.company.zoo;

import static com.company.zoo.Texts.ELEPHANT_SOUND;

public class Elephant extends Animal {

    public Elephant(final AnimalType animalType, final SexType sex, final int age, final float weight, final boolean pregnant) {
        super(animalType, sex, age, weight, pregnant);
    }

    @Override
    public String getSound() {
        return ELEPHANT_SOUND;
    }
}
