package com.revolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/*
* Write a program to find the 3rd highest number in an array using lambda expressions and stream api.
* */

public class Question9 {

    public static void main(String[] args) {
        int[] array = {6, 5, 4, 3, 2, 1};
        List<Integer> numbers = new ArrayList<>();
        for (int a : array) {
            numbers.add(a);
        }

        /*numbers.stream()
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                }.reversed())
                .distinct()
                .limit(3)
                .skip(2)
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer);
                    }
                });
        */
        numbers.stream()
                .sorted(Collections.reverseOrder())
                .distinct()
                .limit(3)
                .skip(2)
                .forEach(integer -> System.out.println("Third Highest number is "+integer));

    }
}
