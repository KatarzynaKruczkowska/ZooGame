package com.company.zoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.company.zoo.AnimalType.OCTOPUS;
import static com.company.zoo.Texts.*;
import static java.lang.String.format;

public class GameManager {

    private final IOManager ioManager;
    private static final int MIN_NUMBER_OF_ANIMALS = 3;
    private static final int MAX_NUMBER_OF_ANIMALS = 10;

    private static final String FORMATTED_SHORT_LIST_OF_ANIMALS = "%2d. %s";

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
            ioManager.showMessage(i + 1 + " " + animals.get(i).toString());
        }
    }

    private List<Animal> initPopulation(final int startNumberOfAnimals) {
        final List<Animal> animals = new ArrayList<>(startNumberOfAnimals);

        for (int i = 0; i < startNumberOfAnimals; i++) {
            final AnimalType animalType = AnimalType.values()[getRandomNumber(1, AnimalType.values().length) - 1];   //0-7

            if (animalType == OCTOPUS) {
                animals.add(new Octopus(OCTOPUS, 10));
            } else {
                animals.add(animalType.getNewAnimal());
            }
        }
        return animals;
    }

    private int getRandomNumber(final int min, final int max) {
        return random.nextInt(max + 1 - min) + min; //tak musi być żeby zakres był zachowany
    }


    private void playGame(List<Animal> animals) {
        do {
            switch (ioManager.chooseFromMenu()) {
                case LIST_OF_ANIMALS:
                    showListOfAnimals();
                    break;
                case TRAINING:
                    training();
                    break;
                case SORTING_BY_ENUM:
                    sorting_by_ENUM();
                    break;
                case SORTING_BY_COMPARATOR:
                    sorting_by_comparator();
                    break;
                case EXIT:
                    return;
            }
        } while (true);
    }

    private void sorting_by_comparator() {
        AnimalComparator comparator = new AnimalComparator();

        SortMenuType sortType = ioManager.chooseFromSortByMenu();
        comparator.setSortBy(sortType);
        Collections.sort(animals, comparator);
        showListOfAnimals();
    }

    private void sorting_by_ENUM() {
        Collections.sort(animals, ioManager.chooseFromSortByMenu());
        showListOfAnimals();
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
