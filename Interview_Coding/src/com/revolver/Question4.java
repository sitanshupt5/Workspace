package com.revolver;

/*
* Given an element write a program to check if element(value) exists in ArrayList
* */

import java.util.List;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args)
    {
        List<String> names = Question2.initArrayList();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter element to be searched in the arraylist:");
        String element = scan.nextLine();

        /*
        Boolean flag = false;
        for(String s:names)
        {
            if(s.equals(element)) {
                System.out.println("Element exists in the arraylist");
            }
        }
        if(!flag)
            System.out.println("Element does not exist in arraylist");
        */

        if(names.contains(element))
            System.out.println("Element exists in the arrayList");
        else
            System.out.println("Element does not exist in arrayList");
    }
}
