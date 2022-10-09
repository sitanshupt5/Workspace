package com.fireworks;

public class Introduction {
    /*
    * Lambda expressions were introduced in Java 8. Lambda expressions provide and easier way to deal
    * with functional interfaces(interfaces that only have one method).
    * For starters lets take a look at how we can define methods of a functional interface.
    * Lets take an example of the Runnable interface with only has one method 'run()'.
    * This can be done in three ways.
    * The first ways is to create a class implementing the Runnable interface. Lets check how that works.
    * And we execute the thread from our main method.
    * */
    public static void main(String[] args)
    {
        new Thread(new CodeToRun()).start();

    }

}

class CodeToRun implements Runnable{


    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}
