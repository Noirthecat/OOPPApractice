package com.company.trains;

public class IC extends Train {
    private final float ticketPrice;
    private final int COST;

    public IC() {
        this.COST = 1200;
        this.ticketPrice = (float) 2.00;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public int getCost() {
        return COST;
    }
}
