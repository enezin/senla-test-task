package com.stepchenko.thirdtask;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 12;
    private static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "1234567890";
    private static final String SPECIAL_SYMBOLS = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final String ALL_TYPES = LOWERCASE_ALPHABET + UPPERCASE_ALPHABET + NUMBERS + SPECIAL_SYMBOLS;
    private final Random random = new Random();

    public String getPassword(int length) {
        if (length < MIN_PASSWORD_LENGTH || length > MAX_PASSWORD_LENGTH) {
            return "You entered the incorrect password length. Restart the program and try again.";
        }
        String password;
        char[] symbols = new char[length];
        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = getRandomSymbol(LOWERCASE_ALPHABET);
            i++;
            symbols[i] = getRandomSymbol(UPPERCASE_ALPHABET);
            i++;
            symbols[i] = getRandomSymbol(NUMBERS);
            i++;
            symbols[i] = getRandomSymbol(SPECIAL_SYMBOLS);
            i++;
            for (int j = i; j < symbols.length; j++) {
                symbols[i] = getRandomSymbol(ALL_TYPES);
                i++;
            }
        }
        password = new String(symbols);
        return shuffleSymbols(password);
    }

    private String shuffleSymbols(String prePassword) {
        List<String> symbols = Arrays.asList(prePassword.split(""));
        Collections.shuffle(symbols);
        StringBuilder stringBuilder = new StringBuilder(symbols.size());
        for (int i = 0; i < prePassword.length(); i++) {
            stringBuilder.append(symbols.get(i));
        }
        return stringBuilder.toString();
    }

    private char getRandomSymbol(String type) {
        return type.charAt(random.nextInt(type.length()));
    }
}