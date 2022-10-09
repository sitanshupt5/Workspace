package com.revolver;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* Write a program to remove all the duplicates from a String and print only the unique characters.
* */

public class Question10 {

    public static void main(String[] args){
        String word = "aijef13459anakdjvkajsfvbahsdbvlhrkvdvbbk";
        char[] array = word.toCharArray();
        Set<Character> chars = new HashSet<>();

        for(int i=0;i<array.length;  i++)
        {
            chars.add(array[i]);
        }


        chars.stream().forEach(System.out::print);



    }
}
