package com.rifle;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String to find whether a palindrome: \n");
        String value = scanner.nextLine();

        System.out.println("String "+value+" is a palindrome: "+isPalindrome(value));

        System.out.println("String "+value+" is a palindrome: "+ isPalindromeString(value));
    }

    public static Boolean isPalindrome(String s)
    {
        char[] values = s.toLowerCase().toCharArray();
        boolean flag = true;
        if(values.length%2==0)
        {
            for (int i=0,j= values.length;i<= values.length/2;i++,j--)
            {
                if(values[i]!=values[j-1]){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static String reverse(String input){
        if (input==null||input.isEmpty())
            return input;

        return input.charAt(input.length()-1)+reverse(input.substring(0,input.length()-1));
    }

    public static Boolean isPalindromeString(String text)
    {
        if (text.equals(reverse(text)))
            return true;
        else
            return false;
    }
}
