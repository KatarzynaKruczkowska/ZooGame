package com.company.zoo;

import java.util.*;

import static com.company.zoo.AnimalType.OCTOPUS;
import static com.company.zoo.Texts.*;

public class GameManager {

    private final IOManager ioManager;
    private static final int MIN_NUMBER_OF_ANIMALS = 3;
    private static final int MAX_NUMBER_OF_ANIMALS = 10;

    private static final String FORMATTED_SHORT_LIST_OF_ANIMALS = "%2d. %s";

    final Random random = new Random();
    private Map<AnimalType, List<Animal>> animals = new HashMap<>();
    //private List<Animal> animals;

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
        //ioManager.showMessage(NUMBER_OF_ANIMALS + Integer.toString(animals.size()));
//        int counter = 0;
//        for (int i = 0; i < AnimalType.values().length; i++) {
//            final AnimalType animalType = AnimalType.values()[i];
//            final List<Animal> animalsList = animals.get(animalType);
//            if (animalsList != null) {
//                //ioManager.showMessage(animalType.typeName);
//                for (int j = 0; j < animalsList.size(); j++) {
//                    ioManager.showMessage(counter + 1 + " " + animalsList.get(j).toString());
//                    counter += 1;
//                }
//            }
//        }

        int counter = 0;
        for (AnimalType animalType : animals.keySet()) {
            final List<Animal> animalsList = animals.get(animalType);
            for (int i = 0; i < animalsList.size(); i++) {
                ioManager.showMessage(counter + 1 + " " + animalsList.get(i).toString());
                counter += 1;
            }
        }
    }

    private void showListTypesOfAnimals() {
        int counter = 0;
        for (AnimalType animalType : animals.keySet()) {
            ioManager.showMessage(counter + 1 + " " + animalType.typeName);
            counter += 1;
        }
    }

    private AnimalType chooseTypeOfAnimal() {
        showListTypesOfAnimals();
        int index = ioManager.chooseAnimal(animals.size());
        int i = 1;
        AnimalType type = null;
        for (AnimalType animalType : animals.keySet()) {
            if (i == index) {
                type = animalType;
                break;
            }
            i += 1;
        }
        return type;
    }

    private Map<AnimalType, List<Animal>> initPopulation(final int startNumberOfAnimals) {
        final Map<AnimalType, List<Animal>> animals = new HashMap<>();

        for (int i = 0; i < startNumberOfAnimals; i++) {
            final AnimalType animalType = AnimalType.values()[getRandomNumber(1, AnimalType.values().length) - 1];   //0-7
            List<Animal> animalsList = animals.get(animalType);
            if (animalsList == null) {
                animalsList = new ArrayList<>();
            }
            if (animalType == OCTOPUS) {
                animalsList.add(new Octopus(OCTOPUS, 10));
            } else {
                animalsList.add(animalType.getNewAnimal());
            }
            animals.put(animalType, animalsList);
        }
        return animals;
    }

    private int getRandomNumber(final int min, final int max) {
        return random.nextInt(max + 1 - min) + min; //tak musi być żeby zakres był zachowany
    }


    private void playGame(Map<AnimalType, List<Animal>> animals) {
        do {
            switch (ioManager.chooseFromMenu()) {
                case LIST_OF_ANIMALS:
                    showListOfAnimals();
                    break;
                case TRAINING:
                    training();
                    break;
                case SORTING_BY_ENUM:
                    sortingByEnum();
                    break;
                case SORTING_BY_COMPARATOR:
                    sortingByComparator();
                    break;
                case FEEDING:
                    feeding();
                    break;
                case WALKING:
                    //walking();
                    break;
                case EXIT:
                    return;
            }
        } while (true);
    }

    private void feeding() {

        AnimalType animalType = chooseTypeOfAnimal();
        final List<Animal> animalsList = animals.get(animalType);
        for (int i = 0; i < animalsList.size(); i++) {
            animalsList.get(i).eat();
        }

//        AnimalType animalType = ioManager.selectAnimalType();
//        for (final Animal animal : animals.get(animalType)) {
//            animal.eat();
//        }

//        animals.get(animalType).stream()
//                .limit(10)
//                .filter(animal -> animal.getAge() > 2)
//                .forEach(Animal::eat);

    }

    private void sortingByComparator() {
        AnimalComparator comparator = new AnimalComparator();
        SortMenuType sortType = ioManager.chooseFromSortByMenu();
        comparator.setSortBy(sortType);
        for (AnimalType animalType : animals.keySet()) {
            final List<Animal> animalsList = animals.get(animalType);
            Collections.sort(animalsList, comparator);
            animals.put(animalType, animalsList);
        }
        showListOfAnimals();
    }

    private void sortingByEnum() {
        SortMenuType sortType = ioManager.chooseFromSortByMenu();
        for (AnimalType animalType : animals.keySet()) {
            final List<Animal> animalsList = animals.get(animalType);
            Collections.sort(animalsList, sortType);
            animals.put(animalType, animalsList);
        }
        showListOfAnimals();
    }

    private void training() {
        AnimalType animalType = chooseTypeOfAnimal();
        final List<Animal> animalsList = animals.get(animalType);
        ioManager.showMessage(animalsList.get(0).getName());
        //ioManager.showMessage(SOUND);
        ioManager.showMessage(animalsList.get(0).getSound());
        //każde zwierzę musi być zmodyfikowane (inf że była zabawa)
        for (int i = 0; i < animalsList.size(); i++) {
            animalsList.get(i).fun();
        }
    }
}
