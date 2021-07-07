package com.company.zoo;

import static com.company.zoo.Texts.*;

public enum YesNoType {
    YES(YES_TXT),
    NO(NO_TXT);

    public final String yesNoText;

    YesNoType (final String yesNoText){
        this.yesNoText = yesNoText;
    }
}
