package com.ds.divideAndConquer;

/**
 * 9^25 = (9*9^12)^2 = (9*9^6)^2^2 = 9*9^24
 */
public class Exponential {

    private double getExponential(int number, int exp) {
        if (exp == 0) {
            return 1.0;
        }
        double halfResult = getExponential(number, exp / 2);
        if (exp % 2 == 0) {
            return halfResult * halfResult;
        } else {
            return number * halfResult * halfResult;
        }
    }
}
