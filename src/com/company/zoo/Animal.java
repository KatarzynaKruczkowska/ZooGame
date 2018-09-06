package com.company.zoo;

public abstract class Animal {
    private final int id;
    //private final AnimalType animalType;
    private final String name;
    private final SexType sex;
    private int age; //age in years? days? rounds?
    private float weight;
    private boolean pregnant;

    public Animal(final int id, final String name,
                  final SexType sex, int age, float weight, boolean pregnant) {
        this.id = id;
        //this.animalType = animalType;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.pregnant = pregnant;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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
}
