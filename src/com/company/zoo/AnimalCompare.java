package com.company.zoo;
import java.util.Comparator;

public class AnimalCompare implements Comparator<Animal>{

        @Override
        public int compareAge(Animal animal_1, Animal animal_2) {
            if(animal_2 == null) return -1;
            if(animal_1.getAge() > animal_2.getAge()) return 1;
            else if(animal_1.getAge() < animal_2.getAge()) return -1;
            else return 0;
        }
}
