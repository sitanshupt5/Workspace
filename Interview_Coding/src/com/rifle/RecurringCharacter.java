package com.rifle;

import java.util.ArrayList;
import java.util.List;

public class RecurringCharacter {

    public static void main(String[] args)
    {
        String s = "sjvkjnjnksv";
        System.out.println("4th recurring character of the String is: "+nthRecurringChar(4, s));
    }

    public static Character nthRecurringChar(Integer number,String value){
        int count = 1;
        List<Character> list = new ArrayList<>();
        int i=0;
        while(i<value.length()){
            list.add(value.charAt(i));
            i++;
        }

        for (i=0; i< value.length(); i++)
        {
            char x = list.get(i);
            int num = 0;
            for (int j=i+1;j<list.size();j++)
            {
                if(list.get(j)==x) {
                    if (count == number) {
                        return x;
                    } else {
                        list.remove(j);
                        num++;
                    }
                }
            }
            if(num>0)
                count++;

        }
        return null;
    }
}
