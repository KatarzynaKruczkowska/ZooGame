package com.company.zoo;

import static com.company.zoo.Texts.*;

public enum YesNoType {
    YES(YES_TXT),
    NO(NO_TXT);

    public final String yesNoTekst;

    YesNoType (final String yesNoTekst){
        this.yesNoTekst = yesNoTekst;
    }
}
