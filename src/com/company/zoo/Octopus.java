package com.company.zoo;

import static com.company.zoo.Texts.OCTOPUS_SOUND;

public class Octopus extends Animal {

    private final int tentaclesAmount = 8;

    public Octopus(int id, String name, SexType sex, int age, float weight, boolean pregnant) {
        super(id, name, sex, age, weight, pregnant);
    }

    @Override
    public String getSound() {
        return OCTOPUS_SOUND;
    }

    public int getTentaclesAmount() {
        return tentaclesAmount;
    }
}
