package com.explosives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Streams1 {

    /*
    * In this section we aim to extract strings from a list based on certain criteria and
    * then sort the strings and print them.
    * Lets see how we can do that.
    * */

    public static void main(String[] args)
    {
        List<String> bingoNumbers = Arrays.asList(
                "N40","N36",
                "B12", "B6",
                "G53","G56","G60", "G48", "g62",
                "I26", "I17", "I29",
                "O2");

        List<String> gNumbers = new ArrayList<>();

        bingoNumbers.forEach(number ->{
            if(number.toUpperCase().startsWith("G"))
                gNumbers.add(number);
        });

        gNumbers.sort((s1,s2) ->s1.compareTo(s2));
        gNumbers.forEach(s-> System.out.println(s));
    }

    /*
    * In the above example:
    * We are extracting strings starting with 'G' from a list and then sort the strings and
    * printing them. In order to do that we store the elements in the list starting with 'G' into
    * another list. Then we sort the list and print it.
    * Lets go step by step.
    *
    * First we are extracting all element from a list starting with G.
    * We do this using the forEach() method with lambda expression for the Consumer interface.
    * Now the challenge is the forEach() method only operates on one element at time.
    * So we declare the new list outside the lambda expression and then use it.
    * As we know if we intend to use a variable declared outside a lambda within it, then the
    * variable has to be effectively final.
    * In this case we changing the contents of our gNumber List but the object reference stored
    * in the gNumber variable doesn't change so it is effectively final.
    *
    * Second we sort the list we created using a lambda expression for the compareTo() method of
    * the Comparator interface.
    *
    * Third we print the sorted gNumbers list using lambda for the Consumer interface in the
    * forEach() method.
    *
    * As we can see although the code is concise, we can still make it more concise to the point
    * it can be accommodated in one line.
    *
    * Let's try that in the next example.
    * */
}
