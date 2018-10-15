package com.company.zoo;

import java.util.Comparator;

public class AnimalCompare implements Comparator<Animal> {

    private SortMenuType sortBy = SortMenuType.SORT_BY_NAME;

    private int compareName(Animal o1, Animal o2) {
        return o1.getName().compareTo(o2.getName());
    }

    private int compareAge(Animal o1, Animal o2) {
        if (o1 == null || o2 == null) return -1;
        if (o1.getAge() > o2.getAge()) return 1;
        if (o1.getAge() < o2.getAge()) return -1;
        return 0;
    }

    private int compareSex(Animal o1, Animal o2) {
        if (o1 == null || o2 == null) return -1;
        if (o1.getSexType().ordinal() > o2.getSexType().ordinal()) return 1;
        if (o1.getSexType().ordinal() < o2.getSexType().ordinal()) return -1;
        return 0;
    }

    private int compareWeight(Animal o1, Animal o2) {
        if (o1 == null || o2 == null) return -1;
        if (o1.getWeight() > o2.getWeight()) return 1;
        if (o1.getWeight() < o2.getWeight()) return -1;
        return 0;
    }

    private int comparePregnant(Animal o1, Animal o2) {
        if (o1 == null || o2 == null) return -1;
        if (o1.isPregnant() == false & o2.isPregnant() == true) return 1;
        if (o1.isPregnant() == true & o2.isPregnant() == false) return -1;
        return 0;
    }

    @Override
    public int compare(Animal o1, Animal o2) {
        switch (sortBy) {
            case SORT_BY_NAME:
                return compareName(o1, o2);
            case SORT_BY_AGE:
                return compareAge(o1, o2);
            case SORT_BY_SEX:
                return compareSex(o1, o2);
            case SORT_BY_WEIGHT:
                return compareWeight(o1, o2);
            case SORT_BY_PREGNANT:
                return comparePregnant(o1, o2);
        }
        return 0;
    }

    public void setSortBy(SortMenuType sortBy) {
        this.sortBy = sortBy;
    }
}
