package com.company.zoo;

import static com.company.zoo.Texts.*;

public enum MenuType {

    LIST(LIST_OF_ANIMALS),
    TRAINING(Texts.TRAINING),   //czy zmienić nazwę stałej tekstowej? Żeby nie była taka sama
    EXIT(Texts.EXIT);

    public final String printableMenu;

    MenuType(final String printableMenu) {
        this.printableMenu = printableMenu;
    }
}
