package com.company.zoo;

import static com.company.zoo.Texts.OCTOPUS_EATING_SOUND;
import static com.company.zoo.Texts.OCTOPUS_SOUND;

public class Octopus extends Animal {

    private int tentaclesAmount = 8;

    public Octopus(final AnimalType animalType) {
        super(animalType);
    }

    @Override
    protected Animal bornChildren() {
        return new Octopus(animalType, 9, 0);
    }

    public Octopus(final AnimalType animalType, final int tentaclesAmount) {
        super(animalType);
        this.tentaclesAmount = tentaclesAmount;
    }

    public Octopus(final AnimalType animalType, final int tentaclesAmount, final int age) {
        super(animalType);
        this.tentaclesAmount = tentaclesAmount;
        setAge(age);
    }

    @Override
    public String getSound() {
        return OCTOPUS_SOUND;
    }

    @Override
    public String getEatingSound() {
        return OCTOPUS_EATING_SOUND;
    }

    public int getTentaclesAmount() {
        return tentaclesAmount;
    }
}
