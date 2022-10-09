package com.explosives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams2 {

    /*
    * In the previous we tried to do our operation using the forEach() loop method.
    * In this example let's try the same operation using the stream().
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

        bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

       /* bingoNumbers
                .stream()
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.toUpperCase();
                    }
                })
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.startsWith("G");
                    }
                })
                .sorted()
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });*/
    }

    /*
    * Before beginning we need to define what a stream is.
    * As per the official documentation a stream is a sequence of elements supporting sequential
    * and parallel aggregate operation.
    * What that means is stream is a set of object references. The stream() method added to the
    * Collections class in java 8 creates a stream from a collection. Each object reference in a
    * stream corresponds to an object in the collection and the ordering of the object reference
    * matches the ordering of the collection.
    * When we are using a stream that uses collection as its source, the stream() method is the
    * first call that needs to be made.
    * All stream operations must meet 2 requirements:
    * 1. They have to be non-interfering which mean don't change the stream source in any way.
    * 2. They have to be stateless so that the result of an operation cannot depend on any state
    *    outside of the operation.eg: it cannot depend on variable values on a previous step.
    *
    * Next step we use the map() method.
    * The map() method takes a Function whose argument is the object type of bingoNumber i.e String
    * and returns a value.
    * Here we are passing 'String::toUpperCase'.This can be used when all a lambda expression does
    * is call a method. This tells us that the lambda is returning a String value of
    * toUpperCase() method call with source stream object as argument. Refer to the commented
    * code block for synonymous code using anonymous class.
    * The value returned by the map method is then consumed by the next step as argument just like
    * chaining of functions.
    *
    * Next step we use the filter() method.
    * The filter() method accepts Predicate whose argument is the object type of bingoNumber i.e
    * String and returns a boolean value. In this case the value of 's.startsWith("G")'.
    *
    * Next step we use the sorted() method.
    * The sorted() method sorts the values in the natural order.
    *
    * Next step we use the forEach() method which takes a lambda for the Consumer and then prints
    * the values.
    * It is important to note that all the methods stream(), map(), filter(), sorted() and
    * forEach() return a Stream object.
    * Also, the forEach() method used here belongs to the java.util.stream.Stream class and not
    * java.lang.Iterable interface.
    *
    * Now in the above code since the forEach() method doesn't return any value, the operation
    * end there. Hence, it is called a terminal method. Methods that return void or non stream
    * results are called terminal methods.
    * Similarly the operations that return a Stream are called intermediate operations.
    * */
}
