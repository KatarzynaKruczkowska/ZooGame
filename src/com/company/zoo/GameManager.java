package com.company.zoo;

import java.util.*;

import static com.company.zoo.AnimalType.OCTOPUS;
import static com.company.zoo.Texts.*;

public class GameManager {

    private final IOManager ioManager;
    private static final int MIN_NUMBER_OF_ANIMALS = 3;
    private static final int MAX_NUMBER_OF_ANIMALS = 10;
    private static final int MIN_NUMBER_OF_TYPES = 2;
    private static final int MIN_DAYS_WITHOUT_TRAINING = 2;
    private boolean endOfTheGame = false;

    final Random random = new Random();
    private Map<AnimalType, List<Animal>> animals = new HashMap<>();

    public GameManager(final IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public void play() {
        int startNumberOfAnimals = getRandomNumber(MIN_NUMBER_OF_ANIMALS, MAX_NUMBER_OF_ANIMALS);
        endOfTheGame = false;
        animals = initPopulation(startNumberOfAnimals);
        showMapOfAnimals();
        playGame(animals);
        ioManager.showMessage(END_OF_THE_GAME);
    }

    private void endOfTheDay() {
        ioManager.showMessage(END_OF_THE_DAY_TXT);

        final List<AnimalType> keysToRemove = new ArrayList<>();

        for (AnimalType animalType : animals.keySet()) {
            final List<Animal> animalsList = animals.get(animalType);
            ioManager.showMessage(animalType.typeName);

            for (int i = animalsList.size(); i > 0; i--) {
                final Animal animal = animalsList.get(i - 1);
                animal.animalEndOfTheDay();
                if (animal.isPregnant()) {
                    //długość trwania ciąży?
                    animal.setPregnantToFalse();
                    animalsList.add(animalType.getNewAnimal(1));
                    //animalsList.add(animalType.getNewAnimal());    //dodane na końcu czyli już po nim nie przejdzie(?)
                }
                if (!animal.isAlive()) {
                    animalsList.remove(animal);
                }
            }

            final List<Animal> femaleAnimalList = new ArrayList<>();
            final List<Animal> maleAnimalList = new ArrayList<>();
            for (Animal animal : animalsList) {
                if (animal.getSexType() == SexType.FEMALE && animal.getTrainingDays() <= MIN_DAYS_WITHOUT_TRAINING
                        && animal.getAge() > animalType.maxAge / 10) {
                    femaleAnimalList.add(animal);
                }
                if (animal.getSexType() == SexType.MALE && animal.getTrainingDays() <= MIN_DAYS_WITHOUT_TRAINING) {
                    maleAnimalList.add(animal);
                }
            }
            if (femaleAnimalList.size() > 0 && maleAnimalList.size() > 0) {
                for (Animal animal : femaleAnimalList) {
                    //animal.setPregnantToTrue() == random.nextBoolean(); ???
                    if (random.nextBoolean()) {
                        animal.setPregnantToTrue();
                    }
                }
            }

            if (animalsList.isEmpty()) {
                keysToRemove.add(animalType);
                ioManager.showMessage(animalType.typeName + " " + ANIMAL_TYPE_REMOVAL);
            }
        }
        keysToRemove.forEach(key -> animals.remove(key));

        ioManager.showMessage(CURRENT_STATUS);
        showMapOfAnimals();
        if (animals.size() <= MIN_NUMBER_OF_TYPES) {
            endOfTheGame = true;
        }
    }

    private void showMapOfAnimals() {
        ioManager.showMessage(SORTED_MAP_OF_ANIMALS);
        int counter = 0;
        for (AnimalType animalType : animals.keySet()) {
            final List<Animal> animalsList = animals.get(animalType);
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
        do {
            if (!animals.isEmpty()) {
                for (AnimalType animalType : animals.keySet()) {
                    animals.remove(animalType);
                }
            }
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
        } while (animals.size() < MIN_NUMBER_OF_TYPES);
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
                    sorting("ByEnum");
                    break;
                case SORTING_BY_COMPARATOR:
                    sorting("ByComparator");
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
        } while (!endOfTheGame);
    }

    private void walking() {
        final AnimalType animalType = ioManager.selectAnimalType(new ArrayList<>(animals.keySet()));
        for (Animal animal : animals.get(animalType)) {
            animal.walk();
            animal.trainingLoss();
            ioManager.showMessage(animalType.typeName + " " + WALKING);
        }
    }

    private void feeding() {

        final AnimalType animalType = ioManager.selectAnimalType(new ArrayList<>(animals.keySet()));
        ioManager.showMessage(animalType.typeName + " " + EATING);
        for (Animal animal : animals.get(animalType)) {
            animal.eat();
            animal.trainingLoss();
            ioManager.showMessage(animal.getEatingSound());
        }
    }

    private void sorting(String sortingType) {

        SortMenuType sortType = ioManager.chooseFromSortByMenu();
        ioManager.showMessage(sortType.menuSortBy);
        final List<Animal> sortedAllAnimalsList = new ArrayList<>();

        //czy istniele możliwość dodania wszystkich wartości mapy do listy?
        //nie udało mi sie
        //sortedAllAnimalsList.addAll(animals.values());

        for (AnimalType animalType : animals.keySet()) {
            final List<Animal> animalsList = animals.get(animalType);
            sortedAllAnimalsList.addAll(animalsList);
        }
        if (sortingType == "ByEnum") {
            Collections.sort(sortedAllAnimalsList, sortType);
        } else if (sortingType == "ByComparator") {
            AnimalComparator comparator = new AnimalComparator();
            comparator.setSortBy(sortType);
            Collections.sort(sortedAllAnimalsList, comparator);
        }
        showListOfAnimals(sortedAllAnimalsList);
    }

    private void training() {
        AnimalType animalType = ioManager.selectAnimalType(new ArrayList<>(animals.keySet()));

        final Animal firstAnimal = animals.get(animalType).get(0);
        ioManager.showMessage(firstAnimal.getName());
        ioManager.showMessage(firstAnimal.getSound());
        //każde zwierzę musi być zmodyfikowane (inf że była zabawa=training)
        for (Animal animal : animals.get(animalType)) {
            animal.trainingIncrease();
            ioManager.showMessage(animalType.typeName + " " + PLAYING);
        }
    }
}
