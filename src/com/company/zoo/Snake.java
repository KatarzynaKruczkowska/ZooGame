package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Snake extends Animal {
    private final String sound;

    public Snake(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);
        sound = SNAKE_SOUND;

    }
}
