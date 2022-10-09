package com.revolver;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Question29 {

    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M", 98);
        map.put("A", 85);
        map.put("E", 91);
        map.put("J", 95);
        map.put("O", 79);
        map.put("N", 80);

        map.entrySet().stream()
                .sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .forEach((line)->{
                    System.out.print("Key: " + line.getKey() + ", ");
                    System.out.println("Value: "+line.getValue());
                });
    }
}
