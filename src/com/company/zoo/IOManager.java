package com.company.zoo;

import java.util.List;

public interface IOManager {

    void showMessage(final String message);

    boolean getDecision(final String message);

    MenuType chooseFromMenu();

    SortMenuType chooseFromSortByMenu();

    AnimalType selectAnimalType(final List<AnimalType> animalTypeList);

    int chooseAnimal(final int max);
}
