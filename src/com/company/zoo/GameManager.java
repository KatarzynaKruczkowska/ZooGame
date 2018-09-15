package com.company.zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.company.zoo.AnimalType.OCTOPUS;
import static com.company.zoo.Texts.*;
import static java.lang.String.format;

public class GameManager {

    private final IOManager ioManager;
    private static final int MIN_NUMBER_OF_ANIMALS = 3;
    private static final int MAX_NUMBER_OF_ANIMALS = 10;

    private static final String FORMATTED_LIST_OF_ANIMALS = "%d. %-25s %s %-8s %s %3d %s %10.2f %s %b";
    private static final String FORMATTED_SHORT_LIST_OF_ANIMALS = "%d. %s";

    final Random random = new Random();
    private List<Animal> animals;

    public GameManager(final IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void play() {
        int startNumberOfAnimals = getRandomNumber(MIN_NUMBER_OF_ANIMALS, MAX_NUMBER_OF_ANIMALS);

        animals = initPopulation(startNumberOfAnimals);
        showListOfAnimals();
        playGame(animals);
        ioManager.showMessage(END_OF_THE_GAME);
    }

    private void showListOfAnimals() {
        ioManager.showMessage(NUMBER_OF_ANIMALS + Integer.toString(animals.size()));
        for (int i = 0; i < animals.size(); i++) {
//            Animal animal = animals.get(i);
            ioManager.showMessage(animals.get(i).toString());
//            ioManager.showMessage(format(FORMATTED_LIST_OF_ANIMALS, i + 1,
//                    animal.getName(),
//                    SEX, animal.getSexType().printableSex,
//                    AGE, animal.getAge(),
//                    WEIGHT, animal.getWeight(),
//                    PREGNANT, animal.isPregnant()));
        }
    }

    private List<Animal> initPopulation(final int startNumberOfAnimals) {
        final List<Animal> animals = new ArrayList<>(startNumberOfAnimals);

        for (int i = 0; i < startNumberOfAnimals; i++) {
            final AnimalType animalType = AnimalType.values()[getRandomNumber(1, AnimalType.values().length) - 1];   //0-7
            final int age = getRandomNumber(1, animalType.maxAge);
            final float weight = getRandomWeight(animalType.minWeight, animalType.maxWeight);
            if (animalType == OCTOPUS) {
                animals.add(new Octopus(OCTOPUS, getRandomSex(), age, weight, false, 10));
            } else {
                animals.add(animalType.getNewAnimal(getRandomSex(), age, weight, false));
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
                case LIST:
                    showListOfAnimals();
                    break;
                case TRAINING:
                    training();
                    break;
                case EXIT:
                    return;
                //default:
                //    throw new IllegalArgumentException(WRONG_FORMAT);
            }
        } while (true);
    }

    private void training() {
        showListOfAnimals();
        int index = ioManager.chooseAnimal(animals.size());
        ioManager.showMessage(format(FORMATTED_SHORT_LIST_OF_ANIMALS, index,
                animals.get(index - 1).getName()));
        ioManager.showMessage(SOUND);
        ioManager.showMessage(animals.get(index - 1).getSound());

    }
}
