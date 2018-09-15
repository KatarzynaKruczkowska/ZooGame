package com.company.zoo;

import static com.company.zoo.Texts.TIGER_SOUND;

public class Tiger extends Animal {

    public Tiger(final AnimalType animalType, final SexType sex, final int age, final float weight, final boolean pregnant) {
        super(animalType, sex, age, weight, pregnant);
    }

    @Override
    public String getSound() {
        return TIGER_SOUND;
    }
}
