package com.company.zoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.company.zoo.Texts.*;
import static java.lang.String.format;

public class GameManager {

    private final IOManager ioManager;
    private static final int MIN_NUMBER_OF_ANIMALS = 3;
    private static final int MAX_NUMBER_OF_ANIMALS = 10;

    private static final String FORMATTED_LIST_OF_ANIMALS = "%d. %s %s %s %s %d %s %.2f %s %b";
    private static final String FORMATTED_SHORT_LIST_OF_ANIMALS = "%d. %s";

    final Random random = new Random();
    private List<Animal> animals;

    public GameManager(final IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void play() {
        int startNumberOfAnimals = getRandomNumber(MIN_NUMBER_OF_ANIMALS, MAX_NUMBER_OF_ANIMALS);
        ioManager.showMessage(Texts.NUMBER_OF_ANIMALS + Integer.toString(startNumberOfAnimals));

        animals = initPopulation(startNumberOfAnimals);
        showListOfAnimals();
        playGame(animals);
        ioManager.showMessage(END_OF_THE_GAME);
    }

    private void showListOfAnimals() {
        ioManager.showMessage(NUMBER_OF_ANIMALS + Integer.toString(animals.size()));
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            ioManager.showMessage(format(FORMATTED_LIST_OF_ANIMALS, i + 1,
                    animal.getName(),
                    SEX, animal.getSexType().printableSex,
                    AGE, animal.getAge(),
                    WEIGHT, animal.getWeight(),
                    PREGNANT, animal.isPregnant()));
        }
    }

    private List<Animal> initPopulation(final int startNumberOfAnimals) {
        int index;
        final List<Animal> animals = new ArrayList<>(startNumberOfAnimals);

        for (int i = 0; i < startNumberOfAnimals; i++) {
            index = getRandomNumber(1, AnimalType.values().length) - 1; //1-8 => -1 daje 0-7
            final AnimalType animalType = AnimalType.values()[index];   //0-7
            //final SexType sex = new SexType.valueOf(getRandomNumber(0, 1));
            final SexType sex = getRandomSex();
            final int age = getRandomNumber(1, animalType.maxAge);
            final float weight = getRandomWeight(animalType.minWeight, animalType.maxWeight);
            switch (index) {
                case 0:
                    animals.add(new Elephant(index, animalType.typeName, sex, age, weight, false));
                    break;
                case 1:
                    animals.add(new Snake(index, animalType.typeName, sex, age, weight, false));
                    break;
                case 2:
                    animals.add(new Dog(index, animalType.typeName, sex, age, weight, false));
                    break;
                case 3:
                    animals.add(new Fish(index, animalType.typeName, sex, age, weight, false));
                    break;
                case 4:
                    animals.add(new Octopus(index, animalType.typeName, sex, age, weight, false));
                    break;
                case 5:
                    animals.add(new Stork(index, animalType.typeName, sex, age, weight, false));
                    break;
                case 6:
                    animals.add(new Ostrich(index, animalType.typeName, sex, age, weight, false));
                    break;
                case 7:
                    animals.add(new Tiger(index, animalType.typeName, sex, age, weight, false));
                    break;
            }
        }
        return animals;
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

    private void playGame(List<Animal> animals) {
        do {
            switch (ioManager.chooseFromMenu()) {
                case 1:
                    showListOfAnimals();
                    break;
                case 2:
                    training();
                    break;
                case 9:
                    return;
            }
        } while (true);
    }

    private void training() {
        final List<AnimalType> source = new ArrayList<>(Arrays.asList(AnimalType.values()));
        showListOfAnimals();
        int index = ioManager.chooseAnimal(animals.size());
        ioManager.showMessage(format(FORMATTED_SHORT_LIST_OF_ANIMALS, index,
                animals.get(index - 1).getName()));
        ioManager.showMessage(SOUND);
        //int sourceid = animals.get(index-1).getId();
        ioManager.showMessage(animals.get(index - 1).getSound());
        //ioManager.showMessage(source.get(sourceid-1).sound);
        final Animal octopus = new Octopus(index, "Octopuusss", SexType.MALE, 2, 0.5f, false);

        if(octopus instanceof Octopus) {
            ((Octopus) octopus).getTentaclesAmount();
        }

    }
}
