package com.company.zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.company.zoo.Texts.*;
import static java.lang.String.format;

public abstract class Animal implements Comparable<Animal> {

    private static final Random random = new Random();
    public final int factor = 10;

    private final AnimalType animalType;
    private final SexType sex;
    private int age; //age in years? days? rounds?
    private float weight;
    private int pregnantDays = 0;
    private int starvingDays = 0;
    private int trainingDays = 0;
    private int walkingDays = 0;
    private boolean isAlive = true;
    private String sound = EATING_SOUND_TXT;
    private List<Animal> childs = new ArrayList<>();

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
    }

    public void animalEndOfTheDay() {
        ageIncrease();
        if (getStarvingDays() > 0) {    //to daje dwa dni głodowania bez straty wagi
            weightLoss();
        }
        starvingDaysIncrease();
        if (sex == SexType.FEMALE && pregnantDays > 0) {
            pregnantDaysIncrease();
            if (pregnantDays > this.animalType.maxPregnantDays / factor) {
                final int numberOfChildren = getRandomNumber(1, this.animalType.maxCountOfChild);
                for (int i = 1; i < numberOfChildren; i++) {
                    childs.add(animalType.getNewAnimal());
                }
            }
        }
        if (getWeight() < animalType.minWeight || getAge() >= animalType.maxAge) {
            isAlive = false;
        }
    }

    public int getPregnantDays(){
        return pregnantDays;
    }

    public int getNumberOfChild() {
        return childs.size();
    }

    public List<Animal> childTransfer() {
        final List<Animal> transfer = new ArrayList<>();
        transfer.addAll(childs);
        childs.clear();
        return transfer;
    }


    private void starvingDaysIncrease() {
        starvingDays += 1;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String eat() {
        weight += animalType.maxWeight / factor;
        starvingDays = -1;
        return getEatingSound();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void pregnantDaysIncrease() {
        pregnantDays += animalType.maxPregnantDays / factor;
    }

    public void ageIncrease() {
        age += animalType.maxAge / factor;
    }   //operacja na int niewiele daje

    public void weightLoss() {
        weight -= animalType.maxWeight / factor;
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

    public int getStarvingDays() {
        return starvingDays;
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

    public int isPregnant() {
        return pregnantDays;
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
}
