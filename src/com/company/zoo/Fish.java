package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Fish extends Animal {

    public Fish(final AnimalType animalType) {
        super(animalType);

    }
    public Fish(final AnimalType animalType, final int age) {
        super(animalType);
        setAge(age);
    }

    @Override
    protected Animal bornChildren() {
        return new Fish(animalType, 0);
    }

    @Override
    public String getSound() {
        return FISH_SOUND;
    }

    @Override
    public String getEatingSound() {
        return FISH_EATING_SOUND;
    }
}
