package com.company.zoo;

import java.util.Comparator;

import static com.company.zoo.Texts.*;

public enum SortMenuType implements Comparator<Animal> {
    SORT_BY_ID_ASC(SORT_BY_ID_ASC_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.compareTo(o2);
        }
    },
    SORT_BY_ID_DESC(SORT_BY_ID_DESC_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o2.compareTo(o1);
        }
    },
    SORT_BY_NAME_ASC(SORT_BY_NAME_ASC_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getName().compareTo(o2.getName());
        }
    },
    SORT_BY_NAME_DESC(SORT_BY_NAME_DESC_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o2.getName().compareTo(o1.getName());
        }
    },
    SORT_BY_SEX(SORT_BY_SEX_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getSexType().compareTo(o2.getSexType());
        }
    },
    SORT_BY_AGE_ASC(SORT_BY_AGE_ASC_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    },
    SORT_BY_AGE_DESC(SORT_BY_AGE_DESC_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return Integer.compare(o2.getAge(), o1.getAge());
        }
    },
    SORT_BY_WEIGHT_ASC(SORT_BY_WEIGHT_ASC_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return Float.compare(o1.getWeight(), o2.getWeight());
        }
    },
    SORT_BY_WEIGHT_DESC(SORT_BY_WEIGHT_DESC_TXT) {
        @Override
        public int compare(Animal o1, Animal o2) {
            return Float.compare(o2.getWeight(), o1.getWeight());
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
