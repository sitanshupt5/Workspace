package com.explosives;

import java.util.stream.Stream;

public class Streams3 {

    public static void main(String[] args)
    {
        /*
        * In the previous created Stream object from a collection. It is also possible to create
        * Stream objects directly.
        * This can be done using the Stream.of() method.
        * */

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29","O2");
        Stream<String> ibnNumberStream = Stream.of("I26", "I17", "I29","N40","N36", "B12", "B6");
        Stream<String> concatStream = Stream.concat(ioNumberStream,ibnNumberStream);
        System.out.println(concatStream.distinct().peek(System.out::println).count());

        /*
        * In the above code we declare 2 stream objects and concatenate the 2 Streams to create a
        * 3 Stream object using the concat() method. The concat() method concatenates two Stream
        * objects passed as arguments and returns a Stream object.
        *
        * The distinct() method returns a Stream object with distinct values(without any duplicates)
        * The peek() method is similar to forEach() except for it returns a Stream object instead of
        * void. Hence, it is an intermediate operation instead of a terminal operation.
        *
        * The count() method is a terminal operation that returns a long value of the number elements
        * in the stream.
        * */
    }
}
