package com.explosives;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams5 {

    public static void main(String[] args)
    {
        List<String> bingoNumbers = Arrays.asList(
                "N40","N36",
                "B12", "B6",
                "G53","G56","G60", "G48", "g62",
                "I26", "I17", "I29",
                "O2");

        List<String> sortedNumbers  = bingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        sortedNumbers.forEach(System.out::println);
    }
}
