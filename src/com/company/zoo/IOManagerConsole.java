package com.company.zoo;

import java.util.Scanner;

import static com.company.zoo.Texts.*;

public class IOManagerConsole implements IOManager {

    private final Scanner INPUT = new Scanner(System.in);

    @Override
    public void showMessage(final String message) {
        System.out.println(message);
    }

    public int chooseAnimal(int max) {
        showMessage(CHOOSE_AN_ANIMAL);
        int result = 0;
        do {
            result = getNumber();
        }while (result < 1 || result > max);
        return result;
    }

    public int chooseFromMenu() {
        showMessage(MENU);
        showMessage("1 - " + LIST_OF_ANIMALS);
        showMessage("2 - " + TRAINING);
        showMessage("9 - " + EXIT);
        return getNumber();
    }

    @Override
    public boolean getDecision(final String message) {
        showMessage(message);
        showMessage(TAKE_DECISION);
        showMessage("1 - " + DECISION_YES);
        showMessage("2 - " + DECISION_NO);
        return getNumber() == 1;
    }

    private int getNumber() {
        int result = 0;
        try {
            result = Integer.parseInt(INPUT.nextLine());
        } catch (NumberFormatException error) {
            showMessage(WRONG_FORMAT);
        } catch (Exception error) {
            error.printStackTrace();
        }
        return result;
    }
}
