package com.company.zoo;

import static com.company.zoo.Texts.ELEPHANT_EATING_SOUND;
import static com.company.zoo.Texts.ELEPHANT_SOUND;

public class Elephant extends Animal {

    public Elephant(final AnimalType animalType) {
        super(animalType);
    }

    public Elephant(final AnimalType animalType, final int age) {
        super(animalType);
        setAge(age);
    }

    @Override
    protected Animal bornChildren() {
        return new Elephant(animalType, 0);
    }

    @Override
    public String getSound() {
        return ELEPHANT_SOUND;
    }

    @Override
    public String getEatingSound() {
        return ELEPHANT_EATING_SOUND;
    }
}
