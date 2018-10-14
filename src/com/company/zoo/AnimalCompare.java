package com.company.zoo;

import java.util.Comparator;

public class AnimalCompare implements Comparator<Animal> {

    private SortMenuType sortBy = SortMenuType.SORT_BY_NAME;

    private int compareAge(Animal animal_1, Animal animal_2) {
        if (animal_2 == null) return -1;
        if (animal_1.getAge() > animal_2.getAge()) return 1;
        else if (animal_1.getAge() < animal_2.getAge()) return -1;
        else return 0;
    }

    @Override
    public int compare(Animal o1, Animal o2) {
        switch (sortBy) {
            case SORT_BY_AGE:
                compareAge(o1, o2);
                break;
            case SORT_BY_SEX:
                break;
        }
        return compareAge(o1, o2);
    }

    public void setSortBy(SortMenuType sortBy) {
        this.sortBy = sortBy;
    }
}
