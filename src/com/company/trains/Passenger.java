package com.company.trains;

public class Passenger extends Train {
    private final float ticketPrice;

    public Passenger() {
        this.cost = 1000;
        this.ticketPrice = (float) 1.50;
    }

    public float getTicketPrice(){
        return ticketPrice;
    }

}
