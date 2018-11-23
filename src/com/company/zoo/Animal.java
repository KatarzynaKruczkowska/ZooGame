package com.company.zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.company.zoo.Texts.*;
import static java.lang.String.format;

public abstract class Animal implements Comparable<Animal> {

    private static final Random random = new Random();
    private final int factor = 5;

    protected final AnimalType animalType;
    private final SexType sex;
    private int age; //age in years? days? rounds?
    private float weight;
    private int pregnantDays = 0;
    private int starvingDays = 0;
    private int trainingDays = 0;
    private int walkingDays = 0;
    private boolean isAlive = true;
    private String sound = EATING_SOUND_TXT;
    private List<Animal> children = new ArrayList<>();
    private float maxWeightFactor;
    private int maxPregnantDaysFactor;
    private int maxAgeFactor;

    private static final String FORMATTED_LIST_OF_ANIMALS = "id=%d %-25s %s %-7s | %s %3d lat | %s %7.2f kg | %s %b";


    public Animal(final AnimalType animalType) {
        this(animalType, getRandomNumber(1, animalType.maxAge));
    }

    protected Animal(final AnimalType animalType, final int age) {
        this.animalType = animalType;
        this.sex = getRandomSex();
        this.age = age;
        this.weight = getRandomWeight(animalType.minWeight, animalType.maxWeight);
        //        this.pregnantDays = sex == SexType.FEMALE ? random.nextBoolean() : false; //operator tenarny


        //this.pregnantDays = sex == SexType.FEMALE && random.nextBoolean();          // to samo co wyzej
        if (sex == SexType.FEMALE && random.nextBoolean() && age > 1) {
            this.pregnantDays = getRandomNumber(1, this.animalType.maxPregnantDays);
        }
        this.maxWeightFactor = animalType.maxWeight / factor;
        this.maxPregnantDaysFactor = animalType.maxPregnantDays / factor;
        this.maxAgeFactor = animalType.maxAge / factor;

    }

    public void animalEndOfTheDay() {
        age += maxAgeFactor;
        if (starvingDays > 0) {    //to daje dwa dni głodowania bez straty wagi
            weight -= maxWeightFactor;
        }
        starvingDaysIncrease();
        if (sex == SexType.FEMALE && pregnantDays > 0) {
            pregnantDays += maxPregnantDaysFactor;
            if (pregnantDays > maxPregnantDaysFactor) {
                final int numberOfChildren = getRandomNumber(1, animalType.maxCountOfChild);
                for (int i = 0; i < numberOfChildren; i++) {
                    children.add(bornChildren());
                }
            }
        }
        if (getWeight() < animalType.minWeight || getAge() >= animalType.maxAge) {
            isAlive = false;
        }
    }

    protected abstract Animal bornChildren();

    public int getPregnantDays() {
        return pregnantDays;
    }

    public List<Animal> childTransfer() {
        final List<Animal> transfer = new ArrayList<>();
        if (children.size() > 0) {
            transfer.addAll(children);
            children.clear();
        }
        return transfer;
    }


    private void starvingDaysIncrease() {
        starvingDays += 1;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String eat() {
        weight += maxWeightFactor;
        starvingDays = -1;
        return getEatingSound();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void trainingIncrease() {  //training
        trainingDays += 1;
    }

    public void trainingLoss() {
        trainingDays -= 1;
    }

    public void walk() {
        walkingDays += 1;
    }

    private SexType getRandomSex() {
        return SexType.values()[random.nextInt(SexType.values().length)];
    }

    private static int getRandomNumber(final int min, final int max) {
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
        return pregnantDays > 0;
    }

    public abstract String getSound();

    protected String getEatingSound() {
        return EATING_SOUND_TXT;
    }

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


    public int getTrainingDays() {
        return trainingDays;
    }

    public void setPregnantDays() {
        pregnantDays = 1;
    }

    public int getMaxAgeFactor() {
        return maxAgeFactor;
    }
}
