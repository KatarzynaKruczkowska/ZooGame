package com.company.zoo;

import static com.company.zoo.Texts.SNAKE_SOUND;

public class Snake extends Animal {

    public Snake(final AnimalType animalType) {
        super(animalType);
    }

    @Override
    public String getSound() {
        return SNAKE_SOUND;
    }
}
