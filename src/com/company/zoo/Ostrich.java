package com.company.zoo;

import static com.company.zoo.Texts.*;

public class Ostrich extends Animal {

    public Ostrich(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);
    }

    @Override
    public String getSound() {
        return OSTRICH_SOUND;
    }
}
