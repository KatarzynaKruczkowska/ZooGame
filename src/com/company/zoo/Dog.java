package com.company.zoo;

import static com.company.zoo.Texts.DOG_SOUND;

public class Dog extends Animal {

    public Dog(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);

    }

    @Override
    public String getSound() {
        return DOG_SOUND;
    }
}
