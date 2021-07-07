package com.company.zoo;

import static com.company.zoo.Texts.DOG_SOUND;

public class Dog extends Animal {

    public Dog(final AnimalType animalType) {
        super(animalType);

    }

    @Override
    public String getSound() {
        return DOG_SOUND;
    }
}
