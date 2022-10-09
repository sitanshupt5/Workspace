package com.revolver;

/*
* Write a program to iterate the HashMap
 * */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question6 {
    public static void main(String[] args)
    {
        Map<Integer, String> students = Question7.initHashMap();

        Iterator iterator = students.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry mp = (Map.Entry)iterator.next();
            System.out.print(mp.getKey()+": ");
            System.out.println(mp.getValue());
        }
    }
}
