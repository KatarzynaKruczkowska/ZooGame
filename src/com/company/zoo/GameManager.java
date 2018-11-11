package com.company.zoo;

import java.util.*;

import static com.company.zoo.AnimalType.OCTOPUS;
import static com.company.zoo.Texts.*;

public class GameManager {

    private final IOManager ioManager;
    private static final int MIN_NUMBER_OF_ANIMALS = 3;
    private static final int MAX_NUMBER_OF_ANIMALS = 10;
    private boolean endOfTheGame = false;

    final Random random = new Random();
    private Map<AnimalType, List<Animal>> animals = new HashMap<>();

    public GameManager(final IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void play() {
        do {
            int startNumberOfAnimals = getRandomNumber(MIN_NUMBER_OF_ANIMALS, MAX_NUMBER_OF_ANIMALS);

            animals = initPopulation(startNumberOfAnimals);
            showMapOfAnimals();
            playGame(animals);
            ioManager.showMessage(END_OF_THE_GAME);
        } while (endOfTheGame);
    }

    private void endOfTheDay() {
        ioManager.showMessage(SUNSET_TXT);

        int counter = 0;
        for (AnimalType animalType : animals.keySet()) {
            final List<Animal> animalsList = animals.get(animalType);
            ioManager.showMessage(animalType.typeName);
            for (int i = 0; i < animalsList.size(); i++) {
                counter += 1;
                Animal animal = animalsList.get(i);
                animal.ageChange();
                if (animal.getStarvingDays() < -1) {
                    animal.weightLoss();
                }
                if (animal.isPregnant()) {
                    //długość trwania ciąży?
                    animalsList.add(animalType.getNewAnimal());
                    // powinno być a minimalną wagą i minimalnym wiekiem
                    animal.changePregnantStatus();
                }
                if (animal.getWeight() < animalType.minWeight || animal.getAge() >= animalType.maxAge) {
                    animalsList.remove(i);
                    if (animalsList.size() == 0) {
                        animals.remove(animalType, animalsList);
                        ioManager.showMessage(animalType.typeName);
                        ioManager.showMessage(ANIMAL_TYPE_REMOVAL);
                        break;
                    }
                }
                ioManager.showMessage(CURRENT_STATUS);
                showMapOfAnimals();
                if (animals.size() <= 2) {
                    endOfTheGame = true;
                }
            }
        }
    }

    private void showMapOfAnimals() {
        ioManager.showMessage(SORTED_MAP_OF_ANIMALS);
        int counter = 0;
        for (AnimalType animalType : animals.keySet()) {
            final List<Animal> animalsList = animals.get(animalType);
            ioManager.showMessage(animalType.typeName);
            for (final Animal anAnimalsList : animalsList) {
                ioManager.showMessage(++counter + " " + anAnimalsList.toString());
            }
        }
    }

    private void showListOfAnimals(final List list) {
        ioManager.showMessage(SORTED_LIST_OF_ANIMALS);
        for (int i = 0; i < list.size(); i++) {
            ioManager.showMessage((i + 1) + " " + list.get(i).toString());
        }
    }

    private Map<AnimalType, List<Animal>> initPopulation(final int startNumberOfAnimals) {
        final Map<AnimalType, List<Animal>> animals = new HashMap<>();

        for (int i = 0; i < startNumberOfAnimals; i++) {
            final AnimalType animalType = AnimalType.values()[getRandomNumber(1, AnimalType.values().length) - 1];   //0-7
            List<Animal> animalsList = animals.get(animalType);
            if (animalsList == null) {
                animalsList = new ArrayList<>();
                animals.put(animalType, animalsList);
            }
            if (animalType == OCTOPUS) {
                animalsList.add(new Octopus(OCTOPUS, 10));
            } else {
                animalsList.add(animalType.getNewAnimal());
            }
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
                    showMapOfAnimals();
                    break;
                case TRAINING:
                    training();
                    endOfTheDay();
                    break;
                case SORTING_BY_ENUM:
                    sortingByEnum();
                    break;
                case SORTING_BY_COMPARATOR:
                    sortingByComparator();
                    break;
                case FEEDING:
                    feeding();
                    endOfTheDay();
                    break;
                case WALKING:
                    walking();
                    endOfTheDay();
                    break;
                case EXIT:
                    return;
            }
        } while (true);
    }

    private void walking() {
        final AnimalType animalType = ioManager.selectAnimalType(new ArrayList<>(animals.keySet()));
        for (Animal animal : animals.get(animalType)) {
            animal.walk();
            ioManager.showMessage(animalType.typeName + " " + WALKING);
        }
    }

    private void feeding() {

        final AnimalType animalType = ioManager.selectAnimalType(new ArrayList<>(animals.keySet()));
        for (Animal animal : animals.get(animalType)) {
            animal.eat();
            ioManager.showMessage(animalType.typeName + " " + EATING);
        }
    }

    private void sortingByComparator() {
        AnimalComparator comparator = new AnimalComparator();
        SortMenuType sortType = ioManager.chooseFromSortByMenu();
        ioManager.showMessage(sortType.menuSortBy);
        final List<Animal> sortedAllAnimalsList = new ArrayList<>();
        comparator.setSortBy(sortType);
        for (AnimalType animalType : animals.keySet()) {
            final List<Animal> animalsList = animals.get(animalType);
            Collections.sort(animalsList, comparator);
            sortedAllAnimalsList.addAll(animalsList);
        }
        showMapOfAnimals();
        Collections.sort(sortedAllAnimalsList, comparator);
        showListOfAnimals(sortedAllAnimalsList);
    }

    private void sortingByEnum() {
        SortMenuType sortType = ioManager.chooseFromSortByMenu();
        ioManager.showMessage(sortType.menuSortBy);
        final List<Animal> sortedAllAnimalsList = new ArrayList<>();
        for (AnimalType animalType : animals.keySet()) {
            final List<Animal> animalsList = animals.get(animalType);
            Collections.sort(animalsList, sortType);
            sortedAllAnimalsList.addAll(animalsList);
        }
        showMapOfAnimals();
        Collections.sort(sortedAllAnimalsList, sortType);
        showListOfAnimals(sortedAllAnimalsList);
    }

    private void training() {
        AnimalType animalType = ioManager.selectAnimalType(new ArrayList<>(animals.keySet()));

        final Animal firstAnimal = animals.get(animalType).get(0);
        ioManager.showMessage(firstAnimal.getName());
        ioManager.showMessage(firstAnimal.getSound());
        //każde zwierzę musi być zmodyfikowane (inf że była zabawa)
        for (Animal animal : animals.get(animalType)) {
            animal.fun();
            ioManager.showMessage(animalType.typeName + " " + PLAYING);
        }
    }
}
