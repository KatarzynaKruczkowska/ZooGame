package com.company.zoo;

import static com.company.zoo.Texts.*;

public enum AnimalType {
    ELEPHANT(ELEPHANT_NAME, 4000f, 110f, 70, 614, 1) {
        @Override
        public Animal getNewAnimal() {
            return new Elephant(this);
        }
    },
    SNAKE(SNAKE_NAME, 10f, 0.5f, 30, 110, 10) {
        @Override
        public Animal getNewAnimal() {
            return new Snake(this);
        }
    },
    DOG(DOG_NAME, 10f, 0.5f, 13, 63, 4) {
        @Override
        public Animal getNewAnimal() {
            return new Dog(this);
        }
    },
    FISH(FISH_NAME, 0.1f, 0.01f, 3, 35, 30) {
        @Override
        public Animal getNewAnimal() {
            return new Fish(this);
        }
    },
    OCTOPUS(OCTOPUS_NAME, 15f, 0.5f, 5, 40, 100) {
        @Override
        public Animal getNewAnimal() {
            return new Octopus(this);
        }
    },
    STORK(STORK_NAME, 4f, 0.2f, 12, 33, 4) {
        @Override
        public Animal getNewAnimal() {
            return new Stork(this);
        }
    },
    OSTRICH(OSTRICH_NAME, 120f, 1.5f, 40, 41, 6) {
        @Override
        public Animal getNewAnimal() {
            return new Ostrich(this);
        }
    },
    TIGER(TIGER_NAME, 90f, 1f, 20, 105, 3) {
        @Override
        public Animal getNewAnimal() {
            return new Tiger(this);
        }
    };

    public final String typeName;
    public final float maxWeight;
    public final float minWeight;
    public final int maxAge;
    public final int maxPregnantDays;
    public final int maxCountOfChild;

    AnimalType(final String typeName, final float maxWeight, final float minWeight, final int maxAge, final int maxPregnantDays, final int maxCountOfChild) {
        this.typeName = typeName;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
        this.maxAge = maxAge;
        this.maxPregnantDays = maxPregnantDays;
        this.maxCountOfChild = maxCountOfChild;
    }

    public abstract Animal getNewAnimal();

}
