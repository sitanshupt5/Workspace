package com.pistol;

import java.util.*;

public class SortMap {
     public static void main(String[] args){
         HashMap<String, String> names = new HashMap<>();
          names.put("Abhishek","Dash");
          names.put("Sitanshu","Pati");
          names.put("Subhransu","Nayak");
          names.put("Debasish","Diptiranjan");
          names.put("Chandan", "Sahu");
          names.put("Suman","Pani");

         System.out.println("Before Sorting:\n");
         Set set = names.entrySet();
         Iterator iterator = set.iterator();
         while (iterator.hasNext())
         {
             Map.Entry pair = (Map.Entry)iterator.next();
             System.out.print(pair.getKey()+":");
             System.out.println(pair.getValue());
         }

         Map<String, String> map = new TreeMap<>(names);
         System.out.println("\nAfter Sorting:\n");
         Set set2 = map.entrySet();
         Iterator iterator1 = set2.iterator();
         while (iterator1.hasNext())
         {
             Map.Entry pair2 = (Map.Entry)iterator1.next();
             System.out.print(pair2.getKey()+":");
             System.out.println(pair2.getValue());
         }

     }
}
