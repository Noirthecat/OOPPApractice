package com.company.katy;

import com.company.animal.Animal;
import com.company.animal.Cat;
import com.company.animal.Hamster;
import com.company.animal.Spider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kati {
    private List<Animal> animals = new ArrayList<>();
    private Mood mood;

    public void getTodaysMood() {
        this.mood = Mood.getRandomMood();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public Mood getMood() {
        return mood;
    }

    public void careForAnimal() {
        switch (getMood()) {
            case SAD, AVERAGE, HAPPY -> {
                takingCareOfAnimal(this.mood);
            }
        }
    }

    private void takingCareOfAnimal(Mood mood) {
            if (mood.equals(Mood.HAPPY)) {
                happyMood();
            } else if (mood.equals(Mood.AVERAGE)) {
                averageMood();
            } else {
                sadMood();
            }
        }


    private void averageMood() {
        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                animal.setHealth(3);
            } else if (animal instanceof Hamster) {
                animal.setHealth(-3);
            } else if (animal instanceof Spider) {
                animal.setHealth(-2);
            }
        }
    }

    private void sadMood() {
        for (Animal animal : animals) {
            if (mood.equals(Mood.SAD)) {
                if (animal instanceof Cat) {
                    animal.setHealth(-7);
                } else if (animal instanceof Hamster) {
                    animal.setHealth(-5);
                } else if (animal instanceof Spider) {
                    animal.setHealth(-3);
                }
            }
        }
    }

    private void happyMood() {
        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                animal.setHealth(3);
            } else if (animal instanceof Hamster) {
                animal.setHealth(2);
            } else if (animal instanceof Spider) {
                animal.setHealth(1);
            }
        }
    }

        public List<Animal> getAnimals() {
            return animals;
        }

        public List<Animal> getAnimalWithSmallestHealth(){
            List<Animal> smallestHealthAnimals = new ArrayList<>();
            Collections.sort(animals);
            int smallestHealth = animals.get(0).getHealth();
            for (int i = 0; i <animals.size() ; i++) {
                if(animals.get(i).getHealth() == smallestHealth){
                    smallestHealthAnimals.add(animals.get(i));
                }else{
                    break;
                }
            }
            return smallestHealthAnimals;
        }
}


