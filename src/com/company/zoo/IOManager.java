package com.company.zoo;

public interface IOManager {

    public void showMessage(final String message);

    public boolean getDecision(final String message);

    public MenuType chooseFromMenu();

    public SortMenuType chooseFromSortByMenu();

    public int chooseAnimal(int max);
}
