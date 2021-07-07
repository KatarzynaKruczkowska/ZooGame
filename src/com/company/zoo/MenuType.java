package com.company.zoo;

import static com.company.zoo.Texts.*;

public enum MenuType {

    LIST_OF_ANIMALS(LIST_OF_ANIMALS_TXT),
    TRAINING(TRAINING_TXT),
    SORTING_BY_ENUM(SORTING_BY_ENUM_TXT),
    SORTING_BY_COMPARATOR(SORTING_BY_COMPARATOR_TXT),
    EXIT(EXIT_TXT);

    public final String menuOptionName;

    MenuType(final String menuOptionName) {
        this.menuOptionName = menuOptionName;
    }
}
