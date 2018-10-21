package com.company.zoo;

import static com.company.zoo.Texts.DOG_SOUND;

public class Dog extends Animal {

    public Dog(final AnimalType animalType, final SexType sex, final int age, final float weight) {
            super(animalType, sex, age, weight);

    }

    @Override
    public String getSound() {
        return DOG_SOUND;
    }
}
