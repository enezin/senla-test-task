package com.stepchenko.secondtask;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exchanger {

    private static final BigDecimal USD = BigDecimal.valueOf(3.275);    // American dollar
    private static final BigDecimal EUR = BigDecimal.valueOf(3.59);     // Euro
    private static final BigDecimal RUB = BigDecimal.valueOf(0.0342);   // Russian ruble
    private static final BigDecimal CNY = BigDecimal.valueOf(0.4744);   // Chinese yuan
    private static final BigDecimal GBP = BigDecimal.valueOf(4.0);      // Pound sterling

    public String getConversionInformation(double sumOfMoney) {
        if (sumOfMoney < 0) {
            return "You entered the incorrect number, restart the program and try again.";
        } else if (sumOfMoney == 0) {
            return "USD - " + sumOfMoney + "\n" +
                   "EUR - " + sumOfMoney + "\n" +
                   "RUB - " + sumOfMoney + "\n" +
                   "CNY - " + sumOfMoney + "\n" +
                   "GBP - " + sumOfMoney;
        }
        return "USD - " + toExchangeMoneyToUsd(sumOfMoney) + "\n" +
               "EUR - " + toExchangeMoneyToEuro(sumOfMoney) + "\n" +
               "RUB - " + toExchangeMoneyToRub(sumOfMoney) + "\n" +
               "CNY - " + toExchangeMoneyToCny(sumOfMoney) + "\n" +
               "GBP - " + toExchangeMoneyToGbp(sumOfMoney);
    }

    private BigDecimal toExchangeMoneyToUsd(double sumOfMoney) {
        return BigDecimal.valueOf(sumOfMoney).divide(USD, 2, RoundingMode.DOWN);
    }

    private BigDecimal toExchangeMoneyToEuro(double sumOfMoney) {
        return BigDecimal.valueOf(sumOfMoney).divide(EUR, 2, RoundingMode.DOWN);
    }

    private BigDecimal toExchangeMoneyToRub(double sumOfMoney) {
        return BigDecimal.valueOf(sumOfMoney).divide(RUB, 2, RoundingMode.DOWN);
    }

    private BigDecimal toExchangeMoneyToCny(double sumOfMoney) {
        return BigDecimal.valueOf(sumOfMoney).divide(CNY, 2, RoundingMode.DOWN);
    }

    private BigDecimal toExchangeMoneyToGbp(double sumOfMoney) {
        return BigDecimal.valueOf(sumOfMoney).divide(GBP, 2, RoundingMode.DOWN);
    }
}