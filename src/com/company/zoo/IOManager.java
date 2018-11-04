package com.company.zoo;

public interface IOManager {

    void showMessage(final String message);

    boolean getDecision(final String message);

    MenuType chooseFromMenu();

    SortMenuType chooseFromSortByMenu();

//    AnimalType selectAnimalType();

    int chooseAnimal(int max);
}
