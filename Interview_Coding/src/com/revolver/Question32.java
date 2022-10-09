package com.revolver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question32 {

    public static void main(String[] args){
        String sentence = "this is a java program, here is java";
        String[] words = sentence.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String word:words)
        {
            if(map.containsKey(word))
            {
                map.put(word,map.get(word)+1);
            }
            else
                map.put(word,1);
        }

        Iterator it= map.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry mp = (Map.Entry)it.next();
            System.out.println(" ");
            System.out.print(mp.getKey()+": ");
            System.out.print(mp.getValue());
        }

    }
}
