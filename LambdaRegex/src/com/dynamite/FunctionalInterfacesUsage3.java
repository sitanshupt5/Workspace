package com.dynamite;

import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class FunctionalInterfacesUsage3 {
    /*
    * In the previous examples we used Consumer and Predicate interfaces methods that do not care
    * about the type of parameter being passed to the lambda expression as argument. They are using
    * generic to infer the type.
    * There are other Consumer and Predicate interfaces that expect a specific type of paramerter as
    * argument.
    * eg. The DoubleConsumer expects that has double argument. The are also int and long Consumers.
    * eg. Similarly there are also DoublePredicate, IntPredicate and LongPredicate.
    * Where possible a more specific type of lambda should be used to improve readability.
    * */

    public static void main(String[] args)
    {
        //Code Block:1
        IntPredicate greaterThan15 = i -> i>15;
        /*IntPredicate gt15 = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value>15;
            }
        };*/
        System.out.println(greaterThan15.test(10));
        int a = 10;
        System.out.println(greaterThan15.test(10+a));

        IntPredicate lessThan100 = i->i<100;
        int x = 20;
        System.out.println(greaterThan15.and(lessThan100).test(x));
        System.out.println(greaterThan15.and(lessThan100).test(15));

        //Code Block:2
        Random random = new Random();
        Supplier<Integer> randomSupplier = ()-> random.nextInt(1000);
        for (int i = 0; i<10; i++)
            System.out.println(randomSupplier.get());

        /*Supplier<Integer>  supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return random.nextInt(1000);
            }
        };*/

    }

    /*
    * In the above example we are using the IntPredicate interface.
    * The test method in the IntPredicate interface accept only integer value as argument unlike the
    * Predicate interface test() method.
    *
    * Another interesting thing about the Predicate interface we can chain multiple lambda expressions
    * together using and() or or() methods for combined results. This enhances re-usability of code.
    *
    * Coming down to Code Block 2, here we are using the Supplier Interface of java.util.function.
    * The Supplier interface method get() does not accept any arguments and returns a value.
    * If we need the Supplier interface to return specific type of value, the we can use interfaces
    * like BooleanSupplier, IntSupplier etc.
    * */
}
