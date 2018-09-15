package com.company.zoo;

import static com.company.zoo.Texts.*;

public enum AnimalType {
    ELEPHANT(ELEPHANT_NAME, 4000f, 110f, 70) {
        @Override
        public Animal getNewAnimal(final SexType sex, final int age, final float weight, final boolean pregnant) {
            return new Elephant(this, sex, age, weight, pregnant);
        }
    },
    SNAKE(SNAKE_NAME, 10f, 0.5f, 30) {
        @Override
        public Animal getNewAnimal(final SexType sex, final int age, final float weight, final boolean pregnant) {
            return new Snake(this, sex, age, weight, pregnant);
        }
    },
    DOG(DOG_NAME, 10f, 0.5f, 13) {
        @Override
        public Animal getNewAnimal(final SexType sex, final int age, final float weight, final boolean pregnant) {
            return new Dog(this, sex, age, weight, pregnant);
        }
    },
    FISH(FISH_NAME, 0.1f, 0.01f, 3) {
        @Override
        public Animal getNewAnimal(final SexType sex, final int age, final float weight, final boolean pregnant) {
            return new Fish(this, sex, age, weight, pregnant);
        }
    },
    OCTOPUS(OCTOPUS_NAME, 15f, 0.5f, 5) {
        @Override
        public Animal getNewAnimal(final SexType sex, final int age, final float weight, final boolean pregnant) {
            return new Octopus(this, sex, age, weight, pregnant);
        }
    },
    STORK(STORK_NAME, 4f, 0.2f, 12) {
        @Override
        public Animal getNewAnimal(final SexType sex, final int age, final float weight, final boolean pregnant) {
            return new Stork(this, sex, age, weight, pregnant);
        }
    },
    OSTRICH(OSTRICH_NAME, 120f, 1.5f, 40) {
        @Override
        public Animal getNewAnimal(final SexType sex, final int age, final float weight, final boolean pregnant) {
            return new Ostrich(this, sex, age, weight, pregnant);
        }
    },
    TIGER(TIGER_NAME, 90f, 1f, 20) {
        @Override
        public Animal getNewAnimal(final SexType sex, final int age, final float weight, final boolean pregnant) {
            return new Tiger(this, sex, age, weight, pregnant);
        }
    };

    public final String typeName;
    public final float maxWeight;
    public final float minWeight;
    public final int maxAge;

    AnimalType(final String typeName, final float maxWeight, final float minWeight, final int maxAge) {
        this.typeName = typeName;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
        this.maxAge = maxAge;
    }

    public abstract Animal getNewAnimal(final SexType sex, final int age, final float weight, final boolean pregnant);
}
