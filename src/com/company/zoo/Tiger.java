package com.company.zoo;

import static com.company.zoo.Texts.TIGER_SOUND;

public class Tiger extends Animal {

    public Tiger(final AnimalType animalType) {
        super(animalType);
    }

    public Tiger(final AnimalType animalType, final int age) {
        super(animalType);
        setAge(age);
    }

    @Override
    public String getSound() {
        return TIGER_SOUND;
    }
}
