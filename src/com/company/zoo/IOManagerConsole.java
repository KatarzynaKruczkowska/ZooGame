package com.company.zoo;

import java.util.Scanner;

import static com.company.zoo.Texts.*;
import static java.lang.String.format;

public class IOManagerConsole implements IOManager {

    private final Scanner INPUT = new Scanner(System.in);
    private static final String FORMATTED_MENU = "%d. %s";
    private static final String FORMATTED_YES_NO = "%d. %s";

    @Override
    public void showMessage(final String message) {
        System.out.println(message);
    }

    public int chooseAnimal(int max) {
        showMessage(CHOOSE_AN_ANIMAL);
        int result = 0;
        do {
            result = getNumber();
        } while (result < 1 || result > max);
        return result;
    }

    public MenuType chooseFromMenu() {
        showMessage(MENU);
        for (MenuType menuType : MenuType.values()) {
            showMessage(format(FORMATTED_MENU, menuType.ordinal() + 1, menuType.menuOptionName));
        }
        int result = 0;
        do {
            result = getNumber();
        } while (result < 1 || result > MenuType.values().length);
        return MenuType.values()[result - 1];
    }

    public SortMenuType chooseFromSortByMenu() {
        showMessage(MENU);
        for (SortMenuType sortMenuType : SortMenuType.values()) {
            showMessage(format(FORMATTED_MENU, sortMenuType.ordinal() + 1, sortMenuType.menuSortBy));
        }
        int result = 0;
        do {
            result = getNumber();
        } while (result < 1 || result > SortMenuType.values().length);
        return SortMenuType.values()[result - 1];
    }

    @Override
    public boolean getDecision(final String message) {
        showMessage(message);
        showMessage(TAKE_DECISION);
        for (YesNoType yesNoType : YesNoType.values()) {
            showMessage(format(FORMATTED_YES_NO, yesNoType.ordinal() + 1, yesNoType.yesNoText));
        }
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
