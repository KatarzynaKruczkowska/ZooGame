package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Fish extends Animal {

    public Fish(final AnimalType animalType) {
        super(animalType);

    }

    @Override
    public String getSound() {
        return FISH_SOUND;
    }
}
