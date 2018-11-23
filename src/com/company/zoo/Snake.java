package com.company.zoo;

import static com.company.zoo.Texts.SNAKE_EATING_SOUND;
import static com.company.zoo.Texts.SNAKE_SOUND;

public class Snake extends Animal {

    public Snake(final AnimalType animalType) {
        super(animalType);
    }

    public Snake(final AnimalType animalType, final int age) {
        super(animalType);
        setAge(age);
    }

    @Override
    protected Animal bornChildren() {
        return new Snake(animalType, 0);
    }

    @Override
    public String getSound() {
        return SNAKE_SOUND;
    }

    @Override
    public String getEatingSound() {
        return SNAKE_EATING_SOUND;
    }
}
