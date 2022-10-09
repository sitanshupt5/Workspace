package com.rifle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DuplicateWords {

    public static void main(String args[])
    {
        String sentence = "This is a duplicate words string of duplicate words";
        String[] words =sentence.split(" ");
        Map<String, Integer> wc = new HashMap<>();
        for (String s:words)
        {
            if(wc.containsKey(s))
            {
                wc.replace(s,wc.get(s)+1);
            }
            else
            {
                wc.put(s, 1);
            }

        }

        Iterator iterator =wc.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry mp =(Map.Entry)iterator.next();
            System.out.print(mp.getKey()+": ");
            System.out.println(mp.getValue());
        }
    }
}
