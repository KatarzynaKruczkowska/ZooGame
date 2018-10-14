package com.company.zoo;

import java.util.Comparator;

import static com.company.zoo.Texts.*;

public enum SortMenuType implements Comparator<Animal> {
    SORT_BY_NAME(SORT_BY_NAME_TXT) {
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
            return Float.compare(o1.getWeight(), o2.getWeight());
        }
    },
    SORT_BY_PREGNANT(SORT_BY_PREGNANT_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return Boolean.compare(o1.isPregnant(), o2.isPregnant());
        }
    };

    public final String menuSortBy;

    SortMenuType(final String menuSortBy) {
        this.menuSortBy = menuSortBy;
    }

}
