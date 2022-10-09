package com.revolver;


/*
* Write a program to count the number of occurrences of each word in a String and parse using Iterator interface.
* */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Question13 {
    public static void main(String[] args)
    {
        String sentence = "this is a duplicate string containing duplicate words";
        String[] words = sentence.split(" ");
        Map<String, Integer> wordMap = new HashMap<>();

        for (String s:words) {
            if (wordMap.containsKey(s))
                wordMap.put(s, wordMap.get(s) + 1);
            else
                wordMap.put(s, 1);
        }

        Iterator iterator = wordMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry mp = (Map.Entry) iterator.next();
            System.out.print(mp.getKey());
            System.out.println("="+mp.getValue());
        }
    }
}
