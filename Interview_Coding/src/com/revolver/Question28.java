package com.revolver;

import java.util.*;

public class Question28 {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("M", 98);
        map.put("A", 85);
        map.put("E", 91);
        map.put("J", 95);
        map.put("O", 79);
        map.put("N", 80);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        /*Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });*/

        Collections.sort(list, ((o1, o2) -> o1.getValue().compareTo(o2.getValue())));

        for (Map.Entry<String, Integer> line : list) {
            System.out.print("Key: " + line.getKey() + ", ");
            System.out.println("Value: "+line.getValue());
        }
    }
}
