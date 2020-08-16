package com.company.trains;

public class Freight extends Train {
    private float monthlyRevenue;
    private final int COST;

    public Freight() {
        this.COST = 1000;
        this.monthlyRevenue = 550;
    }


    @Override
    public int getCost() {
        return COST;
    }
}
