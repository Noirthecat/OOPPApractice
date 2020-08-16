package com.company.trains;

import java.util.UUID;

public abstract class Train {
    protected UUID id = UUID.randomUUID();
    protected int COST;

    public abstract int getCost();
}
