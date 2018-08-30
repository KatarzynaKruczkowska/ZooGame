package com.company.zoo;

public interface IOManager {

    public void showMessage(final String message);

    public boolean getDecision(final String message);

    public int getMenu();

    public int getAnimal(int currentNumberOfAnimals);
}
