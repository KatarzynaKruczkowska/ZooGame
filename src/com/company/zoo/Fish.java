package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Fish extends Animal {

    public Fish(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);

    }

    @Override
    public String getSound() {
        return FISH_SOUND;
    }
}
