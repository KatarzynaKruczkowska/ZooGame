package com.company.zoo;

import static com.company.zoo.Texts.ELEPHANT_SOUND;

public class Elephant extends Animal {

    public Elephant(final AnimalType animalType) {
        super(animalType);
    }

    @Override
    public String getSound() {
        return ELEPHANT_SOUND;
    }
}
