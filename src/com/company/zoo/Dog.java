package com.company.zoo;

import static com.company.zoo.Texts.DOG_SOUND;

public class Dog extends Animal {

    public Dog(final AnimalType animalType) {
        super(animalType);
    }

    private Dog(final AnimalType animalType, final int age) {
        super(animalType, age);
    }

    @Override
    protected Animal bornChildren() {
        return new Dog(animalType, 0);
    }

    @Override
    public String getSound() {
        return DOG_SOUND;
    }

}
