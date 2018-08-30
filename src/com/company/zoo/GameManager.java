package com.company.zoo;

import java.util.*;

import static java.lang.String.format;

public class GameManager {

    private final IOManager ioManager;
    private boolean shouldContinue;
    private static final int MIN_NUMBER_OF_ANIMALS = 3;
    private static final int MAX_NUMBER_OF_ANIMALS = 10;
    private static final int MIN_INDEX = 1;
    private static final int MAX_INDEX = 8;

    private static final String FORMATED_LIST_OF_ANIMALS = "%d. %s " + Texts.SEX + " %d "
            + Texts.AGE + " %d " + Texts.WEIGHT + " %f " + Texts.PREGNANCY + " %b";
    private static final String FORMATED_SHORT_LIST_OF_ANIMALS = "%d. %s";

    private List<Animal> myAnimals;
    private int currentNumberOfAnimals = 0;

    public GameManager(final IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void play() {
        int startNumberOfAnimals = getRandomNumber(MIN_NUMBER_OF_ANIMALS, MAX_NUMBER_OF_ANIMALS);
        //ioManager.showMessage(Texts.NUMBER_OF_ANIMALS + Integer.toString(startNumberOfAnimals));
        myAnimals = initialPopulation(startNumberOfAnimals);
        //showListOfAnimals(currentNumberOfAnimals);
        playGame(myAnimals, currentNumberOfAnimals);
        ioManager.showMessage(Texts.END_OF_THE_GAME);
    }

    private void showListOfAnimals(int current_number_of_animals) {
        ioManager.showMessage(Texts.NUMBER_OF_ANIMALS + Integer.toString(current_number_of_animals));
        for (int i = 0; i < current_number_of_animals; i++) {
            ioManager.showMessage(format(FORMATED_LIST_OF_ANIMALS, i + 1,
                    myAnimals.get(i).getName(), myAnimals.get(i).getSex(), myAnimals.get(i).getAge(),
                    myAnimals.get(i).getWeight(), myAnimals.get(i).isPregnancy()));
        }
    }

    private List<Animal> initialPopulation(final int startNumberOfAnimals) {
        int index;
        final List<AnimalType> source = new ArrayList<>(Arrays.asList(AnimalType.values()));
        final List<Animal> myAnimals = new ArrayList<>(startNumberOfAnimals);

        for (int i = 0; i < startNumberOfAnimals; i++) {
            index = getRandomNumber(MIN_INDEX, MAX_INDEX);
            //ioManager.showMessage("From List of Types: " + source.get(index-1));
            final int sex = getRandomNumber(0, 1);
            final int age = getRandomNumber(1, source.get(index - 1).maxAge);
            final double weight = 0.01;
            //final int weight = getRandomNumber(0, (int) source.get(i).maxWeight * 1000);
            //... (double) weight / 1000, false);
            myAnimals.add(new Animal(index, source.get(index - 1).printableType, sex, age, weight, false));
            currentNumberOfAnimals += 1;
        }
        return myAnimals;
    }

    private int getRandomNumber(final int min, final int max) {
        final Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    private void playGame(List<Animal> myAnimals, int currentNumberOfAnimals) {
        shouldContinue = true;

        do {
            //
            final int menu = ioManager.getMenu();
            switch (menu) {
                case 1:
                    showListOfAnimals(currentNumberOfAnimals);
                    break;
                case 2:
                    training(myAnimals, currentNumberOfAnimals);
                    break;
                case 9:
                    shouldContinue = false;
                    break;
            }
        } while (shouldContinue);
    }

    private void training(List<Animal> myAnimals, int currentNumberOfAnimals) {
        final List<AnimalType> source = new ArrayList<>(Arrays.asList(AnimalType.values()));
        showListOfAnimals(currentNumberOfAnimals);
        int index = ioManager.getAnimal(currentNumberOfAnimals);
        ioManager.showMessage(format(FORMATED_SHORT_LIST_OF_ANIMALS, index,
                myAnimals.get(index - 1).getName()));
        ioManager.showMessage(Texts.SOUND);
        //int sourceid = myAnimals.get(index-1).getId();
        ioManager.showMessage(source.get(myAnimals.get(index-1).getId()-1).sound);
        //ioManager.showMessage(source.get(sourceid-1).sound);
    }
}
