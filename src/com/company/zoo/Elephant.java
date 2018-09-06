package com.company.zoo;

import static com.company.zoo.Texts.ELEPHANT_SOUND;

public class Elephant extends Animal {

    public Elephant(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);
    }

    @Override
    public String getSound() {
        return ELEPHANT_SOUND;
    }
}
