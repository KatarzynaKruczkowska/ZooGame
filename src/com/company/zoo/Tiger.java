package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Tiger extends Animal {
    private final String sound;

    public Tiger(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);
        sound = TIGER_SOUND;

    }
}
