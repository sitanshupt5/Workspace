package com.revolver;

import java.util.*;

public class Question30 {

    public static void main(String[] args){
        Map<String, Integer> marks = new TreeMap<>();
        marks.put("Gargee", 90);
        marks.put("Sitanshu", 90);
        marks.put("Bhagyashree", 85);
        marks.put("Monali", 85);
        marks.put("Gargee", 90);



        Iterator it = marks.entrySet().iterator();

        while(it.hasNext())
        {
            Map.Entry<String, Integer> mp = (Map.Entry)it.next();
            System.out.print(mp.getKey()+": ");
            System.out.println(mp.getValue());
        }
    }
}
