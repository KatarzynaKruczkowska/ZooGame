package com.company.zoo;

import java.util.Comparator;

import static com.company.zoo.Texts.*;

public enum SortMenuType implements Comparator<Animal> {
    SORT_BY_ID_AND_NAME(SORT_BY_ID_AND_NAME_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getName().compareTo(o2.getName());
        }
    },
    SORT_BY_SEX(SORT_BY_SEX_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getSexType().compareTo(o2.getSexType());
        }
    },
    SORT_BY_AGE(SORT_BY_AGE_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    },
    SORT_BY_WEIGHT(SORT_BY_WEIGHT_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return 0;
        }
    },
    SORT_BY_PREGNANT(SORT_BY_PREGNANT_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return 0;
        }
    },
    EXIT(EXIT_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return 0;
        }
    };

    public final String menuSortByName;

    SortMenuType(final String menuSortByName) {
        this.menuSortByName = menuSortByName;
    }

}
