package com.company.zoo;

import static com.company.zoo.Texts.TIGER_SOUND;

public class Tiger extends Animal {

    public Tiger(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);
    }

    @Override
    public String getSound() {
        return TIGER_SOUND;
    }
}
