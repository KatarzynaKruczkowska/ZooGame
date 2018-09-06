package com.company.zoo;

public enum SexType {
    FEMALE(Texts.FEMALE, 0),
    MALE(Texts.MALE, 1);

    public final String printableSex;
    public final int intValueSex;

    SexType(final String printableSex, final int intValueSex) {
        this.printableSex = printableSex;
        this.intValueSex = intValueSex;
    }
}
