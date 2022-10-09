package com.revolver;

import java.util.ArrayList;
import java.util.List;

/* Write Java code to traverse through an ArrayList.
* */

public class Question1 {

    public static void main(String[] args)
    {
        List<String> names= Question2.initArrayList();

        for(String s:names)
        {
            System.out.println(s);
        }
    }
}
