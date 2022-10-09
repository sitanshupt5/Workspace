package com.revolver;


/*
* Write a program to count the number of occurrences of each word in a String.
* */

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Question12 {
    public static void main(String[] args)
    {
        String sentence = "this is a duplicate string containing duplicate words";
        String[] words = sentence.split(" ");
        Map<String, Integer> wordMap = new TreeMap<>();

        for (String s:words) {
            if (wordMap.containsKey(s))
                wordMap.put(s, wordMap.get(s) + 1);
            else
                wordMap.put(s, 1);
        }

        wordMap.forEach((word, count)->{
            System.out.print(word);
            System.out.println("="+count);
        });
    }
}
