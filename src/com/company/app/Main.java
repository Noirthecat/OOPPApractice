package com.company.app;


import com.company.animal.Animal;
import com.company.animal.Cat;
import com.company.animal.Hamster;
import com.company.animal.Spider;
import com.company.katy.Kati;

import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Kati kati = new Kati();
        kati.addAnimal(new Hamster("Hami"));
        kati.addAnimal(new Hamster("Lali"));
        kati.addAnimal(new Hamster("Hali"));
        kati.addAnimal(new Cat("Moni"));
        kati.addAnimal(new Cat("Fluffy"));
        kati.addAnimal(new Cat("Duffy"));
        kati.addAnimal(new Spider("Spoder"));
        kati.addAnimal(new Spider("Nono"));
        kati.addAnimal(new Spider("Kolo"));


        for (int i = 0; i < 3; i++) {
            kati.getTodaysMood();
            kati.careForAnimal();
        }
        for (Animal animal : kati.getAnimals()) {
            if (animal.isAlive()){
                System.out.println(animal.getHealth());
            }else if(!animal.isAlive()){
                System.out.println("animal is dead");
            }
        }
        System.out.println(kati.getAnimalWithSmallestHealth());
        System.out.println(Collections.min(kati.getAnimals(), Comparator.comparing(Animal::getHealth)));

    }
}
