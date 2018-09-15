package com.company.zoo;

public enum SexType {
    FEMALE(Texts.FEMALE),
    MALE(Texts.MALE);

    public final String printableSex;

    SexType(final String printableSex) {
        this.printableSex = printableSex;
    }
}
