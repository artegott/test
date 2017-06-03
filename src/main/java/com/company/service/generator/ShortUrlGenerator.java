package com.company.service.generator;

import java.util.Random;

public class ShortUrlGenerator {
    private final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int SIZE = 4;

    public String generate() {
        char[] letters = new char[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            letters[i] = LETTERS.charAt(random.nextInt(LETTERS.length()));
        }
        return "s/" + new String(letters);
    }
}
