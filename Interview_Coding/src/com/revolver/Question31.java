package com.revolver;

public class Question31 {

    public static void main(String[] args)
    {
        String sentence = "my name is sitanshu";
        String[] words = sentence.split(" ");

        for(int i = 0; i<words.length ;i++){
            System.out.print(reverse(words[i])+ " ");
        }
    }

    private static String reverse(String word) {
        if(word==null||word.isEmpty())
            return word;
        return word.charAt(word.length()-1)+reverse(word.substring(0,word.length()-1));
    }
}
