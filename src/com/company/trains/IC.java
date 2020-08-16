package com.company.trains;

public class IC extends Train {
    private final float ticketPrice;


    public IC() {
        this.cost = 1200;
        this.ticketPrice = (float) 2.00;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }
}
