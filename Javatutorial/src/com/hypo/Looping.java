package com.hypo;

public class Looping {
    /*
    * for loop, while loop and do-while loop
    * for loop syntax:
    * for(intialization, condition, iteration)
    * eg: for(int i =0; i<10; i++)
    * */

    public static void main(String[] args)
    {
        int i = 0;
        for (; i<10;){
            System.out.print("Sitanshu"+i+", ");
            i++;
        }

        System.out.println("\n");

        int j=0;
        while(j<=10)
        {
            System.out.print("Shiva"+j+", ");
            j++;
        }

        System.out.println("\n");

        int k = 10;
        do {
            System.out.print("Sathish"+k+", ");
            k++;
        }while (k<10);
    }
}
