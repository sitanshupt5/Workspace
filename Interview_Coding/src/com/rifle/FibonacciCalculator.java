package com.rifle;

import java.util.Scanner;

public class FibonacciCalculator {

    public static void main(String[] args)
    {
        System.out.println("Enter upper limit of the fibonacci series:\n");
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();

        for(int i = 1; i<=limit-1; i++)
        {
            System.out.print(fibonacci(i)+" ");
        }

        System.out.println("\n");

        for (int i=1; i<limit; i++)
        {
            System.out.print(fibonacci2(i)+" ");
        }
    }

    public static int fibonacci(int number){
        if (number==1||number==2)
            return 1;
        else
            return fibonacci(number-1)+fibonacci(number-2);
    }

    public static int fibonacci2(int number){
        if (number==1||number ==2)
            return 1;

        int fibo1=1, fibo2=1, fibonacci=1;
        for (int i=3;i<=number;i++)
        {
            fibonacci= fibo1+fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci;
    }
}
