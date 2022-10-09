package com.revolver;


import java.util.Scanner;
import java.util.function.Predicate;

/*
* Write a program to verify whether a number is prime.
* */
public class Question14 {
    public static void main(String[] args)
    {
        System.out.println("Please enter a number.");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.close();

        Predicate<Integer> isPrime = num ->{
            for(int i=2; i<num/2; i++)
            { if (num%i==0)
                return false;}
            return true;
        };

        System.out.println("Number is Prime :"+isPrime.test(number));
    }

}
