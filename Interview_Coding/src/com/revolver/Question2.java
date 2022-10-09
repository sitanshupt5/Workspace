package com.revolver;

import java.util.ArrayList;
import java.util.List;

/*Write java code to convert ArrayList to array.
* */
public class Question2 {

    public static void main(String[] args)
    {
        List<String> names = initArrayList();

        /*
        Object[] array = names.toArray();
        for(Object o:array)
        {
            System.out.println(o);
        }
        */

        String[] array = new String[names.size()];
        for(int i= 0; i<names.size(); i++)
        {
            array[i] = names.get(i);
        }

        for(String s:array)
        {
            System.out.println(s);
        }
    }

    public static List<String> initArrayList() {
        List<String> names = new ArrayList<>();
        names.add("Sitanshu");
        names.add("Snigdha");
        names.add("Subhransu");
        names.add("Suman");
        names.add("Smita");
        names.add("Sini");
        return names;
    }


}
