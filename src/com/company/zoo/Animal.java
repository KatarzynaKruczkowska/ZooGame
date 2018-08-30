package com.company.zoo;

public class Animal {
    private final int id;
    //private final AnimalType animalType;
    private final String name;
    private final int sex; //0 = famale, 1=male
    private int age; //age in years? days? rounds?
    private float weight;
    private boolean pregnancy;

    public Animal(final int id, final String name,
                  final int sex, int age, float weight, boolean pregnancy) {
        this.id = id;
        //this.animalType = animalType;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.pregnancy = pregnancy;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isPregnant() {
        return pregnancy;
    }
}
