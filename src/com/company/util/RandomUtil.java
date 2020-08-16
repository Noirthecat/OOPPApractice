package com.company.util;

import java.util.Random;

public class RandomUtil {
    public static final Random RANDOM = new Random();

    public static int generateRandomNumberBetween(int Min, int Max){
         return (Min ) + (int)(Math.random()* ( Max - Min + 1));
    }
}
