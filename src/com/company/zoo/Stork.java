package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Stork extends Animal {
    private final String sound;

    public Stork(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);
        sound = STORK_SOUND;

    }
}
