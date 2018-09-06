package com.company.zoo;

import static com.company.zoo.Texts.SNAKE_SOUND;

public class Snake extends Animal {

    public Snake(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);
    }

    @Override
    public String getSound() {
        return SNAKE_SOUND;
    }
}
