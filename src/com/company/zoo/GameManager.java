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
    private static final int MIN_INDEX = 1;
    private static final int MAX_INDEX = 8;

    private static final String FORMATTED_LIST_OF_ANIMALS = "%d. %s " + SEX + " %d "
            + AGE + " %d " + WEIGHT + " %.2f " + PREGNANCY + " %b";
    private static final String FORMATTED_SHORT_LIST_OF_ANIMALS = "%d. %s";

    final Random random = new Random();
    private List<Animal> myAnimals;
    private int currentNumberOfAnimals = 0;

    public GameManager(final IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void play() {
        int startNumberOfAnimals = getRandomNumber(MIN_NUMBER_OF_ANIMALS, MAX_NUMBER_OF_ANIMALS);
        //ioManager.showMessage(Texts.NUMBER_OF_ANIMALS + Integer.toString(startNumberOfAnimals));
        myAnimals = initPopulation(startNumberOfAnimals);
        //showListOfAnimals(currentNumberOfAnimals);
        playGame(myAnimals, currentNumberOfAnimals);
        ioManager.showMessage(END_OF_THE_GAME);
    }

    private void showListOfAnimals(int current_number_of_animals) {
        ioManager.showMessage(NUMBER_OF_ANIMALS + Integer.toString(current_number_of_animals));
        for (int i = 0; i < current_number_of_animals; i++) {
            ioManager.showMessage(format(FORMATTED_LIST_OF_ANIMALS, i + 1,
                    myAnimals.get(i).getName(), myAnimals.get(i).getSex(), myAnimals.get(i).getAge(),
                    myAnimals.get(i).getWeight(), myAnimals.get(i).isPregnant()));
        }
    }

    private List<Animal> initPopulation(final int startNumberOfAnimals) {
        int index;
        final List<Animal> myAnimals = new ArrayList<>(startNumberOfAnimals);

        for (int i = 0; i < startNumberOfAnimals; i++) {
            index = getRandomNumber(0, AnimalType.values().length);
            final AnimalType animalType = AnimalType.values()[index];
            //ioManager.showMessage("From List of Types: " + source.get(index-1));
            final int sex = getRandomNumber(0, 1);
            final int age = getRandomNumber(1, animalType.maxAge);
            final float weight = getRandomWeight(0, animalType.maxWeight);
            myAnimals.add(new Animal(index, animalType.typeName, sex, age, weight, false));
            currentNumberOfAnimals += 1;
        }
        return myAnimals;
    }

    private int getRandomNumber(final int min, final int max) {
        return random.nextInt(max) + min;
    }

    private float getRandomWeight(final float min, final float max) {
        return random.nextFloat() * max + min;
    }

    private void playGame(List<Animal> myAnimals, int currentNumberOfAnimals) {
        do {
            switch (ioManager.getMenu()) {
                case 1:
                    showListOfAnimals(currentNumberOfAnimals);
                    break;
                case 2:
                    training(myAnimals, currentNumberOfAnimals);
                    break;
                case 9:
                    return;
            }
        } while (true);
    }

    private void training(List<Animal> myAnimals, int currentNumberOfAnimals) {
        final List<AnimalType> source = new ArrayList<>(Arrays.asList(AnimalType.values()));
        showListOfAnimals(currentNumberOfAnimals);
        int index = ioManager.getAnimal(currentNumberOfAnimals);
        ioManager.showMessage(format(FORMATTED_SHORT_LIST_OF_ANIMALS, index,
                myAnimals.get(index - 1).getName()));
        ioManager.showMessage(SOUND);
        //int sourceid = myAnimals.get(index-1).getId();
        ioManager.showMessage(source.get(myAnimals.get(index - 1).getId() - 1).sound);
        //ioManager.showMessage(source.get(sourceid-1).sound);
    }
}
