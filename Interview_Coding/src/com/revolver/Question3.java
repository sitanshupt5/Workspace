package com.revolver;

/*
* Write java code to traverse through a HashSet
* */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Question3 {
    public static void main(String[] args)
    {
        Set<String> names = initHashSet();

        /*
        Iterator<String> it =names.iterator();
        while(it.hasNext())
            System.out.println(it.next());
        */

        for(String s:names)
        {
            System.out.println(s);
        }
    }

    public static Set<String> initHashSet() {
        Set<String> names = new HashSet<>();
        names.add("Sitanshu");
        names.add("Snigdha");
        names.add("Subhransu");
        names.add("Suman");
        names.add("Smita");
        names.add("Sini");
        return names;
    }
}
