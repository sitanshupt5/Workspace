package com.revolver;

/*
* Write a program to sort HashMap by keys
 * */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Question7 {
    public static void main(String[] args)
    {
        Map<Integer, String> students = initHashMap();

        System.out.println("Before Sorting:");
        Iterator iterator = students.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry mp = (Map.Entry)iterator.next();
            System.out.print(mp.getKey()+": ");
            System.out.println(mp.getValue());
        }

        Map<Integer, String> studentTree = new TreeMap<>(students);
        System.out.println("After Sorting");
        Iterator it = studentTree.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry tm = (Map.Entry)it.next();
            System.out.print(tm.getKey()+": ");
            System.out.println(tm.getValue());
        }
        
    }

    public static Map<Integer, String> initHashMap() {
        Map<Integer,String> students = new HashMap<>();
        students.put(3,"Sitanshu");
        students.put(8, "Suman");
        students.put(5,"Subhransu");
        students.put(2, "Snigdha");
        students.put(4, "Smita");
        students.put(7, "Sini");
        return students;
    }
}
