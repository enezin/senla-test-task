package com.stepchenko.secondtask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Exchanger exchanger = new Exchanger();
        Scanner scanner = new Scanner(System.in);
        double sumOfMoney;

        System.out.println("Enter the desired amount to get conversion information:");
        if (scanner.hasNextDouble()) {
            sumOfMoney = scanner.nextDouble();
            System.out.println(exchanger.getConversionInformation(sumOfMoney));
        } else {
            System.out.println("You entered the incorrect number, restart the program and try again.");
        }
    }
}