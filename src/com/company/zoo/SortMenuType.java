package com.company.zoo;

import static com.company.zoo.Texts.*;

public enum SortMenuType {
    SORT_BY_ID_AND_NAME(SORT_BY_ID_AND_NAME_TXT),
    SORT_BY_SEX(SORT_BY_SEX_TXT),
    SORT_BY_AGE(SORT_BY_AGE_TXT),
    SORT_BY_WEIGHT(SORT_BY_WEIGHT_TXT),
    SORT_BY_PREGNANT(SORT_BY_PREGNANT_TXT),
    EXIT(EXIT_TXT);

    public final String menuSortByName;

    SortMenuType(final String menuSortByName) {
        this.menuSortByName = menuSortByName;
    }

}
