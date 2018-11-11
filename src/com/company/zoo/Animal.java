package com.company.zoo;

import java.util.Random;

import static com.company.zoo.Texts.*;
import static java.lang.String.format;

public abstract class Animal implements Comparable<Animal> {

    final Random random = new Random();

    private final AnimalType animalType;
    private final SexType sex;
    private int age; //age in years? days? rounds?
    private float weight;
    private boolean pregnant;
    private int starvingDays = 0;
    private int funDays = 0;
    private int walkingDays = 0;

    private static final String FORMATTED_LIST_OF_ANIMALS = "id=%d %-25s %s %-7s | %s %3d lat | %s %7.2f kg | %s %b";


    public Animal(final AnimalType animalType) {

        this.animalType = animalType;
        this.sex = getRandomSex();
        this.age = getRandomNumber(1, animalType.maxAge);
        this.weight = getRandomWeight(animalType.minWeight, animalType.maxWeight);
//        this.pregnant = sex == SexType.FEMALE ? random.nextBoolean() : false; //operator tenarny
        this.pregnant = sex == SexType.FEMALE && random.nextBoolean();          // to samo co wyzej

    }

    public void changePregnantStatus() {
        pregnant = false;
    }

    public void eat() {
        weight += 1;
        starvingDays = -1;
    }

    public void ageChange() {
        age += 1;
    }

    public void weightLoss() {
        weight -= 1;
    }

    public void fun() {  //training
        funDays += 1;
    }

    public void walk() {
        walkingDays += 1;
    }

    public int getStarvingDays() {
        return starvingDays;
    }

    private SexType getRandomSex() {
        return SexType.values()[random.nextInt(SexType.values().length)];
    }

    private int getRandomNumber(final int min, final int max) {
        return random.nextInt(max + 1 - min) + min; //tak musi być żeby zakres był zachowany
    }

    private float getRandomWeight(final float min, final float max) {
        return random.nextFloat() * (max - min) + min; //nigdy nie będzie max, min bedzie zachowane
    }

    public String getName() {
        return animalType.typeName;
    }

    public SexType getSexType() {
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
