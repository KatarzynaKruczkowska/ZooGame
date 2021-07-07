package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Stork extends Animal {

    public Stork(final AnimalType animalType) {
        super(animalType);
    }

    @Override
    public String getSound() {
        return STORK_SOUND;
    }
}
