package com.revolver;

import java.util.HashMap;
import java.util.Map;

/*
* Given a String "IIINNDDDIINNNNAAA". Print the total occurences of each individual character where they occur
* consecutively more than or equal to 3 times. Example in the above string the character 'I' occurs twice in consecutive. First
* time it occurs 3 times consecutively,Second time it occurs only twice consecutively. Hence, we have to ignore
* the second sequence. Likewise the output should be printed in the following format:
* A=3
* D=3
* I=3
* N=4
* */

public class Question27 {
    public static void main(String[] args)
    {
        String word = "IIINNDDDIINNNNAAA";
        char[] array = word.toCharArray();
        Map<Character, Integer> letters= new HashMap<>();
        for (int i= 0; i<array.length; i++)
        {
            char c = array[i];
            if(i==0)
            {
                if(array[i+1]==c&&array[i+2]==c){
                    if(letters.containsKey(c))
                        letters.put(c, letters.get(c)+1);
                    else
                        letters.put(c,1);
                }
            }
            else if(i==1)
            {
                if (array[i-1]==c&&array[i+1]==c){
                    if(letters.containsKey(c))
                        letters.put(c, letters.get(c)+1);
                    else
                        letters.put(c,1);
                }
            }
            else if(i>1 && i<=array.length-2)
            {
                if ((array[i-1]==c&&array[i+1]==c)||(array[i-2]==c&&array[i-1]==c)||(array[i+1]==c&&array[i+2]==c)){
                    if(letters.containsKey(c))
                        letters.put(c, letters.get(c)+1);
                    else
                        letters.put(c,1);
                }
            }
            else if(i==array.length-1)
            {
                if(array[i-2]==c&&array[i-1]==c){
                    if(letters.containsKey(c))
                        letters.put(c, letters.get(c)+1);
                    else
                        letters.put(c,1);
                }
            }
            else
            {
                if(array[i-2]==c&&array[i-1]==c){
                    if(letters.containsKey(c))
                        letters.put(c, letters.get(c)+1);
                    else
                        letters.put(c,1);
                }
            }
        }
        letters.forEach((key,value)->{
            System.out.print(key+"=");
            System.out.println(value);
        });
    }
}
