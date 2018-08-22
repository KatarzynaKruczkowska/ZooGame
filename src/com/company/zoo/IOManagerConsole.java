package com.company.zoo;

import com.company.zoo.IOManager;

import java.util.Scanner;

public class IOManagerConsole implements IOManager {

    private final Scanner INPUT = new Scanner(System.in);

    @Override
    public void showMessage(final String message) {
        System.out.println(message);
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
