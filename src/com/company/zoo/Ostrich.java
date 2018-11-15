package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Ostrich extends Animal {

    public Ostrich(final AnimalType animalType) {
        super(animalType);
    }

    public Ostrich(final AnimalType animalType, final int age) {
        super(animalType);
        setAge(age);
    }

    @Override
    public String getSound() {
        return OSTRICH_SOUND;
    }

    @Override
    public String getEatingSound() {
        return OSTRICH_EATING_SOUND;
    }

}
