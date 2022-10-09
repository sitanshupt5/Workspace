package com.revolver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question33 {
    public static void main(String[] args){
        String word = "AABBBC";
        char[] chars = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c:chars)
        {
            if(map.containsKey(c))
            {
                map.put(c,map.get(c)+1);
            }
            else
            {
                map.put(c, 1);
            }
        }

        Iterator it = map.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry mp = (Map.Entry)it.next();
            System.out.print(mp.getValue());
            System.out.print(mp.getKey());
        }
    }
}
