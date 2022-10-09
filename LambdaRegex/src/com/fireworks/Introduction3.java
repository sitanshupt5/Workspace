package com.fireworks;

public class Introduction3 {
    /*
    * The third way is using the lambda expressions. With lambda expressions we can overcome the
    * shortcomings of the the previous methods.
    * We can pass the actual code into the thread constructor and not have to write any extra code
    * to instantiate the objects.
    * */
    public static void main(String[] args){
        new Thread(()-> System.out.println("Printing from the Runnable")).start();
    }
    /*
    * Above we can see what started as a 4-5 lines of code in Introduction1 and Introduction2 has been
    * brought down to a single line of code.
    * Every lambda expression has 3 components or parts:
    * 1. The argument list: '()'
    * 2. The arrow token: '->'
    * 3. body: System.out.println("Printing from the Runnable")
    *
    * In the above example we are passing an empty argument list.
    * How does the compiler figure out what to do when it sees a lambda expression.
    * For starters it knows that one of the Thread class constructors accepts a Runnable parameter.
    * It also knows that the Runnable interface has only one method 'run()' which accepts no arguments.
    * It is able to match the lambda expression argument list with the run method.
    * Since compiler needs to match the  lambda expression argument list with a method, the lamda
    * expressions can only be used in case of interfaces that have only one method(otherwise known as
    * Functional interfaces).
    * */
}
