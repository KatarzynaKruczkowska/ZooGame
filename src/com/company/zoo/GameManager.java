package com.company.zoo;

import java.util.*;

import static com.company.zoo.AnimalType.OCTOPUS;
import static com.company.zoo.SortingMethodsType.BY_COMPARATOR;
import static com.company.zoo.SortingMethodsType.BY_ENUM;
import static com.company.zoo.Texts.*;

public class GameManager {

    private final IOManager ioManager;
    private static final int MIN_NUMBER_OF_ANIMALS = 3;
    private static final int MAX_NUMBER_OF_ANIMALS = 10;
    private static final int MIN_NUMBER_OF_TYPES = 2;
    private static final int MIN_DAYS_WITHOUT_TRAINING = 2;
    private static final int MIN_DAYS_WITHOUT_WALKING = 0;
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
            boolean canBePregnant = hasAnyCouple(animalsList);

            for (int i = animalsList.size() - 1; i >= 0; i--) {
                final Animal animal = animalsList.get(i);
                animal.animalEndOfTheDay(canBePregnant);
                animalsList.addAll(animal.childTransfer());
                if (!animal.isAlive()) {
                    animalsList.remove(animal);
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

    private boolean hasAnyCouple(final List<Animal> animalsList) {
//        return animalsList
//                .stream()
//                .filter(this::isPregnantCandidate)
//                .map(Animal::getSexType)
//                .distinct()
//                .count() == 2;

        boolean anyFemale = false;
        boolean anyMale = false;
        for (Animal animal : animalsList) {
            if (!anyFemale
                    && animal.getSexType() == SexType.FEMALE
                    && isPregnantCandidate(animal)) {
                anyFemale = true;
            } else if (!anyMale
                    && animal.getSexType() == SexType.MALE
                    && isPregnantCandidate(animal)) {
                anyMale = true;
            }
            if (anyFemale && anyMale) {
                return true;
            }
        }
        return false;
    }

    private boolean isPregnantCandidate(final Animal animal) {
        return animal.getTrainingDays() <= MIN_DAYS_WITHOUT_TRAINING
                && animal.getWalkingDays() < MIN_DAYS_WITHOUT_WALKING
                && animal.getAge() > animal.getMaxAgeFactor();
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
            animals.clear();
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
                    sorting(BY_ENUM);
                    break;
                case SORTING_BY_COMPARATOR:
                    sorting(BY_COMPARATOR);
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
            ioManager.showMessage(animalType.typeName + " " + WALKING);
        }
    }

    private void feeding() {

        final AnimalType animalType = ioManager.selectAnimalType(new ArrayList<>(animals.keySet()));
        ioManager.showMessage(animalType.typeName + " " + EATING);
        for (Animal animal : animals.get(animalType)) {
            ioManager.showMessage(animal.eat());
//            ioManager.showMessage(animal.getEatingSound());
        }
    }

    private void training() {
        AnimalType animalType = ioManager.selectAnimalType(new ArrayList<>(animals.keySet()));

        final Animal firstAnimal = animals.get(animalType).get(0);
        ioManager.showMessage(firstAnimal.getName());
        ioManager.showMessage(firstAnimal.getSound());
        //każde zwierzę musi być zmodyfikowane (inf że była zabawa=training)
        for (Animal animal : animals.get(animalType)) {
            animal.train();
            ioManager.showMessage(animalType.typeName + " " + PLAYING);
        }
    }

    private void sorting(final SortingMethodsType sortingType) {

        SortMenuType sortType = ioManager.chooseFromSortByMenu();
        ioManager.showMessage(sortType.menuSortBy);
        final List<Animal> sortedAllAnimalsList = new ArrayList<>();

        //czy istniele możliwość dodania wszystkich wartości mapy do listy?
        //nie udało mi sie
        //sortedAllAnimalsList.addAll(animals.values());

        for (AnimalType animalType : animals.keySet()) {
            sortedAllAnimalsList.addAll(animals.get(animalType));
        }
        if (sortingType == BY_ENUM) {
            sortedAllAnimalsList.sort(sortType);
        } else if (sortingType == BY_COMPARATOR) {
            AnimalComparator comparator = new AnimalComparator();
            comparator.setSortBy(sortType);
            sortedAllAnimalsList.sort(comparator);
        }
        showListOfAnimals(sortedAllAnimalsList);

//        String a = "a";
//        String b = "a";
//        String c = new String("a");
//
//        a==b; true
//        a==c; false

    }

}
