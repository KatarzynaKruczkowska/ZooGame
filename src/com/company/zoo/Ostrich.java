package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Ostrich extends Animal {

    public Ostrich(final AnimalType animalType, final SexType sex, final int age, final float weight) {
        super(animalType, sex, age, weight);
    }

    @Override
    public String getSound() {
        return OSTRICH_SOUND;
    }
}
