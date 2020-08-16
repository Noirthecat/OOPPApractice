package com.company.trains;

public class Passenger extends Train {
    private final float ticketPrice;
    private final int COST;

    public Passenger() {
        this.COST = 1000;
        this.ticketPrice = (float) 1.50;
    }

    public float getTicketPrice(){
        return ticketPrice;
    }

    @Override
    public int getCost() {
        return COST;
    }
}
