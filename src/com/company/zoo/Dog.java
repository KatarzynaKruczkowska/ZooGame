package com.company.zoo;

import static com.company.zoo.Texts.DOG_SOUND;

public class Dog extends Animal {

    public Dog(final AnimalType animalType) {
        super(animalType);
    }

    public Dog(final AnimalType animalType, final int age) {
        super(animalType);
        setAge(age);
    }

    @Override
    public String getSound() {
        return DOG_SOUND;
    }

}
