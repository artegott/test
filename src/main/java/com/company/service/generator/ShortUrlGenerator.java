package com.company.service.generator;

import java.util.Random;

public class ShortUrlGenerator {
    private static final short DEFAULT_SIZE = 4;
    private static final String DEFAULT_LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private short size;
    private String letters;

    public ShortUrlGenerator() {
        letters = DEFAULT_LETTERS;
        size = DEFAULT_SIZE;
    }

    public ShortUrlGenerator(String letters, short size) {
        this.letters = letters;
        this.size = size;
    }

    public String generate() {
        char[] result = new char[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = letters.charAt(random.nextInt(letters.length()));
        }
        return "s/" + new String(result);
    }
}
