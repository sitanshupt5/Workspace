package com.rifle;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: \n");
        int number  = scanner.nextInt();

        System.out.println("Factorial of "+number+" is "+factorial(number));
    }

    public static int factorial(int number){
        if(number==0)
            return 1;
        else
            return number*factorial(number-1);
    }
}
