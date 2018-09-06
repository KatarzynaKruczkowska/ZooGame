package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Stork extends Animal {

    public Stork(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);
    }

    @Override
    public String getSound() {
        return STORK_SOUND;
    }
}
