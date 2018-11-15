package com.company.zoo;

import static com.company.zoo.Texts.*;

public enum AnimalType {
    ELEPHANT(ELEPHANT_NAME, 4000f, 110f, 70) {
        @Override
        public Animal getNewAnimal() {
            return new Elephant(this);
        }
        @Override
        public Animal getNewAnimal(int age) {
            return new Elephant(this, age);
        }
    },
    SNAKE(SNAKE_NAME, 10f, 0.5f, 30) {
        @Override
        public Animal getNewAnimal() {
            return new Snake(this);
        }
        @Override
        public Animal getNewAnimal(int age) {
            return new Snake(this, age);
        }
    },
    DOG(DOG_NAME, 10f, 0.5f, 13) {
        @Override
        public Animal getNewAnimal() {
            return new Dog(this);
        }
        @Override
        public Animal getNewAnimal(int age) {
            return new Dog(this, age);
        }
    },
    FISH(FISH_NAME, 0.1f, 0.01f, 3) {
        @Override
        public Animal getNewAnimal() {
            return new Fish(this);
        }

        @Override
        public Animal getNewAnimal(int age) {
            return new Fish(this, age);
        }
    },
    OCTOPUS(OCTOPUS_NAME, 15f, 0.5f, 5) {
        @Override
        public Animal getNewAnimal() {
            return new Octopus(this);
        }

        @Override
        public Animal getNewAnimal(int age) {
            return new Octopus(this, age);
        }
    },
    STORK(STORK_NAME, 4f, 0.2f, 12) {
        @Override
        public Animal getNewAnimal() {
            return new Stork(this);
        }

        @Override
        public Animal getNewAnimal(int age) {
            return new Stork(this, age);
        }
    },
    OSTRICH(OSTRICH_NAME, 120f, 1.5f, 40) {
        @Override
        public Animal getNewAnimal() {
            return new Ostrich(this);
        }

        @Override
        public Animal getNewAnimal(int age) {
            return new Ostrich(this, age);
        }
    },
    TIGER(TIGER_NAME, 90f, 1f, 20) {
        @Override
        public Animal getNewAnimal() {
            return new Tiger(this);
        }

        @Override
        public Animal getNewAnimal(int age) {
            return new Tiger(this, age);
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

    public abstract Animal getNewAnimal();

    public abstract Animal getNewAnimal(int age);
}
