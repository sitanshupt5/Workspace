package com.revolver;

/*
* Given an element write a program to check if element exists in HashSet
* */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question5 {
    public static void main(String[] args)
    {
        Set<String> names = Question3.initHashSet();
        System.out.println("Enter element to be searched in the hashset:");
        Scanner scan = new Scanner(System.in);
        String element = scan.nextLine();

        /*
        Boolean flag = false;
        for (String s:names)
        {
            if (s.equals(element))
            {
                System.out.println("Element exists in the hashset");
                flag = true;
            }
        }
        if (!flag)
            System.out.println("Element does not exist in the hashset");
        */

        if (names.contains(element))
            System.out.println("Element exists in the hashset");
        else
            System.out.println("Element does not exist in the hashset");
    }
}
