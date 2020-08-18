package com.company.animal;

public abstract class Animal implements Comparable<Animal> {
    protected String name;
    protected int health = 70;
    protected boolean alive = true;

    public Animal(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (this.health + health > 0) {
            this.health = this.health + health;
        }else{
            this.alive = false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", health=" + health;
    }

    @Override
    public int compareTo(Animal comparestu) {
        int compareage=((Animal)comparestu).getHealth();
        return this.health-compareage;

    }
}
