package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Elephant extends Animal {
    private final String sound;

    public Elephant(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);
        sound = ELEPHANT_SOUND;
    }

    public String getSound() {
        return sound;
    }
}
