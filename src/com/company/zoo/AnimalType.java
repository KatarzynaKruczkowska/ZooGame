package com.company.zoo;

import static com.company.zoo.Texts.*;

public enum AnimalType {
    ELEPHANT(ELEPHANT_NAME, 4000f, 110f, 70),
    SNAKE(SNAKE_NAME, 10f, 0.5f, 30),
    DOG(DOG_NAME, 10f, 0.5f, 13),
    FISH(FISH_NAME, 0.1f, 0.01f, 3),
    OCTOPUS(OCTOPUS_NAME, 15f, 0.5f, 5),
    STORK(STORK_NAME, 4f, 0.2f, 12),
    OSTRICH(OSTRICH_NAME, 120f, 1.5f, 40),
    TIGER(TIGER_NAME, 90f, 1f, 20);

    public final String typeName;
    public final float maxWeight;
    public final float minWeight;
    public final int maxAge;

    AnimalType(final String typeName, final float maxWeihgt, final float minWeight, final int maxAge) {
        this.typeName = typeName;
        this.maxWeight = maxWeihgt;
        this.minWeight = minWeight;
        this.maxAge = maxAge;
    }
}
