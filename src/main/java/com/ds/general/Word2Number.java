package com.ds.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ten Thousand => 10,000
 * five million => 5,000,000
 * fifteen million twenty five thousand => 15,025,000
 */
public class Word2Number {
    private Map<String, Integer> digits = new HashMap<>();
    {
        digits.put("one", 1);
        digits.put("two", 2);
        digits.put("three", 3);
        digits.put("four", 4);
        digits.put("five", 5);
        digits.put("six", 6);
        digits.put("seven", 7);
        digits.put("eight", 8);
        digits.put("nine", 9);
        digits.put("ten", 10);
        digits.put("eleven", 11);
        digits.put("twelve", 12);
        digits.put("thirteen", 13);
        digits.put("fourteen", 14);
        digits.put("fifteen", 15);
        digits.put("sixteen", 16);
        digits.put("seventeen", 17);
        digits.put("eighteen", 18);
        digits.put("nineteen", 19);
    }

    private Map<String, Integer> multiplier = new HashMap<>();
    {
        multiplier.put("ten", 10);
        multiplier.put("twenty", 20);
        multiplier.put("thirty", 30);
        multiplier.put("forty", 40);
        multiplier.put("fifty", 50);
        multiplier.put("sixty", 60);
        multiplier.put("seventy", 70);
        multiplier.put("eighty", 80);
        multiplier.put("ninety", 90);
        multiplier.put("hundred", 100);
        multiplier.put("thousand", 1000);
        multiplier.put("lac", 100000);
        multiplier.put("million", 1000000);
        multiplier.put("billion", 1000000000);
    }
    public void word2number(String word) {
        int currentNumber = 0;
        List<Integer> calculatedNumbers = new ArrayList<>();
        boolean isDigit = false;
        String [] splits = word.split(" ");
        for(int i = 0; i< splits.length;i++ ){
            String currentWord = splits[i].toLowerCase();
            if(digits.containsKey(currentWord)) {
                currentNumber += digits.get(currentWord);
                isDigit = true;
            } else if (multiplier.containsKey(currentWord)) {
                currentNumber = currentNumber == 0 ? multiplier.get(currentWord) : currentNumber *  multiplier.get(currentWord);
                if(isDigit) { // multiplier after digit , so move to calculated number
                    calculatedNumbers.add(currentNumber);
                    currentNumber = 0;
                }
                isDigit = false;
            } else {
                throw new RuntimeException("perser not found for : "+currentWord);
            }
            System.out.println("Current Iteration, word: " + currentWord + " number: " + currentNumber + " calculated: " + calculatedNumbers);
        }
        if(currentNumber > 0) {
            calculatedNumbers.add(currentNumber);
            currentNumber = 0;
        }
        System.out.println(calculatedNumbers);
        int result = 0;
        for(int i =0; i< calculatedNumbers.size() ; i++) {
            result += calculatedNumbers.get(i);
        }
        System.out.println("Result : " + result);
    }
    public static void main(String[] args) {
        Word2Number obj = new Word2Number();
        obj.word2number("fifteen million twenty five thousand three hundred forty seven");
    }
}
