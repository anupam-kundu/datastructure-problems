package com.ds.general;

import java.util.*;

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
        digits.put("twenty", 20);
        digits.put("thirty", 30);
        digits.put("forty", 40);
        digits.put("fifty", 50);
        digits.put("sixty", 60);
        digits.put("seventy", 70);
        digits.put("eighty", 80);
        digits.put("ninety", 90);
    }

    private Map<String, Long> multiplier = new HashMap<>();
    {
        multiplier.put("hundred", 100L);
        multiplier.put("thousand", 1000L);
        multiplier.put("lac", 100000L);
        multiplier.put("million", 1000000L);
        multiplier.put("billion", 1000000000L);
        multiplier.put("trillion", 1000000000000L);
    }
    public void word2number(String input) {
        boolean isValidInput = true;
        long result = 0;
        long finalResult = 0;
        List<String> allowedStrings = Arrays.asList
                (
                        "zero","one","two","three","four","five","six","seven",
                        "eight","nine","ten","eleven","twelve","thirteen","fourteen",
                        "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
                        "thirty","forty","fifty","sixty","seventy","eighty","ninety",
                        "hundred","thousand","million","billion","trillion"
                );

//        String input="One hundred two thousand and thirty four";

        if(input != null && input.length()> 0)
        {
            input = input.replaceAll("-", " ");
            input = input.toLowerCase().replaceAll(" and", " ");
            String[] splittedParts = input.trim().split("\\s+");

            for(String str : splittedParts)
            {
                if(!allowedStrings.contains(str))
                {
                    isValidInput = false;
                    System.out.println("Invalid word found : "+str);
                    break;
                }
            }
            if(isValidInput)
            {
                for(String str : splittedParts)
                {
                    if(digits.containsKey(str)) {
                        result += digits.get(str);
                    }
                    else if(str.equalsIgnoreCase("hundred")) {
                        result *= 100;  // because hundred can come in million / billion s
                    }
                    else if(multiplier.containsKey(str)) {
                        result *= multiplier.get(str);
                        finalResult += result;
                        result=0;
                    }
                }

                finalResult += result;
                result=0;
                System.out.println(finalResult);
            }
        }
    }
    public static void main(String[] args) {
        Word2Number obj = new Word2Number();
        obj.word2number("three thousand two hundred forty seven");
        obj.word2number("fifteen million twenty five thousand three hundred forty seven");
        obj.word2number("Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven");
    }
}
