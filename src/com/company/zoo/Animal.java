package com.company.zoo;

public class Animal {
    private final int id;
    private final AnimalType animalType;
    private final String name;
    private final byte sex; //0 = famale, 1=male
    private int age; //age in years? days? rounds?
    private int weight;
    private byte pregnancy;

    public Animal(final int id, final AnimalType animalType, final String name,
                  final byte sex, int age, int weight, byte pregnancy) {
        this.id = id;
        this.animalType = animalType;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.pregnancy = pregnancy;

    }
}
