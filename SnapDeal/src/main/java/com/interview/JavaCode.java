package com.interview;

public class JavaCode {

    public static void main(String args[])
    {
        String s1 = "caat";
        String s2 = "aact";
        // s2=aat
        //at
        //t


    }

    public void isAnagram(String s1, String s2){
        if (s1.length()!=s2.length())
        {
            System.out.println("Strings are not anagram of each other");
        }
        else{
            char[] array = s1.toCharArray();
            String other = s2;
            for (int i=0;i< array.length; i++){
                if(s2.contains(String.valueOf(array[i]))){
                    other = s2.substring(0,s2.indexOf(array[i]))+s2.substring(s2.indexOf(array[i+1]),s2.length());
                    System.out.println(other);
                }
                if (other==null)
                    System.out.println("Strings are anagram");
            }
        }
    }
}
