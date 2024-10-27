package com.stepchenko.firsttask;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final int MAX_ATTEMPTS = 3;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;

    public void run() {
        startMainMenu();
    }

    private void startGame() {
        StringBuilder word = new StringBuilder(generateWord());
        String hint = Word.valueOf(word.toString()).getDescription();
        char[] tempWordArray = new char[word.length()];
        Arrays.fill(tempWordArray, '_');
        StringBuilder tempWord = new StringBuilder(String.valueOf(tempWordArray));

        int attempts = MAX_ATTEMPTS;

        System.out.println("You have three attempts to guess the word.");

        flag = true;
        while (flag) {
            System.out.println("Attempts: " + attempts);
            System.out.println(tempWord);
            System.out.println();
            System.out.println("HINT: " + hint);
            printPicture(attempts);
            System.out.println("Enter the letter:");

            char letter = scanner.next().charAt(0);
            int index;
            if (!word.toString().contains(Character.toString(letter).toUpperCase())) {
                attempts--;
            } else {
                do {
                    index = word.indexOf(Character.toString(letter).toUpperCase());
                    if(index > -1) {
                        word.setCharAt(index, '_');
                        tempWord.setCharAt(index, letter);
                    }
                } while (index != -1);
            }
            checkCurrentResult(tempWord, attempts);
        }
        System.out.println();
    }

    private void checkCurrentResult(StringBuilder tempWord, int attempts) {
        if (attempts == 0) {
            printPicture(attempts);
            System.out.println("You lost! What a pity!");
            System.out.println("Would you like to try again?");
            startFinishMenu();
        } else {
            if (!tempWord.toString().contains(Character.toString('_'))) {
                printPicture(attempts);
                System.out.println("You won! Congratulations!");
                System.out.println("Would you like to try again?");
                startFinishMenu();
            }
        }
    }

    private String generateWord() {
        List<Word> words = Arrays.asList(Word.values());
        return words.get(random.nextInt(words.size())).toString();
    }

    private void startMenuSelection() {
        while (flag) {
            String pointOfMenu = new Scanner(System.in).nextLine();
            switch (pointOfMenu) {
                case "1" -> startGame();
                case "2" -> {
                    System.out.println("Good luck!");
                    flag = false;
                }
                default -> {
                    System.out.println("Incorrect choice. Please try again!");
                    printMainMenu();
                }
            }
        }
    }

    private void startMainMenu() {
        System.out.println("Welcome to the hangman game!");
        System.out.println("Make your choice:");

        printMainMenu();
        startMenuSelection();
    }

    private void startFinishMenu() {
        printFinishMenu();
        startMenuSelection();
    }

    private void printMainMenu() {
        System.out.println("1. Start new game");
        System.out.println("2. Quit the game");
        System.out.println();
    }

    private static void printFinishMenu() {
        System.out.println("1. Start new game.");
        System.out.println("2. Quit the game.");
        System.out.println();
    }

    private void printPicture(int attempts) {
        switch (attempts) {
            case 0 -> System.out.println("""
                    ________
                    |       |
                    |       O
                    |      /\\
                    |      /\\
                    |
                    """);
            case 1 -> System.out.println("""
                    ________
                    |       |
                    |
                    |
                    |
                    |
                    """);
            case 2 -> System.out.println("""
                    ________
                    |
                    |
                    |
                    |
                    |
                    """);
            case 3 -> System.out.println("""
                    
                    |
                    |
                    |
                    |
                    |
                    """);
        }
    }
}