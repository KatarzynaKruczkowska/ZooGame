package com.company.zoo;

import static com.company.zoo.Texts.SNAKE_SOUND;

public class Snake extends Animal {

    public Snake(final AnimalType animalType, final SexType sex, final int age, final float weight, final boolean pregnant) {
        super(animalType, sex, age, weight, pregnant);
    }

    @Override
    public String getSound() {
        return SNAKE_SOUND;
    }
}
