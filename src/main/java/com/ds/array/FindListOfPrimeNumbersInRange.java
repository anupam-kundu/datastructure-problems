package com.ds.array;

import java.util.Arrays;

/**
 * remove all factors of prime numbers from a number list to get list of prime number
 *
 * complexity O(n)
 */
public class FindListOfPrimeNumbersInRange {

    private boolean[] generateListOfPrimeNumbers(int max) { // O(n)
        boolean[] primeNumbersList = new boolean[max];
        Arrays.fill(primeNumbersList, true);
        int primeNumber = 2;

        while (primeNumber <= Math.sqrt(max)) { // O( sqrt(n))
            flipArray(primeNumbersList, primeNumber);
            primeNumber = getNextPrimeNumber(primeNumbersList, primeNumber);
        }
        return primeNumbersList;
    }

    private int getNextPrimeNumber(boolean[] primeNumbersList, int primeNumber) { // O(sqrt(n))
        int nextPrime = primeNumber + 1;
        while (nextPrime < primeNumbersList.length && !primeNumbersList[nextPrime]) {
            nextPrime++;
        }
        return nextPrime;
    }

    private void flipArray(boolean[] primeNumbersList, int primeNumber) { // O(sqrt(n))
        for (int i = primeNumber * primeNumber; i < primeNumbersList.length; i += primeNumber) {
            primeNumbersList[i] = false;
        }
    }
}
