package com.company.zoo;

import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal> {

    private SortMenuType sortBy = SortMenuType.SORT_BY_NAME_ASC;

    private int compareIdAsc(Animal o1, Animal o2) {
        return o1.compareTo(o2);
    }

    private int compareIdDesc(Animal o1, Animal o2) {
        return o2.compareTo(o1);
    }

    private int compareNameAsc(Animal o1, Animal o2) {
        return o1.getName().compareTo(o2.getName());
    }

    private int compareNameDesc(Animal o1, Animal o2) {
        return o2.getName().compareTo(o1.getName());
    }

    private int compareAgeAsc(Animal o1, Animal o2) {
        if (o1 == null || o1.getAge() > o2.getAge()) return 1;
        if (o2 == null || o1.getAge() < o2.getAge()) return -1;
        return 0;
    }

    private int compareAgeDesc(Animal o1, Animal o2) {
        if (o2 == null || o2.getAge() > o1.getAge()) return 1;
        if (o1 == null || o2.getAge() < o1.getAge()) return -1;
        return 0;
    }

    private int compareSex(Animal o1, Animal o2) {
        if (o1 == null || o1.getSexType().ordinal() > o2.getSexType().ordinal()) return 1;
        if (o2 == null || o1.getSexType().ordinal() < o2.getSexType().ordinal()) return -1;
        return 0;
    }

    private int compareWeightAsc(Animal o1, Animal o2) {
        if (o1 == null || o1.getWeight() > o2.getWeight()) return 1;
        if (o2 == null || o1.getWeight() < o2.getWeight()) return -1;
        return 0;
    }

    private int compareWeightDesc(Animal o1, Animal o2) {
        if (o2 == null || o2.getWeight() > o1.getWeight()) return 1;
        if (o1 == null || o2.getWeight() < o1.getWeight()) return -1;
        return 0;
    }

    private int comparePregnant(Animal o1, Animal o2) {
        if (o1 == null || o1.isPregnant() == false & o2.isPregnant() == true) return 1;
        if (o2 == null || o1.isPregnant() == true & o2.isPregnant() == false) return -1;
        return 0;
    }

    @Override
    public int compare(Animal o1, Animal o2) {
        switch (sortBy) {
            case SORT_BY_ID_ASC:
                return compareIdAsc(o1, o2);
            case SORT_BY_ID_DESC:
                return compareIdDesc(o1, o2);
            case SORT_BY_NAME_ASC:
                return compareNameAsc(o1, o2);
            case SORT_BY_NAME_DESC:
                return compareNameDesc(o1, o2);
            case SORT_BY_AGE_ASC:
                return compareAgeAsc(o1, o2);
            case SORT_BY_AGE_DESC:
                return compareAgeDesc(o1, o2);
            case SORT_BY_SEX:
                return compareSex(o1, o2);
            case SORT_BY_WEIGHT_ASC:
                return compareWeightAsc(o1, o2);
            case SORT_BY_WEIGHT_DESC:
                return compareWeightDesc(o1, o2);
            case SORT_BY_PREGNANT:
                return comparePregnant(o1, o2);
        }
        return 0;
    }

    public void setSortBy(SortMenuType sortBy) {
        this.sortBy = sortBy;
    }
}

