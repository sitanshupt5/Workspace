package com.rifle;

import java.util.*;

public class AllRecurringCharacters {

    public static void main(String[] args)
    {
        String s = "nicompoop";
        recurringCharacters(s);
    }

    public static void recurringCharacters(String value){
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> chars = new TreeMap<>();
        int i = 0;
        while(i<value.length())
        {
            list.add(value.charAt(i));
            i++;
        }

        /*for(i = 0; i<list.size(); i++)
        {
            char x = list.get(i);
            for (int j=i+1; j<list.size(); j++)
            {
                if(list.get(j)==x)
                {
                    if(chars.containsKey(x))
                    {
                        chars.put(x,chars.get(x)+1);
                        list.remove(j);
                    }
                    else
                        chars.put(x,1);
                }
            }
        }*/
        for(i = 0; i<list.size(); i++)
        {
            char x = list.get(i);
            if(chars.containsKey(x))
            {
                chars.put(x,chars.get(x)+1);
            }
            else
                chars.put(x,1);
        }



        Iterator iterator = chars.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry me = (Map.Entry)iterator.next();
            System.out.print(me.getKey()+"=");
            System.out.println(me.getValue());
        }
    }
}
