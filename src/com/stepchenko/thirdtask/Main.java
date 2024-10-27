package com.stepchenko.thirdtask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        System.out.println("Enter the desired password length. Password must be from 8 to 12 symbols.");
        if(scanner.hasNextInt()) {
            System.out.println("Your password: " + passwordGenerator.getPassword(scanner.nextInt()));
        } else {
            System.out.println("You entered the incorrect password length. Restart the program and try again.");
        }
    }
}