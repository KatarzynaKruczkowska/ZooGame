package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Stork extends Animal {

    public Stork(final AnimalType animalType) {
        super(animalType);
    }

    public Stork(final AnimalType animalType, final int age) {
        super(animalType);
        setAge(age);
    }

    @Override
    protected Animal bornChildren() {
        return new Stork(animalType, 0);
    }

    @Override
    public String getSound() {
        return STORK_SOUND;
    }

    @Override
    public String getEatingSound() {
        return STORK_EATING_SOUND;
    }
}
