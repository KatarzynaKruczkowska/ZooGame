package com.company.zoo;

import static com.company.zoo.Texts.*;
import static java.lang.String.format;

public abstract class Animal implements Comparable<Animal> {
    private final AnimalType animalType;
    private final SexType sex;
    private int age; //age in years? days? rounds?
    private float weight;
    private boolean pregnant;

    private static final String FORMATTED_LIST_OF_ANIMALS = "id=%d %-25s %s %-7s | %s %3d lat | %s %7.2f kg | %s %b";


    public Animal(final AnimalType animalType, SexType sex, int age, float weight, boolean pregnant) {
        this.animalType = animalType;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.pregnant = pregnant;
    }

    public String getName() {
        return animalType.typeName;
    }

    public SexType getSexType() {
        //return SexType.valueOf(sex).printableSex;
        return sex;
    }

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public abstract String getSound();

    @Override
    public String toString() {

        return format(FORMATTED_LIST_OF_ANIMALS,
                animalType.ordinal(),
                getName(),
                SEX, getSexType().printableSex,
                AGE, getAge(),
                WEIGHT, getWeight(),
                PREGNANT, isPregnant());
    }

    @Override
    public int compareTo(Animal animal) {
        return this.animalType.compareTo(animal.animalType);
    }

}
