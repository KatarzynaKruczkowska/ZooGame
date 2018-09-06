package com.company.zoo;

public interface IOManager {

    public void showMessage(final String message);

    public boolean getDecision(final String message);

    public int chooseFromMenu();

    public int chooseAnimal(int max);
}
