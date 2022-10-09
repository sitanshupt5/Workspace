package com.revolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question26 {

    public static void main(String[] args)
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(5,4,8,6,9,1,2,6,9,4));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(6,4,5,9));
        System.out.println(arrange(list1, list2));
    }

    public static List<Integer> arrange(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        List<Integer> output = new ArrayList<>();
        list1.sort((o1, o2) -> o1.compareTo(o2));
        list1.forEach(System.out::print);
        System.out.println();
        for (int num:list2)
        {
            int i=0;
            for (; i<list1.size(); i++)
            {
                if(list1.get(i)==num)
                {
                    output.add(num);
                    list1.remove(i);
                    i--;
                }
            }
        }
        for (int num:list2)
        {
            if(!list1.isEmpty())
            {
                for (int i=0; i<list1.size();i++)
                {
                    if(list1.get(i)!=num)
                    {
                        output.add(list1.get(i));
                        list1.remove(i);
                        i--;
                    }
                }
            }
        }
        return output;
    }
}
