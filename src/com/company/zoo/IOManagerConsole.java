package com.company.zoo;

import com.company.zoo.IOManager;

import java.util.Scanner;

public class IOManagerConsole implements IOManager {

    private final Scanner INPUT = new Scanner(System.in);

    @Override
    public void showMessage(final String message) {
        System.out.println(message);
    }

    public int getAnimal(int currentNumberOfAnimals){
        showMessage(Texts.CHOOSE_AN_ANIMAL); //co z 10?
        int result = getNumber();
        return result;
    }

    public int getMenu(){
        showMessage(Texts.MENU);
        showMessage(Texts.TAKE_DECISION);
        showMessage("1 - " + Texts.LIST_OF_ANIMALS);
        showMessage("2 - " + Texts.TRAINING);
        showMessage("9 - " + Texts.EXIT);
        int result = getNumber();
        return result;
    }

    @Override
    public boolean getDecision(final String message) {
        showMessage(message);
        showMessage(Texts.TAKE_DECISION);
        showMessage("1 - " + Texts.DECISION_YES);
        showMessage("2 - " + Texts.DECISION_NO);
        int result = getNumber();
        return result == 1;
    }

    private int getNumber() {
        int result = 0;
        try {
            result = Integer.parseInt(INPUT.nextLine());
        } catch (NumberFormatException error) {
            showMessage(Texts.WRONG_FORMAT);
        } catch (Exception error) {
            error.printStackTrace();
        }
        return result;
    }
}
