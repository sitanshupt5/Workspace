package com.revolver;

/*
* Write a Java Program to reverse a string without using String inbuilt function reverse()
* */

public class Question11 {
    public static void main(String[] args)
    {
        String name = "sitanshu";
        System.out.println(reverse(name));
    }

    public static String reverse(String value){
        if (value==null||value.isEmpty())
            return value;
        return value.charAt(value.length()-1)+reverse(value.substring(0, value.length()-1));
    }
}
