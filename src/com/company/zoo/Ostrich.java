package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Ostrich extends Animal {

    public Ostrich(final AnimalType animalType) {
        super(animalType);
    }

    @Override
    public String getSound() {
        return OSTRICH_SOUND;
    }
}
