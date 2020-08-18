package com.company.katy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Mood {
    HAPPY,
    AVERAGE,
    SAD;

    private static final List<Mood> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Mood getRandomMood() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
