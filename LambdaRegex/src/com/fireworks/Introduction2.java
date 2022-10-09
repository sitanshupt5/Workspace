package com.fireworks;

public class Introduction2 {
    /*
    * The second way execute to methods of an interface is using an anonymous class object.
    * Here we are actually defining the method while creating the object.
    * However in both the cases we see that the actual code that is getting executed is:
    * System.out.println("Printing from the Runnable")
    * All the other lines of code actually serve as a filler. It is there to instantiate the object
    * and implement the single method in the Runnable interface.
    * So it would be nice if we could pass the System.out.println("Printing from the Runnable") into the
    * thread constructor and not have to write the extra code that isn't really doing anything.
    * */

    public static void main(String[] args)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the Runnable");
            }
        }).start();
    }
}
