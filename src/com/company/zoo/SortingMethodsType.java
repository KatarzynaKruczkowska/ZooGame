package com.company.zoo;

public enum SortingMethodsType {
    BY_ENUM("ByEnum"),
    BY_COMPARATOR("ByComparator");

    public final String menuSortingMethods;

    SortingMethodsType(final String menuSortingMethods){
        this.menuSortingMethods = menuSortingMethods;
    }
}
